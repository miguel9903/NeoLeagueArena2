package view.module.tournament;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.util.AssetPaths;
import co.edu.unbosque.util.Colors;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import view.modules.player.PlayerCardPanel;
import view.shared.CardListPanel;

/**
 * Panel que muestra los detalles de un torneo, incluyendo su nombre, descripción,
 * entrenador, cantidad de miembros y una lista de jugadores participantes.
 * Utiliza componentes personalizados como {@link PlayerCardPanel} y {@link CardListPanel}.
 * 
 * Este panel se utiliza en la vista detallada de un torneo seleccionado.
 * 
 * @author 
 */
public class TournamentDetailPanel extends JPanel {
    
    private JPanel logoPanel;
    private JPanel infoPanel;
    private JLabel logoLabel;
    private JLabel nameLabel;
    private JTextArea descriptionTextArea;
    private JLabel coachLabel;
    private JLabel membersLabel;
    private JLabel playersLabel;
    private CardListPanel playerListPanel;
    private List<PlayerCardPanel> playerCards;

    /**
     * Crea e inicializa el panel de detalles del torneo, estableciendo el layout,
     * color de fondo y márgenes.
     */
    public TournamentDetailPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode(Colors.LIGHT_GRAY));  
        setBorder(new EmptyBorder(20, 20, 20, 20));
        initializeComponents();
    }

    /**
     * Inicializa y construye todos los componentes del panel, incluyendo secciones
     * para logo, nombre del torneo, descripción, entrenador, miembros y jugadores.
     */
    private void initializeComponents() {
        logoPanel = new JPanel();
        ImageIcon teamIcon = loadIcon(AssetPaths.TOURNAMENT_ICON, 80, 80);
        logoLabel = new JLabel(teamIcon);
        logoPanel.add(logoLabel);

        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JPanel nameLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nameLabelPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        nameLabel = new JLabel("Tournament Name");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabelPanel.add(nameLabel);
        infoPanel.add(nameLabelPanel);

        JPanel coachLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        coachLabel = new JLabel("Coach: Ned Flanders");
        coachLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        coachLabelPanel.add(coachLabel);
        infoPanel.add(coachLabelPanel); 

        JPanel membersLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        membersLabel = new JLabel("Members: 5");
        membersLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        membersLabelPanel.add(membersLabel);
        infoPanel.add(membersLabelPanel); 

        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        descriptionPanel.setBorder(new EmptyBorder(10, 0, 5, 0));
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        descriptionPanel.add(descriptionLabel);
        infoPanel.add(descriptionPanel);

        descriptionTextArea = new JTextArea();
        descriptionTextArea.setText("Phoenix Esports...");
        descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionTextArea.setWrapStyleWord(true); 
        descriptionTextArea.setLineWrap(true); 
        descriptionTextArea.setOpaque(false);  
        descriptionTextArea.setEditable(false);  

        JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
        descriptionScrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        infoPanel.add(descriptionScrollPane);

        JPanel playerLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        playerLabelPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        playersLabel = new JLabel("Players");
        playersLabel.setFont(new Font("Arial", Font.BOLD, 16));
        playerLabelPanel.add(playersLabel);
        infoPanel.add(playerLabelPanel);

        playerCards = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            PlayerCardPanel card = new PlayerCardPanel();
            card.initializeComponents();
            card.getNameLabel().setText("Player #" + (i + 1)); 
            card.getTeamLabel().setText("Team: Rocket"); 
            playerCards.add(card);
        }

        playerListPanel = new CardListPanel(3, 3);
        for (PlayerCardPanel card : playerCards) {
            playerListPanel.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(playerListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        infoPanel.add(scrollPane);

        add(logoPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
    }

    /**
     * Carga un ícono desde una ruta de archivo y lo escala a las dimensiones especificadas.
     *
     * @param imagePath Ruta del archivo de la imagen.
     * @param width     Ancho deseado.
     * @param height    Alto deseado.
     * @return {@link ImageIcon} escalado.
     */
    public ImageIcon loadIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    /**
     * Muestra los detalles de un torneo en el panel.
     * Este método debe ser implementado para cargar dinámicamente los datos de un torneo.
     */
    public void displayTournamentDetails() {
        // TODO: Display tournament details
    }
}
