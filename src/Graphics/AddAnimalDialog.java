package Graphics;

import javax.swing.*;

public class AddAnimalDialog extends JDialog {
    public AddAnimalDialog() {
        // Implement dialog creation and display
        setTitle("Add Animal");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getCompetitionType() {
        // Implement logic to return the selected competition type
        return "air"; // Example return value
    }
}
