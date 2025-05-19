package view.module.tournament;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.enums.GamePlatform;
import model.enums.TournamentPhase;

public class TournamentFormFieldsPanel extends JPanel {

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel platformLabel;
    private JLabel gameLabel;
    private JLabel phaseLabel;

    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextArea descriptionTextArea;

    private JComboBox<String> platformComboBox;
    private JComboBox<String> gameComboBox;
    private JComboBox<String> phaseComboBox;

    public TournamentFormFieldsPanel() {
        setLayout(new GridLayout(6, 2, 10, 10));
        initializeComponents();
    }

    public void initializeComponents() {
        idLabel = new JLabel("ID* :");
        idTextField = new JTextField();
        // idTextField.setEditable(false);
        // idTextField.setEnabled(false);
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

        platformLabel = new JLabel("Platform* :");
        platformComboBox = new JComboBox<>(new String[] { "PC", "Console", "Mobile" });
        add(platformLabel);
        add(platformComboBox);

        gameLabel = new JLabel("Game* :");
        gameComboBox = new JComboBox<>(new String[] { "Game 1", "Game 2", "Game 3" });
        add(gameLabel);
        add(gameComboBox);

        phaseLabel = new JLabel("Phase* :");
        phaseComboBox = new JComboBox<>(new String[] { "Group Stage", "Quarterfinal", "Semifinal", "Final" });
        add(phaseLabel);
        add(phaseComboBox);
    }
    
    public void loadPhaseComboBox(List<TournamentPhase> phases) {
        phaseComboBox.removeAllItems();
        
        for (TournamentPhase phase : phases) {
            phaseComboBox.addItem(phase.getDisplayName());
        }
    }

    public void loadPlatformComboBox(List<GamePlatform> platforms) {
        platformComboBox.removeAllItems();
        
        for (GamePlatform platform : platforms) {
            platformComboBox.addItem(platform.getDisplayName());
        }
    }

    public void loadGameComboBox() {
        gameComboBox.removeAllItems();
        gameComboBox.addItem("League of Legends");
        gameComboBox.addItem("Dota 2");
        gameComboBox.addItem("Counter-Strike: Global Offensive");
        gameComboBox.addItem("Valorant");
        gameComboBox.addItem("Overwatch 2");
        gameComboBox.addItem("Fortnite");
        gameComboBox.addItem("Call of Duty: Warzone");
        gameComboBox.addItem("Apex Legends");
        gameComboBox.addItem("PUBG: Battlegrounds");
        gameComboBox.addItem("Rainbow Six Siege");
        gameComboBox.addItem("Rocket League");
        gameComboBox.addItem("Street Fighter VI");
        gameComboBox.addItem("Tekken 8");
        gameComboBox.addItem("StarCraft II");
        gameComboBox.addItem("Hearthstone");
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public JLabel getPlatformLabel() {
        return platformLabel;
    }

    public JComboBox<String> getPlatformComboBox() {
        return platformComboBox;
    }

    public JLabel getGameLabel() {
        return gameLabel;
    }

    public JComboBox<String> getGameComboBox() {
        return gameComboBox;
    }

    public JLabel getPhaseLabel() {
        return phaseLabel;
    }

    public JComboBox<String> getPhaseComboBox() {
        return phaseComboBox;
    }

    public void resetFields() {
        idTextField.setText("");
        nameTextField.setText("");
        descriptionTextArea.setText("");
        platformComboBox.setSelectedIndex(0);
        gameComboBox.setSelectedIndex(0);
        phaseComboBox.setSelectedIndex(0);
    }
}
