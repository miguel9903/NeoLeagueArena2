package view.modules.player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.persistence.dto.PlayerDTO;
import utils.AssetPaths;
import utils.Colors;
import utils.WordingMessages;
import view.modules.player.PlayerCardPanel;
import view.shared.CardListPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDetailPanel extends JPanel {

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

    public PlayerDetailPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        initializeComponents();
    }

    private void initializeComponents() {
        logoPanel = new JPanel();
        logoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        ImageIcon teamIcon = loadIcon(AssetPaths.TEAM_ICON, 80, 80);
        logoLabel = new JLabel(teamIcon);
        logoPanel.add(logoLabel);

        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        nameLabel = new JLabel("Player Name");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        infoPanel.add(nameLabel);

        coachLabel = new JLabel("Coach: ");
        coachLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        coachLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        coachLabel.setBorder(new EmptyBorder(2, 2, 2, 2));
        infoPanel.add(coachLabel);

        membersLabel = new JLabel("Members: ");
        membersLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        membersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        membersLabel.setBorder(new EmptyBorder(2, 2, 2, 2));
        infoPanel.add(membersLabel);

        playersLabel = new JLabel("Description");
        playersLabel.setFont(new Font("Arial", Font.BOLD, 16));
        playersLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        playersLabel.setBorder(new EmptyBorder(10, 0, 5, 0));
        infoPanel.add(playersLabel);

        descriptionTextArea = new JTextArea();
        descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setOpaque(false);
        descriptionTextArea.setEditable(false);

        JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
        descriptionScrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        infoPanel.add(descriptionScrollPane);

        playerCards = new ArrayList<>();
        playerListPanel = new CardListPanel(3, 3);

        JScrollPane scrollPane = new JScrollPane(playerListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        infoPanel.add(scrollPane);

        add(logoPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
    }

    public ImageIcon loadIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public void renderPlayerDetail(PlayerDTO playerDTO) {
        if (playerDTO == null) return;

        String playerName = playerDTO.getFirstName() + " " + playerDTO.getLastName();
        String playerTeamName = (playerDTO.getCurrentTeamName() != null && playerDTO.getCurrentTeamName().isEmpty()) 
        		? playerDTO.getCurrentTeamName() 
        				: WordingMessages.NOT_ASIGN_MESSAGE;
        
        nameLabel.setText(playerName);
        coachLabel.setText("Team: " + playerTeamName);
 
        revalidate();
        repaint();
    }
}
