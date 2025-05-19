package view.module.tournament;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.util.ButtonActionCommands;
import co.edu.unbosque.util.Colors;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

import java.awt.BorderLayout;
import java.awt.Color;

/**
 * Panel principal del formulario de torneos.
 * Este panel agrupa el encabezado, los campos del formulario y el pie de formulario.
 */
public class TournamentFormPanel extends JPanel {

    private FormHeaderPanel formHeaderPanel;
    private TournamentFormFieldsPanel tournamentFormFieldsPanel;
    private FormFooterPanel formFooterPanel;

    /**
     * Constructor que configura el diseño y componentes del formulario.
     */
    public TournamentFormPanel() {
        setLayout(new BorderLayout()); 
        initializeComponents(); 
        setupFormControls();
    }

    /**
     * Inicializa y configura los subpaneles (encabezado, campos y pie de formulario).
     */
    private void initializeComponents() { 
        formHeaderPanel = new FormHeaderPanel();
        formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        tournamentFormFieldsPanel = new TournamentFormFieldsPanel();
        tournamentFormFieldsPanel.setBorder(new EmptyBorder(0, 20, 0, 20)); 

        formFooterPanel = new FormFooterPanel();
        formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        formFooterPanel.setBackground(Color.decode(Colors.MEDIUM_GRAY));

        add(formHeaderPanel, BorderLayout.NORTH); 
        add(tournamentFormFieldsPanel, BorderLayout.CENTER);
        add(formFooterPanel, BorderLayout.SOUTH); 
    }

    /**
     * Configura los textos y comandos de acción para los botones del formulario.
     */
    public void setupFormControls() {
        formHeaderPanel.getFormTitleLabel().setText("Manage Tournaments");
        
        formHeaderPanel.setSearchButtonText("Search");
        formHeaderPanel.setSearchButtonActionCommand(ButtonActionCommands.ADMIN_SEARCH_TOURNAMENT_ACTION_COMMAND);
        
        formFooterPanel.setPrimaryButtonText("CREATE");
        formFooterPanel.setPrimaryButtonActionCommand(ButtonActionCommands.ADMIN_CREATE_TOURNAMENT_ACTION_COMMAND);
        
        formFooterPanel.setSecondaryButtonText("UPDATE");
        formFooterPanel.setSecondaryButtonActionCommand(ButtonActionCommands.ADMIN_UPDATE_TOURNAMENT_ACTION_COMMAND);
        
        formFooterPanel.setTertiaryButtonText("DELETE");
        formFooterPanel.setTertiaryButtonActionCommand(ButtonActionCommands.ADMIN_DELETE_TOURNAMENT_ACTION_COMMAND);
        
        formFooterPanel.setQuaternaryButtonText("RESET DATA");
        formFooterPanel.setQuaternaryButtonActionCommand(ButtonActionCommands.ADMIN_RESET_TOURNAMENT_ACTION_COMMAND);
    }

    /**
     * Retorna el panel de encabezado del formulario.
     * @return FormHeaderPanel
     */
    public FormHeaderPanel getFormHeaderPanel() {
        return formHeaderPanel;
    }

    /**
     * Establece el panel de encabezado del formulario.
     * @param formHeaderPanel nuevo encabezado
     */
    public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
        this.formHeaderPanel = formHeaderPanel;
    }

    /**
     * Retorna el panel de campos del formulario de torneo.
     * @return TournamentFormFieldsPanel
     */
    public TournamentFormFieldsPanel getTournamentFormFieldsPanel() {
        return tournamentFormFieldsPanel;
    }

    /**
     * Establece el panel de campos del formulario de torneo.
     * @param tournamentFormFieldsPanel nuevo panel de campos
     */
    public void setTournamentFormFieldsPanel(TournamentFormFieldsPanel tournamentFormFieldsPanel) {
        this.tournamentFormFieldsPanel = tournamentFormFieldsPanel;
    }

    /**
     * Retorna el panel de pie de formulario.
     * @return FormFooterPanel
     */
    public FormFooterPanel getFormFooterPanel() {
        return formFooterPanel;
    }

    /**
     * Establece el panel de pie de formulario.
     * @param formFooterPanel nuevo pie de formulario
     */
    public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
        this.formFooterPanel = formFooterPanel;
    }
}
