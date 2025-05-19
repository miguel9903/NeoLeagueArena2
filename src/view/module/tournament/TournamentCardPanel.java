package view.module.tournament;

import javax.swing.*;
import java.awt.*;

import utils.AssetPaths;
import utils.Colors;
import view.shared.BaseCardPanel;

public class TournamentCardPanel extends BaseCardPanel {

	private JLabel iconLabel;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JLabel gameLabel;
	private JLabel stageLabel;
	private JLabel platformLabel;
	private JButton detailButton;

	@Override
	protected void buildHeader() {
		ImageIcon icon = loadIcon(AssetPaths.TOURNAMENT_ICON, 20, 20);
		iconLabel = new JLabel(icon);

		nameLabel = new JLabel("Tournament Name");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

		headerPanel.add(iconLabel);
		headerPanel.add(nameLabel);
	}

	@Override
	protected void buildInfo() {
		descriptionLabel = new JLabel("Description");
		gameLabel = new JLabel("Game: -");
		stageLabel = new JLabel("Current Stage: -");
		platformLabel = new JLabel("Platform: -");

		infoPanel.add(descriptionLabel);
		infoPanel.add(gameLabel);
		infoPanel.add(stageLabel);
		infoPanel.add(platformLabel);		
	}

	@Override
	protected void buildFooter() {
		detailButton = new JButton("View Details");
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

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public JLabel getDescriptionLabel() {
		return descriptionLabel;
	}

	public JLabel getGameLabel() {
		return gameLabel;
	}

	public JLabel getStageLabel() {
		return stageLabel;
	}

	public JLabel getPlatformLabel() {
		return platformLabel;
	}

	public JButton getDetailButton() {
		return detailButton;
	}
}
