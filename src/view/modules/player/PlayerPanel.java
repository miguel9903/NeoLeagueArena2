package view.modules.player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import utils.ButtonActionCommands;
import utils.Colors;
import utils.WordingMessages;
import view.shared.CardListPanel;
import model.persistence.dto.PlayerDTO; // Asegúrate de que esta clase exista

public class PlayerPanel extends JPanel {

    private JPanel playerListPanel;
    private JScrollPane scrollPanel;
    private List<PlayerCardPanel> playerCards;
    private JLabel emptyMessageLabel;

    public PlayerPanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10)); 
        initializeComponents();
    }

    public void initializeComponents() {
        playerCards = new ArrayList<>();

        emptyMessageLabel = new JLabel(WordingMessages.EMPTY_PLAYER_LIST_MESSAGE); 
        emptyMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emptyMessageLabel.setBorder(new EmptyBorder(20, 20, 20, 20));

        if (playerCards.isEmpty()) {
            add(emptyMessageLabel, BorderLayout.NORTH);
        }
    }

    public void renderPlayerCards(List<PlayerDTO> playerDTOs) {
        removeAll();

        playerCards.clear();

        if (playerDTOs == null || playerDTOs.isEmpty()) {
            emptyMessageLabel.setText(WordingMessages.EMPTY_PLAYER_LIST_MESSAGE);
            add(emptyMessageLabel, BorderLayout.NORTH);
        } else {
            playerListPanel = new JPanel();
            playerListPanel.setLayout(new GridLayout(0, 2, 10, 10));

            for (PlayerDTO currentDTO : playerDTOs) {
                String playerName = currentDTO.getFirstName() + currentDTO.getLastName();
                String buttonActionCommand = ButtonActionCommands.PLAYER_DETAIL_ACTION_COMMAND + "_" + currentDTO.getId();

                PlayerCardPanel card = new PlayerCardPanel();
                card.getNameLabel().setText(playerName);
                card.getTeamLabel().setText("Team: " + currentDTO.getCurrentTeamName());
                card.getCountryLabel().setText("Country: " + currentDTO.getCountry());
                card.getCityLabel().setText("City: " + currentDTO.getCity());
                card.getAgeLabel().setText("Age: " + currentDTO.getAge());
                card.getExperienceLevelLabel().setText("Experience level: " + currentDTO.getExperienceLevel());
                card.getDetailButton().setActionCommand(buttonActionCommand);

                playerCards.add(card);
                playerListPanel.add(card);
            }

            scrollPanel = new JScrollPane(playerListPanel);
            scrollPanel.setBorder(BorderFactory.createEmptyBorder());
            scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
            add(scrollPanel, BorderLayout.CENTER);
        }

        repaintView();
    }

    public void repaintView() {
        revalidate();
        repaint();  
    }

    public JPanel getPlayerListPanel() {
        return playerListPanel;
    }

    public void setPlayerListPanel(JPanel playerListPanel) {
        this.playerListPanel = playerListPanel;
    }

    public List<PlayerCardPanel> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<PlayerCardPanel> playerCards) {
        this.playerCards = playerCards;
    }

    public JLabel getEmptyMessageLabel() {
        return emptyMessageLabel;
    }

    public void setEmptyMessageLabel(JLabel emptyMessageLabel) {
        this.emptyMessageLabel = emptyMessageLabel;
    }
}
