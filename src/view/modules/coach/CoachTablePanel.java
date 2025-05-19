package view.modules.coach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.CoachDTO;
import view.shared.FormHeaderPanel;

public class CoachTablePanel extends JPanel {

    private JTable coachesTable;
    private DefaultTableModel tableModel;
    private FormHeaderPanel formHeaderPanel;

    public CoachTablePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initializeComponents();
        setupFormControls();
    }

    private void initializeComponents() {
        formHeaderPanel = new FormHeaderPanel();
        formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        String[] columns = {
            "ID", "Name", "Last Name", "Email", "Country",
            "City", "Role", "Team"
        };

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        coachesTable = new JTable(tableModel);
        coachesTable.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(coachesTable);

        add(formHeaderPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void setupFormControls() {
        formHeaderPanel.getFormTitleLabel().setText("List Coaches");
    }

    public void loadTableData(List<CoachDTO> coachDTOs) {
        tableModel.setRowCount(0);

        for (CoachDTO coachDTO : coachDTOs) {
            Object[] rowData = {
                coachDTO.getId(),
                coachDTO.getFirstName(),
                coachDTO.getLastName(),
                coachDTO.getEmail(),
                coachDTO.getCountry(),
                coachDTO.getCity(),
                coachDTO.getRole(),
                coachDTO.getTeamIds().toString()
            };

            tableModel.addRow(rowData);
        }
    }
}
