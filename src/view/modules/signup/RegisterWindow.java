package view.modules.signup;

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

import co.edu.unbosque.util.AssetPaths;
import co.edu.unbosque.util.ButtonActionCommands;
import co.edu.unbosque.util.Colors;

public class RegisterWindow extends JFrame {

	private RegisterFieldsPanel registerFieldsPanel;
	private JLabel logoLabel;
	private JPanel buttonsPanel;
	private JPanel logoPanel;
	private JButton registerButton;
	private JButton cancelButton;

	public RegisterWindow() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
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

		registerFieldsPanel = new RegisterFieldsPanel();
		registerFieldsPanel.setPreferredSize(new Dimension(600, 300));
		registerFieldsPanel.setBorder(new EmptyBorder(20, 100, 0, 100)); 

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		buttonsPanel.setBorder(new EmptyBorder(20, 40, 20, 40)); 

		registerButton = new JButton("Register");
		registerButton.setActionCommand(ButtonActionCommands.REGISTER_ACTION_COMMAND);
		buttonsPanel.add(registerButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand(ButtonActionCommands.REGISTER_CANCEL_ACTION_COMMAND);
		buttonsPanel.add(cancelButton);

		add(logoPanel, BorderLayout.NORTH);
		add(registerFieldsPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	private ImageIcon loadIcon(String imagePath, int width, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}


	public RegisterFieldsPanel getRegisterFieldsPanel() {
		return registerFieldsPanel;
	}


	public void setRegisterFieldsPanel(RegisterFieldsPanel registerFieldsPanel) {
		this.registerFieldsPanel = registerFieldsPanel;
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


	public JButton getRegisterButton() {
		return registerButton;
	}


	public void setRegisterButton(JButton registerButton) {
		this.registerButton = registerButton;
	}


	public JButton getCancelButton() {
		return cancelButton;
	}


	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}
}
