package view.module.team;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import utils.ButtonActionCommands;
import utils.Colors;
import utils.WordingMessages;
import view.shared.CardListPanel;
import model.persistence.dto.TeamDTO; // Asegúrate de importar el DTO correctamente

public class TeamPanel extends JPanel {

	private JPanel teamListPanel;
	private	JScrollPane scrollPanel;
	private List<TeamCardPanel> teamCards;
	private JLabel emptyMessageLabel;

	public TeamPanel() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10)); 
		initializeCompoenents();
	}

	public void initializeCompoenents() {
		teamCards = new ArrayList<>();

		emptyMessageLabel = new JLabel(WordingMessages.EMPTY_TEAM_LIST_MESSAGE);
	    emptyMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emptyMessageLabel.setBorder(new EmptyBorder(20, 20, 20, 20));

		if(teamCards.size() == 0) {
			add(emptyMessageLabel, BorderLayout.NORTH);
		}
	}

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
	            card.getMembersLabel().setText("Members: " + currentDTO.getPlayerIds().size());
	            card.getCoachLabel().setText("Coach: " + coachName);
	            card.getScoreLabel().setText("Score: " + currentDTO.getScore());
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

	public void repaintView() {
		revalidate();
		repaint();  
	}

	public JPanel getTeamListPanel() {
		return teamListPanel;
	}

	public void setTeamListPanel(JPanel teamListPanel) {
		this.teamListPanel = teamListPanel;
	}

	public List<TeamCardPanel> getTeamCards() {
		return teamCards;
	}

	public void setTeamCards(List<TeamCardPanel> teamCards) {
		this.teamCards = teamCards;
	}

	public JLabel getEmptyMessageLabel() {
		return emptyMessageLabel;
	}

	public void setEmptyMessageLabel(JLabel emptyMessageLabel) {
		this.emptyMessageLabel = emptyMessageLabel;
	}
}
