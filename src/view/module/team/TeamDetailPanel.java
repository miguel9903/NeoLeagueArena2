/**
 * La clase TeamDetailPanel representa un panel que muestra los detalles de un equipo.
 * Incluye información como el nombre del equipo, entrenador, miembros, puntuación, ranking,
 * descripción y una lista de jugadores.
 */
package view.module.team;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.persistence.dto.PlayerDTO;
import model.persistence.dto.TeamDTO;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import utils.AssetPaths;
import utils.Colors;
import utils.WordingMessages;
import view.modules.player.PlayerCardPanel;
import view.shared.CardListPanel;

/**
 * La clase TeamDetailPanel representa un panel que muestra los detalles de un equipo.
 * Incluye información como el nombre del equipo, entrenador, miembros, puntuación, ranking,
 * descripción y una lista de jugadores.
 */
public class TeamDetailPanel extends JPanel {

    /** Panel para la etiqueta de jugadores. */
    private JPanel playerLabelPanel;

    /** Panel para el logo del equipo. */
    private JPanel logoPanel;

    /** Panel para la información del equipo. */
    private JPanel infoPanel;

    /** Panel para la lista de jugadores. */
    private JPanel playerListPanel;

    /** Panel de desplazamiento para la lista de jugadores. */
    private JScrollPane scrollPanel;

    /** Lista de tarjetas de jugadores. */
    private List<PlayerCardPanel> playerCards;

    /** Etiqueta para el logo del equipo. */
    private JLabel logoLabel;

    /** Etiqueta para el nombre del equipo. */
    private JLabel nameLabel;

    /** Etiqueta para el nombre del entrenador. */
    private JLabel coachLabel;

    /** Etiqueta para el número de miembros del equipo. */
    private JLabel membersLabel;

    /** Etiqueta para la lista de jugadores. */
    private JLabel playersLabel;

    /** Etiqueta para la puntuación del equipo. */
    private JLabel scoreLabel;

    /** Etiqueta para el ranking del equipo. */
    private JLabel rankingLabel;

    /** Área de texto para la descripción del equipo. */
    private JTextArea descriptionTextArea;

    /**
     * Construye un nuevo TeamDetailPanel e inicializa sus componentes.
     */
    public TeamDetailPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        initializeComponents();
    }

    /**
     * Inicializa los componentes del panel, incluyendo el logo, la información del equipo
     * y la lista de jugadores.
     */
    private void initializeComponents() {
        logoPanel = new JPanel();
        logoPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        ImageIcon teamIcon = loadIcon(AssetPaths.TEAM_ICON, 90, 90);
        logoLabel = new JLabel(teamIcon);
        logoPanel.add(logoLabel);

        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        nameLabel = new JLabel("Nombre del Equipo");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        infoPanel.add(nameLabel);

        coachLabel = new JLabel("Entrenador: ");
        coachLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        coachLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        coachLabel.setBorder(new EmptyBorder(2, 2, 2, 2));
        infoPanel.add(coachLabel);

        membersLabel = new JLabel("Miembros: 5");
        membersLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        membersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        membersLabel.setBorder(new EmptyBorder(2, 2, 2, 2));
        infoPanel.add(membersLabel);

        scoreLabel = new JLabel("Puntuación: ");
        scoreLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setBorder(new EmptyBorder(2, 2, 2, 2));
        infoPanel.add(scoreLabel);

        rankingLabel = new JLabel("Ranking: ");
        rankingLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        rankingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rankingLabel.setBorder(new EmptyBorder(2, 2, 20, 2));
        infoPanel.add(rankingLabel);

        descriptionTextArea = new JTextArea();
        descriptionTextArea.setText("");
        descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setOpaque(false);
        descriptionTextArea.setEditable(false);

        playerCards = new ArrayList<>();

        playersLabel = new JLabel("Jugadores: ");
        playersLabel.setFont(new Font("Arial", Font.BOLD, 20));
        playersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playersLabel.setBorder(new EmptyBorder(20, 0, 20, 0));
        infoPanel.add(playersLabel);

        add(logoPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
    }

    /**
     * Carga un icono desde una ruta de imagen y lo escala a un tamaño específico.
     *
     * @param imagePath la ruta de la imagen
     * @param width el ancho deseado del icono
     * @param height el alto deseado del icono
     * @return el icono escalado
     */
    public ImageIcon loadIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    /**
     * Renderiza los detalles del equipo a partir de un DTO de equipo.
     *
     * @param teamDTO el DTO del equipo
     */
    public void renderTeamDetail(TeamDTO teamDTO) {
        int totalPlayers = teamDTO.getPlayerIds() != null ? teamDTO.getPlayerIds().size() : 0;

        nameLabel.setText(teamDTO.getName());
        coachLabel.setText("Entrenador: " + teamDTO.getCoachName());
        descriptionTextArea.setText(teamDTO.getDescription());
        scoreLabel.setText("Puntuación: " + teamDTO.getScore());
        rankingLabel.setText("Ranking: " + teamDTO.getRanking());
        membersLabel.setText("Miembros: " + totalPlayers);

        playerCards.clear();
        playerListPanel = new JPanel();
        playerListPanel.setLayout(new GridLayout(0, 2, 10, 10));

        if (teamDTO.getPlayerIds() != null && !teamDTO.getPlayerIds().isEmpty()) {
            for (PlayerDTO playerDTO : teamDTO.getPlayers()) {
                PlayerCardPanel card = new PlayerCardPanel();
                card.getNameLabel().setText(playerDTO.getFirstName() + playerDTO.getLastName());
                card.getTeamLabel().setText("Equipo: " + teamDTO.getName());
                card.getCountryLabel().setText("País: " + playerDTO.getCountry());
                card.getCityLabel().setText("Ciudad: " + playerDTO.getCity());
                card.getAgeLabel().setText("Edad: " + playerDTO.getAge());
                card.getExperienceLevelLabel().setText("Nivel de experiencia: " + playerDTO.getExperienceLevel());

                playerCards.add(card);
                playerListPanel.add(card);
            }

            scrollPanel = new JScrollPane(playerListPanel);
            scrollPanel.setBorder(BorderFactory.createEmptyBorder());
            scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
            infoPanel.add(scrollPanel);
        }

        repaintView();
    }

    /**
     * Vuelve a pintar la vista para reflejar los cambios realizados.
     */
    public void repaintView() {
        revalidate();
        repaint();
    }

    /**
     * Obtiene el panel para la etiqueta de jugadores.
     *
     * @return el panel para la etiqueta de jugadores
     */
    public JPanel getPlayerLabelPanel() {
        return playerLabelPanel;
    }

    /**
     * Establece el panel para la etiqueta de jugadores.
     *
     * @param playerLabelPanel el panel para la etiqueta de jugadores a establecer
     */
    public void setPlayerLabelPanel(JPanel playerLabelPanel) {
        this.playerLabelPanel = playerLabelPanel;
    }

    /**
     * Obtiene el panel para el logo del equipo.
     *
     * @return el panel para el logo del equipo
     */
    public JPanel getLogoPanel() {
        return logoPanel;
    }

    /**
     * Establece el panel para el logo del equipo.
     *
     * @param logoPanel el panel para el logo del equipo a establecer
     */
    public void setLogoPanel(JPanel logoPanel) {
        this.logoPanel = logoPanel;
    }

    /**
     * Obtiene el panel para la información del equipo.
     *
     * @return el panel para la información del equipo
     */
    public JPanel getInfoPanel() {
        return infoPanel;
    }

    /**
     * Establece el panel para la información del equipo.
     *
     * @param infoPanel el panel para la información del equipo a establecer
     */
    public void setInfoPanel(JPanel infoPanel) {
        this.infoPanel = infoPanel;
    }

    /**
     * Obtiene el panel para la lista de jugadores.
     *
     * @return el panel para la lista de jugadores
     */
    public JPanel getPlayerListPanel() {
        return playerListPanel;
    }

    /**
     * Establece el panel para la lista de jugadores.
     *
     * @param playerListPanel el panel para la lista de jugadores a establecer
     */
    public void setPlayerListPanel(JPanel playerListPanel) {
        this.playerListPanel = playerListPanel;
    }

    /**
     * Obtiene el panel de desplazamiento para la lista de jugadores.
     *
     * @return el panel de desplazamiento para la lista de jugadores
     */
    public JScrollPane getScrollPanel() {
        return scrollPanel;
    }

    /**
     * Establece el panel de desplazamiento para la lista de jugadores.
     *
     * @param scrollPanel el panel de desplazamiento para la lista de jugadores a establecer
     */
    public void setScrollPanel(JScrollPane scrollPanel) {
        this.scrollPanel = scrollPanel;
    }

    /**
     * Obtiene la lista de tarjetas de jugadores.
     *
     * @return la lista de tarjetas de jugadores
     */
    public List<PlayerCardPanel> getPlayerCards() {
        return playerCards;
    }

    /**
     * Establece la lista de tarjetas de jugadores.
     *
     * @param playerCards la lista de tarjetas de jugadores a establecer
     */
    public void setPlayerCards(List<PlayerCardPanel> playerCards) {
        this.playerCards = playerCards;
    }

    /**
     * Obtiene la etiqueta del logo del equipo.
     *
     * @return la etiqueta del logo del equipo
     */
    public JLabel getLogoLabel() {
        return logoLabel;
    }

    /**
     * Establece la etiqueta del logo del equipo.
     *
     * @param logoLabel la etiqueta del logo del equipo a establecer
     */
    public void setLogoLabel(JLabel logoLabel) {
        this.logoLabel = logoLabel;
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
     * Obtiene la etiqueta del nombre del entrenador.
     *
     * @return la etiqueta del nombre del entrenador
     */
    public JLabel getCoachLabel() {
        return coachLabel;
    }

    /**
     * Establece la etiqueta del nombre del entrenador.
     *
     * @param coachLabel la etiqueta del nombre del entrenador a establecer
     */
    public void setCoachLabel(JLabel coachLabel) {
        this.coachLabel = coachLabel;
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
     * Obtiene la etiqueta para la lista de jugadores.
     *
     * @return la etiqueta para la lista de jugadores
     */
    public JLabel getPlayersLabel() {
        return playersLabel;
    }

    /**
     * Establece la etiqueta para la lista de jugadores.
     *
     * @param playersLabel la etiqueta para la lista de jugadores a establecer
     */
    public void setPlayersLabel(JLabel playersLabel) {
        this.playersLabel = playersLabel;
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
     * Obtiene el área de texto para la descripción del equipo.
     *
     * @return el área de texto para la descripción del equipo
     */
    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    /**
     * Establece el área de texto para la descripción del equipo.
     *
     * @param descriptionTextArea el área de texto para la descripción del equipo a establecer
     */
    public void setDescriptionTextArea(JTextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }
}
