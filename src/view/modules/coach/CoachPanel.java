package view.modules.coach;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.CoachDTO;
import co.edu.unbosque.util.ButtonActionCommands;
import co.edu.unbosque.util.WordingMessages;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class CoachPanel extends JPanel {

    private JPanel coachListPanel;
    private JScrollPane scrollPanel;
    private List<CoachCardPanel> coachCards;
    private JLabel emptyMessageLabel;

    public CoachPanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        initializeComponents();
    }

    public void initializeComponents() {
        coachCards = new ArrayList<>();

        emptyMessageLabel = new JLabel(WordingMessages.EMPTY_COACH_LIST_MESSAGE);
        emptyMessageLabel.setBorder(new EmptyBorder(20, 20, 20, 20));

        if (coachCards.isEmpty()) {
            add(emptyMessageLabel, BorderLayout.NORTH);
        }
    }

    public void renderCoachCards(List<CoachDTO> coachDTOs) {
        removeAll();
        coachCards.clear();

        if (coachDTOs == null || coachDTOs.isEmpty()) {
            emptyMessageLabel.setText(WordingMessages.EMPTY_COACH_LIST_MESSAGE);
            add(emptyMessageLabel, BorderLayout.NORTH);
        } else {
            coachListPanel = new JPanel();
            coachListPanel.setLayout(new GridLayout(0, 2, 10, 10)); // 2 columnas, filas dinámicas

            for (CoachDTO coachDTO : coachDTOs) {
                String coachName = coachDTO.getFirstName() + " " + coachDTO.getLastName();
                String buttonActionCommand = ButtonActionCommands.COACH_DETAIL_ACTION_COMMAND + "_" + coachDTO.getId();

                CoachCardPanel card = new CoachCardPanel();
                card.getNameLabel().setText(coachName);
                card.getCountryLabel().setText("Country: " + coachDTO.getCountry());
                card.getCityLabel().setText("City: " + coachDTO.getCity());
                card.getAgeLabel().setText("Age: " + coachDTO.getAge());
                card.getDetailButton().setActionCommand(buttonActionCommand);

                coachCards.add(card);
                coachListPanel.add(card);
            }

            scrollPanel = new JScrollPane(coachListPanel);
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

    // Getters y Setters
    public JPanel getCoachListPanel() {
        return coachListPanel;
    }

    public void setCoachListPanel(JPanel coachListPanel) {
        this.coachListPanel = coachListPanel;
    }

    public List<CoachCardPanel> getCoachCards() {
        return coachCards;
    }

    public void setCoachCards(List<CoachCardPanel> coachCards) {
        this.coachCards = coachCards;
    }

    public JLabel getEmptyMessageLabel() {
        return emptyMessageLabel;
    }

    public void setEmptyMessageLabel(JLabel emptyMessageLabel) {
        this.emptyMessageLabel = emptyMessageLabel;
    }
}
