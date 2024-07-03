package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing a Dolphin, extending the WaterAnimal class.
 */
public class Dolphin extends WaterAnimal {

    /**
     * Enum representing the type of water the dolphin lives in.
     */
    public enum WaterType { SEA, SWEET }

    private WaterType waterType;

    public Dolphin() {
        super();
        waterType = null;
    }

    /**
     * Constructor for the Dolphin class.
     *
     * @param name      the name of the dolphin
     * @param gender    the gender of the dolphin
     * @param weight    the weight of the dolphin
     * @param speed     the speed of the dolphin
     * @param medals    an array of medals won by the dolphin
     * @param location  the initial location of the dolphin
     * @param diveDept  the dive depth of the dolphin
     * @param waterType the type of water the dolphin lives in
     */
    public Dolphin(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept, WaterType waterType) {
        super(name, gender, weight, speed, medals, location, diveDept);
        this.waterType = waterType;
    }

    /**
     * Gets the sound of the dolphin.
     *
     * @return the sound of the dolphin
     */
    @Override
    public String getSound() {
        return "Click-click";
    }

    /**
     * Sets the type of water the dolphin lives in.
     *
     * @param waterType the new type of water
     * @return true if the water type is valid and set, false otherwise
     */
    public boolean setWaterType(WaterType waterType) {
        if (waterType != null) {
            this.waterType = waterType;
            return true;
        }
        return false;
    }

    /**
     * Gets the type of water the dolphin lives in.
     *
     * @return the type of water
     */
    public WaterType getWaterType() {
        return waterType;
    }

    /**
     * Returns a string representation of the dolphin.
     *
     * @return a string representation of the dolphin
     */
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Water Type: " + waterType + "\n";
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dolphin other)) {
            return false;
        }
        return super.equals(obj) && other.getName().equals(this.getName());
    }
}
