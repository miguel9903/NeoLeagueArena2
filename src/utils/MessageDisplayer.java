package utils;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MessageDisplayer {
	
	// INFO messages
	public static void showInfoMessage(String message) {
		showInfoMessage(null, message, "Information");
	}

	public static void showInfoMessage(String message, String title) {
		showInfoMessage(null, message, title);
	}

	public static void showInfoMessage(Component parent, String message) {
		showInfoMessage(parent, message, "Information");
	}

	public static void showInfoMessage(Component parent, String message, String title) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	// SUCCESS messages
	public static void showSuccessMessage(String message) {
		showSuccessMessage(null, message, "Success");
	}

	public static void showSuccessMessage(String message, String title) {
		showSuccessMessage(null, message, title);
	}

	public static void showSuccessMessage(Component parent, String message) {
		showSuccessMessage(parent, message, "Success");
	}

	public static void showSuccessMessage(Component parent, String message, String title) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	// ERROR messages
	public static void showErrorMessage(String message) {
		showErrorMessage(null, message, "Error");
	}

	public static void showErrorMessage(String message, String title) {
		showErrorMessage(null, message, title);
	}

	public static void showErrorMessage(Component parent, String message) {
		showErrorMessage(parent, message, "Error");
	}

	public static void showErrorMessage(Component parent, String message, String title) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
	}

	// WARNING messages
	public static void showWarningMessage(String message) {
		showWarningMessage(null, message, "Warning");
	}

	public static void showWarningMessage(String message, String title) {
		showWarningMessage(null, message, title);
	}

	public static void showWarningMessage(Component parent, String message) {
		showWarningMessage(parent, message, "Warning");
	}

	public static void showWarningMessage(Component parent, String message, String title) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
	}

	// CONFIRMATION messages
	public static boolean showConfirmationMessage(String message) {
		return showConfirmationMessage(null, message, "Confirmation");
	}

	public static boolean showConfirmationMessage(String message, String title) {
		return showConfirmationMessage(null, message, title);
	}

	public static boolean showConfirmationMessage(Component parent, String message) {
		return showConfirmationMessage(parent, message, "Confirmation");
	}

	public static boolean showConfirmationMessage(Component parent, String message, String title) {
		int option = JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		return option == JOptionPane.YES_OPTION;
	}
}
