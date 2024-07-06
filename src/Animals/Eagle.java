/**
 * Name: Haim Armias 315569061
 * Name: Yeuda Baza
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * Class representing an Eagle, extending the AirAnimal class.
 */
public class Eagle extends AirAnimal {

    private double altitudeOfFlight;
    private static final int MAX_ALTITUDE = 100;

    public Eagle() {
        super();
        altitudeOfFlight = 0.0;
    }

    /**
     * Constructor for the Eagle class.
     *
     * @param name             the name of the eagle
     * @param gender           the gender of the eagle
     * @param weight           the weight of the eagle
     * @param speed            the speed of the eagle
     * @param medals           an array of medals won by the eagle
     * @param location         the initial location of the eagle
     * @param wingspan         the wingspan of the eagle
     * @param altitudeOfFlight the altitude of flight of the eagle
     */
    public Eagle(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double wingspan, double altitudeOfFlight) {
        super(name, gender, weight, speed, medals, location, wingspan);
        if (altitudeOfFlight > MAX_ALTITUDE) {
            throw new IllegalArgumentException("Altitude of flight exceeds maximum allowed.");
        }
        this.altitudeOfFlight = altitudeOfFlight;
    }

    /**
     * Gets the sound of the eagle.
     *
     * @return the sound of the eagle
     */
    @Override
    public String getSound() {
        return "Clack-wack-chack";
    }

    /**
     * Sets the altitude of flight of the eagle.
     *
     * @param altitudeOfFlight the new altitude of flight
     * @return true if the altitude is valid and set, false otherwise
     */
    public boolean setAltitudeOfFlight(double altitudeOfFlight) {
        if (altitudeOfFlight <= MAX_ALTITUDE) {
            this.altitudeOfFlight = altitudeOfFlight;
            return true;
        }
        return false;
    }

    /**
     * Gets the altitude of flight of the eagle.
     *
     * @return the altitude of flight
     */
    public double getAltitudeOfFlight() {
        return altitudeOfFlight;
    }

    /**
     * Returns a string representation of the eagle.
     *
     * @return a string representation of the eagle
     */
    @Override
    public String toString() {
        return super.toString() +
                "Altitude of Flight: " + altitudeOfFlight + "\n";
    }

    /**
     * Checks if two eagles are equal.
     *
     * @param obj the object to compare with
     * @return true if the eagles are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Eagle other)) {
            return false;
        }
        return super.equals(obj) && other.altitudeOfFlight == altitudeOfFlight;
    }
}
