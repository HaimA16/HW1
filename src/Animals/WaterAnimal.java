package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing a water animal, extending the Animal class.
 */
public class WaterAnimal extends Animal {
    private static final int MAX_DIVE = -800;
    private double diveDept;

    /**
     * Default constructor for the WaterAnimal class.
     * Initializes the dive depth to 0.0.
     */
    public WaterAnimal() {
        super();
        diveDept = 0.0;
    }

    /**
     * Constructor for the WaterAnimal class.
     *
     * @param name      the name of the animal
     * @param gender    the gender of the animal
     * @param weight    the weight of the animal
     * @param speed     the speed of the animal
     * @param medals    an array of medals won by the animal
     * @param location  the initial location of the animal
     * @param diveDept  the initial dive depth of the animal
     */
    public WaterAnimal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept) {
        super(name, gender, weight, speed, medals, new Point(50, 0));
        this.diveDept = diveDept;
    }

    /**
     * Adjusts the dive depth of the animal.
     *
     * @param dive the amount to adjust the dive depth
     * @return the new dive depth
     */
    public double Dive(double dive) {
        if (Math.abs(dive) > MAX_DIVE && dive > 0 && diveDept + dive > MAX_DIVE) {
            diveDept = diveDept + dive;
        }
        return diveDept;
    }

    /**
     * Sets the dive depth of the animal.
     *
     * @param dive the new dive depth
     * @return true if the dive depth is valid and set, false otherwise
     */
    public boolean setDiveDept(double dive) {
        if (dive > MAX_DIVE && diveDept + dive > MAX_DIVE) {
            return false;
        }
        diveDept = dive;
        return true;
    }

    /**
     * Gets the dive depth of the animal.
     *
     * @return the dive depth
     */
    public double getDiveDept() {
        return diveDept;
    }

    /**
     * Checks if two water animals are equal.
     *
     * @param obj the object to compare with
     * @return true if the water animals are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WaterAnimal other)) {
            return false;
        }
        return super.equals(obj) && diveDept == other.diveDept;
    }

    /**
     * Returns a string representation of the water animal.
     *
     * @return a string representation of the water animal
     */
    @Override
    public String toString() {
        return super.toString() + "dive: " + diveDept + "\n";
    }
}
