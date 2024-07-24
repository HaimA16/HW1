package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.xml.stream.Location;
import java.awt.image.BufferedImage;

/**
 * Class representing an Alligator, which is a type of Water Animal.
 * Implements the IReptile and terrestrial_feature interfaces.
 * Includes specific attributes for alligators.
 */
public class Alligator extends WaterAnimal implements IReptile, terrestrial_feature {
    private String areaOfLiving;

    /**
     * Default constructor for Alligator.
     * Initializes the area of living to null.
     */
    public Alligator() {
        super();
        this.areaOfLiving = null;
    }

    /**
     * Constructor for the Alligator class.
     *
     * @param name          the name of the alligator
     * @param gender        the gender of the alligator
     * @param weight        the weight of the alligator
     * @param speed         the speed of the alligator
     * @param medals        an array of medals won by the alligator
     * @param location      the initial location of the alligator

     * @param orientation   the initial orientation of the alligator
     * @param size          the size of the alligator
     * @param id            the id of the alligator
     * @param maxEnergy     the maximum energy of the alligator
     * @param energyPerMeter the energy consumption per meter of the alligator
     * @param pan           the competition panel associated with the alligator
     * @param img1          the first image of the alligator

     * @param diveDept      the dive depth of the alligator
     * @param areaOfLiving  the area of living of the alligator
     */
    public Alligator(String name, Gender gender, double weight, double speed, Medal[] medals, Point location,
                     Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                     BufferedImage img1, double diveDept,
                     String areaOfLiving) {
        super(name, gender, weight,speed,medals, location,
                orientation,size, id,maxEnergy,energyPerMeter,pan,
                img1, diveDept);
        this.areaOfLiving = areaOfLiving;
    }

    /**
     * Gets the sound the alligator makes.
     *
     * @return the sound of the alligator
     */
    @Override
    public String getSound() {
        return "Roar";
    }

    /**
     * Increases the speed of the alligator.
     * Checks if the new speed is less than the maximum allowed speed.
     *
     * @param speeder the amount to increase the speed
     * @return true if the speed was successfully increased, false otherwise
     */
    @Override
    public boolean speedUp(int speeder) {
        double newSpeed = getSpeed() + speeder;
        if (newSpeed <= MAX_SPEED) {
            return setSpeed(newSpeed);
        }
        return false;
    }

    /**
     * Gets the number of legs the alligator has.
     * Alligators typically have 4 legs.
     *
     * @return the number of legs
     */
    @Override
    public int getNoLegs() {
        return 4; // Alligators typically have 4 legs
    }

    /**
     * Gets the area of living of the alligator.
     *
     * @return the area of living
     */
    public String getAreaOfLiving() {
        return areaOfLiving;
    }

    /**
     * Sets the area of living of the alligator.
     *
     * @param areaOfLiving the new area of living
     */
    public void setAreaOfLiving(String areaOfLiving) {
        this.areaOfLiving = areaOfLiving;
    }
}