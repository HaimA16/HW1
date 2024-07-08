/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Animals;

import Mobility.Mobile;
import Olympics.Medal;
import Mobility.Point;
import java.util.Arrays;

/**
 * Abstract class representing an Animal, extending the Mobile class.
 */
public abstract class Animal extends Mobile {

    /**
     * Enum representing the gender of the animal.
     */
    public enum Gender { MALE, FEMALE, HERMAPHRODITE }

    private String name;
    private Gender gender;
    private double weight, speed;
    private Medal[] medals;

    public Animal(){
        name=null;
        gender=null;
        weight=0;
        speed=0;
        medals=null;
    }

    /**
     * Constructor for the Animal class.
     *
     * @param name     the name of the animal
     * @param gender   the gender of the animal
     * @param weight   the weight of the animal
     * @param speed    the speed of the animal
     * @param medals   an array of medals won by the animal
     * @param location the initial location of the animal
     */
    public Animal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location) {
        super(location);
        if (name == null || gender == null || weight <= 0 || speed <= 0) {
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
    public double getSpeed() {
        return speed;
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
     * Sets the name of the animal.
     *
     * @param name the new name of the animal
     * @return true if the name is valid and set, false otherwise
     */
    public boolean setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
            return true;
        }
        return false;
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
     * Sets the gender of the animal.
     *
     * @param gender the new gender of the animal
     * @return true if the gender is valid and set, false otherwise
     */
    public boolean setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender;
            return true;
        }
        return false;
    }

    /**
     * Gets the gender of the animal.
     *
     * @return the gender of the animal
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the weight of the animal.
     *
     * @param weight the new weight of the animal
     * @return true if the weight is valid and set, false otherwise
     */
    public boolean setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
            return true;
        }
        return false;
    }

    /**
     * Gets the weight of the animal.
     *
     * @return the weight of the animal
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the medals of the animal.
     *
     * @param medals the new medals of the animal
     * @return true if the medals are valid and set, false otherwise
     */
    public boolean setMedals(Medal[] medals) {
        if (medals != null) {
            this.medals = new Medal[medals.length];
            for (int i = 0; i < medals.length; i++) {
                if (medals[i] == null) {
                    return false;
                }
                this.medals[i] = medals[i];
            }
            return true;
        }
        return false;
    }

    /**
     * Gets the medals of the animal.
     *
     * @return the medals of the animal
     */
    public Medal[] getMedals() {
        return medals;
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
        return "Animal: " + getClass().getSimpleName() +"\n"+
                "Animal name: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Weight: " + weight + "\n" +
                "Speed: " + speed + "\n" +
                "Medals: \n" + Arrays.toString(medals) + "\n" +
                super.toString() + "\n";
    }
}
