package co.edu.unbosque.model;

public enum GamePlatform {

    PC("Personal Computer"),
    PLAYSTATION("PlayStation"),
    XBOX("Xbox"),
    NINTENDO_SWITCH("Nintendo Switch"),
    UNKNOWN("Unknown");

    private final String displayName;

    GamePlatform(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    public static GamePlatform fromString(String platform) {
        if (platform == null) return null;

        for (GamePlatform gp : GamePlatform.values()) {
            if (gp.name().equalsIgnoreCase(platform) || gp.getDisplayName().equalsIgnoreCase(platform)) {
                return gp;
            }
        }

        return null;
    }
	
}
