/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.imageio.ImageIO;
import javax.xml.stream.Location;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The Eagle class represents an eagle, which is a type of AirAnimal.
 * It includes specific attributes such as altitude of flight.
 */
public class Eagle extends AirAnimal {
    private double altitudeOfFlight;
    private static final int MAX_ALTITUDE = 100;

    /**
     * Default constructor for the Eagle class.
     * Initializes the altitude of flight to 0.0.
     */
    public Eagle(){
        super();
        altitudeOfFlight = 0.0;
    }

    /**
     * Parameterized constructor for the Eagle class.
     *
     * @param name The name of the eagle.
     * @param gender The gender of the eagle.
     * @param weight The weight of the eagle.
     * @param speed The speed of the eagle.
     * @param medals The medals won by the eagle.
     * @param location The location of the eagle.
     * @param loc The XML location of the eagle.
     * @param orientation The orientation of the eagle.
     * @param size The size of the eagle.
     * @param id The ID of the eagle.
     * @param maxEnergy The maximum energy of the eagle.
     * @param energyPerMeter The energy consumed per meter by the eagle.
     * @param pan The competition panel.
     * @param img1 The image of the eagle.
     * @param wingspan The wingspan of the eagle.
     * @param altitudeOfFlight The altitude of flight of the eagle.
     * @throws IllegalArgumentException if altitudeOfFlight exceeds MAX_ALTITUDE.
     */
    public Eagle(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                 Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                 BufferedImage img1, double wingspan, double altitudeOfFlight) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, wingspan);
        if (altitudeOfFlight > MAX_ALTITUDE)
            throw new IllegalArgumentException("Altitude of flight exceeds maximum allowed.");
        this.altitudeOfFlight = altitudeOfFlight;
        loadImages("eagle");
    }

    /**
     * Returns the sound made by the eagle.
     *
     * @return A string representing the sound made by the eagle.
     */
    public String getSound() {
        return "Clack-wack-chack";
    }


}
