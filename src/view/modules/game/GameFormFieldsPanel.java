package view.modules.game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

import co.edu.unbosque.model.GameGenre;
import co.edu.unbosque.model.GameMode;
import co.edu.unbosque.model.GamePlatform;

public class GameFormFieldsPanel extends JPanel {

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel logoLabel;
    private JLabel genreLabel;
    private JLabel platformLabel;
    private JLabel modesLabel;

    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextArea descriptionTextArea;
    private JTextField logoTextField;
    private JComboBox<GameGenre> genreComboBox;
    private JComboBox<GamePlatform> platformComboBox;
    private JList<GameMode> modesList;

    public GameFormFieldsPanel() {
        setLayout(new GridLayout(7, 2, 10, 10));
        initializeComponents();
    }

    public void initializeComponents() {
        idLabel = new JLabel("ID* :");
        idTextField = new JTextField();
        idTextField.setEditable(false);
        idTextField.setEnabled(false);
        add(idLabel);
        add(idTextField);

        nameLabel = new JLabel("Name* :");
        nameTextField = new JTextField();
        add(nameLabel);
        add(nameTextField);

        descriptionLabel = new JLabel("Description* :");
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        add(descriptionLabel);
        add(scrollPane);

        logoLabel = new JLabel("Logo URL/Path:");
        logoTextField = new JTextField();
        add(logoLabel);
        add(logoTextField);

        genreLabel = new JLabel("Genre*:");
        genreComboBox = new JComboBox<>(GameGenre.values());
        add(genreLabel);
        add(genreComboBox);

        platformLabel = new JLabel("Platform*:");
        platformComboBox = new JComboBox<>(GamePlatform.values());
        add(platformLabel);
        add(platformComboBox);

        modesLabel = new JLabel("Modes*:");
        DefaultListModel<GameMode> modesModel = new DefaultListModel<>();
        for (GameMode mode : GameMode.values()) {
            modesModel.addElement(mode);
        }
        modesList = new JList<>(modesModel);
        modesList.setVisibleRowCount(3);
        modesList.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane modesScrollPane = new JScrollPane(modesList);
        modesScrollPane.setPreferredSize(new Dimension(200, 60));
        add(modesLabel);
        add(modesScrollPane);
    }
    
    public void selectModes(List<GameMode> selectedModes) {
        if (selectedModes == null) {
            modesList.clearSelection();
            return;
        }

        ListModel<GameMode> model = modesList.getModel();
        List<Integer> indicesToSelect = new ArrayList<>();

        for (int i = 0; i < model.getSize(); i++) {
            GameMode mode = model.getElementAt(i);
            if (selectedModes.contains(mode)) {
                indicesToSelect.add(i);
            }
        }

        int[] indicesArray = new int[indicesToSelect.size()];
        for (int i = 0; i < indicesToSelect.size(); i++) {
            indicesArray[i] = indicesToSelect.get(i);
        }

        modesList.setSelectedIndices(indicesArray);
    }


    public void resetFields() {
        idTextField.setText("");
        nameTextField.setText("");
        descriptionTextArea.setText("");
        logoTextField.setText("");
        genreComboBox.setSelectedIndex(0);
        platformComboBox.setSelectedIndex(0);
        modesList.clearSelection();
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public JTextField getLogoTextField() {
        return logoTextField;
    }

    public JComboBox<GameGenre> getGenreComboBox() {
        return genreComboBox;
    }

    public JComboBox<GamePlatform> getPlatformComboBox() {
        return platformComboBox;
    }

    public JList<GameMode> getModesList() {
        return modesList;
    }
}
