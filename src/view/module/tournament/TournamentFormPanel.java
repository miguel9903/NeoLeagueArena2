package view.module.tournament;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.util.ButtonActionCommands;
import co.edu.unbosque.util.Colors;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

import java.awt.BorderLayout;
import java.awt.Color;

public class TournamentFormPanel extends JPanel {

	private FormHeaderPanel formHeaderPanel;
	private TournamentFormFieldsPanel tournamentFormFieldsPanel;
	private FormFooterPanel formFooterPanel;

	public TournamentFormPanel() {
		setLayout(new BorderLayout()); 
		initializeComponents(); 
		setupFormControls();
	}

	private void initializeComponents() { 
		formHeaderPanel = new FormHeaderPanel();
		formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		tournamentFormFieldsPanel = new TournamentFormFieldsPanel();
		tournamentFormFieldsPanel.setBorder(new EmptyBorder(0, 20, 0, 20)); 

		formFooterPanel = new FormFooterPanel();
		formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		formFooterPanel.setBackground(Color.decode(Colors.MEDIUM_GRAY));

		add(formHeaderPanel, BorderLayout.NORTH); 
		add(tournamentFormFieldsPanel, BorderLayout.CENTER);
		add(formFooterPanel, BorderLayout.SOUTH); 
	}

	public void setupFormControls() {
		formHeaderPanel.getFormTitleLabel().setText("Manage Tournaments");
		
		formHeaderPanel.setSearchButtonText("Search");
		formHeaderPanel.setSearchButtonActionCommand(ButtonActionCommands.ADMIN_SEARCH_TOURNAMENT_ACTION_COMMAND);
		
		formFooterPanel.setPrimaryButtonText("CREATE");
		formFooterPanel.setPrimaryButtonActionCommand(ButtonActionCommands.ADMIN_CREATE_TOURNAMENT_ACTION_COMMAND);
		
		formFooterPanel.setSecondaryButtonText("UPDATE");
		formFooterPanel.setSecondaryButtonActionCommand(ButtonActionCommands.ADMIN_UPDATE_TOURNAMENT_ACTION_COMMAND);
		
		formFooterPanel.setTertiaryButtonText("DELETE");
		formFooterPanel.setTertiaryButtonActionCommand(ButtonActionCommands.ADMIN_DELETE_TOURNAMENT_ACTION_COMMAND);
		
		formFooterPanel.setQuaternaryButtonText("RESET DATA");
		formFooterPanel.setQuaternaryButtonActionCommand(ButtonActionCommands.ADMIN_RESET_TOURNAMENT_ACTION_COMMAND);
	}

	public FormHeaderPanel getFormHeaderPanel() {
		return formHeaderPanel;
	}

	public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
		this.formHeaderPanel = formHeaderPanel;
	}

	public TournamentFormFieldsPanel getTournamentFormFieldsPanel() {
		return tournamentFormFieldsPanel;
	}

	public void setTournamentFormFieldsPanel(TournamentFormFieldsPanel tournamentFormFieldsPanel) {
		this.tournamentFormFieldsPanel = tournamentFormFieldsPanel;
	}

	public FormFooterPanel getFormFooterPanel() {
		return formFooterPanel;
	}

	public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
		this.formFooterPanel = formFooterPanel;
	}
	
}
