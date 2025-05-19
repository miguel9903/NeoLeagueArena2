package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.edu.unbosque.model.AdminDTO;
import co.edu.unbosque.model.CoachDTO;
import co.edu.unbosque.model.GameDTO;
import co.edu.unbosque.model.GameGenre;
import co.edu.unbosque.model.GameMode;
import co.edu.unbosque.model.GamePlatform;
import co.edu.unbosque.model.MatchDTO;
import co.edu.unbosque.model.MatchStatus;
import co.edu.unbosque.model.NeoLeagueArena;
import co.edu.unbosque.model.PlayerDTO;
import co.edu.unbosque.model.TeamDTO;
import co.edu.unbosque.model.TournamentDTO;
import co.edu.unbosque.model.TournamentPhase;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.UserRole;
import co.edu.unbosque.util.AssetPaths;
import co.edu.unbosque.util.ButtonActionCommands;
import co.edu.unbosque.util.FieldValidator;
import co.edu.unbosque.util.ViewNames;
import view.View;
import view.module.team.TeamCardPanel;
import view.module.tournament.TournamentCardPanel;
import view.modules.player.PlayerCardPanel;

public class Controller implements ActionListener {

	private View view;
	private NeoLeagueArena neoLeagueArena;

	public Controller() {
		view = new View();
		neoLeagueArena = new NeoLeagueArena();

		neoLeagueArena.loadAdmins();
		assignListeners();
	}

	public void run() {
		view.getLoginWindow().setVisible(true);
	}

	public void assignListeners() {
		// Login
		assigLoginListeners();

		// Logout
		assignLogoutListeners();

		// Register
		assignRegisterListeners();

		// Sidebar Panel
		assignSideBarListeners();

		// Admin Panel Navigation
		assignAdminNavBarListeners();

		// Tournaments Panel
		assignTournamentListeners();

		// Teams Panel
		assignAdminTeamListeners();
		assignTeamDetailListeners();

		// Players Panel
		assignAdminPlayerListeners();

		// Coaches Panel
		assignAdminCoachListeners();

		// Games Panel
		assignAdminGameListeners();

		// Tournament Panel
		assignAdminTournamentListeners();
	}


	public void assigLoginListeners() {
		view.getLoginWindow().getLoginButton().addActionListener(this);
		view.getLoginWindow().getRegisterButton().addActionListener(this);
	}

	public void assignRegisterListeners() {
		view.getRegisterWindow().getRegisterButton().addActionListener(this);
		view.getRegisterWindow().getCancelButton().addActionListener(this);
	}

	public void assignLogoutListeners() {
		view.getMainWindow().getMainContentPanel().getTopBarPanel().getLogoutButton().addActionListener(this);
	}

	public void assignSideBarListeners() {
		view.getMainWindow().getSideBarPanel().getHomeButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getTournamentsButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getTeamsButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getPlayersButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getCoachesButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getAdminsButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getMatchesButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getGamesButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getReportsButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getSettingsButton().addActionListener(this);
	}

	public void assignAdminNavBarListeners() {
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getTournamentsButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getTeamsButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getPlayersButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getCoachesButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getAdministratorsButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getMatchesButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getGamesButton().addActionListener(this);
	}

	public void assignAdminTeamListeners() {
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamFormPanel().getFormHeaderPanel().getSearchButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamFormPanel().getFormFooterPanel().getPrimaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamFormPanel().getFormFooterPanel().getSecondaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamFormPanel().getFormFooterPanel().getTertiaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamFormPanel().getFormFooterPanel().getQuaternaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamPlayerAssignmentPanel().getFormFooterPanel().getPrimaryButton().addActionListener(this);
	}

	public void assignAdminPlayerListeners() {
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getPlayerManagementPanel().getPlayerFormPanel().getFormHeaderPanel().getSearchButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getPlayerManagementPanel().getPlayerFormPanel().getFormFooterPanel().getPrimaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getPlayerManagementPanel().getPlayerFormPanel().getFormFooterPanel().getSecondaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getPlayerManagementPanel().getPlayerFormPanel().getFormFooterPanel().getTertiaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getPlayerManagementPanel().getPlayerFormPanel().getFormFooterPanel().getQuaternaryButton().addActionListener(this);
	}

	public void assignAdminCoachListeners() {
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getCoachManagementPanel().getCoachFormPanel().getFormHeaderPanel().getSearchButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getCoachManagementPanel().getCoachFormPanel().getFormFooterPanel().getPrimaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getCoachManagementPanel().getCoachFormPanel().getFormFooterPanel().getSecondaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getCoachManagementPanel().getCoachFormPanel().getFormFooterPanel().getTertiaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getCoachManagementPanel().getCoachFormPanel().getFormFooterPanel().getQuaternaryButton().addActionListener(this);
	}

	public void assignAdminGameListeners() {
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getGameManagementPanel().getGameFormPanel().getFormHeaderPanel().getSearchButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getGameManagementPanel().getGameFormPanel().getFormFooterPanel().getPrimaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getGameManagementPanel().getGameFormPanel().getFormFooterPanel().getSecondaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getGameManagementPanel().getGameFormPanel().getFormFooterPanel().getTertiaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getGameManagementPanel().getGameFormPanel().getFormFooterPanel().getQuaternaryButton().addActionListener(this);
	}

	public void assignAdminTournamentListeners() {
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTournamentManagementPanel().getTournamentFormPanel().getFormFooterPanel().getPrimaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTournamentManagementPanel().getTournamentFormPanel().getFormFooterPanel().getSecondaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTournamentManagementPanel().getTournamentFormPanel().getFormFooterPanel().getTertiaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTournamentManagementPanel().getTournamentFormPanel().getFormFooterPanel().getQuaternaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTournamentManagementPanel().getTournamentMatchAssignmentPanel().getFormHeaderPanel().getSearchButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTournamentManagementPanel().getTournamentMatchAssignmentPanel().getFormFooterPanel().getPrimaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTournamentManagementPanel().getTournamentMatchAssignmentPanel().getFormFooterPanel().getSecondaryButton().addActionListener(this);
	}

	public void assignTournamentListeners() {
		List<TournamentCardPanel> tournamentCards = view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getTournamentPanel().getTournamentCards();

		for (int i = 0; i < tournamentCards.size(); i++) {
			TournamentCardPanel card = tournamentCards.get(i);
			String actionCommand = "TOURNAMENT_" + i;
			card.getDetailButton().setActionCommand(actionCommand);
			card.getDetailButton().addActionListener(this);
		}
	}

	public void assignTeamtListeners() {
		List<TeamCardPanel> teamtCards = view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getTeamsPanel().getTeamCards();

		for (int i = 0; i < teamtCards.size(); i++) {
			TeamCardPanel card = teamtCards.get(i);
			card.getDetailButton().addActionListener(this);
		}
	}

	public void assignTeamListeners () {
		List<TeamCardPanel> teamCards = view.getMainWindow().getMainContentPanel()
				.getLayoutContentPanel().getTeamsPanel().getTeamCards(); 

		for (int i = 0; i < teamCards.size(); i++) {
			TeamCardPanel card = teamCards.get(i);
			String actionCommand = "TEAM_" + i;
			card.getDetailButton().setActionCommand(actionCommand);
			card.getDetailButton().addActionListener(this);
		}
	}

	public void assignTeamDetailListeners() {
		List<PlayerCardPanel> playerCards = view.getMainWindow().getMainContentPanel()
				.getLayoutContentPanel().getTeamDetailPanel().getPlayerCards();

		for (int i = 0; i < playerCards.size(); i++) {
			PlayerCardPanel card = playerCards.get(i);
			String actionCommand = "PLAYER_" + i;
			card.getDetailButton().setActionCommand(actionCommand);
			card.getDetailButton().addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.print("\n COMMAND PRESSED: " + command + "\n");

		// Login
		handleLoginCommand(command);

		// Signup/Register
		handleSignUpCommand(command);

		// Sidebar navigation
		handleSidebarCommand(command);

		// Tournaments
		handleTournamentCommand(command);

		// Teams
		handleTeamCommand(command);

		// Players
		handlePlayerCommand(command);

		// Admin general commands
		handleAdminCommand(command);

		// Admin Teams commands
		handleAdminTeamCommand(command);

		// Admin Players commands
		handleAdminPlayerCommand(command);

		// Admin Coaches commands
		handleAdminCoachCommand(command);

		// Admin Games commands
		handleAdminGameCommand(command);

		// Admin Tournament commands
		handleAdminTournamentCommand(command);

		// Admin Matches commands
		handleAdminMatchCommand(command);
	}


	public void handleLoginCommand(String command) {
		if (command.equals(ButtonActionCommands.LOGIN_ACTION_COMMAND)) {
			String email = view.getLoginWindow().getCredentialsPanel().getEmailTextField().getText().trim();
			String password = new String(view.getLoginWindow().getCredentialsPanel().getPasswordTextField().getPassword()).trim();

			if (FieldValidator.isAnyEmpty(email, password)) {
				view.showErrorMessage(view.getLoginWindow(), "Please enter both email and password.");
				return;
			}

			UserDTO loggedUser = neoLeagueArena.authenticateUser(email, password);

			if (loggedUser != null) {
				String loggedUserName = loggedUser.getFirstName() + " " + loggedUser.getLastName();

				view.getLoginWindow().getCredentialsPanel().resetFields();
				view.getMainWindow().getMainContentPanel().getTopBarPanel().getUserNameLabel().setText(loggedUserName);

				if (loggedUser.getRole() != UserRole.ADMIN.getDisplayName()) {
					view.getMainWindow().getSideBarPanel().showAdminsButton(false);
				}

				view.getLoginWindow().dispose();
				view.getMainWindow().setVisible(true);
			} else {
				view.showErrorMessage(view.getLoginWindow(), "Incorrect email or password. Please try again.");
			}

		} else if (command.equals(ButtonActionCommands.LOGIN_REGISTER_ACTION_COMMAND)) {
			view.getLoginWindow().dispose();
			view.getRegisterWindow().setVisible(true);
		} else if (command.equals(ButtonActionCommands.LOGOUT_ACTION_COMMAND)) {
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getUserNameLabel().setText("");
			view.getMainWindow().dispose();
			view.getLoginWindow().setVisible(true);
		}
	}

	public void handleSignUpCommand(String command) {
		if (command.equals(ButtonActionCommands.REGISTER_ACTION_COMMAND)) {
			String id = view.getRegisterWindow().getRegisterFieldsPanel().getIdTextField().getText().trim();
			String firstName = view.getRegisterWindow().getRegisterFieldsPanel().getFirstNameTextField().getText().trim();
			String lastName = view.getRegisterWindow().getRegisterFieldsPanel().getLastNameTextField().getText().trim();
			String email = view.getRegisterWindow().getRegisterFieldsPanel().getEmailTextField().getText().trim();
			String password = new String(view.getRegisterWindow().getRegisterFieldsPanel().getPasswordTextField().getPassword());
			String country = view.getRegisterWindow().getRegisterFieldsPanel().getCountryTextField().getText().trim();
			String city = view.getRegisterWindow().getRegisterFieldsPanel().getCityTextField().getText().trim();
			String birthDate = view.getRegisterWindow().getRegisterFieldsPanel().getDateBirthDateTextField().getText().trim();
			String role = (String) view.getRegisterWindow().getRegisterFieldsPanel().getRoleComboBox().getSelectedItem();

			if (FieldValidator.isAnyEmpty(id, firstName, lastName, email, password, country, city, birthDate, role)) {
				view.showErrorMessage(view.getRegisterWindow(), "Please fill in all fields.");
				return;
			}

			if (!FieldValidator.isValidDateFormat(birthDate)) {
				view.showErrorMessage(view.getRegisterWindow(), "Invalid birth date format. Use yyyy-MM-dd.");
				return;
			}

			if (role.equalsIgnoreCase("Player")) {
				PlayerDTO newPlayer = new PlayerDTO();

				newPlayer.setId(Integer.parseInt(id));
				newPlayer.setFirstName(firstName);
				newPlayer.setLastName(lastName);
				newPlayer.setEmail(email);
				newPlayer.setPassword(password);
				newPlayer.setCountry(country);
				newPlayer.setCity(city);
				newPlayer.setRole(role);
				newPlayer.setBirthDate(birthDate);

				boolean successRegistry = neoLeagueArena.addPlayer(newPlayer);

				if (successRegistry) {
					view.showInfoMessage(view.getRegisterWindow(), "Player registered successfully!");
					view.getRegisterWindow().getRegisterFieldsPanel().resetFields();
					view.getRegisterWindow().dispose();
					view.getLoginWindow().setVisible(true);
				} else {
					view.showErrorMessage(view.getRegisterWindow(), "Player with that email or ID already exists.");
				}

			} else if (role.equalsIgnoreCase("Coach")) {
				CoachDTO newCoach = new CoachDTO();

				newCoach.setId(Integer.parseInt(id));
				newCoach.setFirstName(firstName);
				newCoach.setLastName(lastName);
				newCoach.setEmail(email);
				newCoach.setPassword(password);
				newCoach.setCountry(country);
				newCoach.setCity(city);
				newCoach.setRole(role);
				newCoach.setBirthDate(birthDate); 

				boolean successRegistry = neoLeagueArena.addCoach(newCoach);

				if (successRegistry) {
					view.showInfoMessage(view.getRegisterWindow(), "Coach registered successfully!");
					view.getRegisterWindow().getRegisterFieldsPanel().resetFields();
					view.getRegisterWindow().dispose();
					view.getLoginWindow().setVisible(true);
				} else {
					view.showErrorMessage(view.getRegisterWindow(), "Coach with that email or ID already exists.");
				}
			}


		} else if(command.equals(ButtonActionCommands.REGISTER_CANCEL_ACTION_COMMAND)) {
			view.getRegisterWindow().dispose();
			view.getLoginWindow().setVisible(true);
		}
	}

	public void handleSidebarCommand(String command) {
		if (command.equals(ViewNames.HOME_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.HOME_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.HOME_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getHomeButton());
		} else if (command.equals(ViewNames.TOURNAMENT_VIEW)) {

			neoLeagueArena.loadTournaments();;
			List<TournamentDTO> tournamenstDTO = neoLeagueArena.getAllTournaments();

			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TOURNAMENT_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TOURNAMENT_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getTournamentsButton());

			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getTournamentPanel().renderTournamentCards(tournamenstDTO);

		} else if (command.equals(ViewNames.TEAM_VIEW)) {

			neoLeagueArena.loadTeams();
			List<TeamDTO> teamsDTO = neoLeagueArena.getAllTeams();

			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TEAM_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TEAM_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getTeamsButton());
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getTeamsPanel().renderTeamCards(teamsDTO);

			assignTeamtListeners();

		} else if (command.equals(ViewNames.PLAYER_VIEW)) {

			neoLeagueArena.loadPlayers();
			List<PlayerDTO>  playersDTO = neoLeagueArena.getAllPlayers();

			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.PLAYER_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.PLAYER_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getPlayersButton());
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getPlayerPanel().renderPlayerCards(playersDTO);

		} else if (command.equals(ViewNames.COACH_VIEW)) {

			neoLeagueArena.loadCoaches();
			List<CoachDTO>  coachesDTO = neoLeagueArena.getAllCoaches();

			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.COACH_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.COACH_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getCoachesButton());
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getCoachPanel().renderCoachCards(coachesDTO);

		} else if (command.equals(ViewNames.ADMIN_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.ADMIN_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.ADMIN_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getAdminsButton());
		} else if (command.equals(ViewNames.MATCH_VIEW)) {
			
			neoLeagueArena.loadMatches();
			List<MatchDTO>  matchesDTO = neoLeagueArena.getAllMatches();
			
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.MATCH_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.MATCH_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getMatchesButton());
			
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getMatchPanel().renderMatchCards(matchesDTO);
			
		} else if (command.equals(ViewNames.GAME_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.GAME_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.GAME_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getGamesButton());
		} else if (command.equals(ViewNames.REPORT_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.REPORT_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.REPORT_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getReportsButton());
		} else if (command.equals(ViewNames.SETTINGS_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.SETTINGS_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.SETTINGS_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getSettingsButton());
		}
	}

	public void handleTournamentCommand(String command) {
		if (command.startsWith("TOURNAMENT_")) {
			int tournamentId = Integer.parseInt(command.split("_")[1]) + 1;
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TOURNAMENT_DETAIL_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TOURNAMENT_DETAIL_VIEW);
			System.out.print("DETAIL TOURNAMENT " + tournamentId);
		}
	}

	public void handleTeamCommand(String command) {
		if (command.startsWith(ButtonActionCommands.TEAM_DETAIL_ACTION_COMMAND + "_")) {
			int teamId = Integer.parseInt(command.substring(command.lastIndexOf("_") + 1));

			TeamDTO foundTeam = neoLeagueArena.getTeamWithPlayers(teamId);

			if (foundTeam != null) {
				view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TEAM_DETAIL_VIEW);
				view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TEAM_DETAIL_VIEW);
				view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getTeamDetailPanel().renderTeamDetail(foundTeam);
			}
		}
	}

	public void handlePlayerCommand(String command) {
		if (command.startsWith("PLAYER_")) {
			int playerId = Integer.parseInt(command.split("_")[1]) + 1;  
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.PLAYER_DETAIL_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.PLAYER_DETAIL_VIEW);
			System.out.println("DETAIL TEAM " + playerId); 
		}
	}

	public void handleAdminCommand(String command) {
		if (command.startsWith(ButtonActionCommands.ADMIN_TOURNAMENT_ACTION_COMMAND)) {

			neoLeagueArena.loadTeams();
			neoLeagueArena.loadTournaments();

			List<TeamDTO> teamsDTO = neoLeagueArena.getAllTeams();
			List<TournamentDTO> tournamentsDTO = neoLeagueArena.getAllTournaments();

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTournamentManagementPanel()
			.getTournamentMatchAssignmentPanel()
			.loadTournamentComboBox(tournamentsDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTournamentManagementPanel()
			.getTournamentMatchAssignmentPanel()
			.loadTeamAComboBox(teamsDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTournamentManagementPanel()
			.getTournamentMatchAssignmentPanel()
			.loadTeamBComboBox(teamsDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTournamentManagementPanel()
			.getTournamentMatchAssignmentPanel()
			.loadWinnerTeamComboBox(teamsDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTournamentManagementPanel()
			.getTournamentMatchAssignmentPanel()
			.loadStatusComboBox(Arrays.asList(MatchStatus.values()));

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTournamentManagementPanel()
			.getTournamentFormPanel()
			.getTournamentFormFieldsPanel()
			.loadPhaseComboBox(Arrays.asList(TournamentPhase.values()));

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTournamentManagementPanel()
			.getTournamentFormPanel()
			.getTournamentFormFieldsPanel()
			.loadPlatformComboBox(Arrays.asList(GamePlatform.values()));

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTournamentManagementPanel()
			.getTournamentFormPanel()
			.getTournamentFormFieldsPanel()
			.loadGameComboBox();

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTournamentManagementPanel()
			.getTournamentTablePanel()
			.loadTableData(tournamentsDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_TOURNAMENT_VIEW);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_TEAM_ACTION_COMMAND)) {

			neoLeagueArena.loadCoaches();
			neoLeagueArena.loadPlayers();
			neoLeagueArena.loadTeams();

			List<CoachDTO> coachesDTO = neoLeagueArena.getAllCoaches();
			List<PlayerDTO> playersDTO = neoLeagueArena.getAllPlayers();
			List<TeamDTO> teamsDTO = neoLeagueArena.getAllTeams();

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.setCoachesComboBox(coachesDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamPlayerAssignmentPanel()
			.loadPlayersComboBox(playersDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamPlayerAssignmentPanel()
			.loadTeamsComboBox(teamsDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamTablePanel()
			.loadTableData(teamsDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamPlayerAssignmentPanel()
			.loadPlayersComboBox(playersDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamPlayerAssignmentPanel()
			.loadTeamsComboBox(teamsDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_TEAM_VIEW);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_PLAYER_ACTION_COMMAND)) {

			neoLeagueArena.loadPlayers();
			List<PlayerDTO> playersDTO = neoLeagueArena.getAllPlayers();

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_PLAYER_VIEW);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerTablePanel()
			.loadTableData(playersDTO);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_COACH_ACTION_COMMAND)) {

			neoLeagueArena.loadCoaches();
			List<CoachDTO> coachesDTO = neoLeagueArena.getAllCoaches();

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getCoachManagementPanel()
			.getCoachTablePanel()
			.loadTableData(coachesDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_COACH_VIEW);


		} else if (command.startsWith(ButtonActionCommands.ADMIN_ADMINISTRATOR_ACTION_COMMAND)) {

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_ADMIN_VIEW);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_MATCH_ACTION_COMMAND)) {

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_MATCH_VIEW);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_GAME_ACTION_COMMAND)) {

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_GAME_VIEW);
		}
	}


	// ==========================================
	// ====  ADMIN COMMANDS: TEAM MANAGEMENT ====
	// ==========================================

	public void handleAdminTeamCommand(String command) {
		if (command.equals(ButtonActionCommands.ADMIN_CREATE_TEAM_ACTION_COMMAND)) {
			handleCreateTeam();
		} else if (command.equals(ButtonActionCommands.ADMIN_ADD_PLAYERS_TO_TEAM_ACTION_COMMAND)) {
			handleAddPlayersToTeam();
		} else if (command.equals(ButtonActionCommands.ADMIN_SEARCH_TEAM_ACTION_COMMAND)) {
			handleSearchTeam();
		} else if (command.equals(ButtonActionCommands.ADMIN_UPDATE_TEAM_ACTION_COMMAND)) {
			handleUpdateTeam();
		} else if (command.equals(ButtonActionCommands.ADMIN_DELETE_TEAM_ACTION_COMMAND)) {
			handleDeleteTeam();
		} else if (command.equals(ButtonActionCommands.ADMIN_RESET_TEAM_ACTION_COMMAND)) {
			handleResetTeamFields();
		}
	}

	private void handleCreateTeam() {
		String name = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getNameTextField()
				.getText()
				.trim();

		String description = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getDescriptionTextArea()
				.getText()
				.trim();

		String logoText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getLogoTextField()
				.getText()
				.trim();

		String scoreText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getScoreTextField()
				.getText()
				.trim();

		String rankingText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getRankingTextField()
				.getText()
				.trim();

		Integer coachId = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getCoachComboBoxIdValue();

		if (FieldValidator.isAnyEmpty(name, description)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please fill in all required fields.");
			return;
		}

		if (!FieldValidator.isAlphanumeric(name)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"The name cannot contain special characters.");
			return;
		}

		if (neoLeagueArena.teamNameExists(name)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"A team with the name \"" + name + "\" already exists. Please choose another name.");
			return;
		}

		if (description.length() < 10) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Description must be at least 10 characters long.");
			return;
		}

		if (!FieldValidator.isAlphanumeric(description)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"The description cannot contain special characters.");
			return;
		}

		if (!scoreText.isEmpty() && !FieldValidator.isDecimal(scoreText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Score must be a valid decimal number.");
			return;
		}

		if (!rankingText.isEmpty() && !FieldValidator.isInteger(rankingText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Ranking must be a valid integer.");
			return;
		}

		String logo = logoText.isEmpty() ? AssetPaths.TEAM_ICON : logoText;
		double score = (scoreText != null && !scoreText.isEmpty()) ? Double.parseDouble(scoreText) : 0.0;
		int ranking = (rankingText != null && !rankingText.isEmpty()) ? Integer.parseInt(rankingText) : 0;

		Integer lastTeamId = neoLeagueArena.getLastTeamId();
		CoachDTO coachDTO = new CoachDTO();
		coachDTO.setId(coachId != null ? coachId : -1);
		CoachDTO foundCoachDTO = neoLeagueArena.findCoach(coachDTO);

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(lastTeamId);
		teamDTO.setName(name);
		teamDTO.setDescription(description);
		teamDTO.setLogo(logo);
		teamDTO.setScore(score);
		teamDTO.setRanking(ranking);	
		teamDTO.setPlayerIds(null); 
		teamDTO.setTournamentIds(null);

		if (foundCoachDTO != null) {
			String teamCoachName = foundCoachDTO.getFirstName() + " " + foundCoachDTO.getLastName();
			teamDTO.setCoachId(foundCoachDTO.getId());
			teamDTO.setCoachName(teamCoachName);
		} else {
			teamDTO.setCoachId(null);
			teamDTO.setCoachName(null);		
		}

		boolean teamAddedSuccessfully = neoLeagueArena.addTeam(teamDTO);

		if (teamAddedSuccessfully) {
			view.showInfoMessage("Team added succesfully.");
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.resetFields();

			neoLeagueArena.loadTeams();
			List<TeamDTO> teamsDTO = neoLeagueArena.getAllTeams();

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamTablePanel()
			.loadTableData(teamsDTO);

		} else {
			view.showErrorMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Error creating team");
		}
	}

	private void handleAddPlayersToTeam() {

		String selectedPlayer = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamPlayerAssignmentPanel()
				.getPlayerComboBox()
				.getSelectedItem();

		String selectedTeam = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamPlayerAssignmentPanel()
				.getTeamComboBox()
				.getSelectedItem();

		if(selectedPlayer == null || selectedPlayer.isEmpty()) {
			view.showErrorMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please select a player before assigning to a team.");
		}

		if(selectedTeam == null || selectedTeam.isEmpty()) {
			view.showErrorMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please select a team before assigning a player.");
		}

		Integer playerId = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamPlayerAssignmentPanel()
				.getPlayerComboBoxIdValue();

		Integer teamId = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamPlayerAssignmentPanel()
				.getTeamComboBoxIdValue();

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(teamId);

		TeamDTO foundTeamDTO = neoLeagueArena.findTeam(teamDTO);
		TeamDTO newTeamDTO = neoLeagueArena.findTeam(teamDTO);

		List<Integer> playerIds = foundTeamDTO.getPlayerIds();
		playerIds.add(playerId);

		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setId(playerId);

		PlayerDTO foundPlayerDTO = neoLeagueArena.findPlayer(playerDTO);
		PlayerDTO newPlayerDTO = neoLeagueArena.findPlayer(playerDTO);

		newTeamDTO.setPlayerIds(playerIds);
		newPlayerDTO.setCurrentTeamId(newTeamDTO.getId());
		newPlayerDTO.setCurrentTeamName(newTeamDTO.getName());

		if (neoLeagueArena.isPlayerInTeam(playerId, teamId)) {
			view.showErrorMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Player is already assigned to this team..");

			return;
		}

		if (neoLeagueArena.isPlayerAssignedToAnyTeam(playerId)) {
			view.showErrorMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Player is already assigned to another team.");

			return;
		}

		boolean teamUpdated = neoLeagueArena.updateTeam(foundTeamDTO, newTeamDTO);
		boolean playerUpdated = neoLeagueArena.updatePlayer(foundPlayerDTO, newPlayerDTO);

		if (teamUpdated && playerUpdated) {
			view.showInfoMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Player assigned to team successfully.");
		} else {
			view.showErrorMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Failed to assign player to team. Please try again.");
		}

	}

	private void handleSearchTeam() {
		String searchText = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText();

		if (FieldValidator.isEmpty(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please enter a search term.");
			return;
		}

		if (!FieldValidator.isInteger(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please enter a valid ID.");
			return;
		}

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(Integer.parseInt(searchText));
		TeamDTO foundTeamDTO = neoLeagueArena.findTeam(teamDTO);

		if (foundTeamDTO != null) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getIdTextField()
			.setText(foundTeamDTO.getId().toString());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getNameTextField()
			.setText(foundTeamDTO.getName());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getDescriptionTextArea()
			.setText(foundTeamDTO.getDescription());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getLogoTextField()
			.setText(foundTeamDTO.getLogo());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getScoreTextField()
			.setText(String.valueOf(foundTeamDTO.getScore()));

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getRankingTextField()
			.setText(String.valueOf(foundTeamDTO.getRanking()));

			CoachDTO coachDTO = new CoachDTO();
			coachDTO.setId(foundTeamDTO.getCoachId());
			List<CoachDTO> coachesDTO = neoLeagueArena.getAllCoaches();
			CoachDTO foundCoachDTO = neoLeagueArena.findCoach(coachDTO);

			if (foundCoachDTO != null) {
				String coachName = foundCoachDTO.getId() + " - " + foundCoachDTO.getFirstName() + " " + foundCoachDTO.getLastName();

				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.setCoachesComboBox(coachesDTO);

				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getCoachComboBox()
				.setSelectedItem(coachName);
			}

		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"No team found with ID: " + searchText
					);
		}
	}

	private void handleUpdateTeam() {
		String id = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getIdTextField()
				.getText()
				.trim();

		String name = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getNameTextField()
				.getText()
				.trim();

		String description = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getDescriptionTextArea()
				.getText()
				.trim();

		String logoText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getLogoTextField()
				.getText()
				.trim();

		String scoreText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getScoreTextField()
				.getText()
				.trim();

		String rankingText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getRankingTextField()
				.getText()
				.trim();

		Integer coachId = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getCoachComboBoxIdValue();

		String searchText = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText();

		if (FieldValidator.isEmpty(searchText) || FieldValidator.isEmpty(id)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"You must search for a team before updating.");
			return;
		}

		if (FieldValidator.isAnyEmpty(name, description)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please fill in all required fields.");
			return;
		}

		if (!FieldValidator.isAlphanumeric(name)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"The name cannot contain special characters.");
			return;
		}

		TeamDTO teamDTO2 = new TeamDTO();
		teamDTO2.setId(Integer.parseInt(searchText));
		TeamDTO oldTeamDTO2 = neoLeagueArena.findTeam(teamDTO2);

		if (neoLeagueArena.teamNameExists(name, oldTeamDTO2.getId())) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"A team with the name \"" + name + "\" already exists. Please choose another name.");
			return;
		}

		if (description.length() < 10) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Description must be at least 10 characters long.");
			return;
		}

		if (!FieldValidator.isAlphanumeric(description)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"The description cannot contain special characters.");
			return;
		}

		if (!scoreText.isEmpty() && !FieldValidator.isDecimal(scoreText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Score must be a valid decimal number.");
			return;
		}

		if (!rankingText.isEmpty() && !FieldValidator.isInteger(rankingText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Ranking must be a valid integer.");
			return;
		}

		String logo = logoText.isEmpty() ? AssetPaths.TEAM_ICON : logoText;
		double score = (scoreText != null && !scoreText.isEmpty()) ? Double.parseDouble(scoreText) : 0.0;
		int ranking = (rankingText != null && !rankingText.isEmpty()) ? Integer.parseInt(rankingText) : 0;

		CoachDTO coachDTO = new CoachDTO();
		coachDTO.setId(coachId != null ? coachId : -1);
		CoachDTO foundCoachDTO = neoLeagueArena.findCoach(coachDTO);

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(Integer.parseInt(searchText));
		TeamDTO oldTeamDTO = neoLeagueArena.findTeam(teamDTO);

		TeamDTO newTeamDTO = new TeamDTO();
		newTeamDTO.setId(oldTeamDTO.getId());
		newTeamDTO.setName(name);
		newTeamDTO.setDescription(description);
		newTeamDTO.setLogo(logo);
		newTeamDTO.setScore(score);
		newTeamDTO.setRanking(ranking);	
		newTeamDTO.setPlayerIds(oldTeamDTO.getPlayerIds()); 
		newTeamDTO.setTournamentIds(oldTeamDTO.getTournamentIds());

		if (foundCoachDTO != null) {
			String teamCoachName = foundCoachDTO.getFirstName() + " " + foundCoachDTO.getLastName();
			newTeamDTO.setCoachId(foundCoachDTO.getId());
			newTeamDTO.setCoachName(teamCoachName);
		} else {
			newTeamDTO.setCoachId(oldTeamDTO.getCoachId());
			newTeamDTO.setCoachName(oldTeamDTO.getCoachName());		
		}

		boolean teamUpdatedSuccessfully = neoLeagueArena.updateTeam(oldTeamDTO, newTeamDTO);

		if (teamUpdatedSuccessfully) {
			view.showInfoMessage("Team updated succesfully.");
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.resetFields();
		} else {
			view.showErrorMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Error updating team");

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getFormHeaderPanel()
			.resetFields();
		}
	}

	private void handleDeleteTeam() {
		String searchText = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText();

		if (FieldValidator.isEmpty(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please enter a search term.");
			return;
		}

		if (!FieldValidator.isInteger(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please enter a valid ID.");
			return;
		}

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(Integer.parseInt(searchText));
		TeamDTO foundTeamDTO = neoLeagueArena.findTeam(teamDTO);

		if (foundTeamDTO != null) {
			boolean teamDeletedSuccessfully = neoLeagueArena.deleteTeam(foundTeamDTO);

			if (teamDeletedSuccessfully) {
				view.showInfoMessage("Team deleted succesfully.");
				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.resetFields();

				view.showInfoMessage("Team deleted succesfully.");
				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getFormHeaderPanel()
				.resetFields();

			} else {
				view.showErrorMessage(view.getMainWindow()
						.getMainContentPanel()
						.getLayoutContentPanel()
						.getAdminPanel()
						.getAdminContentPanel()
						.getTeamManagementPanel(),
						"Error deleting team");
			}

		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"No team found with ID: " + searchText
					);
		}
	}

	private void handleResetTeamFields() {
		view.getMainWindow()
		.getMainContentPanel()
		.getLayoutContentPanel()
		.getAdminPanel()
		.getAdminContentPanel()
		.getTeamManagementPanel()
		.getTeamFormPanel()
		.getTeamFormFieldsPanel()
		.resetFields();

	}


	// ==========================================
	// ====  ADMIN COMMANDS: PLAYER MANAGEMENT ===
	// ==========================================

	public void handleAdminPlayerCommand(String command) {
		if (command.equals(ButtonActionCommands.ADMIN_CREATE_PLAYER_ACTION_COMMAND)) {
			handleCreatePlayer();
		} else if (command.equals(ButtonActionCommands.ADMIN_SEARCH_PLAYER_ACTION_COMMAND)) {
			handleSearchPlayer();
		} else if (command.equals(ButtonActionCommands.ADMIN_UPDATE_PLAYER_ACTION_COMMAND)) {
			handleUpdatePlayer();
		} else if (command.equals(ButtonActionCommands.ADMIN_DELETE_PLAYER_ACTION_COMMAND)) {
			handleDeletePlayer();
		} else if (command.equals(ButtonActionCommands.ADMIN_RESET_PLAYER_ACTION_COMMAND)) {
			handleResetPlayerFields();
		}
	}

	private void handleCreatePlayer() {
		String id = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getIdTextField()
				.getText()
				.trim();

		String firstName = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getFirstNameTextField()
				.getText()
				.trim();

		String lastName = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getLastNameTextField()
				.getText()
				.trim();

		String nickName = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getNickNameTextField()
				.getText()
				.trim();

		String email = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getEmailTextField()
				.getText()
				.trim();

		String birthDate = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getDateBirthDateTextField()
				.getText()
				.trim();

		String password = new String(view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getPasswordTextField()
				.getPassword())
				.trim();

		String country = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getCountryTextField()
				.getText()
				.trim();

		String city = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getCityTextField()
				.getText()
				.trim();

		Integer experienceLevel = (Integer) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getExperienceLevelSpinner()
				.getValue();


		if (FieldValidator.isAnyEmpty(id, firstName, lastName, nickName, email, password, country, city, birthDate)) {
			view.showErrorMessage(view.getRegisterWindow(), "Please fill in all fields.");
			return;
		}

		if (!FieldValidator.isValidDateFormat(birthDate)) {
			view.showErrorMessage(view.getRegisterWindow(), "Invalid birth date format. Use yyyy-MM-dd.");
			return;
		}

		if (!FieldValidator.isValidEmail(email)) {
			view.showErrorMessage(view.getRegisterWindow(), "Invalid email format.");
			return;
		}

		PlayerDTO newPlayerDTO = new PlayerDTO();

		newPlayerDTO.setId(Integer.parseInt(id));
		newPlayerDTO.setFirstName(firstName);
		newPlayerDTO.setLastName(lastName);
		newPlayerDTO.setNickName(nickName);
		newPlayerDTO.setEmail(email);
		newPlayerDTO.setPassword(password);
		newPlayerDTO.setCountry(country);
		newPlayerDTO.setCity(city);
		newPlayerDTO.setRole(UserRole.PLAYER.getDisplayName());
		newPlayerDTO.setBirthDate(birthDate);
		newPlayerDTO.setExperienceLevel(experienceLevel);
		newPlayerDTO.setCurrentTeamId(null);
		newPlayerDTO.setCurrentTeamName(null);

		boolean successRegistry = neoLeagueArena.addPlayer(newPlayerDTO);

		if (successRegistry) {
			view.showInfoMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getPlayerManagementPanel(), 
					"Player registered successfully!");
			handleResetPlayerFields();

		} else {
			view.showErrorMessage(view.getRegisterWindow(), "Player with that email or ID already exists.");
		}
	}	

	private void handleSearchPlayer() {
		String searchText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText()
				.trim();

		if (FieldValidator.isEmpty(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getPlayerManagementPanel(),
					"Please enter a search term."
					);
			return;
		}

		if (!FieldValidator.isInteger(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getPlayerManagementPanel(),
					"Please enter a valid ID."
					);
			return;
		}

		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setId(Integer.parseInt(searchText));
		PlayerDTO foundPlayerDTO = neoLeagueArena.findPlayer(playerDTO);

		if (foundPlayerDTO != null) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getIdTextField()
			.setText(foundPlayerDTO.getId().toString());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getFirstNameTextField()
			.setText(foundPlayerDTO.getFirstName());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getLastNameTextField()
			.setText(foundPlayerDTO.getLastName());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getNickNameTextField()
			.setText(foundPlayerDTO.getNickName());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getEmailTextField()
			.setText(foundPlayerDTO.getEmail());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getDateBirthDateTextField()
			.setText(foundPlayerDTO.getBirthDate());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getPasswordTextField()
			.setText(foundPlayerDTO.getPassword());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getCountryTextField()
			.setText(foundPlayerDTO.getCountry());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getCityTextField()
			.setText(foundPlayerDTO.getCity());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getExperienceLevelSpinner()
			.setValue(foundPlayerDTO.getExperienceLevel());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.getRoleComboBox()
			.setSelectedItem(foundPlayerDTO.getRole());

		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getPlayerManagementPanel(),
					"No player found with ID: " + searchText
					);
		}

	}

	private void handleUpdatePlayer() {
		String id = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getIdTextField()
				.getText()
				.trim();

		String firstName = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getFirstNameTextField()
				.getText()
				.trim();

		String lastName = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getLastNameTextField()
				.getText()
				.trim();

		String nickName = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getNickNameTextField()
				.getText()
				.trim();

		String email = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getEmailTextField()
				.getText()
				.trim();

		String birthDate = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getDateBirthDateTextField()
				.getText()
				.trim();

		String password = new String(view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getPasswordTextField()
				.getPassword())
				.trim();

		String country = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getCountryTextField()
				.getText()
				.trim();

		String city = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getCityTextField()
				.getText()
				.trim();


		Integer experienceLevel = (Integer) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.getExperienceLevelSpinner()
				.getValue();

		String searchText = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText()
				.trim();

		if (FieldValidator.isEmpty(searchText) || FieldValidator.isEmpty(id)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"You must search for a player before updating.");
			return;
		}

		if (FieldValidator.isAnyEmpty(id, firstName, lastName, email, password, country, city, birthDate)) {
			view.showErrorMessage(view.getRegisterWindow(), "Please fill in all fields.");
			return;
		}

		if (!FieldValidator.isValidDateFormat(birthDate)) {
			view.showErrorMessage(view.getRegisterWindow(), "Invalid birth date format. Use yyyy-MM-dd.");
			return;
		}

		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setId(Integer.parseInt(searchText));
		PlayerDTO oldPlayerDTO = neoLeagueArena.findPlayer(playerDTO);

		PlayerDTO updatePlayerDTO = new PlayerDTO();
		updatePlayerDTO.setId(Integer.parseInt(id));
		updatePlayerDTO.setFirstName(firstName);
		updatePlayerDTO.setLastName(lastName);
		updatePlayerDTO.setNickName(nickName);
		updatePlayerDTO.setEmail(email);
		updatePlayerDTO.setBirthDate(birthDate);
		updatePlayerDTO.setPassword(password);
		updatePlayerDTO.setExperienceLevel(experienceLevel);
		updatePlayerDTO.setCountry(country);
		updatePlayerDTO.setCity(city);
		updatePlayerDTO.setRole(oldPlayerDTO.getRole());

		boolean playerUpdatedSuccessfully = neoLeagueArena.updatePlayer(oldPlayerDTO, updatePlayerDTO);

		if (playerUpdatedSuccessfully) {
			view.showInfoMessage("Player updated successfully.");
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getPlayerFormFieldsPanel()
			.resetFields();
		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getPlayerManagementPanel(),
					"Error updating player"
					);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getPlayerManagementPanel()
			.getPlayerFormPanel()
			.getFormHeaderPanel()
			.resetFields();
		}
	}

	private void handleDeletePlayer() {
		String searchText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText()
				.trim();

		if (FieldValidator.isEmpty(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getPlayerManagementPanel(),
					"Please enter a search term.");
			return;
		}

		if (!FieldValidator.isInteger(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getPlayerManagementPanel(),
					"Please enter a valid ID.");
			return;
		}

		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setId(Integer.parseInt(searchText));
		PlayerDTO foundPlayerDTO = neoLeagueArena.findPlayer(playerDTO);

		if (foundPlayerDTO != null) {
			boolean playerDeletedSuccessfully = neoLeagueArena.deletePlayer(foundPlayerDTO);

			if (playerDeletedSuccessfully) {
				view.showInfoMessage("Player deleted successfully.");

				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getPlayerFormFieldsPanel()
				.resetFields();

				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getPlayerManagementPanel()
				.getPlayerFormPanel()
				.getFormHeaderPanel()
				.resetFields();

			} else {
				view.showErrorMessage(
						view.getMainWindow()
						.getMainContentPanel()
						.getLayoutContentPanel()
						.getAdminPanel()
						.getAdminContentPanel()
						.getPlayerManagementPanel(),
						"Error deleting player");
			}
		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getPlayerManagementPanel(),
					"No player found with ID: " + searchText);
		}

	}

	private void handleResetPlayerFields() {
		view.getMainWindow()
		.getMainContentPanel()
		.getLayoutContentPanel()
		.getAdminPanel()
		.getAdminContentPanel()
		.getPlayerManagementPanel()
		.getPlayerFormPanel()
		.getPlayerFormFieldsPanel()
		.resetFields();
	}


	// ==========================================
	// ====  ADMIN COMMANDS: COACH MANAGEMENT ====
	// ==========================================

	public void handleAdminCoachCommand(String command) {
		if (command.equals(ButtonActionCommands.ADMIN_CREATE_COACH_ACTION_COMMAND)) {
			handleCreateCoach();
		} else if (command.equals(ButtonActionCommands.ADMIN_SEARCH_COACH_ACTION_COMMAND)) {
			handleSearchCoach();
		} else if (command.equals(ButtonActionCommands.ADMIN_UPDATE_COACH_ACTION_COMMAND)) {
			handleUpdateCoach();
		} else if (command.equals(ButtonActionCommands.ADMIN_DELETE_COACH_ACTION_COMMAND)) {
			handleDeleteCoach();
		} else if (command.equals(ButtonActionCommands.ADMIN_RESET_COACH_ACTION_COMMAND)) {
			handleResetCoachFields();
		}
	}

	private void handleCreateCoach() {
		String id = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getIdTextField()
				.getText()
				.trim();

		String firstName = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getFirstNameTextField()
				.getText()
				.trim();

		String lastName = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getLastNameTextField()
				.getText()
				.trim();

		String email = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getEmailTextField()
				.getText()
				.trim();

		String birthDate = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getDateBirthDateTextField()
				.getText()
				.trim();

		String password = new String(view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getPasswordTextField()
				.getPassword())
				.trim();

		String country = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getCountryTextField()
				.getText()
				.trim();

		String city = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getCityTextField()
				.getText()
				.trim();

		if (FieldValidator.isAnyEmpty(id, firstName, lastName, email, password, country, city, birthDate)) {
			view.showErrorMessage(view.getRegisterWindow(), "Please fill in all fields.");
			return;
		}

		if (!FieldValidator.isValidDateFormat(birthDate)) {
			view.showErrorMessage(view.getRegisterWindow(), "Invalid birth date format. Use yyyy-MM-dd.");
			return;
		}

		if (!FieldValidator.isValidEmail(email)) {
			view.showErrorMessage(view.getRegisterWindow(), "Invalid email format.");
			return;
		}

		CoachDTO newCoachDTO = new CoachDTO();
		newCoachDTO.setId(Integer.parseInt(id));
		newCoachDTO.setFirstName(firstName);
		newCoachDTO.setLastName(lastName);
		newCoachDTO.setEmail(email);
		newCoachDTO.setPassword(password);
		newCoachDTO.setCountry(country);
		newCoachDTO.setCity(city);
		newCoachDTO.setRole(UserRole.COACH.getDisplayName());
		newCoachDTO.setBirthDate(birthDate);

		boolean successRegistry = neoLeagueArena.addCoach(newCoachDTO);

		if (successRegistry) {
			view.showInfoMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getCoachManagementPanel(), 
					"Coach registered successfully!");
			handleResetCoachFields(); 

		} else {
			view.showErrorMessage(view.getRegisterWindow(), "Coach with that email or ID already exists.");
		}
	}

	private void handleSearchCoach() {
		String searchText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText()
				.trim();

		if (FieldValidator.isEmpty(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getCoachManagementPanel(),
					"Please enter a search term."
					);
			return;
		}

		if (!FieldValidator.isInteger(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getCoachManagementPanel(),
					"Please enter a valid ID."
					);
			return;
		}

		CoachDTO coachDTO = new CoachDTO();
		coachDTO.setId(Integer.parseInt(searchText));
		CoachDTO foundCoachDTO = neoLeagueArena.findCoach(coachDTO);

		if (foundCoachDTO != null) {
			var coachFields = view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getCoachManagementPanel()
					.getCoachFormPanel()
					.getCoachFormFieldsPanel();

			coachFields.getIdTextField().setText(foundCoachDTO.getId().toString());
			coachFields.getFirstNameTextField().setText(foundCoachDTO.getFirstName());
			coachFields.getLastNameTextField().setText(foundCoachDTO.getLastName());
			coachFields.getEmailTextField().setText(foundCoachDTO.getEmail());
			coachFields.getDateBirthDateTextField().setText(foundCoachDTO.getBirthDate());
			coachFields.getPasswordTextField().setText(foundCoachDTO.getPassword());
			coachFields.getCountryTextField().setText(foundCoachDTO.getCountry());
			coachFields.getCityTextField().setText(foundCoachDTO.getCity());
			coachFields.getRoleComboBox().setSelectedItem(foundCoachDTO.getRole());

		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getCoachManagementPanel(),
					"No coach found with ID: " + searchText
					);
		}
	}

	private void handleUpdateCoach() {
		String id = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getIdTextField()
				.getText()
				.trim();

		String firstName = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getFirstNameTextField()
				.getText()
				.trim();

		String lastName = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getLastNameTextField()
				.getText()
				.trim();

		String email = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getEmailTextField()
				.getText()
				.trim();

		String birthDate = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getDateBirthDateTextField()
				.getText()
				.trim();

		String password = new String(view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getPasswordTextField()
				.getPassword())
				.trim();

		String country = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getCountryTextField()
				.getText()
				.trim();

		String city = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.getCityTextField()
				.getText()
				.trim();

		String searchText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText()
				.trim();

		if (FieldValidator.isEmpty(searchText) || FieldValidator.isEmpty(id)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getCoachManagementPanel(),
					"You must search for a coach before updating.");
			return;
		}

		if (FieldValidator.isAnyEmpty(id, firstName, lastName, email, password, country, city, birthDate)) {
			view.showErrorMessage(view.getRegisterWindow(), "Please fill in all fields.");
			return;
		}

		if (!FieldValidator.isValidDateFormat(birthDate)) {
			view.showErrorMessage(view.getRegisterWindow(), "Invalid birth date format. Use yyyy-MM-dd.");
			return;
		}

		CoachDTO coachDTO = new CoachDTO();
		coachDTO.setId(Integer.parseInt(searchText));
		CoachDTO oldCoachDTO = neoLeagueArena.findCoach(coachDTO);

		CoachDTO updateCoachDTO = new CoachDTO();
		updateCoachDTO.setId(Integer.parseInt(id));
		updateCoachDTO.setFirstName(firstName);
		updateCoachDTO.setLastName(lastName);
		updateCoachDTO.setEmail(email);
		updateCoachDTO.setBirthDate(birthDate);
		updateCoachDTO.setPassword(password);
		updateCoachDTO.setCountry(country);
		updateCoachDTO.setCity(city);
		updateCoachDTO.setRole(oldCoachDTO.getRole());

		boolean coachUpdatedSuccessfully = neoLeagueArena.updateCoach(oldCoachDTO, updateCoachDTO);

		if (coachUpdatedSuccessfully) {
			view.showInfoMessage("Coach updated successfully.");
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getCoachManagementPanel()
			.getCoachFormPanel()
			.getCoachFormFieldsPanel()
			.resetFields();
		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getCoachManagementPanel(),
					"Error updating coach");

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getCoachManagementPanel()
			.getCoachFormPanel()
			.getFormHeaderPanel()
			.resetFields();
		}
	}

	private void handleDeleteCoach() {
		String searchText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText()
				.trim();

		if (FieldValidator.isEmpty(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getCoachManagementPanel(),
					"Please enter a search term.");
			return;
		}

		if (!FieldValidator.isInteger(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getCoachManagementPanel(),
					"Please enter a valid ID.");
			return;
		}

		CoachDTO coachDTO = new CoachDTO();
		coachDTO.setId(Integer.parseInt(searchText));
		CoachDTO foundCoachDTO = neoLeagueArena.findCoach(coachDTO);

		if (foundCoachDTO != null) {
			boolean coachDeletedSuccessfully = neoLeagueArena.deleteCoach(foundCoachDTO);

			if (coachDeletedSuccessfully) {
				view.showInfoMessage("Coach deleted successfully.");

				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getCoachFormFieldsPanel()
				.resetFields();

				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getCoachManagementPanel()
				.getCoachFormPanel()
				.getFormHeaderPanel()
				.resetFields();

			} else {
				view.showErrorMessage(
						view.getMainWindow()
						.getMainContentPanel()
						.getLayoutContentPanel()
						.getAdminPanel()
						.getAdminContentPanel()
						.getCoachManagementPanel(),
						"Error deleting coach");
			}
		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getCoachManagementPanel(),
					"No coach found with ID: " + searchText);
		}
	}

	private void handleResetCoachFields() {
		view.getMainWindow()
		.getMainContentPanel()
		.getLayoutContentPanel()
		.getAdminPanel()
		.getAdminContentPanel()
		.getCoachManagementPanel()
		.getCoachFormPanel()
		.getCoachFormFieldsPanel()
		.resetFields();
	}


	// ==========================================
	// ====  ADMIN COMMANDS: GAME MANAGEMENT ====
	// ==========================================

	public void handleAdminGameCommand(String command) {
		if (command.equals(ButtonActionCommands.ADMIN_CREATE_GAME_ACTION_COMMAND)) {
			handleCreateGame();
		} else if (command.equals(ButtonActionCommands.ADMIN_SEARCH_GAME_ACTION_COMMAND)) {
			handleSearchGame();
		} else if (command.equals(ButtonActionCommands.ADMIN_UPDATE_GAME_ACTION_COMMAND)) {
			handleUpdateGame();
		} else if (command.equals(ButtonActionCommands.ADMIN_DELETE_GAME_ACTION_COMMAND)) {
			handleDeleteGame();
		} else if (command.equals(ButtonActionCommands.ADMIN_RESET_GAME_ACTION_COMMAND)) {
			handleResetGameFields();
		}
	}

	private void handleCreateGame() {
		String idStr = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel() //
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getIdTextField()
				.getText()
				.trim();

		String name = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getNameTextField()
				.getText()
				.trim();

		String description = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getDescriptionTextArea()
				.getText()
				.trim();

		String logo = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getLogoTextField()
				.getText()
				.trim();

		GameGenre genre = (GameGenre) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getGenreComboBox()
				.getSelectedItem();

		GamePlatform platform = (GamePlatform) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getPlatformComboBox()
				.getSelectedItem();

		List<GameMode> selectedModes = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getModesList()
				.getSelectedValuesList();

		if (FieldValidator.isAnyEmpty(idStr, name, description) 
				|| genre == null 
				|| platform == null 
				|| selectedModes.isEmpty()) {
			view.showErrorMessage(view.getMainWindow(), "Please fill in all required fields.");
			return;
		}

		if (!FieldValidator.isInteger(idStr)) {
			view.showErrorMessage(view.getMainWindow(), "ID must be a valid integer.");
			return;
		}

		List<String> modeNames = new ArrayList<>();

		int id = Integer.parseInt(idStr);
		GameDTO newGameDTO = new GameDTO();
		newGameDTO.setId(id);
		newGameDTO.setName(name);
		newGameDTO.setDescription(description);
		newGameDTO.setLogo(logo);
		newGameDTO.setGenre(genre.getDisplayName());
		newGameDTO.setPlatform(platform.getDisplayName());

		for (GameMode mode : selectedModes) {
			modeNames.add(mode.getDisplayName());
		}

		newGameDTO.setModes(modeNames);

		boolean successRegistry = neoLeagueArena.addGame(newGameDTO);

		if (successRegistry) {
			view.showInfoMessage(view.getMainWindow(), "Game registered successfully!");
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getGameManagementPanel()
			.getGameFormPanel()
			.getGameFormFieldsPanel()
			.resetFields();
		} else {
			view.showErrorMessage(view.getMainWindow(), "Game with that ID or name already exists.");
		}
	}


	private void handleSearchGame() {
		String searchText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText()
				.trim();

		if (FieldValidator.isEmpty(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getGameManagementPanel(),
					"Please enter a search term."
					);
			return;
		}

		if (!FieldValidator.isInteger(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getGameManagementPanel(),
					"Please enter a valid ID."
					);
			return;
		}

		GameDTO gameDTO = new GameDTO();
		gameDTO.setId(Integer.parseInt(searchText));
		GameDTO foundGameDTO = neoLeagueArena.findGame(gameDTO);

		if (foundGameDTO != null) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getGameManagementPanel()
			.getGameFormPanel()
			.getGameFormFieldsPanel()
			.getIdTextField()
			.setText(foundGameDTO.getId().toString());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getGameManagementPanel()
			.getGameFormPanel()
			.getGameFormFieldsPanel()
			.getNameTextField()
			.setText(foundGameDTO.getName());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getGameManagementPanel()
			.getGameFormPanel()
			.getGameFormFieldsPanel()
			.getGenreComboBox()
			.setSelectedItem(foundGameDTO.getGenre());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getGameManagementPanel()
			.getGameFormPanel()
			.getGameFormFieldsPanel()
			.getPlatformComboBox()
			.setSelectedItem(foundGameDTO.getPlatform());

			List<?> rawModes = foundGameDTO.getModes();

			List<GameMode> convertedModes = rawModes.stream()
					.map(mode -> {
						if (mode instanceof GameMode) {
							return (GameMode) mode;
						} else if (mode instanceof String) {
							return GameMode.valueOf((String) mode);
						} else {
							throw new IllegalArgumentException("Invalid type in modes list: " + mode.getClass());
						}
					})
					.toList();

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getGameManagementPanel()
			.getGameFormPanel()
			.getGameFormFieldsPanel()
			.selectModes(convertedModes);

		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getGameManagementPanel(),
					"No game found with ID: " + searchText
					);
		}
	}

	private void handleUpdateGame() {
		String idText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getIdTextField()
				.getText()
				.trim();

		String name = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getNameTextField()
				.getText()
				.trim();

		String description = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getDescriptionTextArea()
				.getText()
				.trim();

		String logo = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getLogoTextField()
				.getText()
				.trim();

		String genre = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getGenreComboBox()
				.getSelectedItem();

		String platform = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getPlatformComboBox()
				.getSelectedItem();

		/*List<String> modes = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.getModesList()
				.getSelectedValuesList(); */

		String searchText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText()
				.trim();

		if (FieldValidator.isEmpty(searchText) || FieldValidator.isEmpty(idText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getGameManagementPanel(),
					"You must search for a game before updating.");
			return;
		}

		if (FieldValidator.isAnyEmpty(idText, name, description, logo, genre, platform)) {
			view.showErrorMessage(view.getRegisterWindow(), "Please fill in all fields.");
			return;
		}

		GameDTO oldGameDTO = new GameDTO();
		oldGameDTO.setId(Integer.parseInt(searchText));

		GameDTO foundGame = neoLeagueArena.findGame(oldGameDTO);
		if (foundGame == null) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getGameManagementPanel(),
					"Game not found.");
			return;
		}

		GameDTO updatedGame = new GameDTO();
		updatedGame.setId(Integer.parseInt(idText));
		updatedGame.setName(name);
		updatedGame.setDescription(description);
		updatedGame.setLogo(logo);
		updatedGame.setGenre(genre);
		updatedGame.setPlatform(platform);
		// updatedGame.setModes(modes);

		boolean gameUpdated = neoLeagueArena.updateGame(foundGame, updatedGame);

		if (gameUpdated) {
			view.showInfoMessage("Game updated successfully.");
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getGameManagementPanel()
			.getGameFormPanel()
			.getGameFormFieldsPanel()
			.resetFields();
		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getGameManagementPanel(),
					"Error updating game.");

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getGameManagementPanel()
			.getGameFormPanel()
			.getFormHeaderPanel()
			.resetFields();
		}
	}


	private void handleDeleteGame() {
		String searchText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText()
				.trim();

		if (FieldValidator.isEmpty(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getGameManagementPanel(),
					"Please enter a search term.");
			return;
		}

		if (!FieldValidator.isInteger(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getGameManagementPanel(),
					"Please enter a valid ID.");
			return;
		}

		GameDTO gameDTO = new GameDTO();
		gameDTO.setId(Integer.parseInt(searchText));
		GameDTO foundGameDTO = neoLeagueArena.findGame(gameDTO);

		if (foundGameDTO != null) {
			boolean gameDeletedSuccessfully = neoLeagueArena.deleteGame(foundGameDTO);

			if (gameDeletedSuccessfully) {
				view.showInfoMessage("Game deleted successfully.");
				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getGameFormFieldsPanel()
				.resetFields();

				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getGameManagementPanel()
				.getGameFormPanel()
				.getFormHeaderPanel()
				.resetFields();

			} else {
				view.showErrorMessage(
						view.getMainWindow()
						.getMainContentPanel()
						.getLayoutContentPanel()
						.getAdminPanel()
						.getAdminContentPanel()
						.getGameManagementPanel(),
						"Error deleting game.");
			}

		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getGameManagementPanel(),
					"No game found with ID: " + searchText);
		}
	}

	private void handleResetGameFields() {
		view.getMainWindow()
		.getMainContentPanel()
		.getLayoutContentPanel()
		.getAdminPanel()
		.getAdminContentPanel()
		.getGameManagementPanel()
		.getGameFormPanel()
		.getGameFormFieldsPanel()
		.resetFields();
	}

	// ==========================================
	// ==== ADMIN COMMANDS: TOURNAMENT MANAGEMENT ====
	// ==========================================

	public void handleAdminTournamentCommand(String command) {
		if (command.equals(ButtonActionCommands.ADMIN_CREATE_TOURNAMENT_ACTION_COMMAND)) {
			handleCreateTournament();
		} else if (command.equals(ButtonActionCommands.ADMIN_SEARCH_TOURNAMENT_ACTION_COMMAND)) {
			handleSearchTournament();
		} else if (command.equals(ButtonActionCommands.ADMIN_UPDATE_TOURNAMENT_ACTION_COMMAND)) {
			handleUpdateTournament();
		} else if (command.equals(ButtonActionCommands.ADMIN_DELETE_TOURNAMENT_ACTION_COMMAND)) {
			handleDeleteTournament();
		} else if (command.equals(ButtonActionCommands.ADMIN_RESET_TOURNAMENT_ACTION_COMMAND)) {
			handleResetTournamentFields();
		}
	}

	private void handleCreateTournament() {
		String idText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentFormPanel()
				.getTournamentFormFieldsPanel()
				.getIdTextField()
				.getText()
				.trim();

		String name = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentFormPanel()
				.getTournamentFormFieldsPanel()
				.getNameTextField()
				.getText()
				.trim();

		String description = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentFormPanel()
				.getTournamentFormFieldsPanel()
				.getDescriptionTextArea()
				.getText()
				.trim();

		String selectedPlatform = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentFormPanel()
				.getTournamentFormFieldsPanel()
				.getPlatformComboBox()
				.getSelectedItem();

		String selectedGame = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentFormPanel()
				.getTournamentFormFieldsPanel()
				.getGameComboBox()
				.getSelectedItem();

		String selectedPhase = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentFormPanel()
				.getTournamentFormFieldsPanel()
				.getPhaseComboBox()
				.getSelectedItem();

		if (idText.isEmpty()) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Please enter a valid ID."
					);
			return;
		}
		if (!FieldValidator.isInteger(idText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"ID must be numeric."
					);
			return;
		}

		if (name.isEmpty()) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Please enter a valid name."
					);
			return;
		}

		if (description.isEmpty() || description.length() < 10) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Description must be at least 10 characters long."
					);
			return;
		}

		if (selectedPlatform == null || selectedPlatform.isEmpty()) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Please select a valid platform."
					);
			return;
		}

		if (selectedGame == null || selectedGame.isEmpty()) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Please select a valid game."
					);
			return;
		}

		if (selectedPhase == null || selectedPhase.isEmpty()) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Please select a valid phase."
					);
			return;
		}

		TournamentDTO newTournament = new TournamentDTO();
		newTournament.setId(Integer.parseInt(idText));
		newTournament.setName(name);
		newTournament.setDescription(description);
		newTournament.setPlatform(selectedPlatform);
		newTournament.setGame(selectedGame);
		newTournament.setPhase(selectedPhase);

		boolean successRegistry = neoLeagueArena.addTournament(newTournament);

		if (successRegistry) {
			view.showInfoMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Tournament created successfully!"
					);

			handleResetTournamentFields();

		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Tournament with that ID already exists or could not be created."
					);
		}
	}


	private void handleCreateTournament2() {
		String tournamentText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentFormPanel()
				.getTournamentFormFieldsPanel()
				.getIdTextField()
				.getText()
				.trim();

		String teamAText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getTeamAComboBox()
				.getSelectedItem()
				.toString()
				.trim();

		String teamBText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getTeamBComboBox()
				.getSelectedItem()
				.toString()
				.trim();

		String date = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getDateField()
				.getText()
				.trim();

		String startTime = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getStartTimeField()
				.getText()
				.trim();

		String endTime = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getEndTimeField()
				.getText()
				.trim();

		String winner = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getWinnerComboBox()
				.getSelectedItem();

		String scoreAText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getScoreTeamAField()
				.getText()
				.trim();

		String scoreBText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getScoreTeamBField()
				.getText()
				.trim();

		String summary = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getSummaryArea()
				.getText()
				.trim();

		String status = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getStatusComboBox()
				.getSelectedItem();

		if (FieldValidator.isAnyEmpty(tournamentText, teamAText, teamBText, date, startTime, endTime, scoreAText, scoreBText, summary, status)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Please fill in all fields."
					);
			return;
		}

		if (!FieldValidator.isInteger(tournamentText) ||
				!FieldValidator.isInteger(teamAText) ||
				!FieldValidator.isInteger(teamBText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Tournament and Team IDs must be valid integers."
					);
			return;
		}
		int tournamentId = Integer.parseInt(tournamentText);
		int teamAId       = Integer.parseInt(teamAText);
		int teamBId       = Integer.parseInt(teamBText);

		// Formato de fecha
		if (!FieldValidator.isValidDateFormat(date)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Invalid date format. Use yyyy-MM-dd."
					);
			return;
		}

		// Formato de hora
		if (!startTime.matches("\\d{2}:\\d{2}") || !endTime.matches("\\d{2}:\\d{2}")) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Time must be in HH:mm format."
					);
			return;
		}

		// Puntajes
		if (!FieldValidator.isInteger(scoreAText) || !FieldValidator.isInteger(scoreBText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Scores must be valid integers."
					);
			return;
		}
		int scoreA = Integer.parseInt(scoreAText);
		int scoreB = Integer.parseInt(scoreBText);

		if ("Select winner".equals(winner)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel(),
					"Please select a winner."
					);
			return;
		}

		// Aquí ya tienes todas las variables validadas:
		//   tournamentId, teamAId, teamBId,
		//   date, startTime, endTime,
		//   winner, scoreA, scoreB,
		//   summary, status

		// TODO: construir un MatchDTO, llamara a neoLeagueArena.addMatch(...) o similar
	}

	private void handleSearchTournament() {
		// TODO: implement tournament search logic
	}

	private void handleUpdateTournament() {
		// TODO: implement tournament update logic
	}

	private void handleDeleteTournament() {
		// TODO: implement tournament deletion logic
	}

	private void handleResetTournamentFields() {
		view.getMainWindow()
		.getMainContentPanel()
		.getLayoutContentPanel()
		.getAdminPanel()
		.getAdminContentPanel()
		.getTournamentManagementPanel()
		.getTournamentFormPanel()
		.getTournamentFormFieldsPanel()
		.resetFields();
	}


	// ==========================================
	// ==== ADMIN COMMANDS: MATCH MANAGEMENT ====
	// ==========================================

	public void handleAdminMatchCommand(String command) {
		if (command.equals(ButtonActionCommands.ADMIN_CREATE_MATCH_ACTION_COMMAND)) {
			handleCreateMatch();
		} else if (command.equals(ButtonActionCommands.ADMIN_SEARCH_MATCH_ACTION_COMMAND)) {
			handleSearchMatch();
		} else if (command.equals(ButtonActionCommands.ADMIN_UPDATE_MATCH_ACTION_COMMAND)) {
			handleUpdateMatch();
		} else if (command.equals(ButtonActionCommands.ADMIN_DELETE_MATCH_ACTION_COMMAND)) {
			handleDeleteMatch();
		} else if (command.equals(ButtonActionCommands.ADMIN_RESET_MATCH_ACTION_COMMAND)) {
			handleResetMatchFields();
		}
	}

	private void handleCreateMatch() {

		Integer tournamentId = (Integer) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getTournamentComboBoxIdValue();

		Integer teamAId = (Integer) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getTeamAComboBoxIdValue();

		Integer teamBId = (Integer) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getTeamBComboBoxIdValue();

		String dateText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getDateField()
				.getText();

		String startTimeText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getStartTimeField()
				.getText();

		String endTimeText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getEndTimeField()
				.getText();

		Integer winnerId = (Integer) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getWinnerComboBoxIdValue();

		String statusText = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getStatusComboBox()
				.getSelectedItem();
		
		String teamAScore = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getScoreTeamAField()
				.getText();
		
		String teamBScore = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTournamentManagementPanel()
				.getTournamentMatchAssignmentPanel()
				.getScoreTeamBField()
				.getText();

		if (FieldValidator.isAnyEmpty(dateText, startTimeText, endTimeText, statusText)) {
			view.showErrorMessage(view.getMainWindow(), "Please complete all fields.");
			return;
		}

		if (!FieldValidator.isValidDateFormat(dateText)) {
			view.showErrorMessage(view.getMainWindow(), "Invalid date format. Use yyyy-MM-dd.");
			return;
		}

		if (!FieldValidator.isValidTimeFormat(startTimeText)) {
			view.showErrorMessage(view.getMainWindow(), "Invalid start time format. Use HH:mm.");
			return;
		}

		if (!FieldValidator.isValidTimeFormat(endTimeText)) {
			view.showErrorMessage(view.getMainWindow(), "Invalid end time format. Use HH:mm.");
			return;
		}
		
		if (!FieldValidator.isDecimal(teamAScore)) {
			view.showErrorMessage(view.getMainWindow(), "The A score must be a numerical value.");
			return;
		}
		
		if (!FieldValidator.isDecimal(teamBScore)) {
			view.showErrorMessage(view.getMainWindow(), "The B score must be a numerical value.");
			return;
		}

		if (teamAId == teamBId) {
			view.showErrorMessage(view.getMainWindow(), "Selected teams must be different.");
			return;
		}

		LocalDate date = LocalDate.parse(dateText);
		LocalTime startTime = LocalTime.parse(startTimeText);
		LocalTime endTime = LocalTime.parse(endTimeText);

		TeamDTO team1DTO = new TeamDTO();
		team1DTO.setId(teamAId);
		
		TeamDTO team2DTO = new TeamDTO();
		team2DTO.setId(teamBId);

		TeamDTO foundTeam1DTO = neoLeagueArena.findTeam(team1DTO);
		TeamDTO foundTeam2DTO = neoLeagueArena.findTeam(team2DTO);
		
		
		MatchDTO newMatchDTO = new MatchDTO();
		newMatchDTO.setId(neoLeagueArena.getNextMtachId());
		newMatchDTO.setTournamentId(tournamentId);
		newMatchDTO.setTeamAId(teamAId);
		newMatchDTO.setTeamBId(teamBId);
		newMatchDTO.setTeamAName(foundTeam1DTO.getName());
		newMatchDTO.setTeamBName(foundTeam2DTO.getName());
		newMatchDTO.setDate(date);
		newMatchDTO.setStartTime(startTime);
		newMatchDTO.setEndTime(endTime);
		newMatchDTO.setWinnerId(winnerId);
		newMatchDTO.setStatus(statusText);
		newMatchDTO.setTeamAScore(Double.parseDouble(teamAScore));
		newMatchDTO.setTeamBScore(Double.parseDouble(teamBScore));
		newMatchDTO.setTeamBScore(0);
		newMatchDTO.setSummary("");

		boolean success = neoLeagueArena.addMatch(newMatchDTO);

		if (success) {
			view.showInfoMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTournamentManagementPanel()
					.getTournamentMatchAssignmentPanel(),
					"Match created successfully!");

			resetMatchFields();

		} else {
			view.showErrorMessage(view.getMainWindow(), "Failed to create match. It may already exist.");
		}
	}

	private void resetMatchFields() {
		view.getMainWindow()
		.getMainContentPanel()
		.getLayoutContentPanel()
		.getAdminPanel()
		.getAdminContentPanel()
		.getTournamentManagementPanel()
		.getTournamentMatchAssignmentPanel()
		.resetFields();
	}

	private void handleSearchMatch() {
		// TODO: implement logic for searching a match
	}

	private void handleUpdateMatch() {
		// TODO: implement logic for updating a match
	}

	private void handleDeleteMatch() {
		// TODO: implement logic for deleting a match
	}

	private void handleResetMatchFields() {
		// TODO: implement logic for resetting match form fields
	}


}
