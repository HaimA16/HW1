package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAnimalDialog extends JDialog {
    private boolean confirmed = false;
    private JComboBox<String> animalTypeComboBox;
    private JTextField nameField;
    private JTextField weightField;
    private JTextField speedField;
    private JTextField medalsField;
    private JComboBox<String> genderComboBox;
    private JComboBox<String> competitionTypeComboBox; // תיבת בחירה לסוג תחרות


    // Additional fields for all animals
    private JTextField idField;
    private JTextField maxEnergyField;
    private JTextField energyPerMeterField;

    // Specific fields
    private JTextField breedField; // Dog
    private JComboBox<String> castratedComboBox; // Cat
    private JComboBox<String> venomLevelComboBox; // Snake
    private JTextField lengthField; // snake animals
    private JTextField habitatLocationField; // Alligator
    private JTextField altitudeOfFlightField; // Eagle
    private JTextField familyField; // Pigeon
    private JComboBox<String> waterTypeComboBox; // Dolphin
    private JTextField foodTypeField; // Whale
    private JTextField divingDepthField; // Water animals
    private JTextField wingSpanField; // Air animals

    private JPanel specificFieldsPanel;

    public AddAnimalDialog(Frame owner) {
        super(owner, "Add Animal", true);
        setSize(300, 500);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2); // Minimal margins
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
        add(new JLabel("Gender:"), gbc);
        genderComboBox = new JComboBox<>(new String[] {"Male", "Female"});
        gbc.gridx = 1;
        add(genderComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Competition Type:"), gbc);
        competitionTypeComboBox = new JComboBox<>(new String[] {"","Air", "Terrestrial", "Water"});
        gbc.gridx = 1;
        add(competitionTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("ID:"), gbc);
        idField = new JTextField(15);
        gbc.gridx = 1;
        add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Max Energy:"), gbc);
        maxEnergyField = new JTextField(15);
        gbc.gridx = 1;
        add(maxEnergyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(new JLabel("Energy per Meter:"), gbc);
        energyPerMeterField = new JTextField(15);
        gbc.gridx = 1;
        add(energyPerMeterField, gbc);

        specificFieldsPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 9;
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
                if (validateFields()) {
                    try {
                        validateAnimalAndCompetitionType();
                        confirmed = true;
                        setVisible(false);
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(AddAnimalDialog.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        buttonPanel.add(addButton);

        JButton closeButton = new JButton("CLOSE");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = false;
                setVisible(false);
            }
        });
        buttonPanel.add(closeButton);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);
    }

    private void showSpecificFields(String animalType) {
        specificFieldsPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        switch (animalType) {
            case "Dog":
                addSpecificField("Breed:", breedField = new JTextField(15), gbc);
                break;
            case "Cat":
                addSpecificField("Castrated:", castratedComboBox = new JComboBox<>(new String[]{"", "Yes", "No"}), gbc);
                break;
            case "Snake":
                addSpecificField("Venom Level:", venomLevelComboBox = new JComboBox<>(new String[]{"", "Low", "Medium", "High"}), gbc);
                addSpecificField("Length:", lengthField = new JTextField(15), gbc);
                break;
            case "Eagle":
                addSpecificField("Altitude of Flight:", altitudeOfFlightField = new JTextField(15), gbc);
                addSpecificField("Wing Span:", wingSpanField = new JTextField(15), gbc);
                break;
            case "Pigeon":
                addSpecificField("Family:", familyField = new JTextField(15), gbc);
                addSpecificField("Wing Span:", wingSpanField = new JTextField(15), gbc);
                break;
            case "Alligator":
                addSpecificField("Area of living:", habitatLocationField = new JTextField(15), gbc);
                break;
            case "Whale":
                addSpecificField("Food Type:", foodTypeField = new JTextField(15), gbc);
                addSpecificField("Diving Depth:", divingDepthField = new JTextField(15), gbc);
                break;
            case "Dolphin":
                addSpecificField("Water Type:", waterTypeComboBox = new JComboBox<>(new String[]{"", "SEA", "SWEET"}), gbc);
                addSpecificField("Diving Depth:", divingDepthField = new JTextField(15), gbc);
                break;
        }

        specificFieldsPanel.revalidate();
        specificFieldsPanel.repaint();
    }

    private void addSpecificField(String label, JComponent component, GridBagConstraints gbc) {
        specificFieldsPanel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        specificFieldsPanel.add(component, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
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

    private boolean validateFields() {
        try {
            Double.parseDouble(weightField.getText());
            Double.parseDouble(speedField.getText());
            Integer.parseInt(idField.getText());
            Integer.parseInt(maxEnergyField.getText());
            Integer.parseInt(energyPerMeterField.getText());
            if (lengthField != null) {
                Double.parseDouble(lengthField.getText());
            }
            if (altitudeOfFlightField != null) {
                Double.parseDouble(altitudeOfFlightField.getText());
            }
            if (wingSpanField != null) {
                Double.parseDouble(wingSpanField.getText());
            }
            if (divingDepthField != null) {
                Double.parseDouble(divingDepthField.getText());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values in the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getAnimalType() {
        return (String) animalTypeComboBox.getSelectedItem();
    }

    public String getCompetitionType() {
        return (String) competitionTypeComboBox.getSelectedItem();
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getWeightField() {
        return weightField;
    }

    public JTextField getSpeedField() {
        return speedField;
    }

    public JTextField getMedalsField() {
        return medalsField;
    }

    public JComboBox<String> getGenderComboBox() {
        return genderComboBox;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getMaxEnergyField() {
        return maxEnergyField;
    }

    public JTextField getEnergyPerMeterField() {
        return energyPerMeterField;
    }

    public JTextField getBreedField() {
        return breedField;
    }

    public ComboBoxModel<String> getCastratedComboBox() {
        return castratedComboBox.getModel();
    }

    public ComboBoxModel<String> getVenomLevelComboBox() {
        return venomLevelComboBox.getModel();
    }

    public JTextField getAltitudeOfFlightField() {
        return altitudeOfFlightField;
    }

    public JTextField getWingSpanField() {
        return wingSpanField;
    }

    public JTextField getFamilyField() {
        return familyField;
    }

    public JTextField getFoodTypeField() {
        return foodTypeField;
    }

    public JTextField getDivingDepthField() {
        return divingDepthField;
    }

    public ComboBoxModel<String> getWaterTypeComboBox() {
        return waterTypeComboBox.getModel();
    }

    public JTextField getHabitatLocationField() {
        return habitatLocationField;
    }

    public JTextField getLengthField() {
        return lengthField;
    }
}
