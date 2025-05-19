package model;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private int id;
	private String name;
	private String description;
	private String logo;
	private double score;
	private int ranking;
	private List<Player> players;
	private List<Tournament> tournaments;
	private Coach coach;
	
	public Team() {
		this.id = 0;
		this.name = "";
		this.description = "";
		this.logo = "";
		this.score = 0.0;
		this.ranking = 0;
		this.players = new ArrayList<>();
		this.tournaments = new ArrayList<>();
		this.coach = null;
	}
	
	public Team(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.logo = "";
		this.score = 0.0;
		this.ranking = 0;
		this.players = new ArrayList<>();
		this.tournaments = new ArrayList<>();
		this.coach = null;
	}
	
	public Team(int id, String name, String description, String logo, double score, int ranking, List<Player> players,
			List<Tournament> tournaments, Coach coach) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.logo = logo;
		this.score = score;
		this.ranking = ranking;
		this.players = players;
		this.tournaments = tournaments;
		this.coach = coach;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public int getRanking() {
		return ranking;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public List<Tournament> getTournaments() {
		return tournaments;
	}
	
	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}
	
	public Coach getCoach() {
		return coach;
	}
	
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
}
