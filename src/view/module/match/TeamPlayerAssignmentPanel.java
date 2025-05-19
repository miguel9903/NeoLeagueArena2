/**
 * La clase TeamPlayerAssignmentPanel representa un panel para asignar jugadores a equipos.
 * Incluye un encabezado, un panel para seleccionar equipos y jugadores, y un pie de formulario
 * con botones para realizar acciones como agregar jugadores.
 */
package view.module.match;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.persistence.dto.CoachDTO;
import model.persistence.dto.PlayerDTO;
import model.persistence.dto.TeamDTO;
import utils.Colors;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

/**
 * La clase TeamPlayerAssignmentPanel representa un panel para asignar jugadores a equipos.
 * Incluye un encabezado, un panel para seleccionar equipos y jugadores, y un pie de formulario
 * con botones para realizar acciones como agregar jugadores.
 */
public class TeamPlayerAssignmentPanel extends JPanel {

    /** Panel de encabezado del formulario. */
    private FormHeaderPanel formHeaderPanel;

    /** Panel de pie del formulario con botones de acción. */
    private FormFooterPanel formFooterPanel;

    /** Panel para seleccionar equipos y jugadores. */
    private JPanel playersPanel;

    /** Etiqueta para el ComboBox de equipos. */
    private JLabel teamLabel;

    /** ComboBox para seleccionar equipos. */
    private JComboBox<String> teamComboBox;

    /** Etiqueta para el ComboBox de jugadores. */
    private JLabel playerLabel;

    /** ComboBox para seleccionar jugadores. */
    private JComboBox<String> playerComboBox;

    /** Botón para agregar jugadores al equipo seleccionado. */
    private JButton addPlayerButton;

    /**
     * Construye un nuevo TeamPlayerAssignmentPanel e inicializa sus componentes.
     */
    public TeamPlayerAssignmentPanel() {
        setLayout(new BorderLayout());
        initializeComponents();
        setupFormControls();
    }

    /**
     * Inicializa los componentes del panel, incluyendo el encabezado, el panel de selección
     * de equipos y jugadores, y el pie del formulario.
     */
    private void initializeComponents() {
        formHeaderPanel = new FormHeaderPanel();
        formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        formFooterPanel = new FormFooterPanel();
        formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        formFooterPanel.setBackground(Color.decode(Colors.MEDIUM_GRAY));

        playersPanel = new JPanel();
        playersPanel.setLayout(new GridLayout(6, 2, 10, 10));
        playersPanel.setBorder(new EmptyBorder(20, 20, 120, 20));

        teamLabel = new JLabel("Equipo:");
        teamComboBox = new JComboBox<>();
        teamComboBox.addItem("Equipo Alpha");
        teamComboBox.addItem("Equipo Beta");

        playerLabel = new JLabel("Jugador:");
        playerComboBox = new JComboBox<>();
        playerComboBox.addItem("Juan Pérez");
        playerComboBox.addItem("María Gómez");
        playerComboBox.addItem("Carlos López");
        playerComboBox.addItem("Ana Torres");

        addPlayerButton = new JButton("AGREGAR JUGADOR");
        addPlayerButton.setActionCommand("ADD_PLAYER");

        JLabel EMPTY_LABEL = new JLabel("");
        playersPanel.add(teamLabel);
        playersPanel.add(teamComboBox);
        playersPanel.add(playerLabel);
        playersPanel.add(playerComboBox);
        playersPanel.add(EMPTY_LABEL);
        playersPanel.add(EMPTY_LABEL);
        playersPanel.add(EMPTY_LABEL);
        playersPanel.add(EMPTY_LABEL);
        playersPanel.add(EMPTY_LABEL);
        playersPanel.add(EMPTY_LABEL);
        playersPanel.add(EMPTY_LABEL);
        playersPanel.add(EMPTY_LABEL);

        add(formHeaderPanel, BorderLayout.NORTH);
        add(playersPanel, BorderLayout.CENTER);
        add(formFooterPanel, BorderLayout.SOUTH);
    }

    /**
     * Configura los controles del formulario, incluyendo los textos y comandos de acción de los botones.
     */
    public void setupFormControls() {
        formHeaderPanel.getFormTitleLabel().setText("Agregar Jugadores");
        formFooterPanel.setPrimaryButtonText("AGREGAR JUGADOR");
        formFooterPanel.setPrimaryButtonActionCommand("ADD_PLAYER");
        formFooterPanel.removeSecondaryButton();
        formFooterPanel.removeTertiaryButton();
    }

    /**
     * Carga los elementos del ComboBox de jugadores.
     *
     * @param playerList la lista de DTOs de jugadores
     */
    public void loadPlayersComboBox(List<PlayerDTO> playerList) {
        playerComboBox.removeAllItems();

        for (PlayerDTO playerDTO : playerList) {
            String playerName = playerDTO.getId() + " - " + playerDTO.getFirstName() + " " + playerDTO.getLastName() + " (" + playerDTO.getNickName() + ")";
            playerComboBox.addItem(playerName);
        }
    }

    /**
     * Carga los elementos del ComboBox de equipos.
     *
     * @param teamList la lista de DTOs de equipos
     */
    public void loadTeamsComboBox(List<TeamDTO> teamList) {
        teamComboBox.removeAllItems();

        for (TeamDTO teamDTO : teamList) {
            String teamName = teamDTO.getId() + " - " + teamDTO.getName();
            teamComboBox.addItem(teamName);
        }
    }

    /**
     * Obtiene el panel de encabezado del formulario.
     *
     * @return el panel de encabezado del formulario
     */
    public FormHeaderPanel getFormHeaderPanel() {
        return formHeaderPanel;
    }

    /**
     * Establece el panel de encabezado del formulario.
     *
     * @param formHeaderPanel el panel de encabezado del formulario a establecer
     */
    public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
        this.formHeaderPanel = formHeaderPanel;
    }

    /**
     * Obtiene el panel de pie del formulario con botones de acción.
     *
     * @return el panel de pie del formulario
     */
    public FormFooterPanel getFormFooterPanel() {
        return formFooterPanel;
    }

    /**
     * Establece el panel de pie del formulario con botones de acción.
     *
     * @param formFooterPanel el panel de pie del formulario a establecer
     */
    public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
        this.formFooterPanel = formFooterPanel;
    }

    /**
     * Obtiene el panel para seleccionar equipos y jugadores.
     *
     * @return el panel para seleccionar equipos y jugadores
     */
    public JPanel getPlayersPanel() {
        return playersPanel;
    }

    /**
     * Establece el panel para seleccionar equipos y jugadores.
     *
     * @param playersPanel el panel para seleccionar equipos y jugadores a establecer
     */
    public void setPlayersPanel(JPanel playersPanel) {
        this.playersPanel = playersPanel;
    }

    /**
     * Obtiene la etiqueta del ComboBox de equipos.
     *
     * @return la etiqueta del ComboBox de equipos
     */
    public JLabel getTeamLabel() {
        return teamLabel;
    }

    /**
     * Establece la etiqueta del ComboBox de equipos.
     *
     * @param teamLabel la etiqueta del ComboBox de equipos a establecer
     */
    public void setTeamLabel(JLabel teamLabel) {
        this.teamLabel = teamLabel;
    }

    /**
     * Obtiene el ComboBox de equipos.
     *
     * @return el ComboBox de equipos
     */
    public JComboBox<String> getTeamComboBox() {
        return teamComboBox;
    }

    /**
     * Establece el ComboBox de equipos.
     *
     * @param teamComboBox el ComboBox de equipos a establecer
     */
    public void setTeamComboBox(JComboBox<String> teamComboBox) {
        this.teamComboBox = teamComboBox;
    }

    /**
     * Obtiene la etiqueta del ComboBox de jugadores.
     *
     * @return la etiqueta del ComboBox de jugadores
     */
    public JLabel getPlayerLabel() {
        return playerLabel;
    }

    /**
     * Establece la etiqueta del ComboBox de jugadores.
     *
     * @param playerLabel la etiqueta del ComboBox de jugadores a establecer
     */
    public void setPlayerLabel(JLabel playerLabel) {
        this.playerLabel = playerLabel;
    }

    /**
     * Obtiene el ComboBox de jugadores.
     *
     * @return el ComboBox de jugadores
     */
    public JComboBox<String> getPlayerComboBox() {
        return playerComboBox;
    }

    /**
     * Establece el ComboBox de jugadores.
     *
     * @param playerComboBox el ComboBox de jugadores a establecer
     */
    public void setPlayerComboBox(JComboBox<String> playerComboBox) {
        this.playerComboBox = playerComboBox;
    }

    /**
     * Obtiene el botón para agregar jugadores.
     *
     * @return el botón para agregar jugadores
     */
    public JButton getAddPlayerButton() {
        return addPlayerButton;
    }

    /**
     * Establece el botón para agregar jugadores.
     *
     * @param addPlayerButton el botón para agregar jugadores a establecer
     */
    public void setAddPlayerButton(JButton addPlayerButton) {
        this.addPlayerButton = addPlayerButton;
    }
}
