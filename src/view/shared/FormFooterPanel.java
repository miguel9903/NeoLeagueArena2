package view.shared;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FormFooterPanel extends JPanel {

	private JButton primaryButton;
	private JButton secondaryButton;
	private JButton tertiaryButton;
	private JButton quaternaryButton;
	
	public FormFooterPanel() {
		setLayout(new FlowLayout());
		initializeComponents();
	}

	public void initializeComponents() {
		primaryButton = new JButton("PRIMARY");
		primaryButton.setActionCommand("PRIMARY_BUTTON");
		add(primaryButton);

		secondaryButton = new JButton("SECONDARY");
		secondaryButton.setActionCommand("SECONDARY_BUTTON");
		add(secondaryButton);
		
		tertiaryButton = new JButton("TERTIARY");
		tertiaryButton.setActionCommand("TERTIARY_BUTTON");
		add(tertiaryButton);
		
		quaternaryButton = new JButton("QUATERNARY");
		quaternaryButton.setActionCommand("QUATERNARY_BUTTON");
		add(quaternaryButton);
	}

	public void removePrimaryButton() {
		remove(primaryButton);
		revalidate();
		repaint();
	}

	public void removeSecondaryButton() {
		remove(secondaryButton);
		revalidate();
		repaint();
	}

	public void removeTertiaryButton() {
		remove(tertiaryButton);
		revalidate();
		repaint();
	}
	
	public void removeQuaternaryButton() {
		remove(quaternaryButton);
		revalidate();
		repaint();
	}

	public void setPrimaryButtonActionCommand(String command) {
		primaryButton.setActionCommand(command);
	}

	public void setPrimaryButtonText(String text) {
		primaryButton.setText(text);
	}

	public void setSecondaryButtonActionCommand(String command) {
		secondaryButton.setActionCommand(command);
	}

	public void setSecondaryButtonText(String text) {
		secondaryButton.setText(text);
	}

	public void setTertiaryButtonActionCommand(String command) {
		tertiaryButton.setActionCommand(command);
	}

	public void setTertiaryButtonText(String text) {
		tertiaryButton.setText(text);
	}
	
	public void setQuaternaryButtonActionCommand(String command) {
		quaternaryButton.setActionCommand(command);
	}

	public void setQuaternaryButtonText(String text) {
		quaternaryButton.setText(text);
	}

	public JButton getPrimaryButton() {
		return primaryButton;
	}

	public void setPrimaryButton(JButton primaryButton) {
		this.primaryButton = primaryButton;
	}

	public JButton getSecondaryButton() {
		return secondaryButton;
	}

	public void setSecondaryButton(JButton secondaryButton) {
		this.secondaryButton = secondaryButton;
	}
	
	public JButton getTertiaryButton() {
		return tertiaryButton;
	}

	public void setTertiaryButton(JButton tertiaryButton) {
		this.tertiaryButton = tertiaryButton;
	}

	public JButton getQuaternaryButton() {
		return quaternaryButton;
	}

	public void setQuaternaryButton(JButton quaternaryButton) {
		this.quaternaryButton = quaternaryButton;
	}
}
