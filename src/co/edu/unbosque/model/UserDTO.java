package co.edu.unbosque.model;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String country;
	private String city;
	private String role;
	private String birthDate;
	private int age;

	public UserDTO() { }

	public boolean login(String email, String password) {
		return this.email.equals(email) && this.password.equals(password);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\n"
				+ "First Name: " + firstName + "\n"
				+ "Last Name: " + lastName + "\n"
				+ "Email: " + email + "\n"
				+ "Password: " + password + "\n"
				+ "Country: " + country + "\n"
				+ "City: " + city + "\n"
				+ "Role: " + role + "\n"
				+ "Birth Date: " + birthDate + "\n"
				+ "Age: " + age + "\n";
	}


}
