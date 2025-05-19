package view.module.match;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import utils.Colors;

public class MatchManagementPanel extends JPanel {

    private JTabbedPane tabs;
    private MatchFormPanel matchFormPanel;
    private TeamPlayerAssignmentPanel teamPlayerAssignmentPanel;
    private MatchTablePanel matchTablePanel;
    
    public MatchManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    private void initializeComponents() {
        tabs = new JTabbedPane();

        matchFormPanel = new MatchFormPanel();
        matchFormPanel.setPreferredSize(new Dimension(550, 500));
        tabs.addTab("Manage Matches", matchFormPanel);

        teamPlayerAssignmentPanel = new TeamPlayerAssignmentPanel();
        teamPlayerAssignmentPanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("Assign Players", teamPlayerAssignmentPanel);
        
        matchTablePanel = new MatchTablePanel();
        matchTablePanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("List Matches", matchTablePanel);
        
        add(tabs);
    }

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public MatchFormPanel getMatchFormPanel() {
		return matchFormPanel;
	}

	public void setMatchFormPanel(MatchFormPanel matchFormPanel) {
		this.matchFormPanel = matchFormPanel;
	}

	public TeamPlayerAssignmentPanel getTeamPlayerAssignmentPanel() {
		return teamPlayerAssignmentPanel;
	}

	public void setTeamPlayerAssignmentPanel(TeamPlayerAssignmentPanel teamPlayerAssignmentPanel) {
		this.teamPlayerAssignmentPanel = teamPlayerAssignmentPanel;
	}

	public MatchTablePanel getMatchTablePanel() {
		return matchTablePanel;
	}

	public void setMatchTablePanel(MatchTablePanel matchTablePanel) {
		this.matchTablePanel = matchTablePanel;
	}


}
