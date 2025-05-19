package model.persistence.dao;

import java.util.ArrayList;

import model.Tournament;
import model.persistence.FileManager;
import utils.PersistencePaths;

public class TournamentDAO implements InterfaceDAO<Tournament> {

    private ArrayList<Tournament> tournaments;
    private FileManager<Tournament> fileManager;

    public TournamentDAO() {
        fileManager = new FileManager<>(PersistencePaths.TOURNAMENTS_FILE);
        tournaments = new ArrayList<>();
        loadFromFile();
    }

    public void loadFromFile() {
        ArrayList<Tournament> loaded = fileManager.readFromFile(Tournament.class);
        if (loaded != null) {
            tournaments = loaded;
        }
    }

    public void saveToFile() {
        fileManager.writeToFile(tournaments, Tournament.class);
    }

    @Override
    public ArrayList<Tournament> getAll() {
        return new ArrayList<>(tournaments);
    }

    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Tournament t : tournaments) {
            sb.append(t).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean add(Tournament tournament) {
        if (find(tournament) == null) {
            tournaments.add(tournament);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Tournament tournament) {
        Tournament found = find(tournament);
        if (found != null) {
            tournaments.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Tournament oldTournament, Tournament newTournament) {
        Tournament existing = find(oldTournament);
        if (existing != null) {
            tournaments.remove(existing);
            tournaments.add(newTournament);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public Tournament find(Tournament tournament) {
        for (Tournament t : tournaments) {
            if (t.equals(tournament)) {
                return t;
            }
        }
        return null;
    }
    
}
