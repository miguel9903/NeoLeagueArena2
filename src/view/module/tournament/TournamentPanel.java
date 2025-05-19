package view.module.tournament;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.TournamentDTO;
import co.edu.unbosque.util.Colors;
import co.edu.unbosque.util.WordingMessages;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TournamentPanel extends JPanel {

    private JPanel tournamentListPanel;
    private JScrollPane scrollPanel;
    private List<TournamentCardPanel> tournamentCards;
    private JLabel emptyMessageLabel;

    public TournamentPanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        initializeComponents();
    }

    private void initializeComponents() {
        tournamentCards = new ArrayList<>();

        emptyMessageLabel = new JLabel(WordingMessages.EMPTY_TOURNAMENT_LIST_MESSAGE);
        emptyMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emptyMessageLabel.setBorder(new EmptyBorder(20, 20, 20, 20));

        if (tournamentCards.isEmpty()) {
            add(emptyMessageLabel, BorderLayout.NORTH);
        }
    }

    public void renderTournamentCards(List<TournamentDTO> tournamentDTOs) {
        removeAll();
        tournamentCards.clear();

        if (tournamentDTOs == null || tournamentDTOs.isEmpty()) {
            emptyMessageLabel.setText(WordingMessages.EMPTY_TOURNAMENT_LIST_MESSAGE);
            add(emptyMessageLabel, BorderLayout.NORTH);
        } else {
            tournamentListPanel = new JPanel();
            tournamentListPanel.setLayout(new GridLayout(0, 3, 10, 10));
            tournamentListPanel.setBackground(Color.decode(Colors.LIGHT_GRAY));

            for (TournamentDTO dto : tournamentDTOs) {
                TournamentCardPanel card = new TournamentCardPanel();
                card.initializeComponents();

                card.getNameLabel().setText(dto.getName());
                card.getDescriptionLabel().setText(dto.getDescription());
                card.getGameLabel().setText("Game: " + dto.getGame());
                card.getStageLabel().setText("Stage: " + dto.getPhase());
                card.getPlatformLabel().setText("Platform: " + dto.getPlatform());

                tournamentCards.add(card);
                tournamentListPanel.add(card);
            }

            scrollPanel = new JScrollPane(tournamentListPanel);
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

    public JPanel getTournamentListPanel() {
        return tournamentListPanel;
    }

    public void setTournamentListPanel(JPanel tournamentListPanel) {
        this.tournamentListPanel = tournamentListPanel;
    }

    public List<TournamentCardPanel> getTournamentCards() {
        return tournamentCards;
    }

    public void setTournamentCards(List<TournamentCardPanel> tournamentCards) {
        this.tournamentCards = tournamentCards;
    }

    public JLabel getEmptyMessageLabel() {
        return emptyMessageLabel;
    }

    public void setEmptyMessageLabel(JLabel emptyMessageLabel) {
        this.emptyMessageLabel = emptyMessageLabel;
    }
}
