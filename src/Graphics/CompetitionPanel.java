package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompetitionPanel extends JPanel {
    private BufferedImage backgroundImage;
    private JButton[] routeButtons;
    private String[] competitionsArray = {"Air", "Water", "Terrestrial"};

    public CompetitionPanel() {
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\competitionBackground.png"));
        } catch (IOException e) {
            System.out.println("Error loading background image");
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
                            String competitionType = dialog.getCompetitionType();
                            if (competitionType != null && !competitionType.isEmpty()) {
                                // Handle the competition addition here if needed
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
                            // Wait for dialog to close
                            int result = JOptionPane.showConfirmDialog(CompetitionPanel.this, dialog, "Add Animal", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                            if (result == JOptionPane.OK_OPTION) {
                                try {
                                    String animalType = dialog.getAnimalType();
                                    String competitionType = dialog.getCompetitionType();
                                    if (!isValidCompetitionTypeForAnimal(animalType, competitionType)) {
                                        throw new Exception("The selected animal cannot participate in the chosen competition type.");
                                    } else {
                                        // Handle valid animal addition here
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
                    // Add action for Clear button
                    break;
                case "Eat":
                    // Add action for Eat button
                    break;
                case "Info":
                    // Add action for Info button
                    break;
                case "Exit":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
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
                System.exit(0);
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
        return false; // Return false if competitionType is not found in the array
    }
}
