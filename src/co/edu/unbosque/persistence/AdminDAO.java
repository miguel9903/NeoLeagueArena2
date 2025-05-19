package co.edu.unbosque.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import co.edu.unbosque.model.Admin;
import co.edu.unbosque.util.PersistencePaths;

public class AdminDAO implements InterfaceDAO<Admin> {

    private ArrayList<Admin> admins;
    private FileManager<Admin> fileManager;

    public AdminDAO() {
        fileManager = new FileManager<>(PersistencePaths.ADMINS_FILE);
        admins = new ArrayList<>();
        loadFromFile();

        if (admins.isEmpty()) {
            loadInitialData();
            saveToFile();
        }
    }

    public void loadFromFile() {
        ArrayList<Admin> loaded = fileManager.readFromFile(Admin.class);
        if (loaded != null) {
            admins = loaded;
        }
    }

    public void saveToFile() {
        fileManager.writeToFile(admins, Admin.class);
    }

    private void loadInitialData() {
        Admin defaultAdmin = new Admin(
            1,
            "ADMIN",
            "ADMIN",
            "admin",
            "123",
            "Colombia",
            "Bogotá D.C.",
            LocalDate.of(1990, 1, 1)
        );

        admins.add(defaultAdmin);
    }

    @Override
    public ArrayList<Admin> getAll() {
        return new ArrayList<>(admins);
    }

    @Override
    public String getAllAsString() {
        return admins.stream()
                .map(Admin::toString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean add(Admin admin) {
        if (find(admin) == null) {
            admins.add(admin);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Admin admin) {
        Admin found = find(admin);
        if (found != null) {
            admins.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Admin oldAdmin, Admin newAdmin) {
        Admin existing = find(oldAdmin);
        if (existing != null) {
            admins.remove(existing);
            admins.add(newAdmin);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public Admin find(Admin admin) {
        for (Admin a : admins) {
            if (a.getId() == admin.getId()) {
                return a;
            }
        }
        return null;
    }
}
