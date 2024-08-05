package Graphics;

import Animals.*;
import Mobility.Point;

import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddCompetitionDialog extends JDialog {
    private JTextField competitionNameField;
    private JRadioButton regularCompetitionRadio;
    private JRadioButton relayCompetitionRadio;
    private JComboBox<String> competitionTypeComboBox;
    private JPanel groupsPanel;
    private List<List<String>> groups;
    private JButton addGroupButton;
    private String selectedCompetitionType;
    private int maxAnimalsPerGroup;
    private CompetitionPanel competitionPanel;
    private boolean competitionTypeSet = false;
    private Map<Animal, Point> initialLocations = new HashMap<>();
    private Map<String, List<Animal>> competitionAnimals = new HashMap<>();

    public AddCompetitionDialog(Frame owner, CompetitionPanel competitionPanel) {
        super(owner, "Add Competition", true);
        this.competitionPanel = competitionPanel;
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
            if (!competitionTypeSet) {
                updateSelectedCompetitionType();
                updateGroupsPanel();
                lockCompetitionType();
            }
        });
        relayCompetitionRadio.addActionListener(e -> {
            if (!competitionTypeSet) {
                updateSelectedCompetitionType();
                updateGroupsPanel();
                lockCompetitionType();
            }
        });
        competitionTypeComboBox.addActionListener(e -> {
            if (!competitionTypeSet) {
                updateSelectedCompetitionType();
                updateGroupsPanel();
            }
        });
        okButton.addActionListener(e -> {
            if (validateInput()) {
                setVisible(false);
            }
        });
        cancelButton.addActionListener(e -> setVisible(false));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void lockCompetitionType() {
        competitionTypeSet = true;
        regularCompetitionRadio.setEnabled(false);
        relayCompetitionRadio.setEnabled(false);
        competitionTypeComboBox.setEnabled(false);
    }

    private void updateSelectedCompetitionType() {
        selectedCompetitionType = (String) competitionTypeComboBox.getSelectedItem();
        updateMaxAnimalsPerGroup();
    }

    private void updateMaxAnimalsPerGroup() {
        if (regularCompetitionRadio.isSelected()) {
            maxAnimalsPerGroup = Integer.MAX_VALUE; // No limit for regular competition
        } else {
            switch (selectedCompetitionType) {
                case "Air":
                case "Water":
                    maxAnimalsPerGroup = 2;
                    break;
                case "Terrestrial":
                    maxAnimalsPerGroup = 4;
                    break;
                default:
                    maxAnimalsPerGroup = 0;
            }
        }
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
            addAnimalButton.setEnabled(regularCompetitionRadio.isSelected() || groups.get(i).size() < maxAnimalsPerGroup);
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

        if (!regularCompetitionRadio.isSelected() && groups.get(groupIndex).size() >= maxAnimalsPerGroup) {
            JOptionPane.showMessageDialog(this,
                    "Maximum number of animals reached for this group in relay competition.",
                    "Group Full",
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

            Animal animal = createAnimalFromDialog(addAnimalDialog);
            if (animal != null) {
                String animalName = addAnimalDialog.getNameField().getText();
                groups.get(groupIndex).add(animalName);

                int route;
                if (regularCompetitionRadio.isSelected()) {
                    route = selectRoute(selectedCompetitionType.equals("Air") ? 5 : 4);
                } else {
                    route = groupIndex + 1; // For relay, use group index as route
                }

                // Update the animal's location based on the route
                Point location;
                if (selectedCompetitionType.equals("Air")) {
                    location = getAirInitialLocation(route);
                } else if (selectedCompetitionType.equals("Water")) {
                    location = getWaterInitialLocation(route);
                } else { // Terrestrial
                    location = new Point(0, route * 100);
                }
                animal.setLocation(location);

                // Add the animal directly to the CompetitionPanel
                competitionPanel.addAnimal(animal, selectedCompetitionType);

                updateGroupsPanel();

                // Force repaint of the CompetitionPanel
                competitionPanel.repaint();
            }
        }
    }


    private Animal createAnimalFromDialog(AddAnimalDialog dialog) {
        try {
            String name = dialog.getNameField().getText();
            Animal.Gender gender = Animal.Gender.valueOf(dialog.getGenderComboBox().getSelectedItem().toString().toUpperCase());
            double weight = Double.parseDouble(dialog.getWeightField().getText());
            double speed = Double.parseDouble(dialog.getSpeedField().getText());
            Point location = getInitialLocation(selectedCompetitionType); // Get initial location based on competition type
            Animal.Orientation orientation = Animal.Orientation.EAST; // Set initial orientation to EAST
            int size = 65; // Set size to 65 pixels
            int id = Integer.parseInt(dialog.getIdField().getText());
            int maxEnergy = Integer.parseInt(dialog.getMaxEnergyField().getText());
            int energyPerMeter = Integer.parseInt(dialog.getEnergyPerMeterField().getText());
            CompetitionPanel pan = this.competitionPanel;
            BufferedImage img1 = null; // You might want to load an image based on the animal type

            String animalType = dialog.getAnimalType();
            Animal animal;
            switch (animalType) {
                case "Dog":
                    String breed = dialog.getBreedField().getText();
                    int noLegs = 4;
                    animal = new Dog(name, gender, weight, speed, null, location, null, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs, breed);
                    break;
                case "Cat":
                    boolean castrated = dialog.getCastratedComboBox().getSelectedItem().toString().equalsIgnoreCase("Yes");
                    noLegs = 4;
                    animal = new Cat(name, gender, weight, speed, null, location, null, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs, castrated);
                    break;
                case "Snake":
                    Snake.PoisonousLevel venomLevel = Snake.PoisonousLevel.valueOf(dialog.getVenomLevelComboBox().getSelectedItem().toString().toUpperCase());
                    double length = Double.parseDouble(dialog.getLengthField().getText());
                    animal = new Snake(name, gender, weight, speed, null, location, null, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, 0, length, venomLevel);
                    break;
                case "Eagle":
                    double altitudeOfFlight = Double.parseDouble(dialog.getAltitudeOfFlightField().getText());
                    double wingSpan = Double.parseDouble(dialog.getWingSpanField().getText());
                    animal = new Eagle(name, gender, weight, speed, null, location, null, Animal.Orientation.EAST, size, id, maxEnergy, energyPerMeter, pan, img1, altitudeOfFlight, wingSpan);
                    break;
                case "Pigeon":
                    String family = dialog.getFamilyField().getText();
                    wingSpan = Double.parseDouble(dialog.getWingSpanField().getText());
                    animal = new Pigeon(name, gender, weight, speed, null, location, null, Animal.Orientation.EAST, size, id, maxEnergy, energyPerMeter, pan, img1, wingSpan, family);
                    break;
                case "Alligator":
                    double divingDepth = Double.parseDouble(dialog.getDivingDepthField().getText());
                    String habitatLocation = dialog.getHabitatLocationField().getText();
                    noLegs = 4;
                    animal = new Alligator(name, gender, weight, speed, null, location, null, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, divingDepth, noLegs, habitatLocation);
                    break;
                case "Whale":
                    String foodType = dialog.getFoodTypeField().getText();
                    divingDepth = Double.parseDouble(dialog.getDivingDepthField().getText());
                    animal = new Whale(name, gender, weight, speed, null, location, null, Animal.Orientation.EAST, size, id, maxEnergy, energyPerMeter, pan, img1, divingDepth, foodType);
                    break;
                case "Dolphin":
                    Dolphin.WaterType waterType = Dolphin.WaterType.valueOf(dialog.getWaterTypeComboBox().getSelectedItem().toString().toUpperCase());
                    divingDepth = Double.parseDouble(dialog.getDivingDepthField().getText());
                    animal = new Dolphin(name, gender, weight, speed, null, location, null, Animal.Orientation.EAST, size, id, maxEnergy, energyPerMeter, pan, img1, divingDepth, waterType);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid animal type!");
            }

            // Save the initial location of the animal
            initialLocations.put(animal, location);


            return animal;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error creating animal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    private Point getInitialLocation(String competitionType) {
        return switch (competitionType) {
            case "Terrestrial" -> new Point(0, 0); // Adjust y-coordinate based on route
            case "Air" -> getAirInitialLocation(selectRoute(5));
            case "Water" -> getWaterInitialLocation(selectRoute(4));
            default -> throw new IllegalArgumentException("Invalid competition type!");
        };
    }
    /**
     * Gets the initial location for an air competition based on the selected route.
     *
     * @param route The selected route.
     * @return The initial location as a Point.
     */

    private Point getAirInitialLocation(int route) {
        int height = getHeight();
        int add = 20;
        int right = 70;
        return switch (route) {
            case 1 -> new Point(right, 0);
            case 2 -> new Point(right, height / 5 + add);
            case 3 -> new Point(right, height / 5 * 2 + add);
            case 4 -> new Point(right, height / 5 * 3 + add);
            case 5 -> new Point(right, height / 5 * 4 + add);
            default -> throw new IllegalArgumentException("Invalid route for Air!");
        };
    }
    /**
     * Gets the initial location for a water competition based on the selected route.
     *
     * @param route The selected route.
     * @return The initial location as a Point.
     */

    private Point getWaterInitialLocation(int route) {
        int height = getHeight();
        int red = 60;
        int right = 70;
        return switch (route) {
            case 1 -> new Point(right, height / 5 - red);
            case 2 -> new Point(right, height / 5 * 2 - red);
            case 3 -> new Point(right, height / 5 * 3 - red);
            case 4 -> new Point(right, height / 5 * 4 - red);
            default -> throw new IllegalArgumentException("Invalid route for Water!");
        };
    }


    private int selectRoute(int max) {
        Integer[] routes = new Integer[max];
        for (int i = 0; i < routes.length; i++) {
            routes[i] = i + 1;
        }

        return (Integer) JOptionPane.showInputDialog(this,
                "Select a route:",
                "Select Route",
                JOptionPane.QUESTION_MESSAGE,
                null,
                routes,
                routes[0]);
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
    public void addAnimalFromCompetitionDialog(Animal animal, String competitionType, int route) {
        if (competitionAnimals.containsKey(competitionType)) {
            List<Animal> animalList = competitionAnimals.get(competitionType);
            animalList.add(animal);

            // Set the animal's location based on the route
            Point location;
            if (competitionType.equals("Air")) {
                location = getAirInitialLocation(route);
            } else if (competitionType.equals("Water")) {
                location = getWaterInitialLocation(route);
            } else {
                location = new Point(0, route * 100); // Adjust for Terrestrial
            }
            animal.setLocation(location);
            initialLocations.put(animal, location);

            repaint();
        }
    }
}
