package view.shared;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Colors;

public abstract class BaseCardPanel extends JPanel {

	protected JPanel headerPanel;
	protected JPanel infoPanel;
	protected JPanel footerPanel;

	public BaseCardPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.decode(Colors.LIGHT_GRAY), 1));
		initializeComponents();
	}

	public void initializeComponents() {
		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		infoPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(1, 0, 1, 0, Color.decode(Colors.LIGHT_GRAY)),
				new EmptyBorder(10, 10, 10, 10) 
				));

		footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		footerPanel.setBackground(Color.WHITE);
		footerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		buildHeader();
		buildInfo();
		buildFooter();

		add(headerPanel, BorderLayout.NORTH);
		add(infoPanel, BorderLayout.CENTER);
		add(footerPanel, BorderLayout.SOUTH);
	}

	public ImageIcon loadIcon(String imagePath, int width, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}

	protected abstract void buildHeader();
	protected abstract void buildInfo();
	protected abstract void buildFooter();
}
