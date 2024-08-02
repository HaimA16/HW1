package Graphics;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A dialog for adding a new competition.
 * This dialog allows the user to input the competition name and select the competition type.
 */
public class AddCompetitionDialog extends JDialog {
    private JRadioButton relayRaceButton;
    private JRadioButton regularRaceButton;
    private JTextField competitionNameField;
    private JTable animalTable;
    private DefaultTableModel tableModel;
    private String competitionName;
    private boolean isRelayRace;

    /**
     * Constructs a new AddCompetitionDialog.
     * Initializes the dialog components and layout.
     */
    public AddCompetitionDialog() {
        setTitle("Add Competition");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        contentPanel.add(new JLabel("Competition Name:"), gbc);
        competitionNameField = new JTextField(15);
        gbc.gridx = 1;
        contentPanel.add(competitionNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(new JLabel("Select Competition Type:"), gbc);

        relayRaceButton = new JRadioButton("Relay Race");
        regularRaceButton = new JRadioButton("Regular Race");
        ButtonGroup raceTypeGroup = new ButtonGroup();
        raceTypeGroup.add(relayRaceButton);
        raceTypeGroup.add(regularRaceButton);

        JPanel raceTypePanel = new JPanel();
        raceTypePanel.add(relayRaceButton);
        raceTypePanel.add(regularRaceButton);

        gbc.gridx = 1;
        contentPanel.add(raceTypePanel, gbc);

        add(contentPanel, BorderLayout.NORTH);

        // Table for animal groups
        String[] columnNames = {"Group 1", "Group 2", "Group 3"};
        tableModel = new DefaultTableModel(columnNames, 0);
        animalTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(animalTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Animal");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAnimal();
            }
        });
        buttonPanel.add(addButton);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                competitionName = competitionNameField.getText();
                isRelayRace = relayRaceButton.isSelected();
                setVisible(false);
            }
        });
        buttonPanel.add(okButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
    }

    /**
     * Adds a new animal to the selected group.
     */
    private void addAnimal() {
        String animalName = JOptionPane.showInputDialog(this, "Enter animal name:");
        if (animalName != null && !animalName.isEmpty()) {
            int selectedColumn = animalTable.getSelectedColumn();
            if (selectedColumn == -1) {
                selectedColumn = 0;
            }
            tableModel.addRow(new Object[]{animalName, "", ""});
        }
    }

    /**
     * Returns the competition name entered by the user.
     *
     * @return the competition name
     */
    public String getCompetitionName() {
        return competitionName;
    }

    /**
     * Returns whether the competition is a relay race.
     *
     * @return true if the competition is a relay race, false otherwise
     */
    public boolean isRelayRace() {
        return isRelayRace;
    }

    public String getCompetitionType() {
        if (relayRaceButton.isSelected()) {
            return "Relay Race";
        } else {
            return "Regular Race";
        }
    }
}
