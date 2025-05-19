package model.persistence.dto;

import java.io.Serializable;
import java.util.List;

public class CoachDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> teamIds;

	public List<Integer> getTeamIds() {
		return teamIds;
	}

	public void setTeamIds(List<Integer> teamIds) {
		this.teamIds = teamIds;
	}

	@Override
	public String toString() {
		return super.toString() + ", CoachDTO [teamIds=" + teamIds + "]";
	}

}
