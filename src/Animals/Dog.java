/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing a Dog, extending the TerrestrialAnimals class.
 */
public class Dog extends TerrestrialAnimals {

    private String breed;

    /**
     * Default constructor for the Dog class.
     */
    public Dog() {
        super();
        breed = null;
    }

    /**
     * Constructor for the Dog class.
     *
     * @param name     the name of the dog
     * @param gender   the gender of the dog
     * @param weight   the weight of the dog
     * @param speed    the speed of the dog
     * @param medals   an array of medals won by the dog
     * @param location the initial location of the dog
     * @param noLegs   the number of legs the dog has
     * @param breed    the breed of the dog
     */
    public Dog(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs, String breed) {
        super(name, gender, weight, speed, medals, location, noLegs);
        this.breed = breed;
    }

    /**
     * Gets the sound of the dog.
     *
     * @return the sound of the dog
     */
    @Override
    public String getSound() {
        return "Woof Woof";
    }

    /**
     * Sets the breed of the dog.
     *
     * @param breed the new breed
     * @return true if the breed is changed, false otherwise
     */
    public boolean setBreed(String breed) {
        if (this.breed.equals(breed)) {
            return false;
        }
        this.breed = breed;
        return true;
    }

    /**
     * Gets the breed of the dog.
     *
     * @return the breed of the dog
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Checks if two dogs are equal.
     *
     * @param obj the object to compare with
     * @return true if the dogs are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dog other)) {
            return false;
        }
        return super.equals(obj) && breed.equals(other.breed);
    }

    /**
     * Returns a string representation of the dog.
     *
     * @return a string representation of the dog
     */
    @Override
    public String toString() {
        return super.toString() + "breed: " + breed + "\n";
    }
}
