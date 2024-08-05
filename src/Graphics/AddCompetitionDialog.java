package Graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AddCompetitionDialog extends JDialog {
    private JTextField competitionNameField;
    private JRadioButton regularCompetitionRadio;
    private JRadioButton relayCompetitionRadio;
    private JComboBox<String> competitionTypeComboBox;
    private JPanel groupsPanel;
    private List<List<String>> groups;
    private JButton addGroupButton;
    private String selectedCompetitionType;

    public AddCompetitionDialog(Frame owner) {
        super(owner, "Add Competition", true);
        setSize(700, 600);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Competition Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(new JLabel("Competition Name:"), gbc);
        competitionNameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        contentPanel.add(competitionNameField, gbc);

        // Competition Type
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        contentPanel.add(new JLabel("Competition Type:"), gbc);
        competitionTypeComboBox = new JComboBox<>(new String[]{"Air", "Water", "Terrestrial"});
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        contentPanel.add(competitionTypeComboBox, gbc);

        // Radio Buttons for Regular/Relay
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        regularCompetitionRadio = new JRadioButton("Regular Competition");
        relayCompetitionRadio = new JRadioButton("Relay Competition");
        ButtonGroup competitionGroup = new ButtonGroup();
        competitionGroup.add(regularCompetitionRadio);
        competitionGroup.add(relayCompetitionRadio);
        contentPanel.add(regularCompetitionRadio, gbc);
        gbc.gridx = 1;
        contentPanel.add(relayCompetitionRadio, gbc);

        // Groups Panel
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        groupsPanel = new JPanel(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(groupsPanel);
        contentPanel.add(scrollPane, gbc);

        // Add Group Button
        gbc.gridy = 4;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        addGroupButton = new JButton("Add Group");
        contentPanel.add(addGroupButton, gbc);

        add(contentPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        groups = new ArrayList<>();

        // Action Listeners
        addGroupButton.addActionListener(e -> addGroup());
        regularCompetitionRadio.addActionListener(e -> {
            updateSelectedCompetitionType();
            lockCompetitionType();
            updateGroupsPanel();
        });
        relayCompetitionRadio.addActionListener(e -> {
            updateSelectedCompetitionType();
            lockCompetitionType();
            updateGroupsPanel();
        });
        competitionTypeComboBox.addActionListener(e -> {
            updateSelectedCompetitionType();
            updateGroupsPanel();
        });
        okButton.addActionListener(e -> {
            if (validateInput()) {
                setVisible(false);
            }
        });
        cancelButton.addActionListener(e -> setVisible(false));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void updateSelectedCompetitionType() {
        selectedCompetitionType = (String) competitionTypeComboBox.getSelectedItem();
    }

    private void lockCompetitionType() {
        competitionTypeComboBox.setEnabled(false);
    }

    private void addGroup() {
        if (regularCompetitionRadio.isSelected()) {
            // For regular competition, only one group is allowed
            return;
        }
        List<String> newGroup = new ArrayList<>();
        groups.add(newGroup);
        updateGroupsPanel();
    }

    private void updateGroupsPanel() {
        groupsPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;

        if (regularCompetitionRadio.isSelected()) {
            // For regular competition, ensure there's only one group
            if (groups.isEmpty()) {
                groups.add(new ArrayList<>());
            } else if (groups.size() > 1) {
                groups = new ArrayList<>(groups.subList(0, 1));
            }
            addGroupButton.setEnabled(false);
        } else {
            addGroupButton.setEnabled(true);
        }

        for (int i = 0; i < groups.size(); i++) {
            JPanel groupPanel = new JPanel(new BorderLayout());
            groupPanel.setBorder(BorderFactory.createTitledBorder("Group " + (i + 1)));

            // Create a list for animals
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String animal : groups.get(i)) {
                listModel.addElement(animal);
            }
            JList<String> animalList = new JList<>(listModel);
            JScrollPane listScrollPane = new JScrollPane(animalList);
            groupPanel.add(listScrollPane, BorderLayout.CENTER);

            JButton addAnimalButton = new JButton("Add Animal");
            final int groupIndex = i;
            addAnimalButton.addActionListener(e -> addAnimal(groupIndex));
            groupPanel.add(addAnimalButton, BorderLayout.SOUTH);

            gbc.gridx = i;
            gbc.gridy = 0;
            groupsPanel.add(groupPanel, gbc);
        }

        groupsPanel.revalidate();
        groupsPanel.repaint();
    }

    private void addAnimal(int groupIndex) {
        if (selectedCompetitionType == null) {
            JOptionPane.showMessageDialog(this,
                    "Please select a competition type first.",
                    "No Competition Type",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        AddAnimalDialog addAnimalDialog = new AddAnimalDialog(null);
        addAnimalDialog.setVisible(true);
        if (addAnimalDialog.isConfirmed()) {
            String animalType = addAnimalDialog.getAnimalType();
            if (!isAnimalTypeValidForCompetition(animalType)) {
                JOptionPane.showMessageDialog(this,
                        "This animal type is not valid for " + selectedCompetitionType + " competition.",
                        "Invalid Animal Type",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            String animalName = addAnimalDialog.getNameField().getText();
            groups.get(groupIndex).add(animalName);
            updateGroupsPanel();
        }
    }

    private boolean isAnimalTypeValidForCompetition(String animalType) {
        switch (selectedCompetitionType) {
            case "Air":
                return animalType.equals("Eagle") || animalType.equals("Pigeon");
            case "Water":
                return animalType.equals("Alligator") || animalType.equals("Whale") || animalType.equals("Dolphin");
            case "Terrestrial":
                return animalType.equals("Dog") || animalType.equals("Cat") || animalType.equals("Snake") || animalType.equals("Alligator");
            default:
                return false;
        }
    }

    private boolean validateInput() {
        if (competitionNameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a competition name.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!regularCompetitionRadio.isSelected() && !relayCompetitionRadio.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a competition type (Regular or Relay).", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (selectedCompetitionType == null) {
            JOptionPane.showMessageDialog(this, "Please select a competition type (Air, Water, or Terrestrial).", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (groups.isEmpty() || groups.get(0).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please add at least one animal to the group.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public String getCompetitionName() {
        return competitionNameField.getText();
    }

    public String getCompetitionType() {
        return selectedCompetitionType;
    }

    public boolean isRelayCompetition() {
        return relayCompetitionRadio.isSelected();
    }

    public List<List<String>> getGroups() {
        return groups;
    }
}
