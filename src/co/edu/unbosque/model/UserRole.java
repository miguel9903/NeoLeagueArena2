package co.edu.unbosque.model;

public enum UserRole {

	ADMIN("Administrator"),
	PLAYER("Player"),
	COACH("Coach");

	private final String displayName;

	UserRole(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
    public static UserRole fromString(String role) {
        if (role == null) return null;

        for (UserRole ur : UserRole.values()) {
            if (ur.name().equalsIgnoreCase(role) || ur.getDisplayName().equalsIgnoreCase(role)) {
                return ur;
            }
        }

        return null;
    }
}
