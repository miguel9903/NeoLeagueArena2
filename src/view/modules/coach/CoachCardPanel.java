package view.modules.coach;

import javax.swing.*;

import co.edu.unbosque.util.AssetPaths;
import co.edu.unbosque.util.Colors;

import java.awt.*;

import view.shared.BaseCardPanel;

public class CoachCardPanel extends BaseCardPanel {

	private JLabel iconLabel;
	private JLabel nameLabel;
	private JLabel teamLabel;
	private JLabel countryLabel;
	private JLabel cityLabel;
	private JLabel ageLabel;
	private JLabel experienceYearsLabel;
	private JButton detailButton;

	@Override
	protected void buildHeader() {
		ImageIcon icon = loadIcon(AssetPaths.USER_ICON, 20, 20);
		iconLabel = new JLabel(icon);

		nameLabel = new JLabel("Coach");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

		headerPanel.add(iconLabel);
		headerPanel.add(nameLabel);
	}

	@Override
	protected void buildInfo() {
		teamLabel = new JLabel("Team: ");
		infoPanel.add(teamLabel);

		countryLabel = new JLabel("Country: ");
		infoPanel.add(countryLabel);

		cityLabel = new JLabel("City: ");
		infoPanel.add(cityLabel);

		ageLabel = new JLabel("Age: ");
		infoPanel.add(ageLabel);
	}

	@Override
	protected void buildFooter() {
		detailButton = new JButton("View Coach");
		detailButton.setForeground(Color.decode(Colors.BLUE_NEON));
		detailButton.setOpaque(false);
		detailButton.setContentAreaFilled(false);
		detailButton.setBorderPainted(false);
		detailButton.setFocusPainted(false);
		detailButton.setFont(new Font("Arial", Font.PLAIN, 12));
		detailButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		footerPanel.add(detailButton);
	}

	// Getters y Setters

	public JLabel getIconLabel() {
		return iconLabel;
	}

	public void setIconLabel(JLabel iconLabel) {
		this.iconLabel = iconLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getTeamLabel() {
		return teamLabel;
	}

	public void setTeamLabel(JLabel teamLabel) {
		this.teamLabel = teamLabel;
	}

	public JLabel getCountryLabel() {
		return countryLabel;
	}

	public void setCountryLabel(JLabel countryLabel) {
		this.countryLabel = countryLabel;
	}

	public JLabel getCityLabel() {
		return cityLabel;
	}

	public void setCityLabel(JLabel cityLabel) {
		this.cityLabel = cityLabel;
	}

	public JLabel getAgeLabel() {
		return ageLabel;
	}

	public void setAgeLabel(JLabel ageLabel) {
		this.ageLabel = ageLabel;
	}

	public JLabel getExperienceYearsLabel() {
		return experienceYearsLabel;
	}

	public void setExperienceYearsLabel(JLabel experienceYearsLabel) {
		this.experienceYearsLabel = experienceYearsLabel;
	}

	public JButton getDetailButton() {
		return detailButton;
	}

	public void setDetailButton(JButton detailButton) {
		this.detailButton = detailButton;
	}
}
