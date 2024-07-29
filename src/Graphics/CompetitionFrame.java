package Graphics;

import javax.swing.*;

public class CompetitionFrame extends JFrame {
    private CompetitionPanel panel;

    public CompetitionFrame() {
        super("Competition");
        panel = new CompetitionPanel();
        add(panel);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 800);
        setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new CompetitionFrame();

    }
}