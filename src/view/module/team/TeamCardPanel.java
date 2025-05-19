/**
 * La clase TeamCardPanel representa un panel que muestra información sobre un equipo.
 * Extiende la clase BaseCardPanel y proporciona funcionalidad para construir y mostrar
 * la información del equipo, incluyendo miembros, entrenador, puntuación y ranking.
 */
package view.module.team;

import javax.swing.*;
import java.awt.*;

import utils.AssetPaths;
import utils.Colors;
import view.shared.BaseCardPanel;

/**
 * La clase TeamCardPanel representa un panel que muestra información sobre un equipo.
 * Extiende la clase BaseCardPanel y proporciona funcionalidad para construir y mostrar
 * la información del equipo, incluyendo miembros, entrenador, puntuación y ranking.
 */
public class TeamCardPanel extends BaseCardPanel {

    /** Etiqueta para el icono del equipo. */
    private JLabel iconLabel;

    /** Etiqueta para el nombre del equipo. */
    private JLabel nameLabel;

    /** Etiqueta para el número de miembros del equipo. */
    private JLabel membersLabel;

    /** Etiqueta para el nombre del entrenador del equipo. */
    private JLabel coachLabel;

    /** Etiqueta para la puntuación del equipo. */
    private JLabel scoreLabel;

    /** Etiqueta para el ranking del equipo. */
    private JLabel rankingLabel;

    /** Botón para ver los detalles del equipo. */
    private JButton detailButton;

    /**
     * Construye el encabezado del panel con un icono y un nombre de equipo.
     */
    @Override
    protected void buildHeader() {
        ImageIcon icon = loadIcon(AssetPaths.TEAM_ICON, 35, 35);
        iconLabel = new JLabel(icon);

        nameLabel = new JLabel("Equipo Phoenix");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        headerPanel.add(iconLabel);
        headerPanel.add(nameLabel);
    }

    /**
     * Construye la sección de información del panel con los miembros, entrenador,
     * puntuación y ranking del equipo.
     */
    @Override
    protected void buildInfo() {
        membersLabel = new JLabel("Miembros: 5");
        coachLabel = new JLabel("Entrenador: Alex");
        scoreLabel = new JLabel("Puntuación: 5");
        rankingLabel = new JLabel("Ranking: #5");

        infoPanel.add(membersLabel);
        infoPanel.add(coachLabel);
        infoPanel.add(scoreLabel);
        infoPanel.add(rankingLabel);
    }

    /**
     * Construye el pie del panel con un botón para ver los detalles del equipo.
     */
    @Override
    protected void buildFooter() {
        detailButton = new JButton("Ver Equipo");
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
     * Obtiene la etiqueta del icono.
     *
     * @return la etiqueta del icono
     */
    public JLabel getIconLabel() {
        return iconLabel;
    }

    /**
     * Establece la etiqueta del icono.
     *
     * @param iconLabel la etiqueta del icono a establecer
     */
    public void setIconLabel(JLabel iconLabel) {
        this.iconLabel = iconLabel;
    }

    /**
     * Obtiene la etiqueta del nombre del equipo.
     *
     * @return la etiqueta del nombre del equipo
     */
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * Establece la etiqueta del nombre del equipo.
     *
     * @param nameLabel la etiqueta del nombre del equipo a establecer
     */
    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    /**
     * Obtiene la etiqueta del número de miembros del equipo.
     *
     * @return la etiqueta del número de miembros del equipo
     */
    public JLabel getMembersLabel() {
        return membersLabel;
    }

    /**
     * Establece la etiqueta del número de miembros del equipo.
     *
     * @param membersLabel la etiqueta del número de miembros del equipo a establecer
     */
    public void setMembersLabel(JLabel membersLabel) {
        this.membersLabel = membersLabel;
    }

    /**
     * Obtiene la etiqueta del nombre del entrenador del equipo.
     *
     * @return la etiqueta del nombre del entrenador del equipo
     */
    public JLabel getCoachLabel() {
        return coachLabel;
    }

    /**
     * Establece la etiqueta del nombre del entrenador del equipo.
     *
     * @param coachLabel la etiqueta del nombre del entrenador del equipo a establecer
     */
    public void setCoachLabel(JLabel coachLabel) {
        this.coachLabel = coachLabel;
    }

    /**
     * Obtiene la etiqueta de la puntuación del equipo.
     *
     * @return la etiqueta de la puntuación del equipo
     */
    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    /**
     * Establece la etiqueta de la puntuación del equipo.
     *
     * @param scoreLabel la etiqueta de la puntuación del equipo a establecer
     */
    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    /**
     * Obtiene la etiqueta del ranking del equipo.
     *
     * @return la etiqueta del ranking del equipo
     */
    public JLabel getRankingLabel() {
        return rankingLabel;
    }

    /**
     * Establece la etiqueta del ranking del equipo.
     *
     * @param rankingLabel la etiqueta del ranking del equipo a establecer
     */
    public void setRankingLabel(JLabel rankingLabel) {
        this.rankingLabel = rankingLabel;
    }

    /**
     * Obtiene el botón de detalles del equipo.
     *
     * @return el botón de detalles del equipo
     */
    public JButton getDetailButton() {
        return detailButton;
    }

    /**
     * Establece el botón de detalles del equipo.
     *
     * @param detailButton el botón de detalles del equipo a establecer
     */
    public void setDetailButton(JButton detailButton) {
        this.detailButton = detailButton;
    }
}
