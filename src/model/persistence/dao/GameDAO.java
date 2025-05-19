package model.persistence.dao;

import java.util.ArrayList;

import model.Game;
import model.persistence.FileManager;
import utils.PersistencePaths;

public class GameDAO implements InterfaceDAO<Game> {

    private ArrayList<Game> games;
    private FileManager<Game> fileManager;

    public GameDAO() {
        fileManager = new FileManager<>(PersistencePaths.GAMES_FILE);
        games = new ArrayList<>();
        loadFromFile();
    }

    public void loadFromFile() {
        ArrayList<Game> loadedGames = fileManager.readFromFile(Game.class);
        if (loadedGames != null) {
            games = loadedGames;
        }
    }

    public void saveToFile() {
        fileManager.writeToFile(games, Game.class);
    }

    @Override
    public ArrayList<Game> getAll() {
        return new ArrayList<>(games);
    }

    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Game g : games) {
            sb.append(g.getId()).append(" - ").append(g.getName()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean add(Game game) {
        if (find(game) == null) {
            games.add(game);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Game game) {
        Game found = find(game);
        if (found != null) {
            games.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Game oldGame, Game newGame) {
        Game existing = find(oldGame);
        if (existing != null) {
            games.remove(existing);
            games.add(newGame);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public Game find(Game game) {
        for (Game g : games) {
            if (g.getId() == game.getId()) {
                return g;
            }
        }
        return null;
    }
}
