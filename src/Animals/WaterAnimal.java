/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Animals;
import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.imageio.ImageIO;
import javax.xml.stream.Location;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Abstract class representing a water animal.
 */
public abstract class WaterAnimal extends Animal {
    private static final int MAX_DIVE = -800;
    private double diveDept;

    /**
     * Default constructor for WaterAnimal.
     */
    public WaterAnimal() {
        super();
        diveDept = 0.0;
    }

    /**
     * Constructor for the WaterAnimal class.
     *
     * @param name           the name of the animal
     * @param gender         the gender of the animal
     * @param weight         the weight of the animal
     * @param speed          the speed of the animal
     * @param medals         an array of medals won by the animal
     * @param location       the initial location of the animal
     * @param loc            the location object (not used in this context)
     * @param orientation    the initial orientation of the animal
     * @param size           the size of the animal
     * @param id             the id of the animal
     * @param maxEnergy      the maximum energy of the animal
     * @param energyPerMeter the energy consumption per meter of the animal
     * @param pan            the competition panel associated with the animal
     * @param img1           the first image of the animal
     * @param diveDept       the dive depth of the water animal
     */
    public WaterAnimal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                       Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                       BufferedImage img1, double diveDept) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1);
        this.diveDept = diveDept;
    }

    /**
     * Simulates the diving of the water animal.
     *
     * @param dive the amount to dive
     * @return the new dive depth of the animal
     */
    public double Dive(double dive) {
        if (Math.abs(dive) > MAX_DIVE && dive > 0 && diveDept + dive > MAX_DIVE) {
            diveDept = diveDept + dive;
        }
        return diveDept;
    }

    /**
     * Gets the category of the animal.
     *
     * @return the category of the animal
     */
    public String getCategory() {
        return "Water";
    }

    /**
     * Gets the dive depth of the animal.
     *
     * @return the dive depth of the animal
     */
    double getDiveDepth() {
        return diveDept;
    }

    /**
     * Moves the water animal to a new location.
     *
     * @param p the new location point
     * @return true if the animal moved successfully, false if it reached the end or energy is depleted
     */
    @Override
    public boolean move(Point p) {
        if (getEnergyAmount() <= 0) {
            return false; // Stop moving if energy is depleted
        }

        Point currentLocation = this.getLocation();
        double distanceToMove = (this.getSpeed() / 50.0) * 10; // Adjust speed factor as needed

        Point newLocation = new Point(currentLocation.getX() + (int) distanceToMove, currentLocation.getY());
        if (newLocation.getX() < this.getPan().getWidth() - this.getSize()) {
            this.setLocation(newLocation);
            return true;
        } else {
            newLocation.setX(this.getPan().getWidth() - this.getSize());
            this.setLocation(newLocation);
            return false;
        }
    }
    /**
     * Loads images for the WaterAnimal.
     *
     * @param nm the name of the image file
     */
    public void loadImages(String nm) {
        try {

            setImg1(ImageIO.read(new File(PICTURE_PATH + File.separator + nm + "E.jpg")));
        } catch (IOException e) {
            System.out.println("Cannot load image for " + nm);
        }
    }
}
