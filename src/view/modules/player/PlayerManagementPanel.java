package view.modules.player;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.util.Colors;
import view.module.team.TeamFormPanel;
import view.module.team.TeamPlayerAssignmentPanel;

public class PlayerManagementPanel extends JPanel {

    private JTabbedPane tabs;
    private PlayerFormPanel playerFormPanel;
    private PlayerTablePanel playerTablePanel;
    
    public PlayerManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    private void initializeComponents() {
        tabs = new JTabbedPane();

        playerFormPanel = new PlayerFormPanel();
        playerFormPanel.setPreferredSize(new Dimension(750, 500));
        tabs.addTab("Manage Players", playerFormPanel);

        playerTablePanel = new PlayerTablePanel();
        playerTablePanel.setPreferredSize(new Dimension(750, 500));
        tabs.addTab("List Players", playerTablePanel);
        
        add(tabs);
    }

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public PlayerFormPanel getPlayerFormPanel() {
		return playerFormPanel;
	}

	public void setPlayerFormPanel(PlayerFormPanel playerFormPanel) {
		this.playerFormPanel = playerFormPanel;
	}

	public PlayerTablePanel getPlayerTablePanel() {
		return playerTablePanel;
	}

	public void setPlayerTablePanel(PlayerTablePanel playerTablePanel) {
		this.playerTablePanel = playerTablePanel;
	}
}
