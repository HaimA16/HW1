package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAnimalDialog extends JDialog {
    private JComboBox<String> animalTypeComboBox;
    private JTextField nameField;
    private JTextField weightField;
    private JTextField speedField;
    private JTextField medalsField;
    private JComboBox<String> genderComboBox;
    private JComboBox<String> competitionTypeComboBox; // תיבת בחירה לסוג תחרות

    // Additional fields for all animals
    private JComboBox<String> directionComboBox;
    private JTextField sizeField;
    private JTextField idField;
    private JTextField maxEnergyField;
    private JTextField energyPerMeterField;

    // Specific fields
    private JTextField breedField; // Dog
    private JComboBox<String> castratedComboBox; // Cat
    private JComboBox<String> venomLevelComboBox; // Snake
    private JTextField habitatLocationField; // Alligator
    private JTextField altitudeOfFlightField; // Eagle
    private JTextField familyField; // Pigeon
    private JComboBox<String> waterTypeComboBox; // Dolphin
    private JTextField foodTypeField; // Whale
    private JTextField divingDepthField; // Water animals
    private JTextField wingSpanField; // Air animals
    private JTextField numberOfLegsField; // Terrestrial animals

    private JPanel specificFieldsPanel;

    public AddAnimalDialog(Frame owner) {
        super(owner, "Add Animal", true);
        setSize(300, 500);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2); // רווחים מינימליים
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Select Animal Type:"), gbc);
        animalTypeComboBox = new JComboBox<>(new String[] {"", "Dog", "Cat", "Snake", "Eagle", "Pigeon", "Alligator", "Whale", "Dolphin"});
        gbc.gridx = 1;
        add(animalTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Name:"), gbc);
        nameField = new JTextField(15);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Weight:"), gbc);
        weightField = new JTextField(15);
        gbc.gridx = 1;
        add(weightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Speed:"), gbc);
        speedField = new JTextField(15);
        gbc.gridx = 1;
        add(speedField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Number of Medals:"), gbc);
        medalsField = new JTextField(15);
        gbc.gridx = 1;
        add(medalsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Gender:"), gbc);
        genderComboBox = new JComboBox<>(new String[] {"Male", "Female"});
        gbc.gridx = 1;
        add(genderComboBox, gbc);

        // תווית ותיבת בחירה לסוג תחרות
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Competition Type:"), gbc);
        competitionTypeComboBox = new JComboBox<>(new String[] {"","Air", "Terrestrial", "Water"});
        gbc.gridx = 1;
        add(competitionTypeComboBox, gbc);

        // Additional fields for all animals
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Direction:"), gbc);
        directionComboBox = new JComboBox<>(new String[] {"", "North", "South", "East", "West"});
        gbc.gridx = 1;
        add(directionComboBox, gbc);

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

        // Specific fields panel
        specificFieldsPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2; // Make the panel span two columns
        add(specificFieldsPanel, gbc);

        animalTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAnimalType = (String) animalTypeComboBox.getSelectedItem();
                showSpecificFields(selectedAnimalType);
            }
        });

        competitionTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateAnimalAndCompetitionType();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(AddAnimalDialog.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateAnimalAndCompetitionType();
                    setVisible(false);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(AddAnimalDialog.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(addButton);

        JButton closeButton = new JButton("CLOSE");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        buttonPanel.add(closeButton);

        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);
    }

    private void showSpecificFields(String animalType) {
        // Remove all components from the specific fields panel
        specificFieldsPanel.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2); // רווחים מינימליים
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        // Add specific fields based on the selected animal type
        switch (animalType) {
            case "Dog":
                if (breedField == null) breedField = new JTextField(15);
                if (numberOfLegsField == null) numberOfLegsField = new JTextField(15);
                specificFieldsPanel.add(new JLabel("Breed:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(breedField, gbc);
                gbc.gridx = 0;
                gbc.gridy++;
                specificFieldsPanel.add(new JLabel("Number of Legs:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(numberOfLegsField, gbc);
                break;
            case "Cat":
                if (castratedComboBox == null) castratedComboBox = new JComboBox<>(new String[] {"","Castrated", "Not Castrated"});
                if (numberOfLegsField == null) numberOfLegsField = new JTextField(15);
                specificFieldsPanel.add(new JLabel("Castrated:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(castratedComboBox, gbc);
                gbc.gridx = 0;
                gbc.gridy++;
                specificFieldsPanel.add(new JLabel("Number of Legs:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(numberOfLegsField, gbc);
                break;
            case "Snake":
                if (venomLevelComboBox == null) venomLevelComboBox = new JComboBox<>(new String[] {"","Low", "Medium", "High"});
                specificFieldsPanel.add(new JLabel("Venom Level:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(venomLevelComboBox, gbc);
                break;
            case "Eagle":
                if (altitudeOfFlightField == null) altitudeOfFlightField = new JTextField(15);
                if (wingSpanField == null) wingSpanField = new JTextField(15);
                specificFieldsPanel.add(new JLabel("Altitude of Flight:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(altitudeOfFlightField, gbc);
                gbc.gridx = 0;
                gbc.gridy++;
                specificFieldsPanel.add(new JLabel("Wing Span:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(wingSpanField, gbc);
                break;
            case "Pigeon":
                if (familyField == null) familyField = new JTextField(15);
                if (wingSpanField == null) wingSpanField = new JTextField(15);
                specificFieldsPanel.add(new JLabel("Family:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(familyField, gbc);
                gbc.gridx = 0;
                gbc.gridy++;
                specificFieldsPanel.add(new JLabel("Wing Span:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(wingSpanField, gbc);
                break;
            case "Alligator":
                if (habitatLocationField == null) habitatLocationField = new JTextField(15);
                if (numberOfLegsField == null) numberOfLegsField = new JTextField(15);
                specificFieldsPanel.add(new JLabel("Area of living:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(habitatLocationField, gbc);
                gbc.gridx = 0;
                gbc.gridy++;
                specificFieldsPanel.add(new JLabel("Number of Legs:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(numberOfLegsField, gbc);
                break;
            case "Whale":
                if (foodTypeField == null) foodTypeField = new JTextField(15);
                if (divingDepthField == null) divingDepthField = new JTextField(15);
                specificFieldsPanel.add(new JLabel("Food Type:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(foodTypeField, gbc);
                gbc.gridx = 0;
                gbc.gridy++;
                specificFieldsPanel.add(new JLabel("Diving Depth:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(divingDepthField, gbc);
                break;
            case "Dolphin":
                if (waterTypeComboBox == null) waterTypeComboBox = new JComboBox<>(new String[] {"","Sea", "Sweet"});
                if (divingDepthField == null) divingDepthField = new JTextField(15);
                specificFieldsPanel.add(new JLabel("Water Type:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(waterTypeComboBox, gbc);
                gbc.gridx = 0;
                gbc.gridy++;
                specificFieldsPanel.add(new JLabel("Diving Depth:"), gbc);
                gbc.gridx = 1;
                specificFieldsPanel.add(divingDepthField, gbc);
                break;
        }

        // Refresh the dialog to show the new specific fields
        specificFieldsPanel.revalidate();
        specificFieldsPanel.repaint();
    }

    private void validateAnimalAndCompetitionType() {
        String animalType = getAnimalType();
        String competitionType = getCompetitionType();

        if ((animalType.equals("Dog") || animalType.equals("Cat") || animalType.equals("Snake") || animalType.equals("Alligator")) && !competitionType.equals("Terrestrial")) {
            throw new IllegalArgumentException("The selected animal type is not suitable for the selected competition type.");
        } else if ((animalType.equals("Eagle") || animalType.equals("Pigeon")) && !competitionType.equals("Air")) {
            throw new IllegalArgumentException("The selected animal type is not suitable for the selected competition type.");
        } else if ((animalType.equals("Whale") || animalType.equals("Dolphin")) && !competitionType.equals("Water")) {
            throw new IllegalArgumentException("The selected animal type is not suitable for the selected competition type.");
        }
    }

    public String getAnimalType() {
        return (String) animalTypeComboBox.getSelectedItem();
    }

    public String getCompetitionType() {
        return (String) competitionTypeComboBox.getSelectedItem();
    }
}
