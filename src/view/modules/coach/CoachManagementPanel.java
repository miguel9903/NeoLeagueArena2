package view.modules.coach;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.util.Colors;

public class CoachManagementPanel extends JPanel {

    private JTabbedPane tabs;
    private CoachFormPanel coachFormPanel;
    private TeamPlayerAssignmentPanel teamPlayerAssignmentPanel;
    private CoachTablePanel coachTablePanel;
    
    public CoachManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    private void initializeComponents() {
        tabs = new JTabbedPane();

        coachFormPanel = new CoachFormPanel();
        coachFormPanel.setPreferredSize(new Dimension(550, 500));
        tabs.addTab("Manage Coaches", coachFormPanel);

        coachTablePanel = new CoachTablePanel();
        coachTablePanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("List Coaches", coachTablePanel);
        
        add(tabs);
    }

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public CoachFormPanel getCoachFormPanel() {
		return coachFormPanel;
	}

	public void setCoachFormPanel(CoachFormPanel coachFormPanel) {
		this.coachFormPanel = coachFormPanel;
	}

	public TeamPlayerAssignmentPanel getTeamPlayerAssignmentPanel() {
		return teamPlayerAssignmentPanel;
	}

	public void setTeamPlayerAssignmentPanel(TeamPlayerAssignmentPanel teamPlayerAssignmentPanel) {
		this.teamPlayerAssignmentPanel = teamPlayerAssignmentPanel;
	}

	public CoachTablePanel getCoachTablePanel() {
		return coachTablePanel;
	}

	public void setCoachTablePanel(CoachTablePanel coachTablePanel) {
		this.coachTablePanel = coachTablePanel;
	}

	

}
