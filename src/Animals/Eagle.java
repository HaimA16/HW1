package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import java.awt.image.BufferedImage;

public class Eagle extends AirAnimal {
    private double altitudeOfFlight;
    private static final int MAX_ALTITUDE = 100;

    public Eagle(){
        super();
        altitudeOfFlight = 0.0;
    }
    public Eagle(String name, Gender gender, double weight, double speed, Medal[] medals, Point location,
                 Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                 BufferedImage img1, double wingspan, double altitudeOfFlight) {
        super( name, gender, weight,speed,medals,location,
                 orientation, size, id, maxEnergy, energyPerMeter, pan,
                img1,wingspan);
        if(altitudeOfFlight > MAX_ALTITUDE)
            throw new IllegalArgumentException("Altitude of flight exceeds maximum allowed.");
        this.altitudeOfFlight = altitudeOfFlight;

    }
    public String getSound() {
        return "Clack-wack-chack";
    }
}
