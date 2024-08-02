/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Animals;

import Graphics.*;
import Mobility.ILocatable;
import Mobility.Mobile;
import Olympics.Medal;
import Mobility.Point;
import javax.imageio.ImageIO;
import javax.xml.stream.Location;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Abstract class representing an Animal, extending the Mobile class.
 */
public abstract class Animal extends Mobile implements ILocatable, IMoveable, IDrawable, IClonable, IAnimal {

    /**
     * Enum representing the gender of the animal.
     */
    public enum Gender { MALE, FEMALE, HERMAPHRODITE }

    /**
     * Enum representing the orientation of the animal.
     */
    public enum Orientation {
        NORTH, SOUTH, EAST, WEST
    }

    private final String name;
    private final Gender gender;
    private double weight, speed;
    private Medal[] medals;
    private int size;
    private int id;
    private Location loc;
    private Orientation orientation;
    private int maxEnergy, Energy, sumEnergy;
    private int energyPerMeter;
    private CompetitionPanel pan;
    private BufferedImage img1, img2, img3, img4;


    /**
     * Default constructor for the Animal class.
     */
    public Animal() {
        name = null;
        gender = null;
        weight = 0;
        speed = 0;
        medals = null;
        final String PICTURE_PATH = "";
        loc = null;
        orientation = null;
        size = 0;
        id = 0;
        maxEnergy = 0;
        Energy = 0;
        sumEnergy = 0;
        energyPerMeter = 0;
        pan = null;
        img1 = null;
        img2 = null;
        img3 = null;
        img4 = null;
    }

    /**
     * Constructor for the Animal class.
     *
     * @param name           the name of the animal
     * @param gender         the gender of the animal
     * @param weight         the weight of the animal
     * @param speed          the speed of the animal
     * @param medals         an array of medals won by the animal
     * @param location       the initial location of the animal
     * @param orientation    the initial orientation of the animal
     * @param size           the size of the animal
     * @param id             the id of the animal
     * @param maxEnergy      the maximum energy of the animal
     * @param energyPerMeter the energy consumption per meter of the animal
     * @param pan            the competition panel associated with the animal
     * @param img1           the first image of the animal
     */
    public Animal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                  Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                  BufferedImage img1) {
        super(location);
        if (name == null || gender == null || weight <= 0 || speed <= 0 || orientation == null || location == null) {
            throw new IllegalArgumentException("Invalid animal value!");
        }
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.speed = speed;
        this.medals = null;

        this.loc = loc; // Use the provided location
        this.orientation = orientation;
        this.size = size;
        this.id = id;
        this.maxEnergy = maxEnergy;
        this.energyPerMeter = energyPerMeter;
        this.sumEnergy = 0;
        this.pan = pan;
        this.img1 = img1;
        this.Energy = maxEnergy;
    }

    /**
     * Sets the medals of the animal.
     *
     * @param medals an array of medals
     * @return true if the medals are set, false otherwise
     */
    public boolean setMedals(Medal[] medals) {
        if (medals != null) {
            this.medals = medals;
            return true;
        }
        return false;
    }

    /**
     * Gets the size of the animal.
     *
     * @return the size of the animal
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the animal.
     *
     * @param size the new size of the animal
     * @return true if the size is valid and set, false otherwise
     */
    public boolean setSize(int size) {
        if (size > 0) {
            this.size = size;
            return true;
        }
        return false;
    }

    /**
     * Gets the ID of the animal.
     *
     * @return the ID of the animal
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the animal.
     *
     * @param id the new ID of the animal
     * @return true if the ID is valid and set, false otherwise
     */
    public boolean setId(int id) {
        if (id > 0) {
            this.id = id;
            return true;
        }
        return false;
    }

    /**
     * Gets the location of the animal.
     *
     * @return the location of the animal
     */
    public Location getLoc() {
        return loc;
    }

    /**
     * Sets the location of the animal.
     *
     * @param loc the new location of the animal
     * @return true if the location is valid and set, false otherwise
     */
    public boolean setLoc(Location loc) {
        if (loc != null) {
            this.loc = loc;
            return true;
        }
        return false;
    }

    /**
     * Gets the orientation of the animal.
     *
     * @return the orientation of the animal
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Sets the orientation of the animal.
     *
     * @param orientation the new orientation of the animal
     * @return true if the orientation is valid and set, false otherwise
     */
    public boolean setOrientation(Orientation orientation) {
        if (orientation != null) {
            this.orientation = orientation;
            return true;
        }
        return false;
    }

    /**
     * Gets the maximum energy of the animal.
     *
     * @return the maximum energy of the animal
     */
    public int getMaxEnergy() {
        return maxEnergy;
    }

    /**
     * Sets the maximum energy of the animal.
     *
     * @param maxEnergy the new maximum energy of the animal
     * @return true if the maximum energy is valid and set, false otherwise
     */
    public boolean setMaxEnergy(int maxEnergy) {
        if (maxEnergy > 0) {
            this.maxEnergy = maxEnergy;
            return true;
        }
        return false;
    }

    /**
     * Gets the energy consumption per meter of the animal.
     *
     * @return the energy consumption per meter of the animal
     */
    public int getEnergyPerMeter() {
        return energyPerMeter;
    }

    /**
     * Gets the name of the animal.
     *
     * @return the name of the animal
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the current energy amount of the animal.
     *
     * @return the current energy amount of the animal
     */
    public int getEnergyAmount() {
        return Energy;
    }

    /**
     * Gets the energy consumption of the animal.
     *
     * @return the energy consumption of the animal
     */
    public int getEnergyConsumption() {
        return maxEnergy;
    }

    /**
     * Sets the energy consumption per meter of the animal.
     *
     * @param energyPerMeter the new energy consumption per meter of the animal
     * @return true if the energy consumption per meter is valid and set, false otherwise
     */
    public boolean setEnergyPerMeter(int energyPerMeter) {
        if (energyPerMeter > 0) {
            this.energyPerMeter = energyPerMeter;
            return true;
        }
        return false;
    }

    /**
     * Gets the competition panel associated with the animal.
     *
     * @return the competition panel associated with the animal
     */
    public CompetitionPanel getPan() {
        return pan;
    }

    /**
     * Sets the competition panel associated with the animal.
     *
     * @param pan the new competition panel associated with the animal
     * @return true if the competition panel is valid and set, false otherwise
     */
    public boolean setPan(CompetitionPanel pan) {
        if (pan != null) {
            this.pan = pan;
            return true;
        }
        return false;
    }

    /**
     * Gets the first image of the animal.
     *
     * @return the first image of the animal
     */
    public BufferedImage getImg1() {
        return img1;
    }

    /**
     * Sets the first image of the animal.
     *
     * @param img1 the new first image of the animal
     * @return true if the first image is valid and set, false otherwise
     */
    public boolean setImg1(BufferedImage img1) {
        if (img1 != null) {
            this.img1 = img1;
            return true;
        }
        return false;
    }

    /**
     * Gets the second image of the animal.
     *
     * @return the second image of the animal
     */
    public BufferedImage getImg2() {
        return img2;
    }

    /**
     * Sets the second image of the animal.
     *
     * @param img2 the new second image of the animal
     * @return true if the second image is valid and set, false otherwise
     */
    public boolean setImg2(BufferedImage img2) {
        if (img2 != null) {
            this.img2 = img2;
            return true;
        }
        return false;
    }

    /**
     * Gets the third image of the animal.
     *
     * @return the third image of the animal
     */
    public BufferedImage getImg3() {
        return img3;
    }

    /**
     * Sets the third image of the animal.
     *
     * @param img3 the new third image of the animal
     * @return true if the third image is valid and set, false otherwise
     */
    public boolean setImg3(BufferedImage img3) {
        if (img3 != null) {
            this.img3 = img3;
            return true;
        }
        return false;
    }

    /**
     * Gets the fourth image of the animal.
     *
     * @return the fourth image of the animal
     */
    public BufferedImage getImg4() {
        return img4;
    }

    /**
     * Sets the fourth image of the animal.
     *
     * @param img4 the new fourth image of the animal
     * @return true if the fourth image is valid and set, false otherwise
     */
    public boolean setImg4(BufferedImage img4) {
        if (img4 != null) {
            this.img4 = img4;
            return true;
        }
        return false;
    }

    /**
     * Sets the speed of the animal.
     *
     * @param speed the new speed of the animal
     * @return true if the speed is valid and set, false otherwise
     */
    public boolean setSpeed(double speed) {
        if (speed > 0) {
            this.speed = speed;
            return true;
        }
        return false;
    }

    /**
     * Gets the speed of the animal.
     *
     * @return the speed of the animal
     */
    public int getSpeed() {
        return (int) speed;
    }

    /**
     * Gets the name of the animal.
     *
     * @return the name of the animal
     */
    public String getAnimaleName() {
        return name;
    }

    /**
     * Moves the animal to a new point.
     *
     * @param p the new point to move to
     * @return true if the animal moves successfully, false otherwise
     */
    @Override
    public boolean move(Point p) {
        if (this.Energy <= 0) {
            return false; // Stop moving when energy is depleted
        }

        Point currentLocation = this.getLocation();
        int panelWidth = this.pan.getWidth();
        int panelHeight = this.pan.getHeight();

        switch (this.orientation) {
            case EAST:
                if (currentLocation.getX() + this.speed < panelWidth - this.size) {
                    this.setLocation(new Point(currentLocation.getX() + (int) this.speed, currentLocation.getY()));
                } else {
                    this.orientation = Orientation.SOUTH; // Change direction to SOUTH
                }
                break;
            case SOUTH:
                if (currentLocation.getY() + this.speed < panelHeight - this.size) {
                    this.setLocation(new Point(currentLocation.getX(), currentLocation.getY() + (int) this.speed));
                } else {
                    this.orientation = Orientation.WEST; // Change direction to WEST
                }
                break;
            case WEST:
                if (currentLocation.getX() - this.speed > 0) {
                    this.setLocation(new Point(currentLocation.getX() - (int) this.speed, currentLocation.getY()));
                } else {
                    this.orientation = Orientation.NORTH; // Change direction to NORTH
                }
                break;
            case NORTH:
                if (currentLocation.getY() - this.speed > 0) {
                    this.setLocation(new Point(currentLocation.getX(), currentLocation.getY() - (int) this.speed));
                } else {
                    return false; // Stop moving when reaching the end of the lap
                }
                break;
        }

        return true;
    }

    /**
     * Consumes energy based on the distance traveled.
     *
     * @param distance the distance traveled
     */
    public void consumeEnergy(double distance) {
        double energyConsumed = distance * this.energyPerMeter;
        if (this.Energy >= energyConsumed) {
            this.Energy -= energyConsumed;
        } else {
            this.Energy = 0; // Ensure energy does not go negative
        }
    }

    /**
     * Draws the animal on the given graphics context.
     *
     * @param g the graphics context
     */
    @Override
    public void drawObject(Graphics g) {
        BufferedImage img = null;
        switch (orientation) {
            case EAST:
                img = img1; // Image facing east
                break;
            case SOUTH:
                img = img2; // Image facing south
                break;
            case WEST:
                img = img3; // Image facing west
                break;
            case NORTH:
                img = img4; // Image facing north
                break;
        }
        if (img != null) {
            g.drawImage(img, getLocation().getX(), getLocation().getY() - size / 10, size * 2, size, pan);
        }
    }

    /**
     * Allows the animal to eat and gain energy.
     *
     * @param energy the amount of energy to gain
     * @return true if the animal successfully eats, false otherwise
     */
    @Override
    public boolean eat(int energy) {
        if (energy > 0 && getEnergy() + energy <= getMaxEnergy()) {
            setEnergy(getEnergy() + energy);
            sumEnergy += energy; // Add the consumed energy to sumEnergy
            return true;
        }
        return false;
    }

    /**
     * Gets the total energy consumed by the animal.
     *
     * @return the total energy consumed by the animal
     */
    public int getSumEnergy() {
        return sumEnergy;
    }

    /**
     * Sets the current energy of the animal.
     *
     * @param e the new energy amount
     */
    public void setEnergy(int e) {
        Energy = e;
    }

    /**
     * Gets the current energy of the animal.
     *
     * @return the current energy of the animal
     */
    private int getEnergy() {
        return Energy;
    }

    /**
     * Loads images for the animal based on the given name.
     *
     * @param nm the name of the animal
     */
    public void loadImages(String nm) {
        try {
            img1 = ImageIO.read(new File("path_to_images/" + nm + "_east.png"));
            img2 = ImageIO.read(new File("path_to_images/" + nm + "_south.png"));
            img3 = ImageIO.read(new File("path_to_images/" + nm + "_west.png"));
            img4 = ImageIO.read(new File("path_to_images/" + nm + "_north.png"));
        } catch (IOException e) {
            System.out.println("Cannot load image for " + nm);
        }
    }

    /**
     * Gets the sound of the animal. This method should be overridden by subclasses.
     *
     * @return the sound of the animal
     */
    public String getSound() {
        return null;
    }

    /**
     * Prints the sound of the animal.
     */
    public void makeSound() {
        System.out.println("Animal: " + getClass().getSimpleName() + " said " + getSound());
    }

    /**
     * Gets the category of the animal. This method should be overridden by subclasses.
     *
     * @return the category of the animal
     */
    public String getCategory() {
        return null;
    }

    /**
     * Checks if two animals are equal.
     *
     * @param obj the object to compare with
     * @return true if the animals are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Animal other))
            return false;
        return this.name.equals(other.name) &&
                this.gender == other.gender &&
                this.weight == other.weight &&
                this.speed == other.speed &&
                Arrays.equals(this.medals, other.medals);
    }

    /**
     * Returns a string representation of the animal.
     *
     * @return a string representation of the animal
     */
    @Override
    public String toString() {
        return "Animal: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Weight: " + weight + "\n" +
                "Speed: " + speed + "\n" +
                "Medals: \n" + Arrays.toString(medals) + "\n" +
                "Location: " + loc + "\n" +
                "Orientation: " + orientation + "\n" +
                "Size: " + size + "\n" +
                "ID: " + id + "\n" +
                "Max Energy: " + maxEnergy + "\n" +
                "Energy Per Meter: " + energyPerMeter + "\n" +
                super.toString() + "\n" +
                "****************************************************";
    }
}
