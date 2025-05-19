package view.modules.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.module.team.TeamManagementPanel;

public class AdminPanel extends JPanel {

    private AdminNavBarPanel adminNavBarPanel;
    private AdminContentPanel adminContentPanel;

    public AdminPanel() {
        initializeComponents();
    }

    public void initializeComponents() {
        setLayout(new BorderLayout());

        adminNavBarPanel = new AdminNavBarPanel();
        add(adminNavBarPanel, BorderLayout.NORTH);

        adminContentPanel = new AdminContentPanel();
        add(adminContentPanel, BorderLayout.CENTER);
    }

	public AdminNavBarPanel getAdminNavBarPanel() {
		return adminNavBarPanel;
	}

	public void setAdminNavBarPanel(AdminNavBarPanel adminNavBarPanel) {
		this.adminNavBarPanel = adminNavBarPanel;
	}

	public AdminContentPanel getAdminContentPanel() {
		return adminContentPanel;
	}

	public void setAdminContentPanel(AdminContentPanel adminContentPanel) {
		this.adminContentPanel = adminContentPanel;
	}
    
}
