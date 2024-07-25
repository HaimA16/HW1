package Animals;

import Graphics.*;
import Mobility.ILocatable;
import Mobility.Mobile;
import Olympics.Medal;
import Mobility.Point;
import javax.xml.stream.Location;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * Abstract class representing an Animal, extending the Mobile class.
 */
public abstract class Animal extends Mobile implements ILocatable, IMoveable, IDrawable, IClonable  {

    public Object getName() {
        return name;
    }

    public Object getEnergyAmount() {
        return energyPerMeter;
    }

    public Object getEnergyConsumption() {
        return maxEnergy;
    }

    /**
     * Enum representing the gender of the animal.
     */
    public enum Gender { MALE, FEMALE, HERMAPHRODITE }
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
    private int maxEnergy;
    private int energyPerMeter;
    private CompetitionPanel pan;
    private BufferedImage img1, img2, img3, img4;

    public Animal(){
        name = null;
        gender = null;
        weight = 0;
        speed = 0;
        medals = null;
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
    public Animal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location,
                  Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                  BufferedImage img1) {
        super(location);
        if (name == null || gender == null || weight <= 0 || speed <= 0 || orientation == null || location == null || loc == null) {
            throw new IllegalArgumentException("Invalid animal value!");
        }
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.speed = speed;
        this.medals = new Medal[medals.length];
        for (int i = 0; i < medals.length; i++) {
            if (medals[i] == null) {
                throw new IllegalArgumentException("Medal cannot be null!");
            }
            this.medals[i] = medals[i];
        }
        this.loc = loc;
        this.orientation = orientation;
        this.size = size;
        this.id = id;
        this.maxEnergy = maxEnergy;
        this.energyPerMeter = energyPerMeter;
        this.pan = pan;
        this.img1 = img1;

    }

    // Getter and Setter for size
    public int getSize() {
        return size;
    }

    public boolean setSize(int size) {
        if (size > 0) {
            this.size = size;
            return true;
        }
        return false;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public boolean setId(int id) {
        if (id > 0) {
            this.id = id;
            return true;
        }
        return false;
    }

    // Getter and Setter for loc
    public Location getLoc() {
        return loc;
    }

    public boolean setLoc(Location loc) {
        if (loc != null) {
            this.loc = loc;
            return true;
        }
        return false;
    }

    // Getter and Setter for orientation
    public Orientation getOrientation() {
        return orientation;
    }

    public boolean setOrientation(Orientation orientation) {
        if (orientation != null) {
            this.orientation = orientation;
            return true;
        }
        return false;
    }

    // Getter and Setter for maxEnergy
    public int getMaxEnergy() {
        return maxEnergy;
    }

    public boolean setMaxEnergy(int maxEnergy) {
        if (maxEnergy > 0) {
            this.maxEnergy = maxEnergy;
            return true;
        }
        return false;
    }

    // Getter and Setter for energyPerMeter
    public int getEnergyPerMeter() {
        return energyPerMeter;
    }

    public boolean setEnergyPerMeter(int energyPerMeter) {
        if (energyPerMeter > 0) {
            this.energyPerMeter = energyPerMeter;
            return true;
        }
        return false;
    }

    // Getter and Setter for pan
    public CompetitionPanel getPan() {
        return pan;
    }

    public boolean setPan(CompetitionPanel pan) {
        if (pan != null) {
            this.pan = pan;
            return true;
        }
        return false;
    }

    // Getter and Setter for img1
    public BufferedImage getImg1() {
        return img1;
    }

    public boolean setImg1(BufferedImage img1) {
        if (img1 != null) {
            this.img1 = img1;
            return true;
        }
        return false;
    }

    // Getter and Setter for img2
    public BufferedImage getImg2() {
        return img2;
    }

    public boolean setImg2(BufferedImage img2) {
        if (img2 != null) {
            this.img2 = img2;
            return true;
        }
        return false;
    }

    // Getter and Setter for img3
    public BufferedImage getImg3() {
        return img3;
    }

    public boolean setImg3(BufferedImage img3) {
        if (img3 != null) {
            this.img3 = img3;
            return true;
        }
        return false;
    }

    // Getter and Setter for img4
    public BufferedImage getImg4() {
        return img4;
    }

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

    public double getSpeed() {
        return speed;
    }

    public String getAnimaleName() {
        return name;
    }

    @Override
    public boolean move(Point p) {
        return false;
    }

    /**
     * Gets the speed of the animal.
     *
     * @return the speed of the animal
     */

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