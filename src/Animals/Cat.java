/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing a Cat, extending the TerrestrialAnimals class.
 */
public class Cat extends TerrestrialAnimals {

    private Boolean castrated;

    /**
     * Default constructor for the Cat class.
     */
    public Cat() {
        super();
        castrated = null;
    }

    /**
     * Constructor for the Cat class.
     *
     * @param name      the name of the cat
     * @param gender    the gender of the cat
     * @param weight    the weight of the cat
     * @param speed     the speed of the cat
     * @param medals    an array of medals won by the cat
     * @param location  the initial location of the cat
     * @param noLegs    the number of legs the cat has
     * @param castrated whether the cat is castrated or not
     */
    public Cat(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs, Boolean castrated) {
        super(name, gender, weight, speed, medals, location, noLegs);
        this.castrated = castrated;
    }

    /**
     * Gets the sound of the cat.
     *
     * @return the sound of the cat
     */
    @Override
    public String getSound() {
        return "Meow";
    }

    /**
     * Sets the castrated status of the cat.
     *
     * @param castrated the new castrated status
     * @return true if the status is changed, false otherwise
     */
    public boolean setCastrated(Boolean castrated) {
        if (this.castrated == castrated) {
            return false;
        }
        this.castrated = castrated;
        return true;
    }

    /**
     * Gets the castrated status of the cat.
     *
     * @return the castrated status of the cat
     */
    public Boolean getCastrated() {
        return castrated;
    }

    /**
     * Checks if two cats are equal.
     *
     * @param obj the object to compare with
     * @return true if the cats are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cat other)) {
            return false;
        }
        return super.equals(obj) && other.castrated.equals(castrated);
    }

    /**
     * Returns a string representation of the cat.
     *
     * @return a string representation of the cat
     */
    @Override
    public String toString() {
        return super.toString() + "castrated: " + castrated + "\n";
    }
}
