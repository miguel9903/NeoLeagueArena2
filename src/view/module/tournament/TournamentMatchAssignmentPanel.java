package view.module.tournament;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.enums.MatchStatus;
import model.persistence.dto.TeamDTO;
import model.persistence.dto.TournamentDTO;
import utils.ButtonActionCommands;
import utils.Colors;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

public class TournamentMatchAssignmentPanel extends JPanel {

    private FormHeaderPanel formHeaderPanel;
    private FormFooterPanel formFooterPanel;

    private JPanel matchPanel;

    private JLabel tournamentLabel;
    private JComboBox<String> tournamentComboBox;

    private JLabel teamALabel;
    private JComboBox<String> teamAComboBox;

    private JLabel teamBLabel;
    private JComboBox<String> teamBComboBox;

    private JLabel dateLabel;
    private JTextField dateField;

    private JLabel startTimeLabel;
    private JTextField startTimeField;

    private JLabel endTimeLabel;
    private JTextField endTimeField;

    private JLabel winnerLabel;
    private JComboBox<String> winnerComboBox;

    private JLabel scoreTeamALabel;
    private JTextField scoreTeamAField;

    private JLabel scoreTeamBLabel;
    private JTextField scoreTeamBField;

    private JLabel summaryLabel;
    private JTextArea summaryArea;

    private JLabel statusLabel;
    private JComboBox<String> statusComboBox;

    public TournamentMatchAssignmentPanel() {
        setLayout(new BorderLayout());
        initializeComponents();
        setupFormControls();
    }

    private void initializeComponents() {
        formHeaderPanel = new FormHeaderPanel();
        formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        formFooterPanel = new FormFooterPanel();
        formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        formFooterPanel.setBackground(Color.decode(Colors.MEDIUM_GRAY));

        matchPanel = new JPanel(new GridLayout(14, 2, 10, 10));
        matchPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        tournamentLabel = new JLabel("Tournament:");
        tournamentComboBox = new JComboBox<>();

        teamALabel = new JLabel("Team A:");
        teamAComboBox = new JComboBox<>();

        teamBLabel = new JLabel("Team B:");
        teamBComboBox = new JComboBox<>();

        dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateField = new JTextField();

        startTimeLabel = new JLabel("Start Time (HH:MM):");
        startTimeField = new JTextField();

        endTimeLabel = new JLabel("End Time (HH:MM):");
        endTimeField = new JTextField();

        winnerLabel = new JLabel("Winner:");
        winnerComboBox = new JComboBox<>();
        winnerComboBox.addItem("Select winner");

        scoreTeamALabel = new JLabel("Score Team A:");
        scoreTeamAField = new JTextField();

        scoreTeamBLabel = new JLabel("Score Team B:");
        scoreTeamBField = new JTextField();

        summaryLabel = new JLabel("Match Summary:");
        summaryArea = new JTextArea(3, 20);
        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);

        statusLabel = new JLabel("Status:");
        statusComboBox = new JComboBox<>();
        statusComboBox.addItem("Scheduled");
        statusComboBox.addItem("Ongoing");
        statusComboBox.addItem("Completed");
        statusComboBox.addItem("Cancelled");

        matchPanel.add(tournamentLabel);
        matchPanel.add(tournamentComboBox);
        matchPanel.add(teamALabel);
        matchPanel.add(teamAComboBox);
        matchPanel.add(teamBLabel);
        matchPanel.add(teamBComboBox);
        matchPanel.add(dateLabel);
        matchPanel.add(dateField);
        matchPanel.add(startTimeLabel);
        matchPanel.add(startTimeField);
        matchPanel.add(endTimeLabel);
        matchPanel.add(endTimeField);
        matchPanel.add(winnerLabel);
        matchPanel.add(winnerComboBox);
        matchPanel.add(scoreTeamALabel);
        matchPanel.add(scoreTeamAField);
        matchPanel.add(scoreTeamBLabel);
        matchPanel.add(scoreTeamBField);
        matchPanel.add(summaryLabel);
        matchPanel.add(summaryArea);
        matchPanel.add(statusLabel);
        matchPanel.add(statusComboBox);

        add(formHeaderPanel, BorderLayout.NORTH);
        add(matchPanel, BorderLayout.CENTER);
        add(formFooterPanel, BorderLayout.SOUTH);
    }
    
    public void resetFields() {
        tournamentComboBox.setSelectedIndex(-1);
        teamAComboBox.setSelectedIndex(-1);
        teamBComboBox.setSelectedIndex(-1);
        dateField.setText("");
        startTimeField.setText("");
        endTimeField.setText("");
        winnerComboBox.setSelectedIndex(-1);
        scoreTeamAField.setText("");
        scoreTeamBField.setText("");
        summaryArea.setText("");
        statusComboBox.setSelectedIndex(-1);
    }

    public void setupFormControls() {
        formHeaderPanel.getFormTitleLabel().setText("Manage Matches");
        formHeaderPanel.setSearchButtonText("Search:");
        formHeaderPanel.setSearchButtonActionCommand(ButtonActionCommands.ADMIN_SEARCH_MATCH_ACTION_COMMAND);

        formFooterPanel.setPrimaryButtonText("SAVE MATCH");
        formFooterPanel.setPrimaryButtonActionCommand(ButtonActionCommands.ADMIN_CREATE_MATCH_ACTION_COMMAND);

        formFooterPanel.setSecondaryButtonText("UPDATE MATCH");
        formFooterPanel.setSecondaryButtonActionCommand(ButtonActionCommands.ADMIN_UPDATE_MATCH_ACTION_COMMAND);

        formFooterPanel.removeTertiaryButton();
        formFooterPanel.removeQuaternaryButton();
    }

    public void loadTournamentComboBox(List<TournamentDTO> tournamentsDTO) {
        tournamentComboBox.removeAllItems();
        for (TournamentDTO dto : tournamentsDTO) {
            tournamentComboBox.addItem(dto.getId() + " - " + dto.getName());
        }
    }

    public void loadTeamAComboBox(List<TeamDTO> teamsDTO) {
        teamAComboBox.removeAllItems();
        for (TeamDTO teamDTO : teamsDTO) {
            teamAComboBox.addItem(teamDTO.getId() + " - " + teamDTO.getName());
        }
    }

    public void loadTeamBComboBox(List<TeamDTO> teamsDTO) {
        teamBComboBox.removeAllItems();
        for (TeamDTO teamDTO : teamsDTO) {
            teamBComboBox.addItem(teamDTO.getId() + " - " + teamDTO.getName());
        }
    }

    public void loadWinnerTeamComboBox(List<TeamDTO> teamsDTO) {
        winnerComboBox.removeAllItems();
        for (TeamDTO teamDTO : teamsDTO) {
            winnerComboBox.addItem(teamDTO.getId() + " - " + teamDTO.getName());
        }
    }

    public void loadStatusComboBox(List<MatchStatus> statuses) {
        statusComboBox.removeAllItems();
        for (MatchStatus ms : statuses) {
            statusComboBox.addItem(ms.getDisplayName());
        }
    }

    public Integer getTournamentComboBoxIdValue() {
        String text = (String) tournamentComboBox.getSelectedItem();
        return text != null && text.contains(" - ") ? Integer.parseInt(text.split(" - ")[0]) : null;
    }

    public Integer getTeamAComboBoxIdValue() {
        String text = (String) teamAComboBox.getSelectedItem();
        return text != null && text.contains(" - ") ? Integer.parseInt(text.split(" - ")[0]) : null;
    }

    public Integer getTeamBComboBoxIdValue() {
        String text = (String) teamBComboBox.getSelectedItem();
        return text != null && text.contains(" - ") ? Integer.parseInt(text.split(" - ")[0]) : null;
    }

    public Integer getWinnerComboBoxIdValue() {
        String text = (String) winnerComboBox.getSelectedItem();
        return text != null && text.contains(" - ") ? Integer.parseInt(text.split(" - ")[0]) : null;
    }

    public String getStatusComboBoxSelectedValue() {
        return (String) statusComboBox.getSelectedItem();
    }

	public FormHeaderPanel getFormHeaderPanel() {
		return formHeaderPanel;
	}

	public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
		this.formHeaderPanel = formHeaderPanel;
	}

	public FormFooterPanel getFormFooterPanel() {
		return formFooterPanel;
	}

	public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
		this.formFooterPanel = formFooterPanel;
	}

	public JPanel getMatchPanel() {
		return matchPanel;
	}

	public void setMatchPanel(JPanel matchPanel) {
		this.matchPanel = matchPanel;
	}

	public JLabel getTournamentLabel() {
		return tournamentLabel;
	}

	public void setTournamentLabel(JLabel tournamentLabel) {
		this.tournamentLabel = tournamentLabel;
	}

	public JComboBox<String> getTournamentComboBox() {
		return tournamentComboBox;
	}

	public void setTournamentComboBox(JComboBox<String> tournamentComboBox) {
		this.tournamentComboBox = tournamentComboBox;
	}

	public JLabel getTeamALabel() {
		return teamALabel;
	}

	public void setTeamALabel(JLabel teamALabel) {
		this.teamALabel = teamALabel;
	}

	public JComboBox<String> getTeamAComboBox() {
		return teamAComboBox;
	}

	public void setTeamAComboBox(JComboBox<String> teamAComboBox) {
		this.teamAComboBox = teamAComboBox;
	}

	public JLabel getTeamBLabel() {
		return teamBLabel;
	}

	public void setTeamBLabel(JLabel teamBLabel) {
		this.teamBLabel = teamBLabel;
	}

	public JComboBox<String> getTeamBComboBox() {
		return teamBComboBox;
	}

	public void setTeamBComboBox(JComboBox<String> teamBComboBox) {
		this.teamBComboBox = teamBComboBox;
	}

	public JLabel getDateLabel() {
		return dateLabel;
	}

	public void setDateLabel(JLabel dateLabel) {
		this.dateLabel = dateLabel;
	}

	public JTextField getDateField() {
		return dateField;
	}

	public void setDateField(JTextField dateField) {
		this.dateField = dateField;
	}

	public JLabel getStartTimeLabel() {
		return startTimeLabel;
	}

	public void setStartTimeLabel(JLabel startTimeLabel) {
		this.startTimeLabel = startTimeLabel;
	}

	public JTextField getStartTimeField() {
		return startTimeField;
	}

	public void setStartTimeField(JTextField startTimeField) {
		this.startTimeField = startTimeField;
	}

	public JLabel getEndTimeLabel() {
		return endTimeLabel;
	}

	public void setEndTimeLabel(JLabel endTimeLabel) {
		this.endTimeLabel = endTimeLabel;
	}

	public JTextField getEndTimeField() {
		return endTimeField;
	}

	public void setEndTimeField(JTextField endTimeField) {
		this.endTimeField = endTimeField;
	}

	public JLabel getWinnerLabel() {
		return winnerLabel;
	}

	public void setWinnerLabel(JLabel winnerLabel) {
		this.winnerLabel = winnerLabel;
	}

	public JComboBox<String> getWinnerComboBox() {
		return winnerComboBox;
	}

	public void setWinnerComboBox(JComboBox<String> winnerComboBox) {
		this.winnerComboBox = winnerComboBox;
	}

	public JLabel getScoreTeamALabel() {
		return scoreTeamALabel;
	}

	public void setScoreTeamALabel(JLabel scoreTeamALabel) {
		this.scoreTeamALabel = scoreTeamALabel;
	}

	public JTextField getScoreTeamAField() {
		return scoreTeamAField;
	}

	public void setScoreTeamAField(JTextField scoreTeamAField) {
		this.scoreTeamAField = scoreTeamAField;
	}

	public JLabel getScoreTeamBLabel() {
		return scoreTeamBLabel;
	}

	public void setScoreTeamBLabel(JLabel scoreTeamBLabel) {
		this.scoreTeamBLabel = scoreTeamBLabel;
	}

	public JTextField getScoreTeamBField() {
		return scoreTeamBField;
	}

	public void setScoreTeamBField(JTextField scoreTeamBField) {
		this.scoreTeamBField = scoreTeamBField;
	}

	public JLabel getSummaryLabel() {
		return summaryLabel;
	}

	public void setSummaryLabel(JLabel summaryLabel) {
		this.summaryLabel = summaryLabel;
	}

	public JTextArea getSummaryArea() {
		return summaryArea;
	}

	public void setSummaryArea(JTextArea summaryArea) {
		this.summaryArea = summaryArea;
	}

	public JLabel getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(JLabel statusLabel) {
		this.statusLabel = statusLabel;
	}

	public JComboBox<String> getStatusComboBox() {
		return statusComboBox;
	}

	public void setStatusComboBox(JComboBox<String> statusComboBox) {
		this.statusComboBox = statusComboBox;
	}

    
}
