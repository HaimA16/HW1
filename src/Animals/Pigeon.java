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
 * The Pigeon class represents a pigeon, which is a type of AirAnimal.
 * It includes specific attributes and behaviors of a pigeon.
 */
public class Pigeon extends AirAnimal {
    private String family;

    /**
     * Default constructor for the Pigeon class.
     * Initializes the family to null.
     */
    public Pigeon() {
        super();
        family = null;
    }

    /**
     * Parameterized constructor for the Pigeon class.
     *
     * @param name           The name of the pigeon.
     * @param gender         The gender of the pigeon.
     * @param weight         The weight of the pigeon.
     * @param speed          The speed of the pigeon.
     * @param medals         An array of medals the pigeon has won.
     * @param location       The current location of the pigeon.
     * @param loc            The location object (not clear from context).
     * @param orientation    The orientation of the pigeon.
     * @param size           The size of the pigeon.
     * @param id             The ID of the pigeon.
     * @param maxEnergy      The maximum energy of the pigeon.
     * @param energyPerMeter The energy consumption per meter.
     * @param pan            The competition panel.
     * @param img1           The image of the pigeon.
     * @param wingspan       The wingspan of the pigeon.
     * @param family         The family of the pigeon.
     */
    public Pigeon(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                  Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                  BufferedImage img1, double wingspan, String family) {
        super(name, gender, weight, speed, medals, location, loc,
                orientation, size, id, maxEnergy, energyPerMeter, pan,
                img1, wingspan);
        this.family = family;
        loadImages("pigeon");
    }

    /**
     * Returns the sound made by the pigeon.
     *
     * @return A string representing the sound made by the pigeon.
     */
    public String getSound() {
        return "Arr-rar-rar-rar-raah";
    }

}
