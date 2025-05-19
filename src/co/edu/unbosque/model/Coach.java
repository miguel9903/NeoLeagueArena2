package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.List;

public class Coach extends User {

	private List<Team> teams;

	public Coach() {
		super();
	}
	
	public Coach(int id, String firstName, String lastName, String email, String password, String country, String city,
			LocalDate birthDate, UserRole role) {
		super(id, firstName, lastName, email, password, country, city, birthDate, role);
	}

	public Coach(int id, String firstName, String lastName, String email, String password, String country, String city,
			LocalDate birthDate) {
		super(id, firstName, lastName, email, password, country, city, birthDate, UserRole.COACH);
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
