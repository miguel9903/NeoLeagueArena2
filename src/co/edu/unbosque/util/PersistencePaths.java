package co.edu.unbosque.util;

public class PersistencePaths {

    // Base folder
    public static final String ARCHIVES_FOLDER = "archives/";

    // Folder for user data
    public static final String USERS_FOLDER = ARCHIVES_FOLDER + "users/";
    public static final String ADMINS_FOLDER = USERS_FOLDER + "admins/";
    public static final String COACHES_FOLDER = USERS_FOLDER + "coaches/";
    public static final String PLAYERS_FOLDER = USERS_FOLDER + "players/";

    // Folder for general entities (same level as USERS_FOLDER)
    public static final String TOURNAMENTS_FOLDER = ARCHIVES_FOLDER + "tournaments/";
    public static final String TEAMS_FOLDER = ARCHIVES_FOLDER + "teams/";
    public static final String GAMES_FOLDER = ARCHIVES_FOLDER + "games/";
    public static final String MATCHES_FOLDER = ARCHIVES_FOLDER + "matches/";

    // Files inside user folders
    public static final String ADMINS_FILE = ADMINS_FOLDER + "admins.dat";
    public static final String COACHES_FILE = COACHES_FOLDER + "coaches.dat";
    public static final String PLAYERS_FILE = PLAYERS_FOLDER + "players.dat";

    // Files inside general entity folders
    public static final String TOURNAMENTS_FILE = TOURNAMENTS_FOLDER + "tournaments.dat";
    public static final String TEAMS_FILE = TEAMS_FOLDER + "teams.dat";
    public static final String GAMES_FILE = GAMES_FOLDER + "games.dat";
    public static final String MATCHES_FILE = MATCHES_FOLDER + "matches.dat";
}
