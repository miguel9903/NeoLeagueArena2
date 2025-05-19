package model.persistence.dao;

import java.util.ArrayList;

import model.Coach;
import model.persistence.FileManager;
import utils.PersistencePaths;

public class CoachDAO implements InterfaceDAO<Coach> {

    private ArrayList<Coach> coaches;
    private FileManager<Coach> fileManager;

    public CoachDAO() {
        fileManager = new FileManager<>(PersistencePaths.COACHES_FILE);
        coaches = new ArrayList<>();
        loadFromFile();
    }

    public void loadFromFile() {
        ArrayList<Coach> loaded = fileManager.readFromFile(Coach.class);
        if (loaded != null) {
            coaches = loaded;
        }
    }

    public void saveToFile() {
        fileManager.writeToFile(coaches, Coach.class);
    }

    @Override
    public ArrayList<Coach> getAll() {
        return new ArrayList<>(coaches);
    }

    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Coach c : coaches) {
            sb.append(c).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean add(Coach coach) {
        if (find(coach) == null) {
            coaches.add(coach);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Coach coach) {
        Coach found = find(coach);
        if (found != null) {
            coaches.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Coach oldCoach, Coach newCoach) {
        Coach existing = find(oldCoach);
        if (existing != null) {
            coaches.remove(existing);
            coaches.add(newCoach);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public Coach find(Coach coach) {
        for (Coach c : coaches) {
            if (c.getId() == coach.getId()) {
                return c;
            }
        }
        return null;
    }
    
}
