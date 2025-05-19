package view.module.tournament;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.util.Colors;
import view.module.team.TeamFormPanel;
import view.module.team.TeamPlayerAssignmentPanel;

/**
 * Panel de gestión de torneos.
 * Contiene pestañas para administrar torneos, asignar partidos y ver el listado de torneos.
 */
public class TournamentManagementPanel extends JPanel {

    private JTabbedPane tabs;
    private TournamentFormPanel tournamentFormPanel;
    private TournamentMatchAssignmentPanel tournamentMatchAssignmentPanel;
    private TournamentTablePanel tournamentTablePanel;
    
    /**
     * Constructor que configura el diseño del panel y su apariencia inicial.
     */
    public TournamentManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    /**
     * Inicializa los componentes internos del panel.
     * Crea las pestañas y les asigna los subpaneles correspondientes.
     */
    private void initializeComponents() {
        tabs = new JTabbedPane();

        tournamentFormPanel = new TournamentFormPanel();
        tournamentFormPanel.setPreferredSize(new Dimension(550, 560));
        tabs.addTab("Manage Tournaments", tournamentFormPanel);

        tournamentMatchAssignmentPanel = new TournamentMatchAssignmentPanel();
        tournamentMatchAssignmentPanel.setPreferredSize(new Dimension(500, 560));
        tabs.addTab("Managa Matches", tournamentMatchAssignmentPanel);
        
        tournamentTablePanel = new TournamentTablePanel();
        tournamentTablePanel.setPreferredSize(new Dimension(500, 560));
        tabs.addTab("List Tournaments", tournamentTablePanel);
        
        add(tabs);
    }

    /**
     * Retorna el componente de pestañas.
     * @return JTabbedPane con los paneles de gestión
     */
    public JTabbedPane getTabs() {
        return tabs;
    }

    /**
     * Establece el componente de pestañas.
     * @param tabs nuevo JTabbedPane
     */
    public void setTabs(JTabbedPane tabs) {
        this.tabs = tabs;
    }

    /**
     * Retorna el panel de formulario de torneo.
     * @return TournamentFormPanel
     */
    public TournamentFormPanel getTournamentFormPanel() {
        return tournamentFormPanel;
    }

    /**
     * Establece el panel de formulario de torneo.
     * @param tournamentFormPanel nuevo panel de formulario
     */
    public void setTournamentFormPanel(TournamentFormPanel tournamentFormPanel) {
        this.tournamentFormPanel = tournamentFormPanel;
    }

    /**
     * Retorna el panel de asignación de partidos de torneo.
     * @return TournamentMatchAssignmentPanel
     */
    public TournamentMatchAssignmentPanel getTournamentMatchAssignmentPanel() {
        return tournamentMatchAssignmentPanel;
    }

    /**
     * Establece el panel de asignación de partidos de torneo.
     * @param tournamentMatchAssignmentPanel nuevo panel de asignación
     */
    public void setTournamentMatchAssignmentPanel(TournamentMatchAssignmentPanel tournamentMatchAssignmentPanel) {
        this.tournamentMatchAssignmentPanel = tournamentMatchAssignmentPanel;
    }

    /**
     * Retorna el panel con la tabla/listado de torneos.
     * @return TournamentTablePanel
     */
    public TournamentTablePanel getTournamentTablePanel() {
        return tournamentTablePanel;
    }

    /**
     * Establece el panel con la tabla/listado de torneos.
     * @param tournamentTablePanel nuevo panel de tabla
     */
    public void setTournamentTablePanel(TournamentTablePanel tournamentTablePanel) {
        this.tournamentTablePanel = tournamentTablePanel;
    }

}
