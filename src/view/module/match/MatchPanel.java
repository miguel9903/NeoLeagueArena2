package view.module.match;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.MatchDTO;
import co.edu.unbosque.util.WordingMessages;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MatchPanel extends JPanel {

	private JPanel matchListPanel;
	private JScrollPane scrollPanel;
	private List<MatchCardPanel> matchCards;
	private JLabel emptyMessageLabel;

	public MatchPanel() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10)); 
		initializeComponents();
	}

	private void initializeComponents() {
		matchCards = new ArrayList<>();

		emptyMessageLabel = new JLabel(WordingMessages.EMPTY_MATCH_LIST_MESSAGE);
		emptyMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emptyMessageLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
		add(emptyMessageLabel, BorderLayout.NORTH);
	}

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

	public void repaintView() {
		revalidate();
		repaint();  
	}

	public List<MatchCardPanel> getMatchCards() {
		return matchCards;
	}
}
