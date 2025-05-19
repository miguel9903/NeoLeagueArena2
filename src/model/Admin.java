package model;

import java.time.LocalDate;

import model.enums.UserRole;

public class Admin extends User {

	public Admin() {
		super();
	}

	public Admin(int id, String firstName, String lastName, String email, String password, String country, String city,
			LocalDate birthDate, UserRole role) {
		super(id, firstName, lastName, email, password, country, city, birthDate, role);
	}

	
	public Admin(int id, String firstName, String lastName, String email, String password, String country, String city,
			LocalDate birthDate) {
		super(id, firstName, lastName, email, password, country, city, birthDate, UserRole.ADMIN);
	}
}
