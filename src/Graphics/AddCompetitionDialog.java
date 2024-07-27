package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompetitionDialog extends JDialog {
    private JComboBox<String> competitionTypeComboBox;
    private JTextField competitionNameField;
    private JTextField distanceField; // שדה להזנת המרחק
    private String selectedCompetitionType;
    private String competitionName;
    private int distance;

    public AddCompetitionDialog() {
        setTitle("Add Competition");
        setSize(300, 250); // הגדלת גודל החלון
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

        competitionTypeComboBox = new JComboBox<>(new String[]{"Air", "Water", "Terrestrial"});
        gbc.gridx = 1;
        contentPanel.add(competitionTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPanel.add(new JLabel("Distance:"), gbc); // תווית להזנת המרחק

        distanceField = new JTextField(15);
        gbc.gridx = 1;
        contentPanel.add(distanceField, gbc);

        add(contentPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCompetitionType = (String) competitionTypeComboBox.getSelectedItem();
                competitionName = competitionNameField.getText();
                try {
                    distance = Integer.parseInt(distanceField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddCompetitionDialog.this, "Please enter a valid distance.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                setVisible(false);
            }
        });
        buttonPanel.add(okButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
    }

    public String getCompetitionType() {
        return selectedCompetitionType;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public int getDistance() {
        return distance;
    }
}
