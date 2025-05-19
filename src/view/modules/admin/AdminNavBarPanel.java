package view.modules.admin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.AssetPaths;
import utils.ButtonActionCommands;
import utils.Colors;

public class AdminNavBarPanel extends JPanel {

    private JButton tournamentsButton;
    private JButton teamsButton;
    private JButton playersButton;
    private JButton coachesButton;
    private JButton administratorsButton;
    private JButton matchesButton;
    private JButton gamesButton;

    public AdminNavBarPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.MEDIUM_GRAY));
        initializeComponents();
    }

    private void initializeComponents() {
        tournamentsButton = createButtonWithIcon("Tournaments", AssetPaths.TOURNAMENT_ICON);
        tournamentsButton.setActionCommand(ButtonActionCommands.ADMIN_TOURNAMENT_ACTION_COMMAND);
        add(tournamentsButton);

        teamsButton = createButtonWithIcon("Teams", AssetPaths.TEAM_ICON);
        teamsButton.setActionCommand(ButtonActionCommands.ADMIN_TEAM_ACTION_COMMAND);
        add(teamsButton);

        playersButton = createButtonWithIcon("Players", AssetPaths.USER_ICON);
        playersButton.setActionCommand(ButtonActionCommands.ADMIN_PLAYER_ACTION_COMMAND);
        add(playersButton);

        coachesButton = createButtonWithIcon("Coaches", AssetPaths.COACH_ICON);
        coachesButton.setActionCommand(ButtonActionCommands.ADMIN_COACH_ACTION_COMMAND);
        add(coachesButton);

        administratorsButton = createButtonWithIcon("Administrators", AssetPaths.ADMIN_ICON);
        administratorsButton.setActionCommand(ButtonActionCommands.ADMIN_ADMINISTRATOR_ACTION_COMMAND);
        // add(administratorsButton);

        matchesButton = createButtonWithIcon("Matches", AssetPaths.MATCH_ICON);
        matchesButton.setActionCommand(ButtonActionCommands.ADMIN_MATCH_ACTION_COMMAND);
        // add(matchesButton);

        gamesButton = createButtonWithIcon("Games", AssetPaths.GAME_ICON);
        gamesButton.setActionCommand(ButtonActionCommands.ADMIN_GAME_ACTION_COMMAND);
        // add(gamesButton);
    }

    private JButton createButtonWithIcon(String text, String iconPath) {
        ImageIcon icon = loadIcon(iconPath, 20, 20);
        JButton button = new JButton(text, icon);
        
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(10);
        button.setMaximumSize(new Dimension(180, 40));
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        
        return button;
    }

    private ImageIcon loadIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        if (icon.getIconWidth() > 0 && icon.getIconHeight() > 0) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
        }
        return icon;
    }

    public JButton getTournamentsButton() {
        return tournamentsButton;
    }

    public JButton getTeamsButton() {
        return teamsButton;
    }

    public JButton getPlayersButton() {
        return playersButton;
    }

    public JButton getCoachesButton() {
        return coachesButton;
    }

    public JButton getAdministratorsButton() {
        return administratorsButton;
    }

    public JButton getMatchesButton() {
        return matchesButton;
    }

    public JButton getGamesButton() {
        return gamesButton;
    }
}
