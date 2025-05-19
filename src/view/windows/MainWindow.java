package view.windows;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import utils.MessageDisplayer;
import view.modules.layout.MainContentPanel;
import view.modules.navigation.SideBarPanel;

public class MainWindow extends JFrame {

	private SideBarPanel sidebarPanel;
	private MainContentPanel mainContentPanel;

	public MainWindow() {
		setTitle("NeoLeague Arena");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		setResizable(false);
		setLocationRelativeTo(null);

		initializeComponents();
		setVisible(false);
	}

	private void initializeComponents() {
		sidebarPanel = new SideBarPanel();
		mainContentPanel = new MainContentPanel();

		add(sidebarPanel, BorderLayout.WEST);
		add(mainContentPanel, BorderLayout.CENTER);
	}

	public SideBarPanel getSideBarPanel() {
		return sidebarPanel;
	}

	public MainContentPanel getMainContentPanel() {
		return mainContentPanel;
	}
	
	public void repaintView() {
		revalidate();
		repaint();
	}
	
}
