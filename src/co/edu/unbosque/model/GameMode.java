package co.edu.unbosque.model;

public enum GameMode {

    ONE_VS_ONE("1v1"),
    TEAM_VS_TEAM("Team vs Team"),
    TOURNAMENT("Tournament"),
    BATTLE_ROYALE("Battle Royale"),
    CO_OP("Cooperative"),
    KING_OF_THE_HILL("King of the Hill"),
    CAPTURE_THE_FLAG("Capture the Flag"),
    TIME_TRIALS("Time Trials"),
    SURVIVAL("Survival"),
    FREE_FOR_ALL("Free-for-All"),
    DRAFT_MODE("Draft Mode");

    private final String displayName;

    GameMode(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
	
    public static GameMode fromString(String mode) {
        if (mode == null) return null;

        for (GameMode gm : GameMode.values()) {
            if (gm.name().equalsIgnoreCase(mode) || gm.getDisplayName().equalsIgnoreCase(mode)) {
                return gm;
            }
        }

        return null;
    }
}
