package view.modules.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import utils.Colors;

public class LoginCredentialsPanel extends JPanel {

	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JTextField emailTextField;
	private JPasswordField passwordTextField;

	public LoginCredentialsPanel() {
		setLayout(new GridLayout(3, 2, 10, 10));
		setBackground(Color.WHITE);

		initializeComponents();
	}

	private void initializeComponents() {
		emailLabel = new JLabel("Email:");
		emailLabel.setForeground(Color.BLACK);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
		add(emailLabel);

		emailTextField = new JTextField();
		add(emailTextField);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
		add(passwordLabel);

		passwordTextField = new JPasswordField();
		add(passwordTextField);
	}

	public void resetFields() {
		emailTextField.setText("");
		passwordTextField.setText("");
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public void setEmailLabel(JLabel emailLabel) {
		this.emailLabel = emailLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(JTextField emailTextField) {
		this.emailTextField = emailTextField;
	}

	public JPasswordField getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(JPasswordField passwordTextField) {
		this.passwordTextField = passwordTextField;
	}
}
