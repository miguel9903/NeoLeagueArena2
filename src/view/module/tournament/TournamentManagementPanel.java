package view.module.tournament;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import utils.Colors;
import view.module.team.TeamFormPanel;
import view.module.team.TeamPlayerAssignmentPanel;

public class TournamentManagementPanel extends JPanel {

    private JTabbedPane tabs;
    private TournamentFormPanel tournamentFormPanel;
    private TournamentMatchAssignmentPanel tournamentMatchAssignmentPanel;
    private TournamentTablePanel tournamentTablePanel;
    
    public TournamentManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    private void initializeComponents() {
        tabs = new JTabbedPane();

        tournamentFormPanel = new TournamentFormPanel();
        tournamentFormPanel.setPreferredSize(new Dimension(550, 560));
        tabs.addTab("Manage Tournaments", tournamentFormPanel);

        tournamentMatchAssignmentPanel = new TournamentMatchAssignmentPanel();
        tournamentMatchAssignmentPanel.setPreferredSize(new Dimension(500, 560));
        tabs.addTab("Managa Matches", tournamentMatchAssignmentPanel);
        
        tournamentTablePanel = new TournamentTablePanel();
        tournamentTablePanel.setPreferredSize(new Dimension(500, 560));
        tabs.addTab("List Tournaments", tournamentTablePanel);
        
        add(tabs);
    }

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public TournamentFormPanel getTournamentFormPanel() {
		return tournamentFormPanel;
	}

	public void setTournamentFormPanel(TournamentFormPanel tournamentFormPanel) {
		this.tournamentFormPanel = tournamentFormPanel;
	}

	public TournamentMatchAssignmentPanel getTournamentMatchAssignmentPanel() {
		return tournamentMatchAssignmentPanel;
	}

	public void setTournamentMatchAssignmentPanel(TournamentMatchAssignmentPanel tournamentMatchAssignmentPanel) {
		this.tournamentMatchAssignmentPanel = tournamentMatchAssignmentPanel;
	}

	public TournamentTablePanel getTournamentTablePanel() {
		return tournamentTablePanel;
	}

	public void setTournamentTablePanel(TournamentTablePanel tournamentTablePanel) {
		this.tournamentTablePanel = tournamentTablePanel;
	}

}
