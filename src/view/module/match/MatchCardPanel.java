package view.module.match;

import javax.swing.*;

import co.edu.unbosque.util.AssetPaths;
import co.edu.unbosque.util.Colors;

import java.awt.*;

import view.shared.BaseCardPanel;

public class MatchCardPanel extends BaseCardPanel {

	private JLabel iconLabel;
	private JLabel titleLabel;

	private JLabel teamALabel;
	private JLabel teamBLabel;
	private JLabel scoreLabel;

	private JButton detailButton;

	@Override
	protected void buildHeader() {
		ImageIcon icon = loadIcon(AssetPaths.MATCH_ICON, 20, 20); 
		iconLabel = new JLabel(icon);

		titleLabel = new JLabel("Match");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

		headerPanel.add(iconLabel);
		headerPanel.add(titleLabel);
	}

	@Override
	protected void buildInfo() {
		teamALabel = new JLabel("Team A: [Name]");
		teamBLabel = new JLabel("Team B: [Name]");
		scoreLabel = new JLabel("Score: [Score A] - [Score B]");

		infoPanel.add(teamALabel);
		infoPanel.add(teamBLabel);
		infoPanel.add(scoreLabel);
	}

	@Override
	protected void buildFooter() {
		detailButton = new JButton("View Match");
		detailButton.setForeground(Color.decode(Colors.BLUE_NEON));
		detailButton.setOpaque(false);
		detailButton.setContentAreaFilled(false);
		detailButton.setBorderPainted(false);
		detailButton.setFocusPainted(false);
		detailButton.setFont(new Font("Arial", Font.PLAIN, 12));
		detailButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		footerPanel.add(detailButton);
	}

	// Getters y Setters
	public JLabel getIconLabel() {
		return iconLabel;
	}

	public void setIconLabel(JLabel iconLabel) {
		this.iconLabel = iconLabel;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JLabel getTeamALabel() {
		return teamALabel;
	}

	public void setTeamALabel(JLabel teamALabel) {
		this.teamALabel = teamALabel;
	}

	public JLabel getTeamBLabel() {
		return teamBLabel;
	}

	public void setTeamBLabel(JLabel teamBLabel) {
		this.teamBLabel = teamBLabel;
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}

	public JButton getDetailButton() {
		return detailButton;
	}

	public void setDetailButton(JButton detailButton) {
		this.detailButton = detailButton;
	}
}
