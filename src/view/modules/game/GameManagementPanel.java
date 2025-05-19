package view.modules.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import utils.Colors;

public class GameManagementPanel extends JPanel {

    private JTabbedPane tabs;
    private GameFormPanel gameFormPanel;
    private TeamPlayerAssignmentPanel teamPlayerAssignmentPanel;
    private GameTablePanel gameTablePanel;
    
    public GameManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    private void initializeComponents() {
        tabs = new JTabbedPane();

        gameFormPanel = new GameFormPanel();
        gameFormPanel.setPreferredSize(new Dimension(550, 500));
        tabs.addTab("Manage Games", gameFormPanel);

        teamPlayerAssignmentPanel = new TeamPlayerAssignmentPanel();
        teamPlayerAssignmentPanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("Assign Players", teamPlayerAssignmentPanel);
        
        gameTablePanel = new GameTablePanel();
        gameTablePanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("List Games", gameTablePanel);
        
        add(tabs);
    }

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public GameFormPanel getGameFormPanel() {
		return gameFormPanel;
	}

	public void setGameFormPanel(GameFormPanel gameFormPanel) {
		this.gameFormPanel = gameFormPanel;
	}

	public TeamPlayerAssignmentPanel getTeamPlayerAssignmentPanel() {
		return teamPlayerAssignmentPanel;
	}

	public void setTeamPlayerAssignmentPanel(TeamPlayerAssignmentPanel teamPlayerAssignmentPanel) {
		this.teamPlayerAssignmentPanel = teamPlayerAssignmentPanel;
	}

	public GameTablePanel getGameTablePanel() {
		return gameTablePanel;
	}

	public void setGameTablePanel(GameTablePanel gameTablePanel) {
		this.gameTablePanel = gameTablePanel;
	}

}
