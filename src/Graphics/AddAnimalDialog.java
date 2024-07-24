package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAnimalDialog extends JDialog {
    private JComboBox<String> competitionTypeComboBox;
    private JComboBox<String> animalTypeComboBox;
    private JTextField nameField;
    private JTextField weightField;
    private JTextField speedField;
    private JTextField positionField;
    private JComboBox<String> genderComboBox;
    private JComboBox<String> orientationComboBox;
    private JTextField sizeField;
    private JTextField idField;
    private JTextField maxEnergyField;
    private JTextField energyPerMeterField;

    private String animalType;
    private String competitionType;

    public AddAnimalDialog() {
        setTitle("Add Animal");
        setSize(500, 550);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Select Animal Type:"), gbc);
        animalTypeComboBox = new JComboBox<>(new String[] {"", "Dog", "Cat", "Snake", "Eagle", "Pigeon", "Alligator", "Whale", "Dolphin"});
        gbc.gridx = 1;
        add(animalTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Select Competition Type:"), gbc);
        competitionTypeComboBox = new JComboBox<>(new String[] {"", "Air", "Water", "Terrestrial"});
        gbc.gridx = 1;
        add(competitionTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Name:"), gbc);
        nameField = new JTextField(15);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Weight:"), gbc);
        weightField = new JTextField(15);
        gbc.gridx = 1;
        add(weightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Speed:"), gbc);
        speedField = new JTextField(15);
        gbc.gridx = 1;
        add(speedField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Position:"), gbc);
        positionField = new JTextField(15);
        gbc.gridx = 1;
        add(positionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Gender:"), gbc);
        genderComboBox = new JComboBox<>(new String[] {"", "Male", "Female"});
        gbc.gridx = 1;
        add(genderComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Orientation:"), gbc);
        orientationComboBox = new JComboBox<>(new String[] {"", "North", "South", "East", "West"});
        gbc.gridx = 1;
        add(orientationComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(new JLabel("Size:"), gbc);
        sizeField = new JTextField(15);
        gbc.gridx = 1;
        add(sizeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        add(new JLabel("ID:"), gbc);
        idField = new JTextField(15);
        gbc.gridx = 1;
        add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        add(new JLabel("Max Energy:"), gbc);
        maxEnergyField = new JTextField(15);
        gbc.gridx = 1;
        add(maxEnergyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        add(new JLabel("Energy per Meter:"), gbc);
        energyPerMeterField = new JTextField(15);
        gbc.gridx = 1;
        add(energyPerMeterField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, gbc);

        // Listeners for validation
        animalTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateAnimalAndCompetitionType();
            }
        });

        competitionTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateAnimalAndCompetitionType();
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animalType = (String) animalTypeComboBox.getSelectedItem();
                competitionType = (String) competitionTypeComboBox.getSelectedItem();

                if (!isValidCompetitionTypeForAnimal(animalType, competitionType)) {
                    JOptionPane.showMessageDialog(
                            AddAnimalDialog.this,
                            "The selected animal cannot participate in the chosen competition type.",
                            "Invalid Competition Type",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    // Optionally, collect other animal details
                    setVisible(false);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        pack();
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void validateAnimalAndCompetitionType() {
        String animalType = (String) animalTypeComboBox.getSelectedItem();
        String competitionType = (String) competitionTypeComboBox.getSelectedItem();

        if (animalType.isEmpty() || competitionType.isEmpty()) {
            return; // Don't validate if either field is empty
        }

        if (!isValidCompetitionTypeForAnimal(animalType, competitionType)) {
            JOptionPane.showMessageDialog(
                    AddAnimalDialog.this,
                    "The selected animal cannot participate in the chosen competition type.",
                    "Invalid Competition Type",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getCompetitionType() {
        return competitionType;
    }

    private boolean isValidCompetitionTypeForAnimal(String animalType, String competitionType) {
        switch (animalType) {
            case "Dog":
            case "Cat":
            case "Snake":
                return competitionType.equals("Terrestrial");
            case "Eagle":
            case "Pigeon":
                return competitionType.equals("Air");
            case "Whale":
            case "Dolphin":
                return competitionType.equals("Water");
            default:
                return false;
        }
    }
}
