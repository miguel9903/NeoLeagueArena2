package view.shared;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.util.Colors;

public class FormHeaderPanel extends JPanel {

	private JPanel searchPanel;

	private JLabel formTitleLabel;
	private JLabel searchLabel;
	private JTextField searchTextField;
	private JButton searchButton;

	public FormHeaderPanel() {
		setLayout(new BorderLayout());
		initilalizeComponents();
	}

	public void initilalizeComponents() {
		formTitleLabel = new JLabel("Form title");
		formTitleLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		formTitleLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
		formTitleLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		searchPanel = new JPanel();
		searchPanel.setLayout(new FlowLayout());
		
		searchLabel = new JLabel("ID: ");
		searchPanel.add(searchLabel);

		searchTextField = new JTextField(15);
		searchPanel.add(searchTextField);

		searchButton = new JButton("Buscar");
		searchButton.setActionCommand("SEARCH_BUTTON");
		searchPanel.add(searchButton);
		
		add(formTitleLabel, BorderLayout.NORTH);
		add(searchPanel, BorderLayout.CENTER);
	}
	
	public void removeSearchPanel() {
	    if (searchPanel != null) {
	        remove(searchPanel);
	        searchPanel = null;
	        revalidate();
	        repaint();
	    }
	}

	public void resetFields() {
		searchTextField.setText("");
	}
	
	public void setSearchButtonActionCommand(String command) {
		searchButton.setActionCommand(command);
	}

	public void setSearchButtonText(String text) {
		searchButton.setText(text);	
	}
	
	public JPanel getSearchPanel() {
		return searchPanel;
	}

	public void setSearchPanel(JPanel searchPanel) {
		this.searchPanel = searchPanel;
	}

	public JLabel getFormTitleLabel() {
		return formTitleLabel;
	}

	public void setFormTitleLabel(JLabel formTitleLabel) {
		this.formTitleLabel = formTitleLabel;
	}

	public JLabel getSearchLabel() {
		return searchLabel;
	}

	public void setSearchLabel(JLabel searchLabel) {
		this.searchLabel = searchLabel;
	}

	public JTextField getSearchTextField() {
		return searchTextField;
	}

	public void setSearchTextField(JTextField searchTextField) {
		this.searchTextField = searchTextField;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}
}
