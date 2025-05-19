package model;

import java.time.LocalDate;

import model.enums.UserRole;

public class Player extends User {

	private String nickName;
	private Team currentTeam;
	private int experienceLevel;

	public Player() {
	    super();
	}
	
	public Player(int id, String firstName, String lastName, String email, String password, String country, String city,
			LocalDate birthDate, UserRole role) {
		super(id, firstName, lastName, email, password, country, city, birthDate, role);
	}

	public Player(int id, String firstName, String lastName, String email, String password, String country, String city,
			LocalDate birthDate) {
		super(id, firstName, lastName, email, password, country, city, birthDate, UserRole.PLAYER);
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(int experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public Team getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
	}
	
}
