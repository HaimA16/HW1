package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing an air animal, extending the Animal class.
 */
public class AirAnimal extends Animal {
    private double wingspan;

    /**
     * Default constructor for the AirAnimal class.
     */
    public AirAnimal() {
        super();
        wingspan = 0.0;
    }

    /**
     * Constructor for the AirAnimal class.
     *
     * @param name       the name of the air animal
     * @param gender     the gender of the air animal
     * @param weight     the weight of the air animal
     * @param speed      the speed of the air animal
     * @param medals     an array of medals won by the air animal
     * @param location   the initial location of the air animal
     * @param wingspan   the wingspan of the air animal
     */
    public AirAnimal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double wingspan) {
        super(name, gender, weight, speed, medals, new Point(0, 100));
        this.wingspan = wingspan;
    }

    /**
     * Sets the wingspan of the air animal.
     *
     * @param wingspan the new wingspan of the air animal
     * @return true if the wingspan is valid and set, false otherwise
     */
    public boolean setWingspan(double wingspan) {
        if (wingspan < 0.0) {
            return false;
        }
        this.wingspan = wingspan;
        return true;
    }

    /**
     * Gets the wingspan of the air animal.
     *
     * @return the wingspan of the air animal
     */
    public double getWingspan() {
        return wingspan;
    }

    /**
     * Checks if two air animals are equal.
     *
     * @param obj the object to compare with
     * @return true if the air animals are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirAnimal other)) {
            return false;
        }
        return super.equals(obj) && wingspan == other.wingspan;
    }

    /**
     * Returns a string representation of the air animal.
     *
     * @return a string representation of the air animal
     */
    @Override
    public String toString() {
        return super.toString() + "wing span: " + wingspan + "\n";
    }
}
