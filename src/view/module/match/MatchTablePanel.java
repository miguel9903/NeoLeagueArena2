package view.module.match;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import view.shared.FormHeaderPanel;

public class MatchTablePanel extends JPanel {
	
    private JTable playersTable;
    private DefaultTableModel tableModel;
	private FormHeaderPanel formHeaderPanel;

    public MatchTablePanel() {
    	setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		initializeComponents();
		setupFormControls();
    }
    
    public void initializeComponents() {
		formHeaderPanel = new FormHeaderPanel();
		formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
    	
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        String[] columns = {
            "ID", "Name", "Last Name", "Email", "Country",
            "City", "Role", "Nickname", "Team", "Experience"
        };

        String[][] exampleData = {
            {"101", "Juan", "Pérez", "juan@correo.com", "Colombia", "Bogotá", "Player", "ShadowX", "Team A", "3"},
            {"102", "Ana", "López", "ana@correo.com", "México", "CDMX", "Administrator", "An4Play", "Team B", "5"},
            {"103", "Luis", "Gómez", "luis@correo.com", "Perú", "Lima", "Player", "LGkiller", "Team A", "2"}
        };

        tableModel = new DefaultTableModel(exampleData, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Celdas no editables
            }
        };

        playersTable = new JTable(tableModel);
        playersTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(playersTable);

        add(formHeaderPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    public void setupFormControls() {
		formHeaderPanel.getFormTitleLabel().setText("List Teams");
	}
}
