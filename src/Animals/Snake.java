/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */

package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing a Snake, extending the TerrestrialAnimals class and implementing the IReptile interface.
 */
public class Snake extends TerrestrialAnimals implements IReptile {
    /**
     * Enum representing whether the snake is poisonous.
     */
    public enum Poisonous { YES, NO }

    private Poisonous poisonous;
    private double length;

    /**
     * Default constructor for the Snake class.
     * Initializes poisonous to YES and length to 0.0.
     */
    public Snake() {
        super();
        poisonous = Poisonous.YES;
        length = 0.0;
    }

    /**
     * Constructor for the Snake class.
     *
     * @param name      the name of the snake
     * @param gender    the gender of the snake
     * @param weight    the weight of the snake
     * @param speed     the speed of the snake
     * @param medals    an array of medals won by the snake
     * @param location  the initial location of the snake
     * @param noLegs    the number of legs of the snake
     * @param length    the length of the snake
     * @param poisonous whether the snake is poisonous
     */
    public Snake(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs, double length, Poisonous poisonous) {
        super(name, gender, weight, speed, medals, location, noLegs);
        this.poisonous = poisonous;
        this.length = length;
    }

    /**
     * Gets the sound of the snake.
     *
     * @return the sound of the snake
     */
    @Override
    public String getSound() {
        return "sssssss";
    }

    /**
     * Speeds up the snake by a specified amount.
     *
     * @param speeder the amount to increase the speed by
     * @return true if the speed was increased successfully, false otherwise
     */
    @Override
    public boolean speedUp(int speeder) {
        return getSpeed() + speeder <= MAX_SPEED && setSpeed(getSpeed() + speeder);
    }
    /**
     * Sets the length of the snake.
     *
     * @param length the new length of the snake
     * @return true if the length was set successfully, false otherwise
     */
    public boolean setLength(double length) {
        if (length < 0) {
            return false;
        }
        this.length = length;
        return true;
    }

    /**
     * Sets whether the snake is poisonous.
     *
     * @param poisonous the new poisonous value
     * @return true if the poisonous value was set successfully, false otherwise
     */
    public boolean setPoisonous(Poisonous poisonous) {
        if (this.poisonous == poisonous) {
            return false;
        }
        this.poisonous = poisonous;
        return true;
    }

    /**
     * Gets the length of the snake.
     *
     * @return the length of the snake
     */
    public double getLength() {
        return length;
    }

    /**
     * Gets whether the snake is poisonous.
     *
     * @return the poisonous value of the snake
     */
    public Poisonous getPoisonous() {
        return poisonous;
    }

    /**
     * Checks if this snake is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Snake other)) {
            return false;
        }
        return super.equals(obj) && other.poisonous == poisonous && other.length == length;
    }

    /**
     * Returns a string representation of the snake.
     *
     * @return a string representation of the snake
     */
    @Override
    public String toString() {
        return super.toString() + "poisonous: " + poisonous + "\n" + "length: " + length + "\n";
    }
}
