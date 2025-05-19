/**
 * La clase TeamTablePanel representa un panel que muestra una tabla de equipos.
 * Incluye un encabezado y una tabla con datos de equipos.
 */
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

/**
 * La clase TeamTablePanel representa un panel que muestra una tabla de equipos.
 * Incluye un encabezado y una tabla con datos de equipos.
 */
public class TeamTablePanel extends JPanel {

    /** Tabla para mostrar los datos de los equipos. */
    private JTable teamsTable;

    /** Modelo de tabla para gestionar los datos de la tabla. */
    private DefaultTableModel tableModel;

    /** Panel de encabezado del formulario. */
    private FormHeaderPanel formHeaderPanel;

    /**
     * Construye un nuevo TeamTablePanel e inicializa sus componentes.
     */
    public TeamTablePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initializeComponents();
        setupFormControls();
    }

    /**
     * Inicializa los componentes del panel, incluyendo el encabezado y la tabla de equipos.
     */
    private void initializeComponents() {
        formHeaderPanel = new FormHeaderPanel();
        formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        String[] columns = {
            "ID", "Nombre", "Puntuación", "Ranking", "Nombre del Entrenador"
        };

        tableModel = new DefaultTableModel(columns, 0);

        teamsTable = new JTable(tableModel);
        teamsTable.setFillsViewportHeight(true);
        teamsTable.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(teamsTable);

        add(formHeaderPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Configura los controles del formulario, incluyendo el título del encabezado.
     */
    private void setupFormControls() {
        formHeaderPanel.getFormTitleLabel().setText("Listar Equipos");
    }

    /**
     * Carga los datos de la tabla a partir de una lista de DTOs de equipos.
     *
     * @param teamDTOs la lista de DTOs de equipos
     */
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
