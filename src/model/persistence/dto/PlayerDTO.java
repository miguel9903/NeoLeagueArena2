package model.persistence.dto;

import java.io.Serializable;

import model.enums.UserRole;

public class PlayerDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nickName;
	private int experienceLevel;
	private Integer currentTeamId;
	private String currentTeamName;

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

	public Integer getCurrentTeamId() {
		return currentTeamId;
	}

	public void setCurrentTeamId(Integer currentTeamId) {
		this.currentTeamId = currentTeamId;
	}

	public String getCurrentTeamName() {
		return currentTeamName;
	}

	public void setCurrentTeamName(String currentTeamName) {
		this.currentTeamName = currentTeamName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return super.toString() +
				"\nNickName: " + nickName +
				"\nExperience Level: " + experienceLevel +
				"\nCurrent Team ID: " + currentTeamId +
				"\nCurrent Team Name: " + currentTeamName;
	}
}
