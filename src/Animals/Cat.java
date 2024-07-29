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
 * Class representing a Cat, which is a type of TerrestrialAnimal.
 */
public class Cat extends TerrestrialAnimals {
    private Boolean castrated;

    /**
     * Constructor for the Cat class.
     *
     * @param name           the name of the cat
     * @param gender         the gender of the cat
     * @param weight         the weight of the cat
     * @param speed          the speed of the cat
     * @param medals         an array of medals won by the cat
     * @param location       the initial location of the cat
     * @param loc            the location object
     * @param orientation    the initial orientation of the cat
     * @param size           the size of the cat
     * @param id             the id of the cat
     * @param maxEnergy      the maximum energy of the cat
     * @param energyPerMeter the energy consumption per meter of the cat
     * @param pan            the competition panel associated with the cat
     * @param img1           the first image of the cat
     * @param noLegs         the number of legs the cat has
     * @param castrated      whether the cat is castrated or not
     */
    public Cat(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
               Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
               BufferedImage img1, int noLegs, Boolean castrated) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs);
        this.castrated = castrated;
        loadImages("cat"); // Load the images of the cat
    }

    /**
     * Gets the sound of the cat.
     *
     * @return the sound of the cat
     */
    @Override
    public String getSound() {
        return "Meow";
    }

}
