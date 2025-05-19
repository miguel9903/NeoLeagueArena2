/**
 * La clase TeamFormFieldsPanel representa un panel que contiene los campos de un formulario
 * para ingresar información sobre un equipo. Incluye campos para el ID, nombre, descripción,
 * URL del logo, puntuación, ranking, entrenador y jugadores.
 */
package view.module.team;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.unbosque.model.CoachDTO;

import javax.swing.JScrollPane;

/**
 * La clase TeamFormFieldsPanel representa un panel que contiene los campos de un formulario
 * para ingresar información sobre un equipo. Incluye campos para el ID, nombre, descripción,
 * URL del logo, puntuación, ranking, entrenador y jugadores.
 */
public class TeamFormFieldsPanel extends JPanel {

    /** Etiqueta para el campo ID. */
    private JLabel idLabel;

    /** Etiqueta para el campo Nombre. */
    private JLabel nameLabel;

    /** Etiqueta para el campo Descripción. */
    private JLabel descriptionLabel;

    /** Etiqueta para el campo Logo. */
    private JLabel logoLabel;

    /** Etiqueta para el campo Puntuación. */
    private JLabel scoreLabel;

    /** Etiqueta para el campo Ranking. */
    private JLabel rankingLabel;

    /** Etiqueta para el campo Entrenador. */
    private JLabel coachLabel;

    /** Etiqueta para el campo Jugadores. */
    private JLabel playersLabel;

    /** Campo de texto para el ID. */
    private JTextField idTextField;

    /** Campo de texto para el Nombre. */
    private JTextField nameTextField;

    /** Área de texto para la Descripción. */
    private JTextArea descriptionTextArea;

    /** Campo de texto para la URL del Logo. */
    private JTextField logoTextField;

    /** Campo de texto para la Puntuación. */
    private JTextField scoreTextField;

    /** Campo de texto para el Ranking. */
    private JTextField rankingTextField;

    /** ComboBox para seleccionar el Entrenador. */
    private JComboBox<String> coachComboBox;

    /** ComboBox para seleccionar los Jugadores. */
    private JComboBox<String> playersComboBox;

    /**
     * Construye un nuevo TeamFormFieldsPanel e inicializa sus componentes.
     */
    public TeamFormFieldsPanel() {
        setLayout(new GridLayout(7, 2, 10, 10));
        initializeComponents();
    }

    /**
     * Inicializa los componentes del panel, incluyendo etiquetas y campos de texto.
     */
    public void initializeComponents() {
        idLabel = new JLabel("ID* :");
        idTextField = new JTextField();
        idTextField.setEditable(false);
        idTextField.setEnabled(false);
        add(idLabel);
        add(idTextField);

        nameLabel = new JLabel("Nombre* :");
        nameTextField = new JTextField();
        add(nameLabel);
        add(nameTextField);

        descriptionLabel = new JLabel("Descripción* :");
        descriptionTextArea = new JTextArea();

        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        add(descriptionLabel);
        add(scrollPane);

        logoLabel = new JLabel("URL/Ruta del Logo:");
        logoTextField = new JTextField();
        add(logoLabel);
        add(logoTextField);

        scoreLabel = new JLabel("Puntuación:");
        scoreTextField = new JTextField();
        add(scoreLabel);
        add(scoreTextField);

        rankingLabel = new JLabel("Ranking:");
        rankingTextField = new JTextField();
        add(rankingLabel);
        add(rankingTextField);

        coachLabel = new JLabel("Entrenador:");
        coachComboBox = new JComboBox<>(new String[]{"Entrenador 1", "Entrenador 2", "Entrenador 3"});
        add(coachLabel);
        add(coachComboBox);

        playersLabel = new JLabel("Jugadores:");
        playersComboBox = new JComboBox<>(new String[]{"Jugador 1", "Jugador 2", "Jugador 3"});
        // add(playersLabel);
        // add(playersComboBox);
    }

    /**
     * Establece los elementos del ComboBox de entrenadores.
     *
     * @param coachList la lista de DTOs de entrenadores
     */
    public void setCoachesComboBox(List<CoachDTO> coachList) {
        coachComboBox.removeAllItems();

        for (CoachDTO coachDTO : coachList) {
            String coachName = coachDTO.getId() + " - " + coachDTO.getFirstName() + " " + coachDTO.getLastName();
            coachComboBox.addItem(coachName);
        }
    }

    /**
     * Reinicia todos los campos del formulario a sus valores por defecto.
     */
    public void resetFields() {
        idTextField.setText("");
        nameTextField.setText("");
        descriptionTextArea.setText("");
        logoTextField.setText("");
        scoreTextField.setText("");
        rankingTextField.setText("");
        coachComboBox.setSelectedIndex(0);
        playersComboBox.setSelectedIndex(0);
    }

    /**
     * Obtiene el valor seleccionado en el ComboBox de entrenadores.
     *
     * @return el ID del entrenador seleccionado, o null si no hay selección válida
     */
    public Integer getCoachComboBoxIdValue() {
        String coachText = (String) coachComboBox.getSelectedItem();
        return (coachText != null && !coachText.isEmpty() && coachText.contains("-"))
                ? Integer.parseInt(coachText.substring(0, coachText.indexOf(" -")))
                : null;
    }

    /**
     * Obtiene el campo de texto del ID.
     *
     * @return el campo de texto del ID
     */
    public JTextField getIdTextField() {
        return idTextField;
    }

    /**
     * Obtiene el campo de texto del Nombre.
     *
     * @return el campo de texto del Nombre
     */
    public JTextField getNameTextField() {
        return nameTextField;
    }

    /**
     * Obtiene el área de texto de la Descripción.
     *
     * @return el área de texto de la Descripción
     */
    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    /**
     * Obtiene el campo de texto de la URL del Logo.
     *
     * @return el campo de texto de la URL del Logo
     */
    public JTextField getLogoTextField() {
        return logoTextField;
    }

    /**
     * Obtiene el campo de texto de la Puntuación.
     *
     * @return el campo de texto de la Puntuación
     */
    public JTextField getScoreTextField() {
        return scoreTextField;
    }

    /**
     * Obtiene el campo de texto del Ranking.
     *
     * @return el campo de texto del Ranking
     */
    public JTextField getRankingTextField() {
        return rankingTextField;
    }

    /**
     * Obtiene el ComboBox de Entrenadores.
     *
     * @return el ComboBox de Entrenadores
     */
    public JComboBox<String> getCoachComboBox() {
        return coachComboBox;
    }

    /**
     * Obtiene el ComboBox de Jugadores.
     *
     * @return el ComboBox de Jugadores
     */
    public JComboBox<String> getPlayersComboBox() {
        return playersComboBox;
    }
}
