/**
 * La clase TeamPanel representa un panel que muestra una lista de tarjetas de equipos.
 * Permite renderizar tarjetas de equipos a partir de una lista de DTOs de equipos y gestionar
 * la visualización de mensajes cuando no hay equipos disponibles.
 */
package view.module.team;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.TeamDTO;
import co.edu.unbosque.util.ButtonActionCommands;
import co.edu.unbosque.util.Colors;
import co.edu.unbosque.util.WordingMessages;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import view.shared.CardListPanel;

/**
 * La clase TeamPanel representa un panel que muestra una lista de tarjetas de equipos.
 * Permite renderizar tarjetas de equipos a partir de una lista de DTOs de equipos y gestionar
 * la visualización de mensajes cuando no hay equipos disponibles.
 */
public class TeamPanel extends JPanel {

    /** Panel que contiene la lista de tarjetas de equipos. */
    private JPanel teamListPanel;

    /** Panel de desplazamiento para la lista de tarjetas de equipos. */
    private JScrollPane scrollPanel;

    /** Lista de tarjetas de equipos. */
    private List<TeamCardPanel> teamCards;

    /** Etiqueta para mostrar un mensaje cuando no hay equipos disponibles. */
    private JLabel emptyMessageLabel;

    /**
     * Construye un nuevo TeamPanel e inicializa sus componentes.
     */
    public TeamPanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        initializeCompoenents();
    }

    /**
     * Inicializa los componentes del panel, incluyendo la etiqueta de mensaje vacío.
     */
    public void initializeCompoenents() {
        teamCards = new ArrayList<>();

        emptyMessageLabel = new JLabel(WordingMessages.EMPTY_TEAM_LIST_MESSAGE);
        emptyMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emptyMessageLabel.setBorder(new EmptyBorder(20, 20, 20, 20));

        if(teamCards.size() == 0) {
            add(emptyMessageLabel, BorderLayout.NORTH);
        }
    }

    /**
     * Renderiza las tarjetas de equipos a partir de una lista de DTOs de equipos.
     *
     * @param teamDTOs la lista de DTOs de equipos
     */
    public void renderTeamCards(List<TeamDTO> teamDTOs) {
        removeAll();

        teamCards.clear();

        if (teamDTOs == null || teamDTOs.isEmpty()) {
            emptyMessageLabel.setText(WordingMessages.EMPTY_TEAM_LIST_MESSAGE);
            add(emptyMessageLabel, BorderLayout.NORTH);
        } else {
            teamListPanel = new JPanel();
            teamListPanel.setLayout(new GridLayout(0, 2, 10, 10));

            for (TeamDTO currentDTO : teamDTOs) {
                String coachName = currentDTO.getCoachName() != null ? currentDTO.getCoachName() : WordingMessages.NOT_ASIGN_MESSAGE;
                String buttonActionCommand = ButtonActionCommands.TEAM_DETAIL_ACTION_COMMAND + "_" + currentDTO.getId();

                TeamCardPanel card = new TeamCardPanel();
                card.getNameLabel().setText(currentDTO.getName());
                card.getMembersLabel().setText("Miembros: " + currentDTO.getPlayerIds().size());
                card.getCoachLabel().setText("Entrenador: " + coachName);
                card.getScoreLabel().setText("Puntuación: " + currentDTO.getScore());
                card.getRankingLabel().setText("Ranking: #" + currentDTO.getRanking());
                card.getDetailButton().setActionCommand(buttonActionCommand);

                teamCards.add(card);
                teamListPanel.add(card);
            }

            scrollPanel = new JScrollPane(teamListPanel);
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
     * Obtiene el panel que contiene la lista de tarjetas de equipos.
     *
     * @return el panel que contiene la lista de tarjetas de equipos
     */
    public JPanel getTeamListPanel() {
        return teamListPanel;
    }

    /**
     * Establece el panel que contiene la lista de tarjetas de equipos.
     *
     * @param teamListPanel el panel que contiene la lista de tarjetas de equipos a establecer
     */
    public void setTeamListPanel(JPanel teamListPanel) {
        this.teamListPanel = teamListPanel;
    }

    /**
     * Obtiene la lista de tarjetas de equipos.
     *
     * @return la lista de tarjetas de equipos
     */
    public List<TeamCardPanel> getTeamCards() {
        return teamCards;
    }

    /**
     * Establece la lista de tarjetas de equipos.
     *
     * @param teamCards la lista de tarjetas de equipos a establecer
     */
    public void setTeamCards(List<TeamCardPanel> teamCards) {
        this.teamCards = teamCards;
    }

    /**
     * Obtiene la etiqueta para mostrar un mensaje cuando no hay equipos disponibles.
     *
     * @return la etiqueta para mostrar un mensaje cuando no hay equipos disponibles
     */
    public JLabel getEmptyMessageLabel() {
        return emptyMessageLabel;
    }

    /**
     * Establece la etiqueta para mostrar un mensaje cuando no hay equipos disponibles.
     *
     * @param emptyMessageLabel la etiqueta para mostrar un mensaje cuando no hay equipos disponibles a establecer
     */
    public void setEmptyMessageLabel(JLabel emptyMessageLabel) {
        this.emptyMessageLabel = emptyMessageLabel;
    }
}
