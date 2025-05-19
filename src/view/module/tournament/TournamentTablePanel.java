package view.module.tournament;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.TournamentDTO;
import view.shared.FormHeaderPanel;

public class TournamentTablePanel extends JPanel {

    private JTable tournamentTable;
    private DefaultTableModel tableModel;
    private FormHeaderPanel formHeaderPanel;

    public TournamentTablePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initializeComponents();
        setupFormControls();
    }

    private void initializeComponents() {
        formHeaderPanel = new FormHeaderPanel();
        formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        String[] columns = {
            "ID", "Name", "Platform", "Game", "Phase"
        };

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        tournamentTable = new JTable(tableModel);
        tournamentTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tournamentTable);

        add(formHeaderPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void setupFormControls() {
        formHeaderPanel.getFormTitleLabel().setText("List Tournaments");
    }

    public void loadTableData(List<TournamentDTO> tournamentDTOs) {
        tableModel.setRowCount(0); 

        for (TournamentDTO dto : tournamentDTOs) {
            Object[] rowData = {
                dto.getId(),
                dto.getName(),
                dto.getPlatform(),
                dto.getGame(),
                dto.getPhase()
            };

            tableModel.addRow(rowData);
        }
    }
}
