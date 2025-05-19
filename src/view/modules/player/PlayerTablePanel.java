package view.modules.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.persistence.dto.PlayerDTO;
import view.shared.FormHeaderPanel;

public class PlayerTablePanel extends JPanel {

    private JTable playersTable;
    private DefaultTableModel tableModel;
    private FormHeaderPanel formHeaderPanel;

    public PlayerTablePanel() {
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
            "City", "Role", "Nickname", "Team", "Experience"
        };

        tableModel = new DefaultTableModel(columns, 0) {
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

    private void setupFormControls() {
        formHeaderPanel.getFormTitleLabel().setText("List Players");
    }

    public void loadTableData(List<PlayerDTO> playerDTOs) {
        tableModel.setRowCount(0);

        for (PlayerDTO playerDTO : playerDTOs) {
            Object[] rowData = {
                playerDTO.getId(),
                playerDTO.getFirstName(),
                playerDTO.getLastName(),
                playerDTO.getEmail(),
                playerDTO.getCountry(),
                playerDTO.getCity(),
                playerDTO.getRole(),
                playerDTO.getNickName(),
                playerDTO.getCurrentTeamName(),
                playerDTO.getExperienceLevel()
            };

            tableModel.addRow(rowData);
        }

    }
}
