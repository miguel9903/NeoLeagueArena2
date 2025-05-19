package view.modules.player;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.ButtonActionCommands;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

import java.awt.BorderLayout;

public class PlayerFormPanel extends JPanel {

	private FormHeaderPanel formHeaderPanel;
	private PlayerFormFieldsPanel playerFormFieldsPanel;
	private FormFooterPanel formFooterPanel;

	public PlayerFormPanel() {
		setLayout(new BorderLayout()); 
		initializeComponents(); 
		setupFormControls();
	}

	private void initializeComponents() { 
		formHeaderPanel = new FormHeaderPanel();
		formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		playerFormFieldsPanel = new PlayerFormFieldsPanel();
		playerFormFieldsPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); 

		formFooterPanel = new FormFooterPanel();
		formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		add(formHeaderPanel, BorderLayout.NORTH); 
		add(playerFormFieldsPanel, BorderLayout.CENTER);
		add(formFooterPanel, BorderLayout.SOUTH); 
	}


	public void setupFormControls() {
	    formHeaderPanel.getFormTitleLabel().setText("Manage Players");
	    
	    formHeaderPanel.setSearchButtonText("Search");
	    formHeaderPanel.setSearchButtonActionCommand(ButtonActionCommands.ADMIN_SEARCH_PLAYER_ACTION_COMMAND);
	    
	    formFooterPanel.setPrimaryButtonText("CREATE");
	    formFooterPanel.setPrimaryButtonActionCommand(ButtonActionCommands.ADMIN_CREATE_PLAYER_ACTION_COMMAND);

	    formFooterPanel.setSecondaryButtonText("UPDATE");
	    formFooterPanel.setSecondaryButtonActionCommand(ButtonActionCommands.ADMIN_UPDATE_PLAYER_ACTION_COMMAND);

	    formFooterPanel.setTertiaryButtonText("DELETE");
	    formFooterPanel.setTertiaryButtonActionCommand(ButtonActionCommands.ADMIN_DELETE_PLAYER_ACTION_COMMAND);
	    
	    formFooterPanel.setQuaternaryButtonText("RESET DATA");
	    formFooterPanel.setQuaternaryButtonActionCommand(ButtonActionCommands.ADMIN_RESET_PLAYER_ACTION_COMMAND);
	}
	
	public FormHeaderPanel getFormHeaderPanel() {
		return formHeaderPanel;
	}

	public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
		this.formHeaderPanel = formHeaderPanel;
	}

	public PlayerFormFieldsPanel getPlayerFormFieldsPanel() {
		return playerFormFieldsPanel;
	}

	public void setPlayerFormFieldsPanel(PlayerFormFieldsPanel playerFormFieldsPanel) {
		this.playerFormFieldsPanel = playerFormFieldsPanel;
	}

	public FormFooterPanel getFormFooterPanel() {
		return formFooterPanel;
	}

	public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
		this.formFooterPanel = formFooterPanel;
	}

}
