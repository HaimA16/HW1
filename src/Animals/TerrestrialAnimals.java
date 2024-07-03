package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing a terrestrial animal, extending the Animal class.
 */
public class TerrestrialAnimals extends Animal {
    private int noLegs;

    /**
     * Default constructor for the TerrestrialAnimals class.
     * Initializes the number of legs to 0.
     */
    public TerrestrialAnimals() {
        super();
        noLegs = 0;
    }

    /**
     * Constructor for the TerrestrialAnimals class.
     *
     * @param name      the name of the animal
     * @param gender    the gender of the animal
     * @param weight    the weight of the animal
     * @param speed     the speed of the animal
     * @param medals    an array of medals won by the animal
     * @param location  the initial location of the animal
     * @param noLegs    the number of legs of the animal
     */
    public TerrestrialAnimals(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs) {
        super(name, gender, weight, speed, medals, new Point(0, 20));
        if (noLegs < 0) {
            throw new IllegalArgumentException("legs number must be positive!");
        }
        this.noLegs = noLegs;
    }

    /**
     * Sets the number of legs of the animal.
     *
     * @param noLegs the new number of legs
     * @return true if the number of legs is valid and set, false otherwise
     */
    public boolean setNoLegs(int noLegs) {
        if (noLegs < 0) {
            return false;
        }
        this.noLegs = noLegs;
        return true;
    }

    /**
     * Gets the number of legs of the animal.
     *
     * @return the number of legs
     */
    public int getNoLegs() {
        return noLegs;
    }

    /**
     * Checks if two terrestrial animals are equal.
     *
     * @param obj the object to compare with
     * @return true if the animals are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TerrestrialAnimals other)) {
            return false;
        }
        return super.equals(obj) && noLegs == other.noLegs;
    }

    /**
     * Returns a string representation of the terrestrial animal.
     *
     * @return a string representation of the terrestrial animal
     */
    @Override
    public String toString() {
        return super.toString() + "number of legs: " + noLegs + "\n";
    }
}
