/**
 * La clase HomePanel representa un panel que muestra una lista de tarjetas de torneos.
 * Extiende la clase JPanel y proporciona funcionalidad para inicializar y mostrar
 * tarjetas de torneos en una lista desplazable.
 */
package view.module.home;

import javax.swing.*;
import java.awt.*;
import utils.Colors;
import view.module.tournament.TournamentCardPanel;
import view.shared.CardListPanel;

/**
 * La clase HomePanel representa un panel que muestra una lista de tarjetas de torneos.
 * Extiende la clase JPanel y proporciona funcionalidad para inicializar y mostrar
 * tarjetas de torneos en una lista desplazable.
 */
public class HomePanel extends JPanel {

    /** El panel que contiene la lista de tarjetas de torneos. */
    private CardListPanel cardListPanel;

    /**
     * Construye un nuevo HomePanel e inicializa sus componentes.
     */
    public HomePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    /**
     * Inicializa los componentes del HomePanel, incluyendo la creación de tarjetas de torneos
     * y la configuración de la lista desplazable.
     */
    public void initializeComponents() {
        JPanel[] cards = new JPanel[10];

        for (int i = 0; i < cards.length; i++) {
            TournamentCardPanel card = new TournamentCardPanel();
            card.initializeComponents();
            card.getNameLabel().setText("Torneo #" + (i + 1));
            card.getGameLabel().setText("Juego: Rocket League");
            card.getStageLabel().setText("Etapa: Grupos");
            cards[i] = card;
        }

        cardListPanel = new CardListPanel(3, 3);
        cardListPanel.setBackground(Color.decode(Colors.LIGHT_GRAY));

        JScrollPane scrollPane = new JScrollPane(cardListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Devuelve el CardListPanel que contiene la lista de tarjetas de torneos.
     *
     * @return la instancia de CardListPanel
     */
    public CardListPanel getCardListPanel() {
        return cardListPanel;
    }
}
