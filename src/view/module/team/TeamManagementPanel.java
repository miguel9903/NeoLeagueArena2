 package view.module.team;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.util.Colors;

public class TeamManagementPanel extends JPanel {

    private JTabbedPane tabs;
    private TeamFormPanel teamFormPanel;
    private TeamPlayerAssignmentPanel teamPlayerAssignmentPanel;
    private TeamTablePanel teamTablePanel;
    
    public TeamManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    private void initializeComponents() {
        tabs = new JTabbedPane();

        teamFormPanel = new TeamFormPanel();
        teamFormPanel.setPreferredSize(new Dimension(550, 500));
        tabs.addTab("Manage Teams", teamFormPanel);

        teamPlayerAssignmentPanel = new TeamPlayerAssignmentPanel();
        teamPlayerAssignmentPanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("Assign Players", teamPlayerAssignmentPanel);
        
        teamTablePanel = new TeamTablePanel();
        teamTablePanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("List Teams", teamTablePanel);
        
        add(tabs);
    }

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public TeamFormPanel getTeamFormPanel() {
		return teamFormPanel;
	}

	public void setTeamFormPanel(TeamFormPanel teamFormPanel) {
		this.teamFormPanel = teamFormPanel;
	}

	public TeamPlayerAssignmentPanel getTeamPlayerAssignmentPanel() {
		return teamPlayerAssignmentPanel;
	}

	public void setTeamPlayerAssignmentPanel(TeamPlayerAssignmentPanel teamPlayerAssignmentPanel) {
		this.teamPlayerAssignmentPanel = teamPlayerAssignmentPanel;
	}

	public TeamTablePanel getTeamTablePanel() {
		return teamTablePanel;
	}

	public void setTeamTablePanel(TeamTablePanel teamTablePanel) {
		this.teamTablePanel = teamTablePanel;
	}

}
