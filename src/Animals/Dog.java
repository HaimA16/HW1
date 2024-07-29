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
 * The Dog class represents a dog in the competition.
 * It extends the TerrestrialAnimals class and includes specific attributes and behaviors for a dog.
 */
public class Dog extends TerrestrialAnimals {
    private String breed;

    /**
     * Constructs a new Dog object with the specified parameters.
     *
     * @param name          the name of the dog
     * @param gender        the gender of the dog
     * @param weight        the weight of the dog
     * @param speed         the speed of the dog
     * @param medals        the medals won by the dog
     * @param location      the current location of the dog
     * @param loc           the location object
     * @param orientation   the orientation of the dog
     * @param size          the size of the dog
     * @param id            the ID of the dog
     * @param maxEnergy     the maximum energy of the dog
     * @param energyPerMeter the energy consumed per meter by the dog
     * @param pan           the competition panel
     * @param img1          the initial image of the dog
     * @param noLegs        the number of legs of the dog
     * @param breed         the breed of the dog
     */
    public Dog(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
               Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
               BufferedImage img1, int noLegs, String breed) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs);
        this.breed = breed;
        loadImages("dog"); // Load the images of the dog
    }

    /**
     * Returns the sound made by the dog.
     *
     * @return the sound made by the dog
     */
    @Override
    public String getSound() {
        return "Woof Woof";
    }


}
