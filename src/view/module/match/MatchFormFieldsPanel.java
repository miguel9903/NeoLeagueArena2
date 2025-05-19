package view.module.match;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.persistence.dto.CoachDTO;

import javax.swing.JScrollPane;

public class MatchFormFieldsPanel extends JPanel {

	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JLabel logoLabel;
	private JLabel scoreLabel;
	private JLabel rankingLabel;
	private JLabel coachLabel;
	private JLabel playersLabel;

	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextArea descriptionTextArea;
	private JTextField logoTextField;
	private JTextField scoreTextField;
	private JTextField rankingTextField;

	private JComboBox<String> coachComboBox;
	private JComboBox<String> playersComboBox;

	public MatchFormFieldsPanel() {
		setLayout(new GridLayout(7, 2, 10, 10));
		initializeComponents();
	}

	public void initializeComponents() {
		idLabel = new JLabel("ID* :");
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setEnabled(false);
		add(idLabel);
		add(idTextField);

		nameLabel = new JLabel("Name* :");
		nameTextField = new JTextField();
		add(nameLabel);
		add(nameTextField);

		descriptionLabel = new JLabel("Description* :");
		descriptionTextArea = new JTextArea();

		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
		scrollPane.setPreferredSize(new Dimension(200, 100));
		add(descriptionLabel);
		add(scrollPane);

		logoLabel = new JLabel("Logo URL/Path:");
		logoTextField = new JTextField();
		add(logoLabel);
		add(logoTextField);

		scoreLabel = new JLabel("Score:");
		scoreTextField = new JTextField();
		add(scoreLabel);
		add(scoreTextField);

		rankingLabel = new JLabel("Ranking:");
		rankingTextField = new JTextField();
		add(rankingLabel);
		add(rankingTextField);

		coachLabel = new JLabel("Coach:");
		coachComboBox = new JComboBox<>(new String[]{"Coach 1", "Coach 2", "Coach 3"});
		add(coachLabel);
		add(coachComboBox);

		playersLabel = new JLabel("Players:");
		playersComboBox = new JComboBox<>(new String[]{"Player 1", "Player 2", "Player 3"});
		// add(playersLabel);
		// add(playersComboBox);
	}

	public void setCoachesComboBox(List<CoachDTO> coachList) {
		coachComboBox.removeAllItems(); 

		for (CoachDTO coachDTO : coachList) {
			String coachName = coachDTO.getId() + " - " + coachDTO.getFirstName() + " " + coachDTO.getLastName();
			coachComboBox.addItem(coachName);
		}
	}

	public void resetFields() {
		idTextField.setText("");
		nameTextField.setText("");
		descriptionTextArea.setText("");
		logoTextField.setText("");
		scoreTextField.setText("");
		rankingTextField.setText("");
		coachComboBox.setSelectedIndex(0);
		playersComboBox.setSelectedIndex(0);
	}

	public Integer getCoachComboBoxValue() {
		String coachText = (String) coachComboBox.getSelectedItem();
		return (coachText != null && !coachText.isEmpty() && coachText.contains("-")) 
				? Integer.parseInt(coachText.substring(0, coachText.indexOf(" -"))) 
						: null;
	}

	public JTextField getIdTextField() {
		return idTextField;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public JTextArea getDescriptionTextArea() {
		return descriptionTextArea;
	}

	public JTextField getLogoTextField() {
		return logoTextField;
	}

	public JTextField getScoreTextField() {
		return scoreTextField;
	}

	public JTextField getRankingTextField() {
		return rankingTextField;
	}

	public JComboBox<String> getCoachComboBox() {
		return coachComboBox;
	}

	public JComboBox<String> getPlayersComboBox() {
		return playersComboBox;
	}
}
