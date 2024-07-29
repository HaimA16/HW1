package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;
import javax.imageio.ImageIO;
import javax.xml.stream.Location;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Alligator extends WaterAnimal implements IAquaticTerrestrial, IReptile {
    private String areaOfLiving;
    private int noLegs;

    public Alligator(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                     Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                     BufferedImage img1, double diveDepth, int noLegs, String areaOfLiving) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, diveDepth);
        this.noLegs = noLegs;
        this.areaOfLiving = areaOfLiving;
        loadImages("alligator");
    }

    @Override
    public int getNoLegs() {
        return noLegs;
    }

    @Override
    public void setNoLegs(int noLegs) {
        if (noLegs >= 0) {
            this.noLegs = noLegs;
        }
    }

    public String getAreaOfLiving() {
        return areaOfLiving;
    }

    public void setAreaOfLiving(String areaOfLiving) {
        this.areaOfLiving = areaOfLiving;
    }

    @Override
    public String getSound() {
        return "Roar";
    }

    public void loadImages(String nm) {
        try {
            img1 = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\" + File.separator + nm + "E.jpg"));
            img2 = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\" + File.separator + nm + "S.jpg"));
            img3 = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\" + File.separator + nm + "W.jpg"));
            img4 = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\" + File.separator + nm + "N.jpg"));
        } catch (IOException e) {
            System.out.println("Cannot load image for " + nm);
        }
    }

    @Override
    public boolean speedUp(int speeder) {
        double newSpeed = getSpeed() + speeder;
        if (newSpeed < MAX_SPEED) {
            setSpeed(newSpeed);
            return true;
        }
        return false;
    }

    @Override
    public String getCategory() {
        // This method should return a category that reflects both terrestrial and aquatic nature.
        return "Water/Terrestrial";
    }
}
