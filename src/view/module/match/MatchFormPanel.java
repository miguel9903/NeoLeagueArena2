package view.module.match;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.ButtonActionCommands;
import utils.Colors;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

import java.awt.BorderLayout;
import java.awt.Color;

public class MatchFormPanel extends JPanel {

	private FormHeaderPanel formHeaderPanel;
	private MatchFormFieldsPanel teamFormFieldsPanel;
	private FormFooterPanel formFooterPanel;

	public MatchFormPanel() {
		setLayout(new BorderLayout()); 
		initializeComponents(); 
		setupFormControls();
	}

	private void initializeComponents() { 
		formHeaderPanel = new FormHeaderPanel();
		formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		teamFormFieldsPanel = new MatchFormFieldsPanel();
		teamFormFieldsPanel.setBorder(new EmptyBorder(0, 20, 0, 20)); 

		formFooterPanel = new FormFooterPanel();
		formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		formFooterPanel.setBackground(Color.decode(Colors.MEDIUM_GRAY));

		add(formHeaderPanel, BorderLayout.NORTH); 
		add(teamFormFieldsPanel, BorderLayout.CENTER);
		add(formFooterPanel, BorderLayout.SOUTH); 
	}

	public void setupFormControls() {
		formHeaderPanel.getFormTitleLabel().setText("Manage Matches");
		
		formHeaderPanel.setSearchButtonText("Search");
		formHeaderPanel.setSearchButtonActionCommand(ButtonActionCommands.ADMIN_SEARCH_TEAM_ACTION_COMMAND);
		
		formFooterPanel.setPrimaryButtonText("CREATE");
		formFooterPanel.setPrimaryButtonActionCommand(ButtonActionCommands.ADMIN_CREATE_TEAM_ACTION_COMMAND);
		
		formFooterPanel.setSecondaryButtonText("UPDATE");
		formFooterPanel.setSecondaryButtonActionCommand(ButtonActionCommands.ADMIN_UPDATE_TEAM_ACTION_COMMAND);
		
		formFooterPanel.setTertiaryButtonText("DELETE");
		formFooterPanel.setTertiaryButtonActionCommand(ButtonActionCommands.ADMIN_DELETE_TEAM_ACTION_COMMAND);
		
		formFooterPanel.setQuaternaryButtonText("RESET DATA");
		formFooterPanel.setQuaternaryButtonActionCommand(ButtonActionCommands.ADMIN_RESET_TEAM_ACTION_COMMAND);
	}
	
	public FormHeaderPanel getFormHeaderPanel() {
		return formHeaderPanel;
	}

	public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
		this.formHeaderPanel = formHeaderPanel;
	}

	public MatchFormFieldsPanel getTeamFormFieldsPanel() {
		return teamFormFieldsPanel;
	}

	public void setTeamFormFieldsPanel(MatchFormFieldsPanel teamFormFieldsPanel) {
		this.teamFormFieldsPanel = teamFormFieldsPanel;
	}

	public FormFooterPanel getFormFooterPanel() {
		return formFooterPanel;
	}

	public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
		this.formFooterPanel = formFooterPanel;
	}

	
}
