package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.xml.stream.Location;
import java.awt.image.BufferedImage;

/**
 * Class representing a Terrestrial Animal.
 * Extends the Animal class and includes specific attributes for terrestrial animals.
 */
public class TerrestrialAnimals extends Animal {
    private int noLegs;

    /**
     * Default constructor for TerrestrialAnimals.
     * Initializes the number of legs to 0.
     */
    public TerrestrialAnimals() {
        super();
        noLegs = 0;
    }

    /**
     * Sets the number of legs for the terrestrial animal.
     *
     * @param noLegs the number of legs to set
     * @return true if the number of legs was updated, false otherwise
     */
    public boolean setNoLegs(int noLegs) {
        if (noLegs >= 0 && this.noLegs != noLegs) {
            this.noLegs = noLegs;
            return true;
        }
        return false;
    }

    /**
     * Gets the number of legs for the terrestrial animal.
     *
     * @return the number of legs
     */
    public int getNoLegs() {
        return noLegs;
    }

    /**
     * Constructor for the TerrestrialAnimals class.
     *
     * @param name           the name of the animal
     * @param gender         the gender of the animal
     * @param weight         the weight of the animal
     * @param speed          the speed of the animal
     * @param medals         an array of medals won by the animal
     * @param location       the initial location of the animal

     * @param orientation    the initial orientation of the animal
     * @param size           the size of the animal
     * @param id             the id of the animal
     * @param maxEnergy      the maximum energy of the animal
     * @param energyPerMeter the energy consumption per meter of the animal
     * @param pan            the competition panel associated with the animal
     * @param img1           the first image of the animal

     * @param noLegs         the number of legs of the terrestrial animal
     * @throws IllegalArgumentException if the number of legs is negative
     */
    public TerrestrialAnimals(String name, Gender gender, double weight, double speed, Medal[] medals, Point location,
                              Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                              BufferedImage img1, int noLegs) {
        super(name, gender, weight, speed, medals, location,
                orientation, size, id, maxEnergy, energyPerMeter, pan,
                img1);
        if (noLegs < 0) {
            throw new IllegalArgumentException("Number of legs must be positive!");
        }
        this.noLegs = noLegs;
    }
}
