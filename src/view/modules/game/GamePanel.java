package view.modules.game;

import javax.swing.*;
import java.awt.*;
import utils.Colors;
import view.shared.CardListPanel;

public class GamePanel extends JPanel {

    private CardListPanel cardListPanel;

    public GamePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    public void initializeComponents() {
        JPanel[] cards = new JPanel[10];

        for (int i = 0; i < cards.length; i++) {
            GameCardPanel card = new GameCardPanel();
            card.initializeComponents(); 
            card.getNameLabel().setText("Game #" + (i + 1));
            card.getGenreLabel().setText("Genre: Action");
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
