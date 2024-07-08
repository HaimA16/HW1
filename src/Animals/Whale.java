/**
 * Name: Haim Armias 315569061
 * Name: Yeuda Baza 208029819
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing a whale, extending the WaterAnimal class.
 */
public class Whale extends WaterAnimal {
    private String foodType;

    /**
     * Default constructor for the Whale class.
     * Initializes the food type to null.
     */
    public Whale() {
        super();
        foodType = null;
    }

    /**
     * Constructor for the Whale class.
     *
     * @param name      the name of the whale
     * @param gender    the gender of the whale
     * @param weight    the weight of the whale
     * @param speed     the speed of the whale
     * @param medals    an array of medals won by the whale
     * @param location  the initial location of the whale
     * @param diveDept  the initial dive depth of the whale
     * @param foodType  the food type of the whale
     */
    public Whale(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept, String foodType) {
        super(name, gender, weight, speed, medals, location, diveDept);
        this.foodType = foodType;
    }

    /**
     * Returns the sound of the whale.
     *
     * @return the sound of the whale
     */
    public String getSound() {
        return "Splash";
    }

    /**
     * Sets the food type of the whale.
     *
     * @param foodType the food type of the whale
     * @return true if the food type is set, false if it's the same as the current food type
     */
    public boolean setFood(String foodType) {
        if (this.foodType.equals(foodType)) {
            return false;
        }
        this.foodType = foodType;
        return true;
    }

    /**
     * Gets the food type of the whale.
     *
     * @return the food type of the whale
     */
    public String getFoodType() {
        return foodType;
    }

    /**
     * Checks if two whales are equal.
     *
     * @param obj the object to compare with
     * @return true if the whales are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Whale other)) {
            return false;
        }
        return super.equals(obj) && other.foodType.equals(foodType);
    }

    /**
     * Returns a string representation of the whale.
     *
     * @return a string representation of the whale
     */
    @Override
    public String toString() {
        return super.toString() + "food type: " + foodType + "\n";
    }
}
