/**
 * Name: Haim Armias 315569061
 * Name: Yeuda Baza 208029819
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing an Alligator, extending the WaterAnimal class and implementing IReptile interface.
 */
public class Alligator extends WaterAnimal implements IReptile {
    private String AreaOfLiving;

    /**
     * Default constructor for the Alligator class.
     */
    public Alligator() {
        super();
        AreaOfLiving = null;
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
     * @param diveDept      the dive depth of the alligator
     * @param AreaOfLiving  the area where the alligator lives
     */
    public Alligator(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept, String AreaOfLiving) {
        super(name, gender, weight, speed, medals, location, diveDept);
        this.AreaOfLiving = AreaOfLiving;
    }

    /**
     * Gets the sound of the alligator.
     *
     * @return the sound of the alligator
     */
    @Override
    public String getSound() {
        return "Roar";
    }

    /**
     * Speeds up the alligator.
     *
     * @param speeder the amount to increase the speed
     * @return true if the speed is valid and set, false otherwise
     */
    public boolean speedUp(int speeder) {
        return getSpeed() + speeder <= MAX_SPEED && setSpeed(getSpeed() + speeder);
    }

    /**
     * Sets the area of living of the alligator.
     *
     * @param area the new area of living
     * @return true if the area is valid and set, false otherwise
     */
    public boolean setArea(String area) {
        if (area == null) {
            return false;
        }
        AreaOfLiving = area;
        return true;
    }

    /**
     * Gets the area of living of the alligator.
     *
     * @return the area of living
     */
    public String getArea() {
        return AreaOfLiving;
    }

    /**
     * Checks if two alligators are equal.
     *
     * @param obj the object to compare with
     * @return true if the alligators are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Alligator other)) {
            return false;
        }
        return super.equals(obj) && other.AreaOfLiving.equals(AreaOfLiving);
    }

    /**
     * Returns a string representation of the alligator.
     *
     * @return a string representation of the alligator
     */
    @Override
    public String toString() {
        return super.toString() + "area: " + AreaOfLiving + "\n";
    }
}
