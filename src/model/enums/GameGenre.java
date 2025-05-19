package model.enums;

public enum GameGenre {
	
	ACTION("Action"),
	ADVENTURE("Adventure"),
	RPG("Role Playing Game"),
	FPS("First Person Shooter"),
	SPORTS("Sports"),
	SIMULATION("Simulation"),
	STRATEGY("Strategy"),
	MOBA("Multiplayer Online Battle Arena"),
	FIGHTING("Fighting"),
	PUZZLE("Puzzle"),
	HORROR("Horror"),
	RACING("Racing"),
	MMO("Massively Multiplayer Online");

	private final String displayName;

	GameGenre(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
    public static GameGenre fromString(String genre) {
        if (genre == null) return null;

        for (GameGenre gg : GameGenre.values()) {
            if (gg.name().equalsIgnoreCase(genre) || gg.getDisplayName().equalsIgnoreCase(genre)) {
                return gg;
            }
        }

        return null;
    }
	
}
