package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.imageio.ImageIO;
import javax.xml.stream.Location;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pigeon extends AirAnimal{
    private String family;
    public Pigeon(){
        super();
        family = null;
    }
    public Pigeon(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                  Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                  BufferedImage img1, double wingspan, String family) {
        super(name, gender, weight, speed, medals, location,loc,
                orientation, size,  id, maxEnergy, energyPerMeter,  pan,
                img1, wingspan);
        this.family = family;
        loadImages("pigeon");
    }
    public String getSound() {
        return "Arr-rar-rar-rar-raah";
    }

    public void loadImages(String nm) {
        try {
            img1 = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\" + nm + ".png")); // תמונה לכיוון מזרח
        } catch (IOException e) {
            System.out.println("Cannot load image for " + nm);
        }
    }
}