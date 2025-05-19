/**
 * La clase TeamFormPanel representa un panel que contiene un formulario para gestionar equipos.
 * Incluye un encabezado, campos de formulario para ingresar información del equipo y un pie de formulario
 * con botones para realizar acciones como crear, actualizar, eliminar y reiniciar datos.
 */
package view.module.team;

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
 * La clase TeamFormPanel representa un panel que contiene un formulario para gestionar equipos.
 * Incluye un encabezado, campos de formulario para ingresar información del equipo y un pie de formulario
 * con botones para realizar acciones como crear, actualizar, eliminar y reiniciar datos.
 */
public class TeamFormPanel extends JPanel {

    /** Panel de encabezado del formulario. */
    private FormHeaderPanel formHeaderPanel;

    /** Panel de campos del formulario para ingresar información del equipo. */
    private TeamFormFieldsPanel teamFormFieldsPanel;

    /** Panel de pie del formulario con botones de acción. */
    private FormFooterPanel formFooterPanel;

    /**
     * Construye un nuevo TeamFormPanel e inicializa sus componentes.
     */
    public TeamFormPanel() {
        setLayout(new BorderLayout());
        initializeComponents();
        setupFormControls();
    }

    /**
     * Inicializa los componentes del panel, incluyendo el encabezado, los campos del formulario
     * y el pie del formulario.
     */
    private void initializeComponents() {
        formHeaderPanel = new FormHeaderPanel();
        formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        teamFormFieldsPanel = new TeamFormFieldsPanel();
        teamFormFieldsPanel.setBorder(new EmptyBorder(0, 20, 0, 20));

        formFooterPanel = new FormFooterPanel();
        formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        formFooterPanel.setBackground(Color.decode(Colors.MEDIUM_GRAY));

        add(formHeaderPanel, BorderLayout.NORTH);
        add(teamFormFieldsPanel, BorderLayout.CENTER);
        add(formFooterPanel, BorderLayout.SOUTH);
    }

    /**
     * Configura los controles del formulario, incluyendo los textos y comandos de acción de los botones.
     */
    public void setupFormControls() {
        formHeaderPanel.getFormTitleLabel().setText("Gestionar Equipos");

        formHeaderPanel.setSearchButtonText("Buscar");
        formHeaderPanel.setSearchButtonActionCommand(ButtonActionCommands.ADMIN_SEARCH_TEAM_ACTION_COMMAND);

        formFooterPanel.setPrimaryButtonText("CREAR");
        formFooterPanel.setPrimaryButtonActionCommand(ButtonActionCommands.ADMIN_CREATE_TEAM_ACTION_COMMAND);

        formFooterPanel.setSecondaryButtonText("ACTUALIZAR");
        formFooterPanel.setSecondaryButtonActionCommand(ButtonActionCommands.ADMIN_UPDATE_TEAM_ACTION_COMMAND);

        formFooterPanel.setTertiaryButtonText("ELIMINAR");
        formFooterPanel.setTertiaryButtonActionCommand(ButtonActionCommands.ADMIN_DELETE_TEAM_ACTION_COMMAND);

        formFooterPanel.setQuaternaryButtonText("REINICIAR DATOS");
        formFooterPanel.setQuaternaryButtonActionCommand(ButtonActionCommands.ADMIN_RESET_TEAM_ACTION_COMMAND);
    }

    /**
     * Obtiene el panel de encabezado del formulario.
     *
     * @return el panel de encabezado del formulario
     */
    public FormHeaderPanel getFormHeaderPanel() {
        return formHeaderPanel;
    }

    /**
     * Establece el panel de encabezado del formulario.
     *
     * @param formHeaderPanel el panel de encabezado del formulario a establecer
     */
    public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
        this.formHeaderPanel = formHeaderPanel;
    }

    /**
     * Obtiene el panel de campos del formulario para ingresar información del equipo.
     *
     * @return el panel de campos del formulario
     */
    public TeamFormFieldsPanel getTeamFormFieldsPanel() {
        return teamFormFieldsPanel;
    }

    /**
     * Establece el panel de campos del formulario para ingresar información del equipo.
     *
     * @param teamFormFieldsPanel el panel de campos del formulario a establecer
     */
    public void setTeamFormFieldsPanel(TeamFormFieldsPanel teamFormFieldsPanel) {
        this.teamFormFieldsPanel = teamFormFieldsPanel;
    }

    /**
     * Obtiene el panel de pie del formulario con botones de acción.
     *
     * @return el panel de pie del formulario
     */
    public FormFooterPanel getFormFooterPanel() {
        return formFooterPanel;
    }

    /**
     * Establece el panel de pie del formulario con botones de acción.
     *
     * @param formFooterPanel el panel de pie del formulario a establecer
     */
    public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
        this.formFooterPanel = formFooterPanel;
    }
}
