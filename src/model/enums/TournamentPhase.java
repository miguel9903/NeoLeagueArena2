package model.enums;

public enum TournamentPhase {

	REGISTRATION("Registration"),
	GROUP_STAGE("Group Stage"),
	KNOCKOUT("Knockout"),
	QUARTERFINALS("Quarterfinals"),
	SEMIFINALS("Semifinals"),
	FINALS("Finals"),
	THIRD_PLACE("Third Place"),
	EXHIBITION("Exhibition");

	private final String displayName;

	TournamentPhase(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static TournamentPhase fromString(String phase) {
		if (phase == null) return null;

		for (TournamentPhase tp : TournamentPhase.values()) {
			if (tp.name().equalsIgnoreCase(phase) || tp.getDisplayName().equalsIgnoreCase(phase)) {
				return tp;
			}
		}

		return null;
	}
}
