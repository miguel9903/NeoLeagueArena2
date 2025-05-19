package view.modules.navigation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.util.AssetPaths;
import co.edu.unbosque.util.ButtonActionCommands;
import co.edu.unbosque.util.Colors;

public class TopBarPanel extends JPanel {

	private JPanel leftPanel;
	private JPanel rightPanel;

	private JLabel titleLabel;
	private JPanel userInfoPanel;
	private JLabel profilePictureLabel;
	private JLabel userNameLabel;
	private JButton logoutButton;

	public TopBarPanel() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 20, 10, 20));
		setBackground(Color.decode(Colors.BLUE_NEON));

		initializeComponets();
	}

	public void initializeComponets() {
		leftPanel= new JPanel();
		leftPanel.setBackground(Color.decode(Colors.DARK_PRIMARY));

		rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rightPanel.setBackground(Color.decode(Colors.BLUE_NEON));

		titleLabel = new JLabel("Home", JLabel.LEFT);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftPanel.add(titleLabel);

		userInfoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		userInfoPanel.setBackground(Color.decode(Colors.BLUE_NEON));
		ImageIcon userIcon = loadIcon(AssetPaths.USER_COLOR_ICON, 20, 20);

		profilePictureLabel = new JLabel();
		profilePictureLabel.setIcon(userIcon);  
		userInfoPanel.add(profilePictureLabel);  

		userNameLabel = new JLabel("User");
		userNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));  
		userNameLabel.setForeground(Color.WHITE); 
		userInfoPanel.add(userNameLabel); 

		rightPanel.add(userInfoPanel);

		ImageIcon logoutButtonIcon = loadIcon(AssetPaths.LOGOUT_ICON, 20, 20);
		logoutButton = new JButton("Logout");
		logoutButton = new JButton("Logout", logoutButtonIcon);
		logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
		logoutButton.setIconTextGap(10);
		logoutButton.setMaximumSize(new Dimension(180, 40));
		logoutButton.setBackground(Color.LIGHT_GRAY);
		logoutButton.setFocusPainted(false);
		logoutButton.setActionCommand(ButtonActionCommands.LOGOUT_ACTION_COMMAND);
		rightPanel.add(logoutButton);  

		add(titleLabel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
	}

	private ImageIcon loadIcon(String imagePath, int width, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(JPanel leftPanel) {
		this.leftPanel = leftPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JPanel getUserInfoPanel() {
		return userInfoPanel;
	}

	public void setUserInfoPanel(JPanel userInfoPanel) {
		this.userInfoPanel = userInfoPanel;
	}

	public JLabel getProfilePictureLabel() {
		return profilePictureLabel;
	}

	public void setProfilePictureLabel(JLabel profilePictureLabel) {
		this.profilePictureLabel = profilePictureLabel;
	}

	public JLabel getUserNameLabel() {
		return userNameLabel;
	}

	public void setUserNameLabel(JLabel userNameLabel) {
		this.userNameLabel = userNameLabel;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}

	public void setLogoutButton(JButton logoutButton) {
		this.logoutButton = logoutButton;
	}
}
