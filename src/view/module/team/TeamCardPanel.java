package view.module.team;

import javax.swing.*;

import co.edu.unbosque.util.AssetPaths;
import co.edu.unbosque.util.Colors;

import java.awt.*;

import view.shared.BaseCardPanel;

public class TeamCardPanel extends BaseCardPanel {

	private JLabel iconLabel;
	private JLabel nameLabel;
	private JLabel membersLabel;
	private JLabel coachLabel;
	private JLabel scoreLabel;
	private JLabel rankingLabel;
	private JButton detailButton;

	@Override
	protected void buildHeader() {
		ImageIcon icon = loadIcon(AssetPaths.TEAM_ICON, 35, 35);
		iconLabel = new JLabel(icon);

		nameLabel = new JLabel("Team Phoenix");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

		headerPanel.add(iconLabel);
		headerPanel.add(nameLabel);
	}

	@Override
	protected void buildInfo() {
		membersLabel = new JLabel("Members: 5");
		coachLabel = new JLabel("Coach: Alex");
		scoreLabel = new JLabel("Score: : 5");
		rankingLabel = new JLabel("Ranking: #5");

		infoPanel.add(membersLabel);
		infoPanel.add(coachLabel);
		infoPanel.add(scoreLabel);
		infoPanel.add(rankingLabel);
	}

	@Override
	protected void buildFooter() {
		detailButton = new JButton("View Team");
		detailButton.setForeground(Color.decode(Colors.BLUE_NEON));
		detailButton.setOpaque(false);
		detailButton.setContentAreaFilled(false);
		detailButton.setBorderPainted(false);
		detailButton.setFocusPainted(false);
		detailButton.setFont(new Font("Arial", Font.PLAIN, 12));
		detailButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		footerPanel.add(detailButton);
	}

	public JLabel getIconLabel() {
		return iconLabel;
	}

	public void setIconLabel(JLabel iconLabel) {
		this.iconLabel = iconLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getMembersLabel() {
		return membersLabel;
	}

	public void setMembersLabel(JLabel membersLabel) {
		this.membersLabel = membersLabel;
	}

	public JLabel getCoachLabel() {
		return coachLabel;
	}

	public void setCoachLabel(JLabel coachLabel) {
		this.coachLabel = coachLabel;
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}

	public JLabel getRankingLabel() {
		return rankingLabel;
	}

	public void setRankingLabel(JLabel rankingLabel) {
		this.rankingLabel = rankingLabel;
	}

	public JButton getDetailButton() {
		return detailButton;
	}

	public void setDetailButton(JButton detailButton) {
		this.detailButton = detailButton;
	}

}
