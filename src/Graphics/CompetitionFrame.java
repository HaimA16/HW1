package Graphics;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class CompetitionFrame extends JFrame {
    private CompetitionPanel panel;

    public CompetitionFrame() {
        super("Competition");
        panel = new CompetitionPanel();
        add(panel);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new CompetitionFrame();

    }
}
