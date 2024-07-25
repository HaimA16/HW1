package Graphics;

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
                                        Animal animal = new Animal(dialog.getNameField().getText(), animalType, competitionType,
                                                Integer.parseInt(dialog.getSpeedField().getText()), Integer.parseInt(dialog.getMaxEnergyField().getText()));
                                        animals.add(animal);
                                        JOptionPane.showMessageDialog(CompetitionPanel.this,
                                                "Animal added: " + animalType + " for " + competitionType + " competition",
                                                "Animal Added",
                                                JOptionPane.INFORMATION_MESSAGE);
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
                                            selectedAnimal.eat(amount);
                                            JOptionPane.showMessageDialog(CompetitionPanel.this,
                                                    "Animal ate " + amount + " units of food. Current energy: " + selectedAnimal.getEnergyAmount(),
                                                    "Eating",
                                                    JOptionPane.INFORMATION_MESSAGE);
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
                                    model.addRow(new Object[]{animal.getName(), animal.getCategory(), animal.getType(), animal.getSpeed(),
                                            animal.getEnergyAmount(), animal.getDistance(), animal.getEnergyConsumption()});
                                }
                                for (Animal animal : removedAnimals) { // הוספת החיות שנמחקו לטבלה
                                    model.addRow(new Object[]{animal.getName(), animal.getCategory(), animal.getType(), animal.getSpeed(),
                                            animal.getEnergyAmount(), animal.getDistance(), animal.getEnergyConsumption()});
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

    private class Animal {
        private String name;
        private String type;
        private String category;
        private int speed;
        private int maxEnergy;
        private int energyAmount;
        private int distance;
        private int energyConsumption;

        public Animal(String name, String type, String category, int speed, int maxEnergy) {
            this.name = name;
            this.type = type;
            this.category = category;
            this.speed = speed;
            this.maxEnergy = maxEnergy;
            this.energyAmount = maxEnergy;
            this.distance = 0;
            this.energyConsumption = 0;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getCategory() {
            return category;
        }

        public int getSpeed() {
            return speed;
        }

        public int getMaxEnergy() {
            return maxEnergy;
        }

        public int getEnergyAmount() {
            return energyAmount;
        }

        public int getDistance() {
            return distance;
        }

        public int getEnergyConsumption() {
            return energyConsumption;
        }

        public void eat(int amount) {
            energyAmount = Math.min(maxEnergy, energyAmount + amount);
            energyConsumption += amount;
        }
    }
}
