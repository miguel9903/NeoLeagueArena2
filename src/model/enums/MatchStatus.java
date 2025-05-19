package model.enums;

public enum MatchStatus {

    SCHEDULED("Scheduled"),
    ONGOING("Ongoing"),
    PAUSED("Paused"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled"),
    POSTPONED("Postponed");

    private final String displayName;

    MatchStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    public static MatchStatus fromString(String status) {
        if (status == null) return null;
        
        for (MatchStatus ms : MatchStatus.values()) {
            if (ms.name().equalsIgnoreCase(status) || ms.getDisplayName().equalsIgnoreCase(status)) {
                return ms;
            }
        }
        
        return null;
    }
}
