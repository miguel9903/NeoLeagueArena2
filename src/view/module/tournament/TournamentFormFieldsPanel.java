package view.module.tournament;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.unbosque.model.GamePlatform;
import co.edu.unbosque.model.TournamentPhase;

/**
 * Panel que contiene los campos del formulario para crear o editar un torneo.
 * Incluye campos para ID, nombre, descripción, plataforma, juego y fase del torneo.
 */
public class TournamentFormFieldsPanel extends JPanel {

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel platformLabel;
    private JLabel gameLabel;
    private JLabel phaseLabel;

    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextArea descriptionTextArea;

    private JComboBox<String> platformComboBox;
    private JComboBox<String> gameComboBox;
    private JComboBox<String> phaseComboBox;

    /**
     * Constructor que inicializa el panel con un diseño de formulario.
     */
    public TournamentFormFieldsPanel() {
        setLayout(new GridLayout(6, 2, 10, 10));
        initializeComponents();
    }

    /**
     * Inicializa y agrega todos los componentes al panel.
     */
    public void initializeComponents() {
        idLabel = new JLabel("ID* :");
        idTextField = new JTextField();
        add(idLabel);
        add(idTextField);

        nameLabel = new JLabel("Name* :");
        nameTextField = new JTextField();
        add(nameLabel);
        add(nameTextField);

        descriptionLabel = new JLabel("Description* :");
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        add(descriptionLabel);
        add(scrollPane);

        platformLabel = new JLabel("Platform* :");
        platformComboBox = new JComboBox<>(new String[] { "PC", "Console", "Mobile" });
        add(platformLabel);
        add(platformComboBox);

        gameLabel = new JLabel("Game* :");
        gameComboBox = new JComboBox<>(new String[] { "Game 1", "Game 2", "Game 3" });
        add(gameLabel);
        add(gameComboBox);

        phaseLabel = new JLabel("Phase* :");
        phaseComboBox = new JComboBox<>(new String[] { "Group Stage", "Quarterfinal", "Semifinal", "Final" });
        add(phaseLabel);
        add(phaseComboBox);
    }

    /**
     * Carga una lista de fases de torneo en el comboBox correspondiente.
     * @param phases Lista de fases del torneo a mostrar.
     */
    public void loadPhaseComboBox(List<TournamentPhase> phases) {
        phaseComboBox.removeAllItems();

        for (TournamentPhase phase : phases) {
            phaseComboBox.addItem(phase.getDisplayName());
        }
    }

    /**
     * Carga una lista de plataformas de juego en el comboBox correspondiente.
     * @param platforms Lista de plataformas de juego a mostrar.
     */
    public void loadPlatformComboBox(List<GamePlatform> platforms) {
        platformComboBox.removeAllItems();

        for (GamePlatform platform : platforms) {
            platformComboBox.addItem(platform.getDisplayName());
        }
    }

    /**
     * Carga una lista predefinida de videojuegos en el comboBox correspondiente.
     */
    public void loadGameComboBox() {
        gameComboBox.removeAllItems();
        gameComboBox.addItem("League of Legends");
        gameComboBox.addItem("Dota 2");
        gameComboBox.addItem("Counter-Strike: Global Offensive");
        gameComboBox.addItem("Valorant");
        gameComboBox.addItem("Overwatch 2");
        gameComboBox.addItem("Fortnite");
        gameComboBox.addItem("Call of Duty: Warzone");
        gameComboBox.addItem("Apex Legends");
        gameComboBox.addItem("PUBG: Battlegrounds");
        gameComboBox.addItem("Rainbow Six Siege");
        gameComboBox.addItem("Rocket League");
        gameComboBox.addItem("Street Fighter VI");
        gameComboBox.addItem("Tekken 8");
        gameComboBox.addItem("StarCraft II");
        gameComboBox.addItem("Hearthstone");
    }

    /**
     * Devuelve la etiqueta del campo ID.
     * @return JLabel del campo ID.
     */
    public JLabel getIdLabel() {
        return idLabel;
    }

    /**
     * Devuelve el campo de texto del ID.
     * @return JTextField del ID.
     */
    public JTextField getIdTextField() {
        return idTextField;
    }

    /**
     * Devuelve la etiqueta del campo nombre.
     * @return JLabel del campo nombre.
     */
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * Devuelve el campo de texto del nombre.
     * @return JTextField del nombre.
     */
    public JTextField getNameTextField() {
        return nameTextField;
    }

    /**
     * Devuelve la etiqueta del campo descripción.
     * @return JLabel del campo descripción.
     */
    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    /**
     * Devuelve el área de texto de la descripción.
     * @return JTextArea de la descripción.
     */
    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    /**
     * Devuelve la etiqueta del campo plataforma.
     * @return JLabel del campo plataforma.
     */
    public JLabel getPlatformLabel() {
        return platformLabel;
    }

    /**
     * Devuelve el comboBox de plataformas.
     * @return JComboBox de plataformas.
     */
    public JComboBox<String> getPlatformComboBox() {
        return platformComboBox;
    }

    /**
     * Devuelve la etiqueta del campo juego.
     * @return JLabel del campo juego.
     */
    public JLabel getGameLabel() {
        return gameLabel;
    }

    /**
     * Devuelve el comboBox de juegos.
     * @return JComboBox de juegos.
     */
    public JComboBox<String> getGameComboBox() {
        return gameComboBox;
    }

    /**
     * Devuelve la etiqueta del campo fase.
     * @return JLabel del campo fase.
     */
    public JLabel getPhaseLabel() {
        return phaseLabel;
    }

    /**
     * Devuelve el comboBox de fases.
     * @return JComboBox de fases.
     */
    public JComboBox<String> getPhaseComboBox() {
        return phaseComboBox;
    }

    /**
     * Restablece todos los campos del formulario a sus valores por defecto.
     */
    public void resetFields() {
        idTextField.setText("");
        nameTextField.setText("");
        descriptionTextArea.setText("");
        platformComboBox.setSelectedIndex(0);
        gameComboBox.setSelectedIndex(0);
        phaseComboBox.setSelectedIndex(0);
    }
}
