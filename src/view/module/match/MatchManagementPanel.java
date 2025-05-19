/**
 * La clase MatchManagementPanel representa un panel que gestiona la visualización y manipulación
 * de partidos a través de diferentes pestañas. Incluye pestañas para gestionar partidos,
 * asignar jugadores a equipos y listar partidos.
 */
package view.module.match;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import utils.Colors;

/**
 * La clase MatchManagementPanel representa un panel que gestiona la visualización y manipulación
 * de partidos a través de diferentes pestañas. Incluye pestañas para gestionar partidos,
 * asignar jugadores a equipos y listar partidos.
 */
public class MatchManagementPanel extends JPanel {

    /** Panel de pestañas para gestionar diferentes vistas. */
    private JTabbedPane tabs;

    /** Panel para gestionar partidos. */
    private MatchFormPanel matchFormPanel;

    /** Panel para asignar jugadores a equipos. */
    private TeamPlayerAssignmentPanel teamPlayerAssignmentPanel;

    /** Panel para listar partidos. */
    private MatchTablePanel matchTablePanel;

    /**
     * Construye un nuevo MatchManagementPanel e inicializa sus componentes.
     */
    public MatchManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    /**
     * Inicializa los componentes del panel, incluyendo las pestañas para gestionar partidos,
     * asignar jugadores y listar partidos.
     */
    private void initializeComponents() {
        tabs = new JTabbedPane();

        matchFormPanel = new MatchFormPanel();
        matchFormPanel.setPreferredSize(new Dimension(550, 500));
        tabs.addTab("Gestionar Partidos", matchFormPanel);

        teamPlayerAssignmentPanel = new TeamPlayerAssignmentPanel();
        teamPlayerAssignmentPanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("Asignar Jugadores", teamPlayerAssignmentPanel);

        matchTablePanel = new MatchTablePanel();
        matchTablePanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("Listar Partidos", matchTablePanel);

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
     * Obtiene el panel para gestionar partidos.
     *
     * @return el panel para gestionar partidos
     */
    public MatchFormPanel getMatchFormPanel() {
        return matchFormPanel;
    }

    /**
     * Establece el panel para gestionar partidos.
     *
     * @param matchFormPanel el panel para gestionar partidos a establecer
     */
    public void setMatchFormPanel(MatchFormPanel matchFormPanel) {
        this.matchFormPanel = matchFormPanel;
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
     * Obtiene el panel para listar partidos.
     *
     * @return el panel para listar partidos
     */
    public MatchTablePanel getMatchTablePanel() {
        return matchTablePanel;
    }

    /**
     * Establece el panel para listar partidos.
     *
     * @param matchTablePanel el panel para listar partidos a establecer
     */
    public void setMatchTablePanel(MatchTablePanel matchTablePanel) {
        this.matchTablePanel = matchTablePanel;
    }
}
