/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Graphics;
import javax.swing.*;

/**
 * The CompetitionFrame class represents the main frame for the competition application.
 * It sets up the main window and adds the CompetitionPanel to it.
 */
public class CompetitionFrame extends JFrame {
    private CompetitionPanel panel;

    /**
     * Constructs a new CompetitionFrame.
     * Initializes the frame with a title, adds the CompetitionPanel, and sets the default settings for the frame.
     */
    public CompetitionFrame() {
        super("Competition");
        panel = new CompetitionPanel();
        add(panel);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);
        setVisible(true);
    }

    /**
     * The main method to run the CompetitionFrame application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        JFrame frame = new CompetitionFrame();
    }
}
