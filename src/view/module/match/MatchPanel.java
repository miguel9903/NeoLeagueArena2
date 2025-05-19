/**
 * La clase MatchPanel representa un panel que muestra una lista de tarjetas de partidos.
 * Permite renderizar tarjetas de partidos a partir de una lista de DTOs de partidos y gestionar
 * la visualización de mensajes cuando no hay partidos disponibles.
 */
package view.module.match;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import model.persistence.dto.MatchDTO;
import utils.WordingMessages;

/**
 * La clase MatchPanel representa un panel que muestra una lista de tarjetas de partidos.
 * Permite renderizar tarjetas de partidos a partir de una lista de DTOs de partidos y gestionar
 * la visualización de mensajes cuando no hay partidos disponibles.
 */
public class MatchPanel extends JPanel {

    /** Panel que contiene la lista de tarjetas de partidos. */
    private JPanel matchListPanel;

    /** Panel de desplazamiento para la lista de tarjetas de partidos. */
    private JScrollPane scrollPanel;

    /** Lista de tarjetas de partidos. */
    private List<MatchCardPanel> matchCards;

    /** Etiqueta para mostrar un mensaje cuando no hay partidos disponibles. */
    private JLabel emptyMessageLabel;

    /**
     * Construye un nuevo MatchPanel e inicializa sus componentes.
     */
    public MatchPanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        initializeComponents();
    }

    /**
     * Inicializa los componentes del panel, incluyendo la etiqueta de mensaje vacío.
     */
    private void initializeComponents() {
        matchCards = new ArrayList<>();

        emptyMessageLabel = new JLabel(WordingMessages.EMPTY_MATCH_LIST_MESSAGE);
        emptyMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emptyMessageLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(emptyMessageLabel, BorderLayout.NORTH);
    }

    /**
     * Renderiza las tarjetas de partidos a partir de una lista de DTOs de partidos.
     *
     * @param matchDTOs la lista de DTOs de partidos
     */
    public void renderMatchCards(List<MatchDTO> matchDTOs) {
        removeAll();
        matchCards.clear();

        if (matchDTOs == null || matchDTOs.isEmpty()) {
            emptyMessageLabel.setText(WordingMessages.EMPTY_MATCH_LIST_MESSAGE);
            add(emptyMessageLabel, BorderLayout.NORTH);
        } else {
            matchListPanel = new JPanel(new GridLayout(0, 1, 10, 10));

            for (MatchDTO match : matchDTOs) {
                MatchCardPanel card = new MatchCardPanel();

                card.getTeamALabel().setText(match.getTeamAName());
                card.getTeamBLabel().setText(match.getTeamBName());
                card.getScoreLabel().setText((String.valueOf(match.getTeamAScore()) + " -  " + String.valueOf(match.getTeamBScore())));
                card.getDetailButton().setActionCommand("MATCH_DETAIL_" + match.getId());

                matchCards.add(card);
                matchListPanel.add(card);
            }

            scrollPanel = new JScrollPane(matchListPanel);
            scrollPanel.setBorder(BorderFactory.createEmptyBorder());
            scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
            add(scrollPanel, BorderLayout.CENTER);
        }

        repaintView();
    }

    /**
     * Vuelve a pintar la vista para reflejar los cambios realizados.
     */
    public void repaintView() {
        revalidate();
        repaint();
    }

    /**
     * Obtiene la lista de tarjetas de partidos.
     *
     * @return la lista de tarjetas de partidos
     */
    public List<MatchCardPanel> getMatchCards() {
        return matchCards;
    }
}
