package view.modules.layout;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import co.edu.unbosque.util.ViewNames;
import view.module.home.HomePanel;
import view.module.match.MatchPanel;
import view.module.report.ReportPanel;
import view.module.settings.SettingsPanel;
import view.module.team.TeamDetailPanel;
import view.module.team.TeamPanel;
import view.module.tournament.TournamentDetailPanel;
import view.module.tournament.TournamentPanel;
import view.modules.admin.AdminPanel;
import view.modules.coach.CoachPanel;
import view.modules.game.GamePanel;
import view.modules.player.PlayerDetailPanel;
import view.modules.player.PlayerPanel;

public class LayoutContentPanel extends JPanel {

	private CardLayout cardLayout;

	private HomePanel homePanel;
	private TournamentPanel tournamentPanel;
	private TournamentDetailPanel tournamentDetailPanel;
	private TeamPanel teamsPanel;
	private TeamDetailPanel teamDetailPanel;
	private PlayerPanel playerPanel;
	private PlayerDetailPanel playerDetailPanel;
	private CoachPanel coachPanel;
	private AdminPanel adminPanel;
	private MatchPanel matchPanel;
	private GamePanel gamePanel;
	private ReportPanel reportPanel;
	private SettingsPanel settingsPanel;

	public LayoutContentPanel() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		
		setPreferredSize(new Dimension(800, 600));
		initializeComponents();
	}

	public void initializeComponents() {
		homePanel = new HomePanel();
		
		tournamentPanel = new TournamentPanel();
		tournamentDetailPanel = new TournamentDetailPanel();
		
		teamsPanel = new TeamPanel();
		teamDetailPanel = new TeamDetailPanel();
		
		playerPanel = new PlayerPanel();
		playerDetailPanel = new PlayerDetailPanel();
		
		coachPanel = new CoachPanel();
		adminPanel = new AdminPanel();
		matchPanel = new MatchPanel();
		gamePanel = new GamePanel();
		reportPanel = new ReportPanel();
		settingsPanel = new SettingsPanel();

		add(homePanel, ViewNames.HOME_VIEW);
		add(tournamentPanel, ViewNames.TOURNAMENT_VIEW);
		add(tournamentDetailPanel, ViewNames.TOURNAMENT_DETAIL_VIEW);
		add(teamsPanel, ViewNames.TEAM_VIEW);
		add(teamDetailPanel, ViewNames.TEAM_DETAIL_VIEW);
		add(playerPanel, ViewNames.PLAYER_VIEW);
		add(playerDetailPanel, ViewNames.PLAYER_DETAIL_VIEW);
		add(coachPanel, ViewNames.COACH_VIEW);
		add(adminPanel, ViewNames.ADMIN_VIEW);
		add(matchPanel, ViewNames.MATCH_VIEW);
		add(gamePanel, ViewNames.GAME_VIEW);
		add(reportPanel, ViewNames.REPORT_VIEW);
		add(settingsPanel, ViewNames.SETTINGS_VIEW);
	}

	public void repaintView() {
		revalidate();
		repaint();
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

	public HomePanel getHomePanel() {
		return homePanel;
	}

	public void setHomePanel(HomePanel homePanel) {
		this.homePanel = homePanel;
	}

	public TournamentPanel getTournamentPanel() {
		return tournamentPanel;
	}

	public void setTournamentPanel(TournamentPanel tournamentPanel) {
		this.tournamentPanel = tournamentPanel;
	}

	public TournamentDetailPanel getTournamentDetailPanel() {
		return tournamentDetailPanel;
	}

	public void setTournamentDetailPanel(TournamentDetailPanel tournamentDetailPanel) {
		this.tournamentDetailPanel = tournamentDetailPanel;
	}

	public TeamPanel getTeamsPanel() {
		return teamsPanel;
	}

	public void setTeamsPanel(TeamPanel teamsPanel) {
		this.teamsPanel = teamsPanel;
	}

	public TeamDetailPanel getTeamDetailPanel() {
		return teamDetailPanel;
	}

	public void setTeamDetailPanel(TeamDetailPanel teamDetailPanel) {
		this.teamDetailPanel = teamDetailPanel;
	}

	public PlayerPanel getPlayerPanel() {
		return playerPanel;
	}

	public void setPlayerPanel(PlayerPanel playerPanel) {
		this.playerPanel = playerPanel;
	}

	public PlayerDetailPanel getPlayerDetailPanel() {
		return playerDetailPanel;
	}

	public void setPlayerDetailPanel(PlayerDetailPanel playerDetailPanel) {
		this.playerDetailPanel = playerDetailPanel;
	}

	public CoachPanel getCoachPanel() {
		return coachPanel;
	}

	public void setCoachPanel(CoachPanel coachPanel) {
		this.coachPanel = coachPanel;
	}

	public AdminPanel getAdminPanel() {
		return adminPanel;
	}

	public void setAdminPanel(AdminPanel adminPanel) {
		this.adminPanel = adminPanel;
	}

	public MatchPanel getMatchPanel() {
		return matchPanel;
	}

	public void setMatchPanel(MatchPanel matchPanel) {
		this.matchPanel = matchPanel;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public ReportPanel getReportPanel() {
		return reportPanel;
	}

	public void setReportPanel(ReportPanel reportPanel) {
		this.reportPanel = reportPanel;
	}

	public SettingsPanel getSettingsPanel() {
		return settingsPanel;
	}

	public void setSettingsPanel(SettingsPanel settingsPanel) {
		this.settingsPanel = settingsPanel;
	}

}
