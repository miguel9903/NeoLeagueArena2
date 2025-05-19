package model;

import java.util.List;

import model.enums.GameGenre;
import model.enums.GameMode;
import model.enums.GamePlatform;

public class Game {

	private int id;
	private String name;
	private String description;
	private String logo;
	private GameGenre genre;
	private GamePlatform platform;
	private List<GameMode> modes;
	
	public Game() {}
	
	public Game(int id, String name, String description, String logo, GameGenre genre, GamePlatform platform,
			List<GameMode> modes) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.logo = logo;
		this.genre = genre;
		this.platform = platform;
		this.modes = modes;
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

	public GameGenre getGenre() {
		return genre;
	}

	public void setGenre(GameGenre genre) {
		this.genre = genre;
	}

	public GamePlatform getPlatform() {
		return platform;
	}

	public void setPlatform(GamePlatform platform) {
		this.platform = platform;
	}

	public List<GameMode> getModes() {
		return modes;
	}

	public void setModes(List<GameMode> modes) {
		this.modes = modes;
	}
}
