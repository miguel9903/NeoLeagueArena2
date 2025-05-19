package view.modules.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import view.modules.navigation.TopBarPanel;

public class MainContentPanel extends JPanel {

	private TopBarPanel topBarPanel;
	private LayoutContentPanel layoutContentPanel;

	public MainContentPanel() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(800, 600));
		
		initializeComponents();
	}

	public void initializeComponents() {
		topBarPanel = new TopBarPanel();
		layoutContentPanel = new LayoutContentPanel();
		
		add(topBarPanel, BorderLayout.NORTH);
		add(layoutContentPanel, BorderLayout.CENTER);
	}

	public TopBarPanel getTopBarPanel() {
		return topBarPanel;
	}

	public void setTopBarPanel(TopBarPanel topBarPanel) {
		this.topBarPanel = topBarPanel;
	}

	public LayoutContentPanel getLayoutContentPanel() {
		return layoutContentPanel;
	}

	public void setLayoutContentPanel(LayoutContentPanel layoutContentPanel) {
		this.layoutContentPanel = layoutContentPanel;
	}
	
	public void repaintView() {
		revalidate();
		repaint();
	}
}
