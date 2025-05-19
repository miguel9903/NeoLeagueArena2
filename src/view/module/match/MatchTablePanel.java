/**
 * La clase MatchTablePanel representa un panel que muestra una tabla de jugadores.
 * Incluye un encabezado y una tabla con datos de ejemplo de jugadores.
 */
package view.module.match;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import view.shared.FormHeaderPanel;

/**
 * La clase MatchTablePanel representa un panel que muestra una tabla de jugadores.
 * Incluye un encabezado y una tabla con datos de ejemplo de jugadores.
 */
public class MatchTablePanel extends JPanel {

    /** Tabla para mostrar los datos de los jugadores. */
    private JTable playersTable;

    /** Modelo de tabla para gestionar los datos de la tabla. */
    private DefaultTableModel tableModel;

    /** Panel de encabezado del formulario. */
    private FormHeaderPanel formHeaderPanel;

    /**
     * Construye un nuevo MatchTablePanel e inicializa sus componentes.
     */
    public MatchTablePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initializeComponents();
        setupFormControls();
    }

    /**
     * Inicializa los componentes del panel, incluyendo el encabezado y la tabla de jugadores.
     */
    public void initializeComponents() {
        formHeaderPanel = new FormHeaderPanel();
        formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        String[] columns = {
            "ID", "Nombre", "Apellido", "Email", "País",
            "Ciudad", "Rol", "Apodo", "Equipo", "Experiencia"
        };

        String[][] exampleData = {
            {"101", "Juan", "Pérez", "juan@correo.com", "Colombia", "Bogotá", "Jugador", "ShadowX", "Equipo A", "3"},
            {"102", "Ana", "López", "ana@correo.com", "México", "CDMX", "Administrador", "An4Play", "Equipo B", "5"},
            {"103", "Luis", "Gómez", "luis@correo.com", "Perú", "Lima", "Jugador", "LGkiller", "Equipo A", "2"}
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

    /**
     * Configura los controles del formulario, incluyendo el título del encabezado.
     */
    public void setupFormControls() {
        formHeaderPanel.getFormTitleLabel().setText("Listar Equipos");
    }
}
