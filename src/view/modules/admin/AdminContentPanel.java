package view.modules.admin;

import java.awt.CardLayout;
import javax.swing.JPanel;

import utils.ViewNames;
import view.module.match.MatchManagementPanel;
import view.module.team.TeamManagementPanel;
import view.module.tournament.TournamentManagementPanel;
import view.modules.coach.CoachManagementPanel;
import view.modules.game.GameManagementPanel;
import view.modules.player.PlayerManagementPanel;

public class AdminContentPanel extends JPanel {

	private CardLayout cardLayout;
	private TournamentManagementPanel tournamentManagementPanel;
	private TeamManagementPanel teamManagementPanel;
	private PlayerManagementPanel playerManagementPanel;
	private CoachManagementPanel coachManagementPanel;
	private AdminManagementPanel adminManagementPanel;
	private MatchManagementPanel matchManagementPanel;
	private GameManagementPanel gameManagementPanel;

	public AdminContentPanel() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		initializeComponents(); 
	}
	
	public void initializeComponents() {
		tournamentManagementPanel = new TournamentManagementPanel();
		teamManagementPanel = new TeamManagementPanel();	
		playerManagementPanel = new PlayerManagementPanel();
		coachManagementPanel = new CoachManagementPanel();
		adminManagementPanel = new AdminManagementPanel();
		matchManagementPanel = new MatchManagementPanel();
		gameManagementPanel = new GameManagementPanel();

		add(teamManagementPanel, ViewNames.ADMIN_TEAM_VIEW);
		add(tournamentManagementPanel, ViewNames.ADMIN_TOURNAMENT_VIEW);
		add(playerManagementPanel, ViewNames.ADMIN_PLAYER_VIEW);
		add(coachManagementPanel, ViewNames.ADMIN_COACH_VIEW);
		add(adminManagementPanel, ViewNames.ADMIN_ADMIN_VIEW);
		add(matchManagementPanel, ViewNames.ADMIN_MATCH_VIEW);
		add(gameManagementPanel, ViewNames.ADMIN_GAME_VIEW);
	}

	public void showView(String viewName) {
		cardLayout.show(this, viewName);
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public TeamManagementPanel getTeamManagementPanel() {
		return teamManagementPanel;
	}

	public void setTeamManagementPanel(TeamManagementPanel teamManagementPanel) {
		this.teamManagementPanel = teamManagementPanel;
	}

	public TournamentManagementPanel getTournamentManagementPanel() {
		return tournamentManagementPanel;
	}

	public void setTournamentManagementPanel(TournamentManagementPanel tournamentManagementPanel) {
		this.tournamentManagementPanel = tournamentManagementPanel;
	}

	public PlayerManagementPanel getPlayerManagementPanel() {
		return playerManagementPanel;
	}

	public void setPlayerManagementPanel(PlayerManagementPanel playerManagementPanel) {
		this.playerManagementPanel = playerManagementPanel;
	}

	public CoachManagementPanel getCoachManagementPanel() {
		return coachManagementPanel;
	}

	public void setCoachManagementPanel(CoachManagementPanel coachManagementPanel) {
		this.coachManagementPanel = coachManagementPanel;
	}

	public AdminManagementPanel getAdminManagementPanel() {
		return adminManagementPanel;
	}

	public void setAdminManagementPanel(AdminManagementPanel adminManagementPanel) {
		this.adminManagementPanel = adminManagementPanel;
	}

	public MatchManagementPanel getMatchManagementPanel() {
		return matchManagementPanel;
	}

	public void setMatchManagementPanel(MatchManagementPanel matchManagementPanel) {
		this.matchManagementPanel = matchManagementPanel;
	}

	public GameManagementPanel getGameManagementPanel() {
		return gameManagementPanel;
	}

	public void setGameManagementPanel(GameManagementPanel gameManagementPanel) {
		this.gameManagementPanel = gameManagementPanel;
	}
}
