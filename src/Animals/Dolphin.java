/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Animals;
import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;
import javax.xml.stream.Location;
import java.awt.image.BufferedImage;

/**
 * The Dolphin class represents a dolphin, which is a type of water animal.
 * It extends the WaterAnimal class and includes additional properties specific to dolphins.
 */
public class Dolphin extends WaterAnimal {

    /**
     * Enum representing the type of water the dolphin lives in.
     */
    public enum WaterType { SEA, SWEET }

    /**
     * The type of water the dolphin lives in.
     */
    WaterType waterType;

    /**
     * Default constructor for the Dolphin class.
     * Initializes the dolphin with default values and loads its images.
     */
    public Dolphin() {
        super();
        waterType = null;
        loadImages("dolphin");
    }

    /**
     * Parameterized constructor for the Dolphin class.
     * Initializes the dolphin with the specified values and loads its images.
     *
     * @param name The name of the dolphin.
     * @param gender The gender of the dolphin.
     * @param weight The weight of the dolphin.
     * @param speed The speed of the dolphin.
     * @param medals The medals won by the dolphin.
     * @param location The location of the dolphin.
     * @param loc The XML location of the dolphin.
     * @param orientation The orientation of the dolphin.
     * @param size The size of the dolphin.
     * @param id The ID of the dolphin.
     * @param maxEnergy The maximum energy of the dolphin.
     * @param energyPerMeter The energy consumed per meter by the dolphin.
     * @param pan The competition panel associated with the dolphin.
     * @param img1 The image of the dolphin.
     * @param diveDept The dive depth of the dolphin.
     * @param waterType The type of water the dolphin lives in.
     */
    public Dolphin(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                   Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                   BufferedImage img1, double diveDept, WaterType waterType) {
        super(name, gender, weight, speed, medals, location, loc,
                orientation, size, id, maxEnergy, energyPerMeter, pan,
                img1, diveDept);
        this.waterType = waterType;
        loadImages("dolphin");
    }

    /**
     * Returns the sound made by the dolphin.
     *
     * @return A string representing the sound made by the dolphin.
     */
    @Override
    public String getSound() {
        return "Click-click";
    }


}
