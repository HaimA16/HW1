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
 * Abstract class representing an air animal.
 */
public abstract class AirAnimal extends Animal {
    private double wingspan;

    /**
     * Default constructor for the AirAnimal class.
     */
    public AirAnimal() {
        super();
        wingspan = 0.0;
    }

    /**
     * Constructor for the AirAnimal class.
     *
     * @param name           the name of the animal
     * @param gender         the gender of the animal
     * @param weight         the weight of the animal
     * @param speed          the speed of the animal
     * @param medals         an array of medals won by the animal
     * @param location       the initial location of the animal
     * @param loc            the location of the animal
     * @param orientation    the initial orientation of the animal
     * @param size           the size of the animal
     * @param id             the id of the animal
     * @param maxEnergy      the maximum energy of the animal
     * @param energyPerMeter the energy consumption per meter of the animal
     * @param pan            the competition panel associated with the animal
     * @param img1           the first image of the animal
     * @param wingspan       the wingspan of the air animal
     */
    public AirAnimal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                     Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                     BufferedImage img1, double wingspan) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1);
        this.wingspan = wingspan;
    }

    /**
     * Gets the wingspan of the air animal.
     *
     * @return the wingspan of the air animal
     */
    public double getWingspan() {
        return wingspan;
    }

    /**
     * Sets the wingspan of the air animal.
     *
     * @param wingspan the new wingspan of the air animal
     * @return true if the wingspan is valid and set, false otherwise
     */
    public boolean setWingspan(double wingspan) {
        if (wingspan > 0) {
            this.wingspan = wingspan;
            return true;
        }
        return false;
    }

    /**
     * Gets the category of the animal.
     *
     * @return the category of the animal
     */
    public String getCategory() {
        return "Air";
    }

    /**
     * Moves the air animal to a new location.
     *
     * @param p the new location point
     * @return true if the animal moved successfully, false otherwise
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
     * Loads images for the AirAnimal.
     *
     * @param nm The name of the image file.
     */
    public void loadImages(String nm) {
        try {
            setImg1(ImageIO.read(new File(PICTURE_PATH + File.separator + nm + "E.jpg")));
        } catch (IOException e) {
            System.out.println("Cannot load image for " + nm);
        }
    }
}