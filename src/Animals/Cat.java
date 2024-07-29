package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.imageio.ImageIO;
import javax.xml.stream.Location;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cat extends TerrestrialAnimals {
    private Boolean castrated;

    public Cat(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
               Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
               BufferedImage img1, int noLegs, Boolean castrated) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs);
        this.castrated = castrated;
        loadImages("cat"); // טען את התמונות של החתול
    }

    @Override
    public String getSound() {
        return "Meow";
    }

    @Override
    public void loadImages(String nm) {
        try {
            String basePath = "C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\";
            img1 = ImageIO.read(new File(basePath+File.separator + nm + "E.jpg")); // תמונה לכיוון מזרח
            img2 = ImageIO.read(new File(basePath+File.separator + nm + "S.png")); // תמונה לכיוון דרום
            img3 = ImageIO.read(new File(basePath+File.separator + nm + "W.png")); // תמונה לכיוון מערב
            img4 = ImageIO.read(new File(basePath+File.separator + nm + "N.png")); // תמונה לכיוון צפון
            System.out.println("Loaded images for " + nm);
        } catch (IOException e) {
            System.out.println("Cannot load image for " + nm);
        }
    }

}

