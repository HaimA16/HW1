package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.imageio.ImageIO;
import javax.xml.stream.Location;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Snake extends TerrestrialAnimals implements IReptile{
    public enum PoisonousLevel {LOW,MEDIUM,HIGH}
    private PoisonousLevel poisonousLevel;
    private double length;
    public Snake(){
        super();
        poisonousLevel = PoisonousLevel.LOW;
        length = 0.0;
    }
    public Snake(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                 Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                 BufferedImage img1, int noLegs, double length, PoisonousLevel poisonousLevel){
        super(name, gender, weight, speed, medals, location,loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1,noLegs);
        this.poisonousLevel = poisonousLevel;
        this.length = length;
        loadImages("snake");
    }
    public String getSound() {
        return "sssssss";
    }

    public boolean speedUp(int speeder) {
        return getSpeed() + speeder < MAX_SPEED && setSpeed(speeder);
    }

    public void loadImages(String nm) {
        try {
            img1 = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\" + nm + "1.png")); // תמונה לכיוון מזרח
            img2 = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\" + nm + "2.png")); // תמונה לכיוון דרום
            img3 = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\" + nm + "3.png")); // תמונה לכיוון מערב
        } catch (IOException e) {
            System.out.println("Cannot load image for " + nm);
        }
    }
}
