package view.module.team;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.PlayerDTO;
import co.edu.unbosque.model.TeamDTO;
import co.edu.unbosque.util.AssetPaths;
import co.edu.unbosque.util.Colors;
import co.edu.unbosque.util.WordingMessages;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import view.modules.player.PlayerCardPanel;
import view.shared.CardListPanel;

public class TeamDetailPanel extends JPanel {

	private JPanel playerLabelPanel ;
	private JPanel logoPanel;
	private JPanel infoPanel;
	
	private JPanel playerListPanel;
	private	JScrollPane scrollPanel;
	private List<PlayerCardPanel> playerCards;

	private JLabel logoLabel;
	private JLabel nameLabel;
	private JLabel coachLabel;
	private JLabel membersLabel;
	private JLabel playersLabel;
	private JLabel scoreLabel;
	private JLabel rankingLabel;
	
	private JTextArea descriptionTextArea;

	
	public TeamDetailPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.decode(Colors.LIGHT_GRAY));  
		setBorder(new EmptyBorder(20, 20, 20, 20));

		initializeComponents();
	}

	private void initializeComponents() {
		logoPanel = new JPanel();
		logoPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

		ImageIcon teamIcon = loadIcon(AssetPaths.TEAM_ICON, 90, 90);
		logoLabel = new JLabel(teamIcon);
		logoPanel.add(logoLabel);

		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		
		nameLabel = new JLabel("Team Name");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
		nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		nameLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		infoPanel.add(nameLabel);

		coachLabel = new JLabel("Coach: ");
		coachLabel.setFont(new Font("Arial", Font.ITALIC, 16));
		coachLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		coachLabel.setBorder(new EmptyBorder(2, 2, 2, 2));
		infoPanel.add(coachLabel); 

		membersLabel = new JLabel("Members: 5");
		membersLabel.setFont(new Font("Arial", Font.ITALIC, 16));
		membersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		membersLabel.setBorder(new EmptyBorder(2, 2, 2, 2));
		infoPanel.add(membersLabel); 

		scoreLabel = new JLabel("Score: ");
		scoreLabel.setFont(new Font("Arial", Font.ITALIC, 16));
		scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		scoreLabel.setBorder(new EmptyBorder(2, 2, 2, 2));
		infoPanel.add(scoreLabel); 
		
		rankingLabel = new JLabel("Ranking: ");
		rankingLabel.setFont(new Font("Arial", Font.ITALIC, 16));
		rankingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		rankingLabel.setBorder(new EmptyBorder(2, 2, 20, 2));
		infoPanel.add(rankingLabel); 

		descriptionTextArea = new JTextArea();
		descriptionTextArea.setText("");
		descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
		descriptionTextArea.setWrapStyleWord(true); 
		descriptionTextArea.setLineWrap(true); 
		descriptionTextArea.setOpaque(false);  
		descriptionTextArea.setEditable(false);  
			
		playerCards = new ArrayList<>();
		
		playersLabel = new JLabel("Players: ");
		playersLabel.setFont(new Font("Arial", Font.BOLD, 20));
		playersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		playersLabel.setBorder(new EmptyBorder(20, 0, 20, 0));
		infoPanel.add(playersLabel);

		add(logoPanel, BorderLayout.NORTH);
		add(infoPanel, BorderLayout.CENTER);
	}

	public ImageIcon loadIcon(String imagePath, int width, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}

	public void renderTeamDetail(TeamDTO teamDTO) {
		int totalPlayers = teamDTO.getPlayerIds() != null ? teamDTO.getPlayerIds().size() : 0;
		
		nameLabel.setText(teamDTO.getName());
		coachLabel.setText("Coach: " + teamDTO.getCoachName());
		descriptionTextArea.setText(teamDTO.getDescription());
		scoreLabel.setText("Score: " + teamDTO.getScore());
		rankingLabel.setText("Ranking: " + teamDTO.getRanking());
		membersLabel.setText("Members: " + totalPlayers);

		playerCards.clear();
		playerListPanel = new JPanel();
		playerListPanel.setLayout(new GridLayout(0, 2, 10, 10));
		
		if (teamDTO.getPlayerIds() != null && !teamDTO.getPlayerIds().isEmpty()) {
			for (PlayerDTO playerDTO : teamDTO.getPlayers()) {
				PlayerCardPanel card = new PlayerCardPanel();
				card.getNameLabel().setText(playerDTO.getFirstName() + playerDTO.getLastName());
				card.getTeamLabel().setText("Team: " + teamDTO.getName());
				card.getCountryLabel().setText("Country: " + playerDTO.getCountry());
				card.getCityLabel().setText("City: " + playerDTO.getCity());
				card.getAgeLabel().setText("City: " + playerDTO.getAge());
			    card.getExperienceLevelLabel().setText("Experience level: " + playerDTO.getExperienceLevel());
				
				playerCards.add(card);
				playerListPanel.add(card);
			}
			
	        scrollPanel = new JScrollPane(playerListPanel);
	        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
	        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
	        infoPanel.add(scrollPanel);
		}
		
		repaintView();
	}

	public void repaintView() {
		revalidate();
		repaint();  
	}
	
	public JPanel getPlayerLabelPanel() {
		return playerLabelPanel;
	}

	public void setPlayerLabelPanel(JPanel playerLabelPanel) {
		this.playerLabelPanel = playerLabelPanel;
	}

	public JPanel getLogoPanel() {
		return logoPanel;
	}

	public void setLogoPanel(JPanel logoPanel) {
		this.logoPanel = logoPanel;
	}

	public JPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(JPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	public JPanel getPlayerListPanel() {
		return playerListPanel;
	}

	public void setPlayerListPanel(JPanel playerListPanel) {
		this.playerListPanel = playerListPanel;
	}

	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}

	public void setScrollPanel(JScrollPane scrollPanel) {
		this.scrollPanel = scrollPanel;
	}

	public List<PlayerCardPanel> getPlayerCards() {
		return playerCards;
	}

	public void setPlayerCards(List<PlayerCardPanel> playerCards) {
		this.playerCards = playerCards;
	}

	public JLabel getLogoLabel() {
		return logoLabel;
	}

	public void setLogoLabel(JLabel logoLabel) {
		this.logoLabel = logoLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getCoachLabel() {
		return coachLabel;
	}

	public void setCoachLabel(JLabel coachLabel) {
		this.coachLabel = coachLabel;
	}

	public JLabel getMembersLabel() {
		return membersLabel;
	}

	public void setMembersLabel(JLabel membersLabel) {
		this.membersLabel = membersLabel;
	}

	public JLabel getPlayersLabel() {
		return playersLabel;
	}

	public void setPlayersLabel(JLabel playersLabel) {
		this.playersLabel = playersLabel;
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}

	public JLabel getRankingLabel() {
		return rankingLabel;
	}

	public void setRankingLabel(JLabel rankingLabel) {
		this.rankingLabel = rankingLabel;
	}

	public JTextArea getDescriptionTextArea() {
		return descriptionTextArea;
	}

	public void setDescriptionTextArea(JTextArea descriptionTextArea) {
		this.descriptionTextArea = descriptionTextArea;
	}



}
