package view.modules.player;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import view.shared.BaseUserFormFieldsPanel;

public class PlayerFormFieldsPanel extends BaseUserFormFieldsPanel {

    private JLabel nickNameLabel;
    private JLabel teamLabel;
    private JLabel experienceLevelLabel;
    private JTextField nickNameTextField;
    private JComboBox<String> teamComboBox;
    private JSpinner experienceLevelSpinner;

    @Override
    public void initializeComponents() {
    	super.initializeComponents(); 
    	
    	removeRoleComboBox(); 
    	// getIdTextField().setEditable(false);
    	// getIdTextField().setEnabled(false);
    	
        nickNameLabel = new JLabel("Nickname:");
        nickNameTextField = new JTextField();
        add(nickNameLabel);
        add(nickNameTextField);

        teamLabel = new JLabel("Team:");
        String[] teamNames = {"Team A", "Team B", "Team C"};
        teamComboBox = new JComboBox<>(teamNames);
        
        experienceLevelLabel = new JLabel("Experience Level:");
        experienceLevelSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        add(experienceLevelLabel);
        add(experienceLevelSpinner);
    }

    public JTextField getNickNameTextField() {
        return nickNameTextField;
    }

    public void setNickNameTextField(JTextField nickNameTextField) {
        this.nickNameTextField = nickNameTextField;
    }

    public JComboBox<String> getTeamComboBox() {
        return teamComboBox;
    }

    public void setTeamComboBox(JComboBox<String> teamComboBox) {
        this.teamComboBox = teamComboBox;
    }

    public JSpinner getExperienceLevelSpinner() {
        return experienceLevelSpinner;
    }

    public void setExperienceLevelSpinner(JSpinner experienceLevelSpinner) {
        this.experienceLevelSpinner = experienceLevelSpinner;
    }
}
