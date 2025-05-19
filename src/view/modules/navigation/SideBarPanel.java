package view.modules.navigation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.AssetPaths;
import utils.Colors;
import utils.ViewNames;

public class SideBarPanel extends JPanel {

	private JPanel logoPanel;
	private JPanel menuOptionsPanel;

	private JButton homeButton;
	private JButton tournamentsButton;
	private JButton teamsButton;
	private JButton playersButton;
	private JButton coachesButton;
	private JButton adminsButton;
	private JButton matchesButton;
	private JButton gamesButton;
	private JButton reportsButton;
	private JButton settingsButton;

	public SideBarPanel() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 600));
		setBackground(Color.decode(Colors.DARK_SECONDARY));

		initializeComponents();
		applyHighlightStyle(homeButton);
	}

	public void initializeComponents() {
		initializeLogoPanel();
		initializeMenuOptionsPanel();

		add(logoPanel, BorderLayout.NORTH);
		add(menuOptionsPanel, BorderLayout.CENTER);
	}

	private void initializeLogoPanel() {
		logoPanel = new JPanel();
		logoPanel.setBackground(Color.decode(Colors.DARK_SECONDARY));
		logoPanel.setPreferredSize(new Dimension(200, 80));
		logoPanel.setBorder(new EmptyBorder(20, 0, 20, 0)); 

		JLabel logoLabel = new JLabel(loadIcon(AssetPaths.LIGHT_LOGO, 180, 40));
		logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoPanel.add(logoLabel);
	}

	private void initializeMenuOptionsPanel() {
		menuOptionsPanel = new JPanel();
		menuOptionsPanel.setBackground(Color.decode(Colors.DARK_SECONDARY));
		menuOptionsPanel.setLayout(new BoxLayout(menuOptionsPanel, BoxLayout.Y_AXIS));

		homeButton = createMenuOptionButton(ViewNames.HOME_VIEW, AssetPaths.HOME_ICON);
		homeButton.setActionCommand(ViewNames.HOME_VIEW);

		tournamentsButton = createMenuOptionButton(ViewNames.TOURNAMENT_VIEW, AssetPaths.TOURNAMENT_ICON);
		tournamentsButton.setActionCommand(ViewNames.TOURNAMENT_VIEW);

		teamsButton = createMenuOptionButton(ViewNames.TEAM_VIEW, AssetPaths.TEAM_ICON);
		teamsButton.setActionCommand(ViewNames.TEAM_VIEW);

		playersButton = createMenuOptionButton(ViewNames.PLAYER_VIEW, AssetPaths.USER_ICON);
		playersButton.setActionCommand(ViewNames.PLAYER_VIEW);

		coachesButton = createMenuOptionButton(ViewNames.COACH_VIEW, AssetPaths.COACH_ICON);
		coachesButton.setActionCommand(ViewNames.COACH_VIEW);		

		adminsButton = createMenuOptionButton(ViewNames.ADMIN_VIEW, AssetPaths.ADMIN_ICON);
		adminsButton.setActionCommand(ViewNames.ADMIN_VIEW);

		matchesButton = createMenuOptionButton(ViewNames.MATCH_VIEW, AssetPaths.MATCH_ICON);
		matchesButton.setActionCommand(ViewNames.MATCH_VIEW);

		gamesButton = createMenuOptionButton(ViewNames.GAME_VIEW, AssetPaths.GAME_ICON);
		gamesButton.setActionCommand(ViewNames.GAME_VIEW);

		reportsButton = createMenuOptionButton(ViewNames.REPORT_VIEW, AssetPaths.REPORT_ICON);
		reportsButton.setActionCommand(ViewNames.REPORT_VIEW);

		settingsButton = createMenuOptionButton(ViewNames.SETTINGS_VIEW, AssetPaths.SETTINGS_ICON);
		settingsButton.setActionCommand(ViewNames.SETTINGS_VIEW);

		// menuOptionsPanel.add(Box.createVerticalStrut(10));
		// menuOptionsPanel.add(homeButton);
		menuOptionsPanel.add(Box.createVerticalStrut(10));
		menuOptionsPanel.add(tournamentsButton);
		menuOptionsPanel.add(Box.createVerticalStrut(10));
		menuOptionsPanel.add(teamsButton);
		menuOptionsPanel.add(Box.createVerticalStrut(10));
		menuOptionsPanel.add(playersButton);
		menuOptionsPanel.add(Box.createVerticalStrut(10));
		menuOptionsPanel.add(coachesButton);
		menuOptionsPanel.add(Box.createVerticalStrut(10));
		menuOptionsPanel.add(adminsButton);
		menuOptionsPanel.add(Box.createVerticalStrut(10));
		menuOptionsPanel.add(matchesButton);
		// menuOptionsPanel.add(Box.createVerticalStrut(10));
		// menuOptionsPanel.add(gamesButton);
		menuOptionsPanel.add(Box.createVerticalStrut(10));
		menuOptionsPanel.add(reportsButton);
		menuOptionsPanel.add(Box.createVerticalStrut(10));
		menuOptionsPanel.add(settingsButton);
	}

	public JButton createMenuOptionButton(String text, String iconPath) {
		ImageIcon icon = loadIcon(iconPath, 20, 20);
		JButton button = new JButton(text, icon);

		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setIconTextGap(10);
		button.setMaximumSize(new Dimension(180, 40));
		button.setBackground(Color.WHITE);
		button.setFocusPainted(false);

		return button;
	}

	public void applyHighlightStyle(JButton button) {
		button.setBackground(Color.decode(Colors.BLUE_NEON));
		button.setContentAreaFilled(true);
		button.setOpaque(true);
	}

	public void clearHighlightStyle(JButton button) {
		button.setBackground(Color.WHITE);
		button.setContentAreaFilled(false);
		button.setOpaque(false);
	}

	public void resetAllButtonStyles() {
		clearHighlightStyle(homeButton);
		clearHighlightStyle(tournamentsButton);
		clearHighlightStyle(teamsButton);
		clearHighlightStyle(playersButton);
		clearHighlightStyle(coachesButton);
		clearHighlightStyle(adminsButton);
		clearHighlightStyle(matchesButton);
		clearHighlightStyle(gamesButton);
		clearHighlightStyle(reportsButton);
		clearHighlightStyle(settingsButton);
	}

	private ImageIcon loadIcon(String imagePath, int width, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}

	public void showHomeButton(boolean visible) {
		toggleButtonVisibility(homeButton, visible);
	}

	public void showTournamentsButton(boolean visible) {
		toggleButtonVisibility(tournamentsButton, visible);
	}

	public void showTeamsButton(boolean visible) {
		toggleButtonVisibility(teamsButton, visible);
	}

	public void showPlayersButton(boolean visible) {
		toggleButtonVisibility(playersButton, visible);
	}

	public void showCoachesButton(boolean visible) {
		toggleButtonVisibility(coachesButton, visible);
	}

	public void showAdminsButton(boolean visible) {
		toggleButtonVisibility(adminsButton, visible);
	}

	public void showMatchesButton(boolean visible) {
		toggleButtonVisibility(matchesButton, visible);
	}

	public void showGamesButton(boolean visible) {
		toggleButtonVisibility(gamesButton, visible);
	}

	public void showReportsButton(boolean visible) {
		toggleButtonVisibility(reportsButton, visible);
	}

	public void showSettingsButton(boolean visible) {
		toggleButtonVisibility(settingsButton, visible);
	}

	private void toggleButtonVisibility(JButton button, boolean visible) {
		if (visible) {
			if (!isInPanel(button)) {
				menuOptionsPanel.add(button);
				menuOptionsPanel.revalidate();
				menuOptionsPanel.repaint();
			}
		} else {
			menuOptionsPanel.remove(button);
			menuOptionsPanel.revalidate();
			menuOptionsPanel.repaint();
		}
	}

	private boolean isInPanel(JButton button) {
		for (Component comp : menuOptionsPanel.getComponents()) {
			if (comp == button) {
				return true;
			}
		}
		return false;
	}


	public JPanel getLogoPanel() {
		return logoPanel;
	}

	public void setLogoPanel(JPanel logoPanel) {
		this.logoPanel = logoPanel;
	}

	public JPanel getMenuOptionsPanel() {
		return menuOptionsPanel;
	}

	public void setMenuOptionsPanel(JPanel menuOptionsPanel) {
		this.menuOptionsPanel = menuOptionsPanel;
	}

	public JButton getHomeButton() {
		return homeButton;
	}

	public void setHomeButton(JButton homeButton) {
		this.homeButton = homeButton;
	}

	public JButton getTournamentsButton() {
		return tournamentsButton;
	}

	public void setTournamentsButton(JButton tournamentsButton) {
		this.tournamentsButton = tournamentsButton;
	}

	public JButton getTeamsButton() {
		return teamsButton;
	}

	public void setTeamsButton(JButton teamsButton) {
		this.teamsButton = teamsButton;
	}

	public JButton getPlayersButton() {
		return playersButton;
	}

	public void setPlayersButton(JButton playersButton) {
		this.playersButton = playersButton;
	}

	public JButton getCoachesButton() {
		return coachesButton;
	}

	public void setCoachesButton(JButton coachesButton) {
		this.coachesButton = coachesButton;
	}

	public JButton getAdminsButton() {
		return adminsButton;
	}

	public void setAdminsButton(JButton adminsButton) {
		this.adminsButton = adminsButton;
	}

	public JButton getMatchesButton() {
		return matchesButton;
	}

	public void setMatchesButton(JButton matchesButton) {
		this.matchesButton = matchesButton;
	}

	public JButton getGamesButton() {
		return gamesButton;
	}

	public void setGamesButton(JButton gamesButton) {
		this.gamesButton = gamesButton;
	}

	public JButton getReportsButton() {
		return reportsButton;
	}

	public void setReportsButton(JButton reportsButton) {
		this.reportsButton = reportsButton;
	}

	public JButton getSettingsButton() {
		return settingsButton;
	}

	public void setSettingsButton(JButton settingsButton) {
		this.settingsButton = settingsButton;
	}
} 