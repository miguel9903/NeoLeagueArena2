package view.modules.signup;

import javax.swing.DefaultComboBoxModel;

import model.enums.UserRole;
import view.shared.BaseUserFormFieldsPanel;

public class RegisterFieldsPanel extends BaseUserFormFieldsPanel {
	
	public RegisterFieldsPanel() { }
	
    @Override
    public void initializeComponents() {
        super.initializeComponents();
        loadUserRolesComboBox();
    }
    
    public void loadUserRolesComboBox() {
		String[] userRoles = new String[]{
				UserRole.PLAYER.getDisplayName(), 
				UserRole.COACH.getDisplayName()};
		
        getRoleComboBox().setModel(new DefaultComboBoxModel<>(userRoles));
    }
}
