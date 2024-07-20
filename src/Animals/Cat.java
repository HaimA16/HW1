package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.xml.stream.Location;
import java.awt.image.BufferedImage;

/**
 * Class representing a Cat, which is a type of Terrestrial Animal.
 * Extends the TerrestrialAnimals class and includes specific attributes for cats.
 */
public class Cat extends TerrestrialAnimals {
    private Boolean castrated;

    /**
     * Default constructor for Cat.
     * Initializes the castrated status to null.
     */
    public Cat() {
        super();
        castrated = null;
    }

    /**
     * Constructor for the Cat class.
     *
     * @param name      the name of the cat
     * @param gender    the gender of the cat
     * @param weight    the weight of the cat
     * @param speed     the speed of the cat
     * @param medals    an array of medals won by the cat
     * @param location  the initial location of the cat

     * @param orientation the orientation of the cat
     * @param size      the size of the cat
     * @param id        the ID of the cat
     * @param maxEnergy the maximum energy of the cat
     * @param energyPerMeter the energy consumption per meter for the cat
     * @param pan       the CompetitionPanel associated with the cat
     * @param img1      the first image of the cat
     * @param noLegs    the number of legs the cat has
     * @param castrated the castrated status of the cat
     */
    public Cat(String name, Gender gender, double weight, double speed, Medal[] medals, Point location,
               Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
               BufferedImage img1, int noLegs, Boolean castrated) {
        super(name, gender, weight, speed, medals, location, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs);
        this.castrated = castrated;
    }

    /**
     * Gets the sound the cat makes.
     *
     * @return the sound of the cat
     */
    @Override
    public String getSound() {
        return "Meow";
    }

    /**
     * Sets the castrated status of the cat.
     *
     * @param castrated the new castrated status of the cat
     */
    public void setCastrated(Boolean castrated) {
        this.castrated = castrated;
    }

    /**
     * Gets the castrated status of the cat.
     *
     * @return the castrated status of the cat
     */
    public Boolean getCastrated() {
        return castrated;
    }
}
