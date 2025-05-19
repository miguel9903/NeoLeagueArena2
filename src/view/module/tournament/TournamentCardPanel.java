package view.module.tournament;

import javax.swing.*;

import co.edu.unbosque.util.AssetPaths;
import co.edu.unbosque.util.Colors;

import java.awt.*;

import view.shared.BaseCardPanel;

/**
 * TournamentCardPanel representa una tarjeta visual que muestra información
 * básica de un torneo, incluyendo nombre, descripción, juego, etapa y plataforma.
 * Hereda de {@link BaseCardPanel} y se utiliza dentro de vistas de torneos.
 * 
 * Proporciona un botón para ver detalles adicionales.
 */
public class TournamentCardPanel extends BaseCardPanel {

	private JLabel iconLabel;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JLabel gameLabel;
	private JLabel stageLabel;
	private JLabel platformLabel;
	private JButton detailButton;

	/**
	 * Construye el encabezado de la tarjeta, que contiene el icono del torneo
	 * y el nombre del torneo.
	 */
	@Override
	protected void buildHeader() {
		ImageIcon icon = loadIcon(AssetPaths.TOURNAMENT_ICON, 20, 20);
		iconLabel = new JLabel(icon);

		nameLabel = new JLabel("Tournament Name");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

		headerPanel.add(iconLabel);
		headerPanel.add(nameLabel);
	}

	/**
	 * Construye el panel de información, mostrando la descripción, el juego
	 * asociado, la etapa actual del torneo y la plataforma.
	 */
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

	/**
	 * Construye el pie de la tarjeta, incluyendo un botón que permite ver
	 * más detalles del torneo.
	 */
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

	/**
	 * @return Etiqueta del icono del torneo.
	 */
	public JLabel getIconLabel() {
		return iconLabel;
	}

	/**
	 * @return Etiqueta del nombre del torneo.
	 */
	public JLabel getNameLabel() {
		return nameLabel;
	}

	/**
	 * @return Etiqueta de la descripción del torneo.
	 */
	public JLabel getDescriptionLabel() {
		return descriptionLabel;
	}

	/**
	 * @return Etiqueta del juego asociado al torneo.
	 */
	public JLabel getGameLabel() {
		return gameLabel;
	}

	/**
	 * @return Etiqueta de la etapa actual del torneo.
	 */
	public JLabel getStageLabel() {
		return stageLabel;
	}

	/**
	 * @return Etiqueta de la plataforma en la que se juega el torneo.
	 */
	public JLabel getPlatformLabel() {
		return platformLabel;
	}

	/**
	 * @return Botón para ver más detalles del torneo.
	 */
	public JButton getDetailButton() {
		return detailButton;
	}
}
