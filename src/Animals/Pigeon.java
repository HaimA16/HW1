package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing a Pigeon, extending the AirAnimal class.
 */
public class Pigeon extends AirAnimal {
    private String family;

    /**
     * Default constructor for the Pigeon class.
     * Initializes the family to null.
     */
    public Pigeon() {
        super();
        family = null;
    }

    /**
     * Constructor for the Pigeon class.
     *
     * @param name     the name of the pigeon
     * @param gender   the gender of the pigeon
     * @param weight   the weight of the pigeon
     * @param speed    the speed of the pigeon
     * @param medals   an array of medals won by the pigeon
     * @param location the initial location of the pigeon
     * @param wingspan the wingspan of the pigeon
     * @param family   the family of the pigeon
     */
    public Pigeon(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double wingspan, String family) {
        super(name, gender, weight, speed, medals, location, wingspan);
        this.family = family;
    }

    /**
     * Gets the sound of the pigeon.
     *
     * @return the sound of the pigeon
     */
    @Override
    public String getSound() {
        return "Arr-rar-rar-rar-raah";
    }

    /**
     * Sets the family of the pigeon.
     *
     * @param family the new family of the pigeon
     * @return true if the family was set successfully, false otherwise
     */
    public boolean setFamily(String family) {
        if (this.family.equals(family)) {
            return false;
        }
        this.family = family;
        return true;
    }

    /**
     * Gets the family of the pigeon.
     *
     * @return the family of the pigeon
     */
    public String getFamily() {
        return family;
    }

    /**
     * Checks if this pigeon is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pigeon other)) {
            return false;
        }
        return super.equals(obj) && family.equals(other.family);
    }

    /**
     * Returns a string representation of the pigeon.
     *
     * @return a string representation of the pigeon
     */
    @Override
    public String toString() {
        return super.toString() + "family: " + family + "\n";
    }
}
