/**
 * La clase TeamManagementPanel representa un panel que gestiona la visualización y manipulación
 * de equipos a través de diferentes pestañas. Incluye pestañas para gestionar equipos,
 * asignar jugadores a equipos y listar equipos.
 */
package view.module.team;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.util.Colors;

/**
 * La clase TeamManagementPanel representa un panel que gestiona la visualización y manipulación
 * de equipos a través de diferentes pestañas. Incluye pestañas para gestionar equipos,
 * asignar jugadores a equipos y listar equipos.
 */
public class TeamManagementPanel extends JPanel {

    /** Panel de pestañas para gestionar diferentes vistas. */
    private JTabbedPane tabs;

    /** Panel para gestionar equipos. */
    private TeamFormPanel teamFormPanel;

    /** Panel para asignar jugadores a equipos. */
    private TeamPlayerAssignmentPanel teamPlayerAssignmentPanel;

    /** Panel para listar equipos. */
    private TeamTablePanel teamTablePanel;

    /**
     * Construye un nuevo TeamManagementPanel e inicializa sus componentes.
     */
    public TeamManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    /**
     * Inicializa los componentes del panel, incluyendo las pestañas para gestionar equipos,
     * asignar jugadores y listar equipos.
     */
    private void initializeComponents() {
        tabs = new JTabbedPane();

        teamFormPanel = new TeamFormPanel();
        teamFormPanel.setPreferredSize(new Dimension(550, 500));
        tabs.addTab("Gestionar Equipos", teamFormPanel);

        teamPlayerAssignmentPanel = new TeamPlayerAssignmentPanel();
        teamPlayerAssignmentPanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("Asignar Jugadores", teamPlayerAssignmentPanel);

        teamTablePanel = new TeamTablePanel();
        teamTablePanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("Listar Equipos", teamTablePanel);

        add(tabs);
    }

    /**
     * Obtiene el panel de pestañas.
     *
     * @return el panel de pestañas
     */
    public JTabbedPane getTabs() {
        return tabs;
    }

    /**
     * Establece el panel de pestañas.
     *
     * @param tabs el panel de pestañas a establecer
     */
    public void setTabs(JTabbedPane tabs) {
        this.tabs = tabs;
    }

    /**
     * Obtiene el panel para gestionar equipos.
     *
     * @return el panel para gestionar equipos
     */
    public TeamFormPanel getTeamFormPanel() {
        return teamFormPanel;
    }

    /**
     * Establece el panel para gestionar equipos.
     *
     * @param teamFormPanel el panel para gestionar equipos a establecer
     */
    public void setTeamFormPanel(TeamFormPanel teamFormPanel) {
        this.teamFormPanel = teamFormPanel;
    }

    /**
     * Obtiene el panel para asignar jugadores a equipos.
     *
     * @return el panel para asignar jugadores a equipos
     */
    public TeamPlayerAssignmentPanel getTeamPlayerAssignmentPanel() {
        return teamPlayerAssignmentPanel;
    }

    /**
     * Establece el panel para asignar jugadores a equipos.
     *
     * @param teamPlayerAssignmentPanel el panel para asignar jugadores a equipos a establecer
     */
    public void setTeamPlayerAssignmentPanel(TeamPlayerAssignmentPanel teamPlayerAssignmentPanel) {
        this.teamPlayerAssignmentPanel = teamPlayerAssignmentPanel;
    }

    /**
     * Obtiene el panel para listar equipos.
     *
     * @return el panel para listar equipos
     */
    public TeamTablePanel getTeamTablePanel() {
        return teamTablePanel;
    }

    /**
     * Establece el panel para listar equipos.
     *
     * @param teamTablePanel el panel para listar equipos a establecer
     */
    public void setTeamTablePanel(TeamTablePanel teamTablePanel) {
        this.teamTablePanel = teamTablePanel;
    }
}
