package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.imageio.ImageIO;
import javax.xml.stream.Location;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Dolphin extends WaterAnimal{
    public enum WaterType { SEA, SWEET }
    WaterType waterType;
    public Dolphin(){
        super();
        waterType = null;
        loadImages("dolphin");
    }
    public Dolphin(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                   Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                   BufferedImage img1, double diveDept, WaterType waterType){
        super(name,gender,weight, speed, medals, location,loc,
                orientation, size, id,maxEnergy, energyPerMeter, pan,
                img1, diveDept);
        this.waterType = waterType;
        loadImages("dolphin");
    }

    @Override
    public String getSound() {
        return "Click-click";
    }

    public void loadImages(String nm) {
        try {
            img1 = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\" + File.separator+ nm + "1.png")); // תמונה לכיוון מזרח
        } catch (IOException e) {
            System.out.println("Cannot load image for " + nm);
        }
    }
}