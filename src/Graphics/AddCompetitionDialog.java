/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A dialog for adding a new competition.
 * This dialog allows the user to input the competition name and select the competition type.
 */
public class AddCompetitionDialog extends JDialog {
    private JComboBox<String> competitionTypeComboBox;
    private JTextField competitionNameField;
    private String selectedCompetitionType;
    private String competitionName;

    /**
     * Constructs a new AddCompetitionDialog.
     * Initializes the dialog components and layout.
     */
    public AddCompetitionDialog() {
        setTitle("Add Competition");
        setSize(300, 200); // Adjusted size after removing distance field
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

        add(contentPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCompetitionType = (String) competitionTypeComboBox.getSelectedItem();
                competitionName = competitionNameField.getText();
                setVisible(false);
            }
        });
        buttonPanel.add(okButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
    }

    /**
     * Returns the selected competition type.
     *
     * @return the selected competition type
     */
    public String getCompetitionType() {
        return selectedCompetitionType;
    }

    /**
     * Returns the competition name entered by the user.
     *
     * @return the competition name
     */
    public String getCompetitionName() {
        return competitionName;
    }
}
