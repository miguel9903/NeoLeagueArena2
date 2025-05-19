package view.module.team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.TeamDTO;
import view.shared.FormHeaderPanel;

public class TeamTablePanel extends JPanel {

    private JTable teamsTable;
    private DefaultTableModel tableModel;
    private FormHeaderPanel formHeaderPanel;

    public TeamTablePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initializeComponents();
        setupFormControls();
    }

    private void initializeComponents() {
        formHeaderPanel = new FormHeaderPanel();
        formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        String[] columns = {
            "ID", "Name", "Score", "Ranking", "Coach Name"
        };

        tableModel = new DefaultTableModel(columns, 0);

        teamsTable = new JTable(tableModel);
        teamsTable.setFillsViewportHeight(true);
        teamsTable.setDefaultEditor(Object.class, null); 

        JScrollPane scrollPane = new JScrollPane(teamsTable);

        add(formHeaderPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void setupFormControls() {
        formHeaderPanel.getFormTitleLabel().setText("List Teams");
    }

    public void loadTableData(List<TeamDTO> teamDTOs) {
        tableModel.setRowCount(0); 

        for (TeamDTO teamDTO : teamDTOs) {
            Object[] rowData = {
                teamDTO.getId(),
                teamDTO.getName(),
                teamDTO.getScore(),
                teamDTO.getRanking(),
                teamDTO.getCoachName()
            };
            
            tableModel.addRow(rowData);
        }
    }
}
