package view.module.team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.CoachDTO;
import co.edu.unbosque.model.PlayerDTO;
import co.edu.unbosque.model.TeamDTO;
import co.edu.unbosque.util.ButtonActionCommands;
import co.edu.unbosque.util.Colors;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

/**
 * Panel encargado de gestionar la asignación de jugadores a equipos.
 * Presenta una interfaz gráfica con listas desplegables para seleccionar
 * un equipo y un jugador, junto con un botón para confirmar la asignación.
 * 
 * Forma parte del módulo visual de gestión de equipos.
 * 
 * @author TuNombre
 */
public class TeamPlayerAssignmentPanel extends JPanel {

	private FormHeaderPanel formHeaderPanel;
	private FormFooterPanel formFooterPanel;

	private JPanel playersPanel;
	private JLabel teamLabel;
	private JLabel playerLabel;
	private JComboBox<String> teamComboBox;
	private JComboBox<String> playerComboBox;

	/**
	 * Constructor que inicializa el panel y sus componentes visuales.
	 */
	public TeamPlayerAssignmentPanel() {
		setLayout(new BorderLayout());
		initializeComponents();
		setupFormControls();	
	}

	/**
	 * Inicializa los componentes del formulario, incluyendo los paneles
	 * de cabecera, contenido central y pie de página.
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

		teamLabel = new JLabel("Team:");
		teamComboBox = new JComboBox<>();

		playerLabel = new JLabel("Player:");
		playerComboBox = new JComboBox<>();

		JLabel EMPTY_LABEL = new JLabel("");
		playersPanel.add(teamLabel);
		playersPanel.add(teamComboBox);
		playersPanel.add(playerLabel);
		playersPanel.add(playerComboBox);

		for (int i = 0; i < 8; i++) playersPanel.add(new JLabel(""));

		add(formHeaderPanel, BorderLayout.NORTH);
		add(playersPanel, BorderLayout.CENTER);
		add(formFooterPanel, BorderLayout.SOUTH);
	}

	/**
	 * Configura los textos y acciones de los botones del formulario.
	 */
	public void setupFormControls() {
		formHeaderPanel.getFormTitleLabel().setText("Add Players");
		formFooterPanel.setPrimaryButtonText("ADD PLAYER");
		formFooterPanel.setPrimaryButtonActionCommand(ButtonActionCommands.ADMIN_ADD_PLAYERS_TO_TEAM_ACTION_COMMAND);
		formFooterPanel.removeSecondaryButton();
		formFooterPanel.removeTertiaryButton();
		formFooterPanel.removeQuaternaryButton();
	}
	
	/**
	 * Carga una lista de jugadores en el combo box de selección de jugadores.
	 * 
	 * @param playerList Lista de objetos {@link PlayerDTO} disponibles.
	 */
	public void loadPlayersComboBox(List<PlayerDTO> playerList) {
		playerComboBox.removeAllItems(); 
		for (PlayerDTO playerDTO : playerList) {
			String playerName = playerDTO.getId() + " - " + playerDTO.getFirstName() + " " + playerDTO.getLastName() + " (" + playerDTO.getNickName() + ")";
			playerComboBox.addItem(playerName);
		}
	}

	/**
	 * Carga una lista de equipos en el combo box de selección de equipos.
	 * 
	 * @param teamList Lista de objetos {@link TeamDTO} disponibles.
	 */
	public void loadTeamsComboBox(List<TeamDTO> teamList) {
		teamComboBox.removeAllItems(); 
		for (TeamDTO teamDTO : teamList) {
			String teamName = teamDTO.getId() + " - " + teamDTO.getName();
			teamComboBox.addItem(teamName);
		}
	}

	/**
	 * Obtiene el ID del equipo seleccionado en el combo box.
	 * 
	 * @return ID del equipo como {@code Integer}, o {@code null} si no es válido.
	 */
	public Integer getTeamComboBoxIdValue() {
		String teamText = (String) teamComboBox.getSelectedItem();
		return (teamText != null && !teamText.isEmpty() && teamText.contains("-")) 
				? Integer.parseInt(teamText.substring(0, teamText.indexOf(" -"))) 
				: null;
	}

	/**
	 * Obtiene el ID del jugador seleccionado en el combo box.
	 * 
	 * @return ID del jugador como {@code Integer}, o {@code null} si no es válido.
	 */
	public Integer getPlayerComboBoxIdValue() {
		String playerText = (String) playerComboBox.getSelectedItem();
		return (playerText != null && !playerText.isEmpty() && playerText.contains("-")) 
				? Integer.parseInt(playerText.substring(0, playerText.indexOf(" -"))) 
				: null;
	}

	// ==================== GETTERS Y SETTERS ====================

	/**
	 * @return Panel de encabezado del formulario.
	 */
	public FormHeaderPanel getFormHeaderPanel() {
		return formHeaderPanel;
	}

	/**
	 * @param formHeaderPanel Panel de encabezado a establecer.
	 */
	public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
		this.formHeaderPanel = formHeaderPanel;
	}

	/**
	 * @return Panel de pie del formulario.
	 */
	public FormFooterPanel getFormFooterPanel() {
		return formFooterPanel;
	}

	/**
	 * @param formFooterPanel Panel de pie a establecer.
	 */
	public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
		this.formFooterPanel = formFooterPanel;
	}

	/**
	 * @return Panel central que contiene los campos de selección.
	 */
	public JPanel getPlayersPanel() {
		return playersPanel;
	}

	/**
	 * @param playersPanel Panel central a establecer.
	 */
	public void setPlayersPanel(JPanel playersPanel) {
		this.playersPanel = playersPanel;
	}

	/**
	 * @return Etiqueta de texto para el campo de equipos.
	 */
	public JLabel getTeamLabel() {
		return teamLabel;
	}

	/**
	 * @param teamLabel Etiqueta de equipos a establecer.
	 */
	public void setTeamLabel(JLabel teamLabel) {
		this.teamLabel = teamLabel;
	}

	/**
	 * @return Etiqueta de texto para el campo de jugadores.
	 */
	public JLabel getPlayerLabel() {
		return playerLabel;
	}

	/**
	 * @param playerLabel Etiqueta de jugadores a establecer.
	 */
	public void setPlayerLabel(JLabel playerLabel) {
		this.playerLabel = playerLabel;
	}

	/**
	 * @return ComboBox que contiene los equipos disponibles.
	 */
	public JComboBox<String> getTeamComboBox() {
		return teamComboBox;
	}

	/**
	 * @param teamComboBox ComboBox de equipos a establecer.
	 */
	public void setTeamComboBox(JComboBox<String> teamComboBox) {
		this.teamComboBox = teamComboBox;
	}

	/**
	 * @return ComboBox que contiene los jugadores disponibles.
	 */
	public JComboBox<String> getPlayerComboBox() {
		return playerComboBox;
	}

	/**
	 * @param playerComboBox ComboBox de jugadores a establecer.
	 */
	public void setPlayerComboBox(JComboBox<String> playerComboBox) {
		this.playerComboBox = playerComboBox;
	}
}
