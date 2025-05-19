/**
 * La clase MatchCardPanel representa un panel que muestra información sobre un partido.
 * Extiende la clase BaseCardPanel y proporciona funcionalidad para construir y mostrar
 * la información del partido, incluyendo los equipos y el marcador.
 */
package view.module.match;

import javax.swing.*;
import java.awt.*;

import utils.AssetPaths;
import utils.Colors;
import view.shared.BaseCardPanel;

/**
 * La clase MatchCardPanel representa un panel que muestra información sobre un partido.
 * Extiende la clase BaseCardPanel y proporciona funcionalidad para construir y mostrar
 * la información del partido, incluyendo los equipos y el marcador.
 */
public class MatchCardPanel extends BaseCardPanel {

    /** Etiqueta para el icono del partido. */
    private JLabel iconLabel;

    /** Etiqueta para el título del partido. */
    private JLabel titleLabel;

    /** Etiqueta para el nombre del equipo A. */
    private JLabel teamALabel;

    /** Etiqueta para el nombre del equipo B. */
    private JLabel teamBLabel;

    /** Etiqueta para el marcador del partido. */
    private JLabel scoreLabel;

    /** Botón para ver los detalles del partido. */
    private JButton detailButton;

    /**
     * Construye el encabezado del panel con un icono y un título.
     */
    @Override
    protected void buildHeader() {
        ImageIcon icon = loadIcon(AssetPaths.MATCH_ICON, 20, 20);
        iconLabel = new JLabel(icon);

        titleLabel = new JLabel("Partido");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        headerPanel.add(iconLabel);
        headerPanel.add(titleLabel);
    }

    /**
     * Construye la sección de información del panel con los nombres de los equipos y el marcador.
     */
    @Override
    protected void buildInfo() {
        teamALabel = new JLabel("Equipo A: [Nombre]");
        teamBLabel = new JLabel("Equipo B: [Nombre]");
        scoreLabel = new JLabel("Marcador: [Score A] - [Score B]");

        infoPanel.add(teamALabel);
        infoPanel.add(teamBLabel);
        infoPanel.add(scoreLabel);
    }

    /**
     * Construye el pie del panel con un botón para ver los detalles del partido.
     */
    @Override
    protected void buildFooter() {
        detailButton = new JButton("Ver Partido");
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
     * Obtiene la etiqueta del título.
     *
     * @return la etiqueta del título
     */
    public JLabel getTitleLabel() {
        return titleLabel;
    }

    /**
     * Establece la etiqueta del título.
     *
     * @param titleLabel la etiqueta del título a establecer
     */
    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    /**
     * Obtiene la etiqueta del equipo A.
     *
     * @return la etiqueta del equipo A
     */
    public JLabel getTeamALabel() {
        return teamALabel;
    }

    /**
     * Establece la etiqueta del equipo A.
     *
     * @param teamALabel la etiqueta del equipo A a establecer
     */
    public void setTeamALabel(JLabel teamALabel) {
        this.teamALabel = teamALabel;
    }

    /**
     * Obtiene la etiqueta del equipo B.
     *
     * @return la etiqueta del equipo B
     */
    public JLabel getTeamBLabel() {
        return teamBLabel;
    }

    /**
     * Establece la etiqueta del equipo B.
     *
     * @param teamBLabel la etiqueta del equipo B a establecer
     */
    public void setTeamBLabel(JLabel teamBLabel) {
        this.teamBLabel = teamBLabel;
    }

    /**
     * Obtiene la etiqueta del marcador.
     *
     * @return la etiqueta del marcador
     */
    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    /**
     * Establece la etiqueta del marcador.
     *
     * @param scoreLabel la etiqueta del marcador a establecer
     */
    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    /**
     * Obtiene el botón de detalles.
     *
     * @return el botón de detalles
     */
    public JButton getDetailButton() {
        return detailButton;
    }

    /**
     * Establece el botón de detalles.
     *
     * @param detailButton el botón de detalles a establecer
     */
    public void setDetailButton(JButton detailButton) {
        this.detailButton = detailButton;
    }
}
