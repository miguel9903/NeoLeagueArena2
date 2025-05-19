package view.shared;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import co.edu.unbosque.model.UserRole;

public class BaseUserFormFieldsPanel extends JPanel {

	protected JLabel idLabel;
	protected JLabel firstNameLabel;
	protected JLabel lastNameLabel;
	protected JLabel emailLabel;
	protected JLabel passwordLabel;
	protected JLabel countryLabel;
	protected JLabel cityLabel;
	protected JLabel roleLabel;
	protected JLabel dateBirthDateLabel;
	protected JLabel formTitleLabel;

	protected JTextField idTextField;
	protected JTextField firstNameTextField;
	protected JTextField lastNameTextField;
	protected JTextField emailTextField;
	protected JTextField dateBirthDateTextField;
	protected JPasswordField passwordTextField;
	protected JTextField countryTextField;
	protected JTextField cityTextField;
	protected JComboBox<String> roleComboBox;
	
	public BaseUserFormFieldsPanel() { 
		setLayout(new GridLayout(0, 2, 10, 10));
		initializeComponents();
	}

	public void initializeComponents() {		
		idLabel = new JLabel("ID:");
		idTextField = new JTextField();
		add(idLabel);
		add(idTextField);

		firstNameLabel = new JLabel("Name:");
		firstNameTextField = new JTextField();
		add(firstNameLabel);
		add(firstNameTextField);

		lastNameLabel = new JLabel("Last name:");
		lastNameTextField = new JTextField();
		add(lastNameLabel);
		add(lastNameTextField);

		emailLabel = new JLabel("Email:");
		emailTextField = new JTextField();
		add(emailLabel);
		add(emailTextField);

		passwordLabel = new JLabel("Password:");
		passwordTextField = new JPasswordField();
		add(passwordLabel);
		add(passwordTextField);

		countryLabel = new JLabel("Country:");
		countryTextField = new JTextField();
		add(countryLabel);
		add(countryTextField);

		cityLabel = new JLabel("City:");
		cityTextField = new JTextField();
		add(cityLabel);
		add(cityTextField);

		dateBirthDateLabel = new JLabel("Date Birthdate:");
		dateBirthDateTextField = new JTextField();
		add(dateBirthDateLabel);
		add(dateBirthDateTextField);
		
		String[] userRoles = new String[]{
				UserRole.ADMIN.getDisplayName(), 
				UserRole.PLAYER.getDisplayName(), 
				UserRole.COACH.getDisplayName()};

		roleLabel = new JLabel("Role:");
		roleComboBox = new JComboBox<String>(userRoles);
		add(roleLabel);
		add(roleComboBox);
	}

	public void resetFields() {
		idTextField.setText("");
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		emailTextField.setText("");
		passwordTextField.setText("");
		countryTextField.setText("");
		cityTextField.setText("");
		roleComboBox.setSelectedIndex(0);
	}
	
	public void removeRoleComboBox() {
		remove(roleLabel);
		remove(roleComboBox);
		revalidate();
		repaint();
	}

	public JLabel getIdLabel() {
		return idLabel;
	}

	public void setIdLabel(JLabel idLabel) {
		this.idLabel = idLabel;
	}

	public JLabel getFirstNameLabel() {
		return firstNameLabel;
	}

	public void setFirstNameLabel(JLabel firstNameLabel) {
		this.firstNameLabel = firstNameLabel;
	}

	public JLabel getLastNameLabel() {
		return lastNameLabel;
	}

	public void setLastNameLabel(JLabel lastNameLabel) {
		this.lastNameLabel = lastNameLabel;
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

	public JLabel getCountryLabel() {
		return countryLabel;
	}

	public void setCountryLabel(JLabel countryLabel) {
		this.countryLabel = countryLabel;
	}

	public JLabel getCityLabel() {
		return cityLabel;
	}

	public void setCityLabel(JLabel cityLabel) {
		this.cityLabel = cityLabel;
	}

	public JLabel getRoleLabel() {
		return roleLabel;
	}

	public void setRoleLabel(JLabel roleLabel) {
		this.roleLabel = roleLabel;
	}

	public JLabel getDateBirthDateLabel() {
		return dateBirthDateLabel;
	}

	public void setDateBirthDateLabel(JLabel dateBirthDateLabel) {
		this.dateBirthDateLabel = dateBirthDateLabel;
	}

	public JLabel getFormTitleLabel() {
		return formTitleLabel;
	}

	public void setFormTitleLabel(JLabel formTitleLabel) {
		this.formTitleLabel = formTitleLabel;
	}

	public JTextField getIdTextField() {
		return idTextField;
	}

	public void setIdTextField(JTextField idTextField) {
		this.idTextField = idTextField;
	}

	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public void setFirstNameTextField(JTextField firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}

	public void setLastNameTextField(JTextField lastNameTextField) {
		this.lastNameTextField = lastNameTextField;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(JTextField emailTextField) {
		this.emailTextField = emailTextField;
	}

	public JTextField getDateBirthDateTextField() {
		return dateBirthDateTextField;
	}

	public void setDateBirthDateTextField(JTextField dateBirthDateTextField) {
		this.dateBirthDateTextField = dateBirthDateTextField;
	}

	public JPasswordField getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(JPasswordField passwordTextField) {
		this.passwordTextField = passwordTextField;
	}

	public JTextField getCountryTextField() {
		return countryTextField;
	}

	public void setCountryTextField(JTextField countryTextField) {
		this.countryTextField = countryTextField;
	}

	public JTextField getCityTextField() {
		return cityTextField;
	}

	public void setCityTextField(JTextField cityTextField) {
		this.cityTextField = cityTextField;
	}

	public JComboBox<String> getRoleComboBox() {
		return roleComboBox;
	}

	public void setRoleComboBox(JComboBox<String> roleComboBox) {
		this.roleComboBox = roleComboBox;
	}

}
