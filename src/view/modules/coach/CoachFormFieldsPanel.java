package view.modules.coach;

import javax.swing.JLabel;
import view.shared.BaseUserFormFieldsPanel;

public class CoachFormFieldsPanel extends BaseUserFormFieldsPanel {

    @Override
    public void initializeComponents() {
        super.initializeComponents();

    	removeRoleComboBox(); 
        // getIdTextField().setEditable(false);
        // getIdTextField().setEnabled(false);
    }
}
