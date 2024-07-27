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
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CompetitionPanel extends JPanel {
    private BufferedImage backgroundImage;
    private JButton[] routeButtons;
    private String[] competitionsArray = {"Air", "Water", "Terrestrial"};
    private Map<String, List<Animal>> competitionAnimals = new HashMap<>();
    private Map<String, String> competitionNames = new HashMap<>(); // Map to store competition names for each type
    private List<Animal> removedAnimals = new ArrayList<>(); // רשימה לשמירת החיות שנמחקו
    private String selectedCompetitionType; // משתנה לאחסון סוג התחרות שנבחרה

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
                for (List<Animal> animalList : competitionAnimals.values()) {
                    for (Animal animal : animalList) {
                        animal.drawObject(g);
                    }
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

        String[] routeNames = {"Add Competition", "Add Animal", "Clear", "Eat", "Info", "Play", "Exit"};
        routeButtons = new JButton[routeNames.length];
        int sumEnergy = 0;
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
                            selectedCompetitionType = dialog.getCompetitionType();
                            String competitionName = dialog.getCompetitionName();
                            if (selectedCompetitionType != null && !selectedCompetitionType.isEmpty()) {
                                // Initialize the list for the new competition type if not already present
                                competitionAnimals.putIfAbsent(selectedCompetitionType, new ArrayList<>());
                                competitionNames.put(selectedCompetitionType, competitionName); // Save the competition name
                                JOptionPane.showMessageDialog(CompetitionPanel.this,
                                        "Competition added: " + competitionName + " (" + selectedCompetitionType + ")",
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
                            if (selectedCompetitionType == null || selectedCompetitionType.isEmpty()) {
                                JOptionPane.showMessageDialog(CompetitionPanel.this,
                                        "Please add a competition first.",
                                        "No Competition",
                                        JOptionPane.WARNING_MESSAGE);
                                return;
                            }

                            AddAnimalDialog dialog = new AddAnimalDialog((Frame) SwingUtilities.getWindowAncestor(CompetitionPanel.this));
                            dialog.setVisible(true);
                            if (dialog.isConfirmed()) {
                                try {
                                    String animalType = dialog.getAnimalType();
                                    String competitionType = selectedCompetitionType;
                                    if (!isValidCompetitionTypeForAnimal(animalType, competitionType)) {
                                        throw new Exception("The selected animal cannot participate in the chosen competition type.");
                                    } else {
                                        // Handle valid animal addition here
                                        Animal animal = createAnimalFromDialog(dialog);
                                        competitionAnimals.get(competitionType).add(animal);
                                        JOptionPane.showMessageDialog(CompetitionPanel.this,
                                                "Animal added: " + animalType + " for " + competitionNames.get(competitionType) + " (" + competitionType + ") competition",
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
                            if (!competitionAnimals.isEmpty()) {
                                Animal selectedAnimal = selectAnimal();
                                if (selectedAnimal != null) {
                                    for (List<Animal> animalList : competitionAnimals.values()) {
                                        if (animalList.remove(selectedAnimal)) {
                                            removedAnimals.add(selectedAnimal); // הוספת החיה לרשימת החיות שנמחקו
                                            JOptionPane.showMessageDialog(CompetitionPanel.this,
                                                    "Animal removed: " + selectedAnimal.getName(),
                                                    "Animal Removed",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            repaint(); // עדכון המסך לאחר הסרת החיה
                                            break;
                                        }
                                    }
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
                            if (!competitionAnimals.isEmpty()) {
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
                            if (!competitionAnimals.isEmpty() || !removedAnimals.isEmpty()) { // Check if there are animals in the main list or the removed list
                                JPanel infoPanel = new JPanel();
                                infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

                                // Add animals in each competition
                                for (String competitionType : competitionsArray) {
                                    if (competitionAnimals.containsKey(competitionType) && !competitionAnimals.get(competitionType).isEmpty()) {
                                        JLabel competitionLabel = new JLabel("Competition: " + competitionNames.get(competitionType));
                                        competitionLabel.setFont(new Font("Arial", Font.BOLD, 16));
                                        infoPanel.add(competitionLabel);

                                        String[] columnNames = {"Animal", "Category", "Type", "Speed", "Energy Amount", "Distance", "Energy Consumption"};
                                        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                                        for (Animal animal : competitionAnimals.get(competitionType)) {
                                            model.addRow(new Object[]{animal.getName(), animal.getCategory(), animal.getClass().getSimpleName(), animal.getSpeed(),
                                                    animal.getEnergyAmount(), animal.getTotalDistance(), animal.getSumEnergy()});
                                        }
                                        JTable table = new JTable(model);
                                        JScrollPane scrollPane = new JScrollPane(table);
                                        infoPanel.add(scrollPane);
                                    }
                                }

                                // Add removed animals
                                if (!removedAnimals.isEmpty()) {
                                    JLabel removedLabel = new JLabel("Removed Animals");
                                    removedLabel.setFont(new Font("Arial", Font.BOLD, 16));
                                    infoPanel.add(removedLabel);

                                    String[] columnNames = {"Animal", "Category", "Type", "Speed", "Energy Amount", "Distance", "Energy Consumption"};
                                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                                    for (Animal animal : removedAnimals) {
                                        model.addRow(new Object[]{animal.getName(), animal.getCategory(), animal.getClass().getSimpleName(), animal.getSpeed(),
                                                animal.getEnergyAmount(), animal.getTotalDistance(), animal.getSumEnergy()});
                                    }
                                    JTable table = new JTable(model);
                                    JScrollPane scrollPane = new JScrollPane(table);
                                    infoPanel.add(scrollPane);
                                }

                                JFrame infoFrame = new JFrame("Animal Info");
                                infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                infoFrame.add(new JScrollPane(infoPanel));
                                infoFrame.setSize(900, 600);
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

                case "Play":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!competitionAnimals.isEmpty()) {
                                // Open a dialog to select a competition
                                String selectedCompetition = (String) JOptionPane.showInputDialog(
                                        CompetitionPanel.this,
                                        "Select a competition:",
                                        "Select Competition",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        competitionsArray,
                                        competitionsArray[0]
                                );

                                if (selectedCompetition != null && competitionAnimals.containsKey(selectedCompetition)) {
                                    List<Animal> animalsInCompetition = competitionAnimals.get(selectedCompetition);
                                    if (!animalsInCompetition.isEmpty()) {
                                        moveAnimalsToEnd(animalsInCompetition);
                                    } else {
                                        JOptionPane.showMessageDialog(CompetitionPanel.this,
                                                "No animals in the selected competition.",
                                                "No Animals",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(CompetitionPanel.this,
                                            "No competition selected or competition does not exist.",
                                            "Invalid Selection",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(CompetitionPanel.this,
                                        "No competitions available.",
                                        "No Competitions",
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
        List<Animal> allAnimals = new ArrayList<>();
        for (List<Animal> animalList : competitionAnimals.values()) {
            allAnimals.addAll(animalList);
        }

        if (allAnimals.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No animals available.", "No Animals", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }

        String[] animalNames = allAnimals.stream().map(Animal::getName).toArray(String[]::new);
        String selectedName = (String) JOptionPane.showInputDialog(this, "Select an animal:", "Select Animal",
                JOptionPane.QUESTION_MESSAGE, null, animalNames, animalNames[0]);

        if (selectedName != null) {
            for (Animal animal : allAnimals) {
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
            Point location = getInitialLocation(selectedCompetitionType); // Get initial location based on competition type
            Animal.Orientation orientation = Animal.Orientation.EAST; // Set initial orientation to EAST
            int size = 65; // Set size to 65 pixels
            int id = Integer.parseInt(dialog.getIdField().getText());
            int maxEnergy = Integer.parseInt(dialog.getMaxEnergyField().getText());
            int energyPerMeter = Integer.parseInt(dialog.getEnergyPerMeterField().getText());
            CompetitionPanel pan = this;
            BufferedImage img1 = null; // You might want to load an image based on the animal type

            String animalType = dialog.getAnimalType();
            Animal animal;
            switch (animalType) {
                case "Dog":
                    String breed = dialog.getBreedField().getText();
                    int noLegs = Integer.parseInt(dialog.getNumberOfLegsField().getText());
                    animal = new Dog(name, gender, weight, speed, null, location, null, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs, breed);
                    break;
                case "Cat":
                    boolean castrated = dialog.getCastratedComboBox().getSelectedItem().toString().equalsIgnoreCase("Yes");
                    noLegs = Integer.parseInt(dialog.getNumberOfLegsField().getText());
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
                    String habitatLocation = dialog.getHabitatLocationField().getText();
                    noLegs = Integer.parseInt(dialog.getNumberOfLegsField().getText());
                    animal = new Alligator(name, gender, weight, speed, null, location, null, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs, habitatLocation);
                    break;
                case "Whale":
                    String foodType = dialog.getFoodTypeField().getText();
                    double divingDepth = Double.parseDouble(dialog.getDivingDepthField().getText());
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
            return animal;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error creating animal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private Point getInitialLocation(String competitionType) {
        switch (competitionType) {
            case "Terrestrial":
                return new Point(0, selectRoute(1, 5) * 100); // Adjust y-coordinate based on route
            case "Air":
                return new Point(0, selectRoute(1, 5) * 100); // Adjust y-coordinate based on route
            case "Water":
                return new Point(0, selectRoute(1, 4) * 100); // Adjust y-coordinate based on route
            default:
                throw new IllegalArgumentException("Invalid competition type!");
        }
    }

    private int selectRoute(int min, int max) {
        Integer[] routes = new Integer[max - min + 1];
        for (int i = 0; i < routes.length; i++) {
            routes[i] = min + i;
        }
        Integer selectedRoute = (Integer) JOptionPane.showInputDialog(this, "Select a route:", "Select Route",
                JOptionPane.QUESTION_MESSAGE, null, routes, routes[0]);
        if (selectedRoute != null) {
            return selectedRoute;
        } else {
            throw new IllegalArgumentException("No route selected!");
        }
    }

    private void moveAnimalsToEnd(List<Animal> animals) {
        int delay = 100; // milliseconds
        Timer timer = new Timer(delay, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean allAnimalsAtEnd = true;
                for (Animal animal : animals) {
                    Point currentLocation = animal.getLocation();
                    int newX = currentLocation.getX() + (int) animal.getSpeed();
                    if (newX < getWidth() - animal.getSize()) {
                        allAnimalsAtEnd = false;
                    } else {
                        newX = getWidth() - animal.getSize();
                    }
                    animal.setLocation(new Point(newX, currentLocation.getY()));
                }
                repaint();
                if (allAnimalsAtEnd) {
                    timer.stop();
                }
            }
        });
        timer.start();
    }

}

