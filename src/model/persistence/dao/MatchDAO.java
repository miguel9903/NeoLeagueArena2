package model.persistence.dao;

import java.util.ArrayList;

import model.Match;
import model.persistence.FileManager;
import utils.PersistencePaths;

public class MatchDAO implements InterfaceDAO<Match> {

    private ArrayList<Match> matches;
    private FileManager<Match> fileManager;

    public MatchDAO() {
        fileManager = new FileManager<>(PersistencePaths.MATCHES_FILE);
        matches = new ArrayList<>();
        loadFromFile();
    }

    public void loadFromFile() {
        ArrayList<Match> loaded = fileManager.readFromFile(Match.class);
        if (loaded != null) {
            matches = loaded;
        }
    }

    public void saveToFile() {
        fileManager.writeToFile(matches, Match.class);
    }

    @Override
    public ArrayList<Match> getAll() {
        return new ArrayList<>(matches);
    }

    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Match m : matches) {
            sb.append(m).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean add(Match match) {
        if (find(match) == null) {
            matches.add(match);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Match match) {
        Match found = find(match);
        if (found != null) {
            matches.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Match oldMatch, Match newMatch) {
        Match existing = find(oldMatch);
        if (existing != null) {
            matches.remove(existing);
            matches.add(newMatch);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public Match find(Match match) {
        for (Match m : matches) {
            if (m.equals(match)) {
                return m;
            }
        }
        return null;
    }
    
}
