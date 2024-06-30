package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Eagle extends AirAnimal {
    private double altitudeOfFlight;
    private static final int MAX_ALTITUDE = 100;

    public Eagle(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double wingspan, double altitudeOfFlight) {
        super(name, gender, weight, speed, medals, location, wingspan);
        if(altitudeOfFlight > MAX_ALTITUDE)
            throw new IllegalArgumentException("Altitude of flight exceeds maximum allowed.");
        this.altitudeOfFlight = altitudeOfFlight;

    }
    protected String getSound() {
        return "Clack-wack-chack";
    }
}
