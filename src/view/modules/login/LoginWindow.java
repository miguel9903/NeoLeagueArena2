package view.modules.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.AssetPaths;
import utils.ButtonActionCommands;
import utils.Colors;

public class LoginWindow extends JFrame {

	private LoginCredentialsPanel credentialsPanel;
	private JLabel logoLabel;
	private JPanel buttonsPanel;
	private JPanel logoPanel;
	private JButton loginButton;
	private JButton registerButton;

	public LoginWindow() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		initializeComponents();
		setVisible(false);
	}


	public void initializeComponents() {
		ImageIcon logo = loadIcon(AssetPaths.DARK_LOGO, 180, 40);
		logoLabel = new JLabel(logo);
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);

		logoPanel = new JPanel(new GridBagLayout());
		logoPanel.setPreferredSize(new Dimension(600, 200));
		logoPanel.setBackground(Color.decode(Colors.DARK_SECONDARY));
		logoPanel.add(logoLabel);

		credentialsPanel = new LoginCredentialsPanel();
		credentialsPanel.setPreferredSize(new Dimension(600, 300));
		credentialsPanel.setBorder(new EmptyBorder(20, 100, 0, 100)); 

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		buttonsPanel.setBorder(new EmptyBorder(20, 40, 20, 40)); 

		loginButton = new JButton("Login");
		loginButton.setActionCommand(ButtonActionCommands.LOGIN_ACTION_COMMAND);
		buttonsPanel.add(loginButton);

		registerButton = new JButton("Register");
		registerButton.setActionCommand(ButtonActionCommands.LOGIN_REGISTER_ACTION_COMMAND);
		buttonsPanel.add(registerButton);

		add(logoPanel, BorderLayout.NORTH);
		add(credentialsPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	private ImageIcon loadIcon(String imagePath, int width, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}


	public LoginCredentialsPanel getCredentialsPanel() {
		return credentialsPanel;
	}


	public void setCredentialsPanel(LoginCredentialsPanel credentialsPanel) {
		this.credentialsPanel = credentialsPanel;
	}


	public JLabel getLogoLabel() {
		return logoLabel;
	}


	public void setLogoLabel(JLabel logoLabel) {
		this.logoLabel = logoLabel;
	}


	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}


	public void setButtonsPanel(JPanel buttonsPanel) {
		this.buttonsPanel = buttonsPanel;
	}


	public JPanel getLogoPanel() {
		return logoPanel;
	}


	public void setLogoPanel(JPanel logoPanel) {
		this.logoPanel = logoPanel;
	}


	public JButton getLoginButton() {
		return loginButton;
	}


	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}


	public JButton getRegisterButton() {
		return registerButton;
	}


	public void setRegisterButton(JButton registerButton) {
		this.registerButton = registerButton;
	}
}
