package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.persistence.AdminDAO;
import co.edu.unbosque.persistence.AdminMapper;
import co.edu.unbosque.persistence.CoachDAO;
import co.edu.unbosque.persistence.CoachMapper;
import co.edu.unbosque.persistence.GameDAO;
import co.edu.unbosque.persistence.GameMapper;
import co.edu.unbosque.persistence.MatchDAO;
import co.edu.unbosque.persistence.MatchMapper;
import co.edu.unbosque.persistence.PlayerDAO;
import co.edu.unbosque.persistence.PlayerMapper;
import co.edu.unbosque.persistence.TeamDAO;
import co.edu.unbosque.persistence.TeamMapper;
import co.edu.unbosque.persistence.TournamentDAO;
import co.edu.unbosque.persistence.TournamentMapper;

public class NeoLeagueArena {

	private AdminDAO adminDAO;
	private PlayerDAO playerDAO;
	private CoachDAO coachDAO;
	private TeamDAO teamDAO;
	private GameDAO gameDAO;
	private TournamentDAO tournamentDAO;
	private MatchDAO matchDAO;
	
	public NeoLeagueArena() {
		adminDAO = new AdminDAO();
		playerDAO = new PlayerDAO();
		coachDAO = new CoachDAO();
		teamDAO = new TeamDAO();
		gameDAO = new GameDAO();
		tournamentDAO = new TournamentDAO();
		matchDAO = new MatchDAO();
	}

	// ----------------- Admin methods -----------------

	public boolean addAdmin(AdminDTO adminDTO) {
		Admin admin = AdminMapper.convertAdminDTOToAdmin(adminDTO);
		return adminDAO.add(admin);
	}

	public boolean deleteAdmin(AdminDTO adminDTO) {
		Admin admin = AdminMapper.convertAdminDTOToAdmin(adminDTO);
		return adminDAO.delete(admin);
	}

	public boolean updateAdmin(AdminDTO oldAdminDTO, AdminDTO newAdminDTO) {
		Admin oldAdmin = AdminMapper.convertAdminDTOToAdmin(oldAdminDTO);
		Admin newAdmin = AdminMapper.convertAdminDTOToAdmin(newAdminDTO);
		return adminDAO.update(oldAdmin, newAdmin);
	}

	public ArrayList<AdminDTO> getAllAdmins() {
		ArrayList<Admin> admins = adminDAO.getAll();
		ArrayList<AdminDTO> adminDTOs = new ArrayList<>();

		for (Admin admin : admins) {
			System.out.print(admin.toString());
		}


		for (Admin admin : admins) {
			AdminDTO dto = AdminMapper.convertAdminToAdminDTO(admin);
			adminDTOs.add(dto);
		}

		return adminDTOs;
	}

	public void loadAdmins() {
		adminDAO.loadFromFile();
	}

	public void saveAdmins() {
		adminDAO.saveToFile();
	}
	
	public Integer getNextAdminId() {
	    List<AdminDTO> admins = getAllAdmins();
	    
	    int maxId = 0;
	    
	    for (AdminDTO t : admins) {
	        if (t.getId() != null && t.getId() > maxId) {
	            maxId = t.getId();
	        }
	    }
	    
	    return maxId + 1;
	}

	// ----------------- Player methods -----------------

	public boolean addPlayer(PlayerDTO playerDTO) {
		Player player = PlayerMapper.convertPlayerDTOToPlayer(playerDTO);
		return playerDAO.add(player);
	}

	public boolean deletePlayer(PlayerDTO playerDTO) {
		Player player = PlayerMapper.convertPlayerDTOToPlayer(playerDTO);
		return playerDAO.delete(player);
	}

	public boolean updatePlayer(PlayerDTO oldPlayerDTO, PlayerDTO newPlayerDTO) {
		Player oldPlayer = PlayerMapper.convertPlayerDTOToPlayer(oldPlayerDTO);
		Player newPlayer = PlayerMapper.convertPlayerDTOToPlayer(newPlayerDTO);
		return playerDAO.update(oldPlayer, newPlayer);
	}

	public ArrayList<PlayerDTO> getAllPlayers() {
		ArrayList<Player> players = playerDAO.getAll();
		ArrayList<PlayerDTO> playerDTOs = new ArrayList<>();

		for (Player player : players) {
			PlayerDTO dto = PlayerMapper.convertPlayerToPlayerDTO(player);
			playerDTOs.add(dto);
		}

		return playerDTOs;
	}

	public ArrayList<PlayerDTO> getPlayersWithTeam(int teamId) {	 
		ArrayList<PlayerDTO> playersDTO = new ArrayList<>();

		for (PlayerDTO playerDTO : getAllPlayers()) {
			TeamDTO teamDTO = new TeamDTO();
			teamDTO.setId(playerDTO.getCurrentTeamId());
			TeamDTO foundTeam = findTeam(teamDTO);
		}

		return playersDTO;
	}

	public void loadPlayers() {
		playerDAO.loadFromFile();
	}

	public void savePlayers() {
		playerDAO.saveToFile();
	}

	public PlayerDTO findPlayer(PlayerDTO playerDTO) {
		Player player = PlayerMapper.convertPlayerDTOToPlayer(playerDTO);
		Player foundPlayer = playerDAO.find(player);
		PlayerDTO foundPlayerDTO = PlayerMapper.convertPlayerToPlayerDTO(foundPlayer);

		return foundPlayerDTO;
	}

	public Integer getNextPlayerId() {
	    List<PlayerDTO> players = getAllPlayers();
	    
	    int maxId = 0;
	    
	    for (PlayerDTO t : players) {
	        if (t.getId() != null && t.getId() > maxId) {
	            maxId = t.getId();
	        }
	    }
	    
	    return maxId + 1;
	}
	
	// ----------------- Coach methods -----------------

	public boolean addCoach(CoachDTO coachDTO) {
		Coach coach = CoachMapper.convertCoachDTOToCoach(coachDTO);
		return coachDAO.add(coach);
	}

	public boolean deleteCoach(CoachDTO coachDTO) {
		Coach coach = CoachMapper.convertCoachDTOToCoach(coachDTO);
		return coachDAO.delete(coach);
	}

	public boolean updateCoach(CoachDTO oldCoachDTO, CoachDTO newCoachDTO) {
		Coach oldCoach = CoachMapper.convertCoachDTOToCoach(oldCoachDTO);
		Coach newCoach = CoachMapper.convertCoachDTOToCoach(newCoachDTO);
		return coachDAO.update(oldCoach, newCoach);
	}

	public ArrayList<CoachDTO> getAllCoaches() {
		ArrayList<Coach> coaches = coachDAO.getAll();
		ArrayList<CoachDTO> coachDTOs = new ArrayList<>();

		for (Coach coach : coaches) {
			CoachDTO dto = CoachMapper.convertCoachToCoachDTO(coach);
			coachDTOs.add(dto);
		}

		return coachDTOs;
	}

	public CoachDTO findCoach(CoachDTO coachDTO) {		
		Coach coach = CoachMapper.convertCoachDTOToCoach(coachDTO);
		Coach foundCoach = coachDAO.find(coach);
		CoachDTO foundTeamDTO = CoachMapper.convertCoachToCoachDTO(foundCoach);

		return foundTeamDTO;
	}

	public void loadCoaches() {
		coachDAO.loadFromFile();
	}

	public void saveCoaches() {
		coachDAO.saveToFile();
	}

	public Integer getNextCoachId() {
	    List<CoachDTO> coaches = getAllCoaches();
	    
	    int maxId = 0;
	    
	    for (CoachDTO t : coaches) {
	        if (t.getId() != null && t.getId() > maxId) {
	            maxId = t.getId();
	        }
	    }
	    
	    return maxId + 1;
	}
	
	// ----------------- Team methods -----------------

	public boolean addTeam(TeamDTO teamDTO) {
		Team team = TeamMapper.convertTeamDTOToTeam(teamDTO);
		return teamDAO.add(team);
	}

	public boolean deleteTeam(TeamDTO teamDTO) {
		Team team = TeamMapper.convertTeamDTOToTeam(teamDTO);
		return teamDAO.delete(team);
	}

	public boolean updateTeam(TeamDTO oldTeamDTO, TeamDTO newTeamDTO) {
		Team oldTeam = TeamMapper.convertTeamDTOToTeam(oldTeamDTO);
		Team newTeam = TeamMapper.convertTeamDTOToTeam(newTeamDTO);
		return teamDAO.update(oldTeam, newTeam);
	}

	public ArrayList<TeamDTO> getAllTeams() {
		ArrayList<Team> teams = teamDAO.getAll();
		ArrayList<TeamDTO> teamDTOs = new ArrayList<>();

		for (Team team : teams) {
			TeamDTO dto = TeamMapper.convertTeamToTeamDTO(team);
			teamDTOs.add(dto);
		}

		return teamDTOs;
	}

	public TeamDTO getTeamWithPlayers(int teamId) {
		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(teamId);
		TeamDTO foundTeam = findTeam(teamDTO);

		if (foundTeam != null && foundTeam.getPlayerIds() != null && !foundTeam.getPlayerIds().isEmpty()) {
			List<PlayerDTO> teamPlayers = new ArrayList<>();

			for (Integer id : foundTeam.getPlayerIds()) {
				PlayerDTO playerDTO = new PlayerDTO();
				playerDTO.setId(id);
				PlayerDTO foundPlayer = findPlayer(playerDTO);

				if (foundPlayer != null) {
					teamPlayers.add(foundPlayer);
				}
			}

			foundTeam.setPlayers(teamPlayers);
		}

		return foundTeam;
	}

	public boolean teamNameExists(String teamName) {
		for (TeamDTO team : getAllTeams()) {
			if (team.getName().equalsIgnoreCase(teamName.trim())) {
				return true;
			}
		}

		return false;
	}

	public boolean teamNameExists(String teamName, Integer currentTeamId) {
		for (TeamDTO team : getAllTeams()) {
			if (!team.getId().equals(currentTeamId) &&
					team.getName().trim().equalsIgnoreCase(teamName.trim())) {
				return true;
			}
		}

		return false;
	}


	public boolean isPlayerAssignedToAnyTeam(Integer playerId) {
		for (TeamDTO teamDTO : getAllTeams()) {
			List<Integer> playerIds = teamDTO.getPlayerIds();

			if (playerIds != null && playerIds.contains(playerId)) {
				return true;
			}
		}

		return false;
	}

	public boolean isPlayerInTeam(Integer playerId, Integer teamId) {	
		TeamDTO teamDTO =  new TeamDTO();
		teamDTO.setId(teamId);

		TeamDTO foundTeamDTO = findTeam(teamDTO);

		if (foundTeamDTO != null && foundTeamDTO.getPlayerIds() != null) {
			return foundTeamDTO.getPlayerIds().contains(playerId);
		}

		return false;
	}

	public void loadTeams() {
		teamDAO.loadFromFile();
	}

	public void saveTeams() {
		teamDAO.saveToFile();
	}

	public Integer getLastTeamId() {
		return teamDAO.getAll().size() + 1;
	}

	public Integer getNextTeamId() {
	    List<TeamDTO> teams = getAllTeams();
	    
	    int maxId = 0;
	    
	    for (TeamDTO t : teams) {
	        if (t.getId() != null && t.getId() > maxId) {
	            maxId = t.getId();
	        }
	    }
	    
	    return maxId + 1;
	}
	
	public TeamDTO findTeam(TeamDTO teamDTO) {
		Team team = TeamMapper.convertTeamDTOToTeam(teamDTO);
		Team foundTeam = teamDAO.find(team);
		TeamDTO foundTeamDTO = TeamMapper.convertTeamToTeamDTO(foundTeam);

		return foundTeamDTO;
	}

	// ----------------- Game methods -----------------

	public boolean addGame(GameDTO gameDTO) {
		Game game = GameMapper.convertGameDTOToGame(gameDTO);
		return gameDAO.add(game);
	}

	public boolean deleteGame(GameDTO gameDTO) {
		Game game = GameMapper.convertGameDTOToGame(gameDTO);
		return gameDAO.delete(game);
	}

	public boolean updateGame(GameDTO oldGameDTO, GameDTO newGameDTO) {
		Game oldGame = GameMapper.convertGameDTOToGame(oldGameDTO);
		Game newGame = GameMapper.convertGameDTOToGame(newGameDTO);
		return gameDAO.update(oldGame, newGame);
	}

	public ArrayList<GameDTO> getAllGames() {
		ArrayList<Game> games = gameDAO.getAll();
		ArrayList<GameDTO> gameDTOs = new ArrayList<>();

		for (Game game : games) {
			GameDTO dto = GameMapper.convertGameToGameDTO(game);
			gameDTOs.add(dto);
		}

		return gameDTOs;
	}

	public GameDTO findGame(GameDTO gameDTO) {
		Game game = GameMapper.convertGameDTOToGame(gameDTO);
		Game foundGame = gameDAO.find(game);
		GameDTO foundGameDTO = GameMapper.convertGameToGameDTO(foundGame);
		return foundGameDTO;
	}

	public void loadGames() {
		gameDAO.loadFromFile();
	}

	public void saveGames() {
		gameDAO.saveToFile();
	}

	
	public Integer getNextGameId() {
	    List<GameDTO> games = getAllGames();
	    
	    int maxId = 0;
	    
	    for (GameDTO t : games) {
	        if (t.getId() != null && t.getId() > maxId) {
	            maxId = t.getId();
	        }
	    }
	    
	    return maxId + 1;
	}

	// ----------------- Tournament methods -----------------

	public boolean addTournament(TournamentDTO tournamentDTO) {
		Tournament tournament = TournamentMapper.convertTournamentDTOToTournament(tournamentDTO);
		return tournamentDAO.add(tournament);
	}

	public boolean deleteTournament(TournamentDTO tournamentDTO) {
		Tournament tournament = TournamentMapper.convertTournamentDTOToTournament(tournamentDTO);
		return tournamentDAO.delete(tournament);
	}

	public boolean updateTournament(TournamentDTO oldDTO, TournamentDTO newDTO) {
		Tournament oldTournament = TournamentMapper.convertTournamentDTOToTournament(oldDTO);
		Tournament newTournament = TournamentMapper.convertTournamentDTOToTournament(newDTO);
		return tournamentDAO.update(oldTournament, newTournament);
	}

	public ArrayList<TournamentDTO> getAllTournaments() {
		ArrayList<Tournament> tournaments = tournamentDAO.getAll();
		ArrayList<TournamentDTO> dtos = new ArrayList<>();
		for (Tournament t : tournaments) {
			dtos.add(TournamentMapper.convertTournamentToTournamentDTO(t));
		}
		return dtos;
	}

	public TournamentDTO findTournament(TournamentDTO tournamentDTO) {
		Tournament tournament = TournamentMapper.convertTournamentDTOToTournament(tournamentDTO);
		Tournament found = tournamentDAO.find(tournament);
		return TournamentMapper.convertTournamentToTournamentDTO(found);
	}

	public void loadTournaments() {
		tournamentDAO.loadFromFile();
	}

	public void saveTournaments() {
		tournamentDAO.saveToFile();
	}
	
	public Integer getNextTournmentId() {
	    List<TournamentDTO> tournaments = getAllTournaments();
	    
	    int maxId = 0;
	    
	    for (TournamentDTO t : tournaments) {
	        if (t.getId() != null && t.getId() > maxId) {
	            maxId = t.getId();
	        }
	    }
	    
	    return maxId + 1;
	}

	
	// ----------------- Match methods -----------------

	public boolean addMatch(MatchDTO matchDTO) {
	    Match match = MatchMapper.convertMatchDTOToMatch(matchDTO);
	    return matchDAO.add(match);
	}

	public boolean deleteMatch(MatchDTO matchDTO) {
	    Match match = MatchMapper.convertMatchDTOToMatch(matchDTO);
	    return matchDAO.delete(match);
	}

	public boolean updateMatch(MatchDTO oldMatchDTO, MatchDTO newMatchDTO) {
	    Match oldMatch = MatchMapper.convertMatchDTOToMatch(oldMatchDTO);
	    Match newMatch = MatchMapper.convertMatchDTOToMatch(newMatchDTO);
	    return matchDAO.update(oldMatch, newMatch);
	}

	public ArrayList<MatchDTO> getAllMatches() {
	    ArrayList<Match> matches = matchDAO.getAll();
	    ArrayList<MatchDTO> matchDTOs = new ArrayList<>();

	    for (Match match : matches) {
	        MatchDTO dto = MatchMapper.convertMatchToMatchDTO(match);
	        matchDTOs.add(dto);
	    }

	    return matchDTOs;
	}

	public MatchDTO findMatch(MatchDTO matchDTO) {
	    Match match = MatchMapper.convertMatchDTOToMatch(matchDTO);
	    Match foundMatch = matchDAO.find(match);
	    return MatchMapper.convertMatchToMatchDTO(foundMatch);
	}

	public void loadMatches() {
		matchDAO.loadFromFile();
	}

	public void saveMatches() {
		matchDAO.saveToFile();
	}
	
	public Integer getNextMtachId() {
	    List<MatchDTO> matches = getAllMatches();
	    
	    int maxId = 0;
	    
	    for (MatchDTO t : matches) {
	        if (t.getId() != null && t.getId() > maxId) {
	            maxId = t.getId();
	        }
	    }
	    
	    return maxId + 1;
	}


	public UserDTO authenticateUser(String email, String password) {
		// Check in admins
		for (AdminDTO admin : getAllAdmins()) {
			if (admin.login(email, password)) {
				return admin;
			}
		}

		// Check in coaches
		for (CoachDTO coach : getAllCoaches()) {
			if (coach.login(email, password)) {
				return coach;
			}
		}

		// Check in players
		for (PlayerDTO player : getAllPlayers()) {
			if (player.login(email, password)) {
				return player;
			}
		}

		// No user found with matching credentials
		return null;
	}

}
