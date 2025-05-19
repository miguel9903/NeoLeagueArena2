package model.persistence.dto;

import java.io.Serializable;
import java.util.List;

public class TournamentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;
    private List<Integer> teamIds;
    private List<Integer> matchIds;
    private String platform;
    private String game;  
    private String phase;
    
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
	
	public List<Integer> getTeamIds() {
		return teamIds;
	}
	
	public void setTeamIds(List<Integer> teamIds) {
		this.teamIds = teamIds;
	}
	
	public List<Integer> getMatchIds() {
		return matchIds;
	}
	
	public void setMatchIds(List<Integer> matchIds) {
		this.matchIds = matchIds;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public String getGame() {
		return game;
	}
	
	public void setGame(String game) {
		this.game = game;
	}
	
	public String getPhase() {
		return phase;
	}
	
	public void setPhase(String phase) {
		this.phase = phase;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
