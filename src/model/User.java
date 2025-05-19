package model;

import java.time.LocalDate;
import java.time.Period;

import model.enums.UserRole;

public abstract class User {

	protected int id;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
	protected String country;
	protected String city;
	private LocalDate birthDate;
	protected UserRole role;
	
	public User() { }
	
	public User(int id, String firstName, String lastName, String email, String password, String country, String city,
			LocalDate birthDate, UserRole role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.country = country;
		this.city = city;
		this.birthDate = birthDate;
		this.role = role;
	}

	public boolean login(String email, String password) {
	    return this.email.equals(email) && this.password.equals(password);
	}
	
	public int getAge() {
	    if (birthDate == null)  return -1; 
	    return Period.between(birthDate, LocalDate.now()).getYears();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
}
