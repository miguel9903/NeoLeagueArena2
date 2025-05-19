package view.modules.admin;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import utils.Colors;

public class AdminManagementPanel extends JPanel {

    private JTabbedPane tabs;
    private AdminFormPanel teamFormPanel;
    private TeamPlayerAssignmentPanel teamPlayerAssignmentPanel;
    private AdminTablePanel teamTablePanel;
    
    public AdminManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    private void initializeComponents() {
        tabs = new JTabbedPane();

        teamFormPanel = new AdminFormPanel();
        teamFormPanel.setPreferredSize(new Dimension(550, 500));
        tabs.addTab("Manage Admins", teamFormPanel);

        teamPlayerAssignmentPanel = new TeamPlayerAssignmentPanel();
        teamPlayerAssignmentPanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("Assign Players", teamPlayerAssignmentPanel);
        
        teamTablePanel = new AdminTablePanel();
        teamTablePanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("List Admins", teamTablePanel);
        
        add(tabs);
    }

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public AdminFormPanel getTeamFormPanel() {
		return teamFormPanel;
	}

	public void setTeamFormPanel(AdminFormPanel teamFormPanel) {
		this.teamFormPanel = teamFormPanel;
	}

	public TeamPlayerAssignmentPanel getTeamPlayerAssignmentPanel() {
		return teamPlayerAssignmentPanel;
	}

	public void setTeamPlayerAssignmentPanel(TeamPlayerAssignmentPanel teamPlayerAssignmentPanel) {
		this.teamPlayerAssignmentPanel = teamPlayerAssignmentPanel;
	}

	public AdminTablePanel getTeamTablePanel() {
		return teamTablePanel;
	}

	public void setTeamTablePanel(AdminTablePanel teamTablePanel) {
		this.teamTablePanel = teamTablePanel;
	}

}
