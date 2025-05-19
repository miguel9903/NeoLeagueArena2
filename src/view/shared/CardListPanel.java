package view.shared;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CardListPanel extends JPanel {

	private GridLayout layout;
	private List<JPanel> cards;

	public CardListPanel(int rows, int cols) {
		layout = new GridLayout(rows, cols, 10, 10);
		cards = new ArrayList<JPanel>();

		setLayout(layout);
		initializeComponents(cards);
	}

	public CardListPanel(int rows, int cols, List<JPanel> cards) {
		layout = new GridLayout(0, 3, 20, 20);
		setLayout(layout);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		initializeComponents(cards);

	}

	public void initializeComponents(List<JPanel> cards) {
		loadCards(cards);
		repaintView();
	}

	public void loadCards(List<JPanel> cards) {
		removeAll();

		for (JPanel card : cards) {
			add(card);
		}

	}

	public void repaintView() {
		revalidate();
		repaint();
	}


	public GridLayout getLayout() {
		return layout;
	}

	public void setLayout(GridLayout layout) {
		this.layout = layout;
	}

	public List<JPanel> getCards() {
		return cards;
	}

	public void setCards(List<JPanel> cards) {
		this.cards = cards;
		loadCards(cards);
		repaintView();
	}

}
