package view.module.team;

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

import co.edu.unbosque.model.CoachDTO;
import co.edu.unbosque.model.PlayerDTO;
import co.edu.unbosque.model.TeamDTO;
import co.edu.unbosque.util.ButtonActionCommands;
import co.edu.unbosque.util.Colors;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

public class TeamPlayerAssignmentPanel extends JPanel {

	private FormHeaderPanel formHeaderPanel;
	private FormFooterPanel formFooterPanel;

	private JPanel playersPanel;
	private JLabel teamLabel;
	private JLabel playerLabel;
	private JComboBox<String> teamComboBox;
	private JComboBox<String> playerComboBox;

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

		playerLabel = new JLabel("Player:");
		playerComboBox = new JComboBox<>();

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
		formFooterPanel.setPrimaryButtonActionCommand(ButtonActionCommands.ADMIN_ADD_PLAYERS_TO_TEAM_ACTION_COMMAND);
		formFooterPanel.removeSecondaryButton();
		formFooterPanel.removeTertiaryButton();
		formFooterPanel.removeQuaternaryButton();
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

    public Integer getTeamComboBoxIdValue() {
        String teamText = (String) teamComboBox.getSelectedItem();
        return (teamText != null && !teamText.isEmpty() && teamText.contains("-")) 
                ? Integer.parseInt(teamText.substring(0, teamText.indexOf(" -"))) 
                : null;
    }

    public Integer getPlayerComboBoxIdValue() {
        String playerText = (String) playerComboBox.getSelectedItem();
        return (playerText != null && !playerText.isEmpty() && playerText.contains("-")) 
                ? Integer.parseInt(playerText.substring(0, playerText.indexOf(" -"))) 
                : null;
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

	public JLabel getPlayerLabel() {
		return playerLabel;
	}

	public void setPlayerLabel(JLabel playerLabel) {
		this.playerLabel = playerLabel;
	}

	public JComboBox<String> getTeamComboBox() {
		return teamComboBox;
	}

	public void setTeamComboBox(JComboBox<String> teamComboBox) {
		this.teamComboBox = teamComboBox;
	}

	public JComboBox<String> getPlayerComboBox() {
		return playerComboBox;
	}

	public void setPlayerComboBox(JComboBox<String> playerComboBox) {
		this.playerComboBox = playerComboBox;
	}
    

}
