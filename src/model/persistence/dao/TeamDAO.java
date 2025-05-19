package model.persistence.dao;

import java.util.ArrayList;

import model.Team;
import model.persistence.FileManager;
import utils.PersistencePaths;

public class TeamDAO implements InterfaceDAO<Team> {

	private ArrayList<Team> teams;
	private FileManager<Team> fileManager;

	public TeamDAO() {
		fileManager = new FileManager<>(PersistencePaths.TEAMS_FILE);
		teams = new ArrayList<>();
		loadFromFile();
	}

	public void loadFromFile() {
		ArrayList<Team> loaded = fileManager.readFromFile(Team.class);
		
		if (loaded != null) {
			teams = loaded;
		}
	}

	public void saveToFile() {
		fileManager.writeToFile(teams, Team.class);
	}

	@Override
	public ArrayList<Team> getAll() {
		return new ArrayList<>(teams);
	}

	@Override
	public String getAllAsString() {
		StringBuilder sb = new StringBuilder();
		for (Team t : teams) {
			sb.append(t).append("\n");
		}
		return sb.toString();
	}

	@Override
	public boolean add(Team team) {
		if (find(team) == null) {
			teams.add(team);
			saveToFile();
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Team team) {
		Team found = find(team);
		if (found != null) {
			teams.remove(found);
			saveToFile();
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Team oldTeam, Team newTeam) {
		Team existing = find(oldTeam);
		if (existing != null) {
			teams.remove(existing);
			teams.add(newTeam);
			saveToFile();
			return true;
		}
		return false;
	}

	@Override
	public Team find(Team team) {
		for (Team t : teams) {
			if (t.getId() == team.getId()) {
				return t;
			}
		}
		return null;
	}

}
