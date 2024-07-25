package Graphics;

import Animals.Animal;
import Animals.Whale;
import Animals.Dolphin;
import Animals.Alligator;
import Animals.Cat;
import Animals.Dog;
import Animals.Eagle;
import Animals.Pigeon;
import Animals.Snake;
import Mobility.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompetitionPanel extends JPanel {
    private BufferedImage backgroundImage;
    private JButton[] routeButtons;
    private String[] competitionsArray = {"Air", "Water", "Terrestrial"};
    private List<Animal> animals = new ArrayList<>();
    private List<Animal> removedAnimals = new ArrayList<>(); // רשימה לשמירת החיות שנמחקו

    public CompetitionPanel() {
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\competitionBackground.png"));
        } catch (IOException e) {
            System.out.println("Error loading background image: " + e.getMessage());
        }

        setLayout(new BorderLayout());

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
                for (Animal animal : animals) {
                    animal.drawObject(g);
                }
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setOpaque(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        String[] routeNames = {"Add Competition", "Add Animal", "Clear", "Eat", "Info", "Exit"};
        routeButtons = new JButton[routeNames.length];
        int sumEnergy=0;
        for (int i = 0; i < routeNames.length; i++) {
            routeButtons[i] = new JButton(routeNames[i]);
            gbc.gridx = i;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            buttonPanel.add(routeButtons[i], gbc);

            switch (routeNames[i]) {
                case "Add Competition":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            AddCompetitionDialog dialog = new AddCompetitionDialog();
                            dialog.setVisible(true);
                            String competitionType = dialog.getCompetitionType();
                            if (competitionType != null && !competitionType.isEmpty()) {
                                // Handle the competition addition here if needed
                                JOptionPane.showMessageDialog(CompetitionPanel.this,
                                        "Competition added: " + competitionType,
                                        "Competition Added",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                    break;
                case "Add Animal":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            AddAnimalDialog dialog = new AddAnimalDialog((Frame) SwingUtilities.getWindowAncestor(CompetitionPanel.this));
                            dialog.setVisible(true);
                            if (dialog.isConfirmed()) {
                                try {
                                    String animalType = dialog.getAnimalType();
                                    String competitionType = dialog.getCompetitionType();
                                    if (!isValidCompetitionTypeForAnimal(animalType, competitionType)) {
                                        throw new Exception("The selected animal cannot participate in the chosen competition type.");
                                    } else {
                                        // Handle valid animal addition here
                                        Animal animal = createAnimalFromDialog(dialog);
                                        animals.add(animal);
                                        JOptionPane.showMessageDialog(CompetitionPanel.this,
                                                "Animal added: " + animalType + " for " + competitionType + " competition",
                                                "Animal Added",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        repaint(); // עדכון המסך לאחר הוספת החיה
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(
                                            CompetitionPanel.this,
                                            ex.getMessage(),
                                            "Invalid Data",
                                            JOptionPane.ERROR_MESSAGE
                                    );
                                }
                            }
                        }
                    });
                    break;

                case "Clear":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!animals.isEmpty()) {
                                Animal selectedAnimal = selectAnimal();
                                if (selectedAnimal != null) {
                                    animals.remove(selectedAnimal);
                                    removedAnimals.add(selectedAnimal); // הוספת החיה לרשימת החיות שנמחקו
                                    JOptionPane.showMessageDialog(CompetitionPanel.this,
                                            "Animal removed: " + selectedAnimal.getName(),
                                            "Animal Removed",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    repaint(); // עדכון המסך לאחר הסרת החיה
                                }
                            } else {
                                JOptionPane.showMessageDialog(CompetitionPanel.this,
                                        "No animals to remove.",
                                        "No Animals",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                    break;
                case "Eat":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!animals.isEmpty()) {
                                Animal selectedAnimal = selectAnimal();
                                if (selectedAnimal != null) {
                                    String input = JOptionPane.showInputDialog(CompetitionPanel.this,
                                            "Enter amount of food:",
                                            "Eat",
                                            JOptionPane.QUESTION_MESSAGE);
                                    if (input != null && !input.isEmpty()) {
                                        try {
                                            int amount = Integer.parseInt(input);
                                            if (selectedAnimal.eat(amount)) {
                                                JOptionPane.showMessageDialog(CompetitionPanel.this,
                                                        "Animal ate " + amount + " units of food. Current energy: " + selectedAnimal.getEnergyAmount(),
                                                        "Eating",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(CompetitionPanel.this,
                                                        "Animal cannot eat that amount of food.",
                                                        "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                            }
                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(CompetitionPanel.this,
                                                    "Invalid input. Please enter a number.",
                                                    "Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(CompetitionPanel.this,
                                        "No animals to feed.",
                                        "No Animals",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                    break;

                case "Info":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!animals.isEmpty() || !removedAnimals.isEmpty()) { // בדיקה אם יש חיות ברשימה הראשית או ברשימת החיות שנמחקו
                                String[] columnNames = {"Animal", "Category", "Type", "Speed", "Energy Amount", "Distance", "Energy Consumption"};
                                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                                for (Animal animal : animals) {
                                    model.addRow(new Object[]{animal.getName(), animal.getCategory(), animal.getClass().getSimpleName(), animal.getSpeed(),
                                            animal.getEnergyAmount(), animal.getTotalDistance(), animal.getSumEnergy()});
                                }
                                for (Animal animal : removedAnimals) { // הוספת החיות שנמחקו לטבלה
                                    model.addRow(new Object[]{animal.getName(), animal.getCategory(), animal.getClass().getSimpleName(), animal.getSpeed(),
                                            animal.getEnergyAmount(), animal.getTotalDistance(), animal.getSumEnergy()});
                                }
                                JTable table = new JTable(model);
                                JScrollPane scrollPane = new JScrollPane(table);
                                JFrame infoFrame = new JFrame("Animal Info");
                                infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                infoFrame.add(scrollPane);
                                infoFrame.setSize(600, 400);
                                infoFrame.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(CompetitionPanel.this,
                                        "No animals to display.",
                                        "No Animals",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                    break;
                case "Exit":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int confirm = JOptionPane.showConfirmDialog(CompetitionPanel.this,
                                    "Are you sure you want to exit?",
                                    "Exit Confirmation",
                                    JOptionPane.YES_NO_OPTION);
                            if (confirm == JOptionPane.YES_OPTION) {
                                System.exit(0);
                            }
                        }
                    });
                    break;
            }
        }

        JPanel overlayPanel = new JPanel(new BorderLayout());
        overlayPanel.add(buttonPanel, BorderLayout.SOUTH);

        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Exit");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(CompetitionPanel.this,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        JMenu menu1 = new JMenu("Help");
        JMenuItem menuItem1 = new JMenuItem("Help");
        menu1.add(menuItem1);
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        CompetitionPanel.this,
                        "Home Work 2\n GUI",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        menuBar.add(menu1);

        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.add(menuBar, BorderLayout.NORTH);

        add(menuPanel, BorderLayout.NORTH);
        add(backgroundPanel, BorderLayout.CENTER);
        add(overlayPanel, BorderLayout.SOUTH);
    }

    private boolean isValidCompetitionTypeForAnimal(String animalType, String competitionType) {
        for (String competition : competitionsArray) {
            if (competition.equals(competitionType)) {
                switch (animalType) {
                    case "Dog":
                    case "Cat":
                    case "Snake":
                    case "Alligator":
                        return competition.equals("Terrestrial");
                    case "Eagle":
                    case "Pigeon":
                        return competition.equals("Air");
                    case "Whale":
                    case "Dolphin":
                        return competition.equals("Water");
                    default:
                        return false;
                }
            }
        }
        return false;
    }

    private Animal selectAnimal() {
        if (animals.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No animals available.", "No Animals", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }

        String[] animalNames = animals.stream().map(Animal::getName).toArray(String[]::new);
        String selectedName = (String) JOptionPane.showInputDialog(this, "Select an animal:", "Select Animal",
                JOptionPane.QUESTION_MESSAGE, null, animalNames, animalNames[0]);

        if (selectedName != null) {
            for (Animal animal : animals) {
                if (animal.getName().equals(selectedName)) {
                    return animal;
                }
            }
        }
        return null;
    }

    private Animal createAnimalFromDialog(AddAnimalDialog dialog) {
        try {
            String name = dialog.getNameField().getText();
            Animal.Gender gender = Animal.Gender.valueOf(dialog.getGenderComboBox().getSelectedItem().toString().toUpperCase());
            double weight = Double.parseDouble(dialog.getWeightField().getText());
            double speed = Double.parseDouble(dialog.getSpeedField().getText());
            Point location = new Point(0, 0); // You might want to get this from the dialog or set it differently
            Animal.Orientation orientation = Animal.Orientation.valueOf(dialog.getDirectionComboBox().getSelectedItem().toString().toUpperCase());
            int size = Integer.parseInt(dialog.getSizeField().getText());
            int id = Integer.parseInt(dialog.getIdField().getText());
            int maxEnergy = Integer.parseInt(dialog.getMaxEnergyField().getText());
            int energyPerMeter = Integer.parseInt(dialog.getEnergyPerMeterField().getText());
            CompetitionPanel pan = this;
            BufferedImage img1 = null; // You might want to load an image based on the animal type

            String animalType = dialog.getAnimalType();
            switch (animalType) {
                case "Dog":
                    String breed = dialog.getBreedField().getText();
                    int noLegs = Integer.parseInt(dialog.getNumberOfLegsField().getText());
                    return new Dog(name, gender, weight, speed, null, location,null ,orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs, breed);
                case "Cat":
                    boolean castrated = dialog.getCastratedComboBox().getSelectedItem().toString().equalsIgnoreCase("Yes");
                    noLegs = Integer.parseInt(dialog.getNumberOfLegsField().getText());
                    return new Cat(name, gender, weight, speed, null, location,null ,orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs, castrated);
                case "Snake":
                    Snake.PoisonousLevel venomLevel = Snake.PoisonousLevel.valueOf(dialog.getVenomLevelComboBox().getSelectedItem().toString());
                    double length = Double.parseDouble(dialog.getLengthField().getText());
                    return new Snake(name, gender, weight, speed, null, location, null,orientation, size, id, maxEnergy, energyPerMeter, pan, img1,0 ,length,venomLevel);
                case "Eagle":
                    double altitudeOfFlight = Double.parseDouble(dialog.getAltitudeOfFlightField().getText());
                    double wingSpan = Double.parseDouble(dialog.getWingSpanField().getText());
                    return new Eagle(name, gender, weight, speed, null, location, null,orientation, size, id, maxEnergy, energyPerMeter, pan, img1, altitudeOfFlight, wingSpan);
                case "Pigeon":
                    String family = dialog.getFamilyField().getText();
                    wingSpan = Double.parseDouble(dialog.getWingSpanField().getText());
                    return new Pigeon(name, gender, weight, speed, null, location, null,orientation, size, id, maxEnergy, energyPerMeter, pan, img1, wingSpan, family);
                case "Alligator":
                    String habitatLocation = dialog.getHabitatLocationField().getText();
                    noLegs = Integer.parseInt(dialog.getNumberOfLegsField().getText());
                    return new Alligator(name, gender, weight, speed, null, location, null,orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs, habitatLocation);
                case "Whale":
                    String foodType = dialog.getFoodTypeField().getText();
                    double divingDepth = Double.parseDouble(dialog.getDivingDepthField().getText());
                    return new Whale(name, gender, weight, speed, null, location, null,orientation, size, id, maxEnergy, energyPerMeter, pan, img1, divingDepth, foodType);
                case "Dolphin":
                    Dolphin.WaterType waterType = Dolphin.WaterType.valueOf(dialog.getWaterTypeComboBox().getSelectedItem().toString());
                    divingDepth = Double.parseDouble(dialog.getDivingDepthField().getText());
                    return new Dolphin(name, gender, weight, speed, null, location, null,orientation, size, id, maxEnergy, energyPerMeter, pan, img1, divingDepth, waterType);
                default:
                    throw new IllegalArgumentException("Invalid animal type!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error creating animal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
