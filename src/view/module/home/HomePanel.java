package view.module.home;

import javax.swing.*;

import co.edu.unbosque.util.Colors;

import java.awt.*;

import view.module.tournament.TournamentCardPanel;
import view.shared.CardListPanel; 

public class HomePanel extends JPanel {

    private CardListPanel cardListPanel; 

    public HomePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    public void initializeComponents() {
        JPanel[] cards = new JPanel[10]; 

        for (int i = 0; i < cards.length; i++) {
            TournamentCardPanel card = new TournamentCardPanel();
            card.initializeComponents();
            card.getNameLabel().setText("Torneo #" + (i + 1));
            card.getGameLabel().setText("Game: Rocket League");
            card.getStageLabel().setText("Stage: Grupos");
            cards[i] = card;  
        }

        cardListPanel = new CardListPanel(3, 3); 
        cardListPanel.setBackground(Color.decode(Colors.LIGHT_GRAY));

        JScrollPane scrollPane = new JScrollPane(cardListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); 
        add(scrollPane, BorderLayout.CENTER);
    }

    public CardListPanel getCardListPanel() {
        return cardListPanel;
    }
}
