package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.xml.stream.Location;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Dog extends TerrestrialAnimals {
    private String breed;

    public Dog(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
               Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
               BufferedImage img1, int noLegs, String breed) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs);
        this.breed = breed;
        loadImages("dog"); // טען את התמונות של הכלב
    }

    @Override
    public String getSound() {
        return "Woof Woof";
    }

    @Override
    public void loadImages(String nm) {
        try {
            img1 = ImageIO.read(new File("C:\\Users\\yeuda\\IdeaProjects\\HW1\\src\\graphics2" +File.separator + nm + "2E.png")); // תמונה לכיוון מזרח
            img2 = ImageIO.read(new File("C:\\Users\\yeuda\\IdeaProjects\\HW1\\src\\graphics2" +File.separator + nm + "2S.png")); // תמונה לכיוון דרום
            img3 = ImageIO.read(new File("C:\\Users\\yeuda\\IdeaProjects\\HW1\\src\\graphics2" +File.separator + nm + "2W.png")); // תמונה לכיוון מערב
            img4 = ImageIO.read(new File("C:\\Users\\yeuda\\IdeaProjects\\HW1\\src\\graphics2" +File.separator + nm + "2N.png")); // תמונה לכיוון צפון
        } catch (IOException e) {
            System.out.println("Cannot load image for " + nm);
        }
    }

}
