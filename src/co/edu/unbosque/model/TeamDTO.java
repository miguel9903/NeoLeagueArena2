package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.List;

public class TeamDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;
    private String logo;
    private double score;
    private int ranking;
    private List<Integer> playerIds;
    private List<Integer> tournamentIds;
    private Integer coachId;
    private String coachName;
    private List<PlayerDTO> players;
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
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
	public List<Integer> getPlayerIds() {
		return playerIds;
	}
	
	public void setPlayerIds(List<Integer> playerIds) {
		this.playerIds = playerIds;
	}
	
	public List<Integer> getTournamentIds() {
		return tournamentIds;
	}
	
	public void setTournamentIds(List<Integer> tournamentIds) {
		this.tournamentIds = tournamentIds;
	}
	
	public Integer getCoachId() {
		return coachId;
	}
	
	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}
	
	public String getCoachName() {
		return coachName;
	}
	
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<PlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDTO> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "TeamDTO [id=" + id + ", name=" + name + ", description=" + description + ", logo=" + logo + ", score="
				+ score + ", ranking=" + ranking + ", playerIds=" + playerIds + ", tournamentIds=" + tournamentIds
				+ ", coachId=" + coachId + ", coachName=" + coachName + ", players=" + players + "]";
	}

	

	
}
