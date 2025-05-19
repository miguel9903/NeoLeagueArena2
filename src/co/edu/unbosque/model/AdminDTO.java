package co.edu.unbosque.model;

public class AdminDTO extends UserDTO {

	private static final long serialVersionUID = 1L;

	public AdminDTO() {
		super();
		setRole("ADMIN");
	}

	public AdminDTO(int id, String firstName, String lastName, String email, String password,
			String country, String city) {
		super(); 
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setCountry(country);
		setCity(city);
		setRole("ADMIN");
	}

	@Override
	public String toString() {
		return "AdminDTO [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName()
		+ ", email=" + getEmail() + ", password=" + getPassword() + ", country=" + getCountry()
		+ ", city=" + getCity() + ", role=" + getRole() + "]";
	}
}
