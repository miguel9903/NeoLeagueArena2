package view.modules.coach;

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

public class TeamPlayerAssignmentPanel extends JPanel {

	private FormHeaderPanel formHeaderPanel;
	private FormFooterPanel formFooterPanel;

	private JPanel playersPanel;
	private JLabel teamLabel;
	private JComboBox<String> teamComboBox;
	private JLabel playerLabel;
	private JComboBox<String> playerComboBox;
	private JButton addPlayerButton;

	public TeamPlayerAssignmentPanel() {
		setLayout(new BorderLayout());
		initializeComponents();
		setupFormControls();	
	}

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
		teamComboBox.addItem("Team Alpha");
		teamComboBox.addItem("Team Beta");

		playerLabel = new JLabel("Player:");
		playerComboBox = new JComboBox<>();
		playerComboBox.addItem("Juan Pérez");
		playerComboBox.addItem("María Gómez");
		playerComboBox.addItem("Carlos López");
		playerComboBox.addItem("Ana Torres");

		addPlayerButton = new JButton("ADD PLAYER");
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

	public void setupFormControls() {
		formHeaderPanel.getFormTitleLabel().setText("Add Players");
		formFooterPanel.setPrimaryButtonText("ADD PLAYER");
		formFooterPanel.setPrimaryButtonActionCommand("ADD_PLAYER");
		formFooterPanel.removeSecondaryButton();
		formFooterPanel.removeTertiaryButton();
	}
	
    public void loadPlayersComboBox(List<PlayerDTO> playerList) {
    	playerComboBox.removeAllItems(); 
        
        for (PlayerDTO playerDTO : playerList) {
            String playerhName = playerDTO.getId() + " - " + playerDTO.getFirstName() + " " + playerDTO.getLastName() + " (" + playerDTO.getNickName() + ")";
            playerComboBox.addItem(playerhName);
        }
    }

    public void loadTeamsComboBox(List<TeamDTO> teamList) {
    	teamComboBox.removeAllItems(); 
        
        for (TeamDTO teamDTO : teamList) {
            String teamName = teamDTO.getId() + " - " + teamDTO.getName();
            teamComboBox.addItem(teamName);
        }
    }

	public FormHeaderPanel getFormHeaderPanel() {
		return formHeaderPanel;
	}

	public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
		this.formHeaderPanel = formHeaderPanel;
	}

	public FormFooterPanel getFormFooterPanel() {
		return formFooterPanel;
	}

	public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
		this.formFooterPanel = formFooterPanel;
	}

	public JPanel getPlayersPanel() {
		return playersPanel;
	}

	public void setPlayersPanel(JPanel playersPanel) {
		this.playersPanel = playersPanel;
	}

	public JLabel getTeamLabel() {
		return teamLabel;
	}

	public void setTeamLabel(JLabel teamLabel) {
		this.teamLabel = teamLabel;
	}

	public JComboBox<String> getTeamComboBox() {
		return teamComboBox;
	}

	public void setTeamComboBox(JComboBox<String> teamComboBox) {
		this.teamComboBox = teamComboBox;
	}

	public JLabel getPlayerLabel() {
		return playerLabel;
	}

	public void setPlayerLabel(JLabel playerLabel) {
		this.playerLabel = playerLabel;
	}

	public JComboBox<String> getPlayerComboBox() {
		return playerComboBox;
	}

	public void setPlayerComboBox(JComboBox<String> playerComboBox) {
		this.playerComboBox = playerComboBox;
	}

	public JButton getAddPlayerButton() {
		return addPlayerButton;
	}

	public void setAddPlayerButton(JButton addPlayerButton) {
		this.addPlayerButton = addPlayerButton;
	}
}
