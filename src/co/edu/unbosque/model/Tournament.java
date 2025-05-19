package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private int id;
    private String name;
    private String description;
    private List<Team> teams;
    private List<Match> matches;
    private GamePlatform platform;
    private Game game;
    private TournamentPhase phase;

    public Tournament() {
        this.id = 0;
        this.name = null;
        this.description = null;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.platform = GamePlatform.UNKNOWN;
        this.game = null;                      
        this.phase = TournamentPhase.REGISTRATION; 
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

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public GamePlatform getPlatform() {
		return platform;
	}

	public void setPlatform(GamePlatform platform) {
		this.platform = platform;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public TournamentPhase getPhase() {
		return phase;
	}

	public void setPhase(TournamentPhase phase) {
		this.phase = phase;
	}
    
}
