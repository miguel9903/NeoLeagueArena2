package view;

import java.awt.Component;
import utils.MessageDisplayer;
import view.modules.login.LoginWindow;
import view.modules.signup.RegisterWindow;
import view.windows.MainWindow;

public class View {
	
	private LoginWindow loginWindow;
	private RegisterWindow registerWindow;
	private MainWindow mainWindow;
	
	public View() {
		loginWindow = new LoginWindow();
		registerWindow = new RegisterWindow();
		mainWindow = new MainWindow();
	}
	
	public void showErrorMessage(Component parent, String message) {
	    MessageDisplayer.showErrorMessage(parent, message, "Error");
	}

	public void showErrorMessage(String message) {
	    showErrorMessage(mainWindow, message);
	}

	public void showInfoMessage(Component parent, String message) {
	    MessageDisplayer.showInfoMessage(parent, message, "Information");
	}

	public void showInfoMessage(String message) {
	    showInfoMessage(mainWindow, message);
	}
	
	public LoginWindow getLoginWindow() {
		return loginWindow;
	}
	
	public void setLoginWindow(LoginWindow loginWindow) {
		this.loginWindow = loginWindow;
	}
	
	public RegisterWindow getRegisterWindow() {
		return registerWindow;
	}
	
	public void setRegisterWindow(RegisterWindow registerWindow) {
		this.registerWindow = registerWindow;
	}
	
	public MainWindow getMainWindow() {
		return mainWindow;
	}
	
	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
}
