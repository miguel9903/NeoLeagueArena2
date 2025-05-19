package model.persistence.dao;

import java.util.ArrayList;

import model.Player;
import model.persistence.FileManager;
import utils.PersistencePaths;

public class PlayerDAO implements InterfaceDAO<Player> {

    private ArrayList<Player> players;
    private FileManager<Player> fileManager;

    public PlayerDAO() {
        fileManager = new FileManager<>(PersistencePaths.PLAYERS_FILE);
        players = new ArrayList<>();
        loadFromFile();
    }

    public void loadFromFile() {
        ArrayList<Player> loaded = fileManager.readFromFile(Player.class);
        
        if (loaded != null) {
            players = loaded;
        }
    }

    public void saveToFile() {
        fileManager.writeToFile(players, Player.class);
    }

    @Override
    public ArrayList<Player> getAll() {
        return new ArrayList<>(players);
    }

    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Player p : players) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean add(Player player) {       	
        if (find(player) == null) {
            players.add(player);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Player player) {
        Player found = find(player);
    	System.out.print("Finded: " + find(player).toString() + ")n)n");

    	  for (Player p : players) {
              if (p.getId() == player.getId()) {
              	System.out.print(p.toString());
              }
          }
    	
        if (found != null) {
            players.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Player oldPlayer, Player newPlayer) {
        Player existing = find(oldPlayer);
        if (existing != null) {
            players.remove(existing);
            players.add(newPlayer);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public Player find(Player player) {
        for (Player p : players) {
            if (p.getId() == player.getId()) {
                return p;
            }
        }
        return null;
    }
}
