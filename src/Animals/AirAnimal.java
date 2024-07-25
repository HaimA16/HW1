package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.xml.stream.Location;
import java.awt.image.BufferedImage;

public abstract class AirAnimal extends Animal {
    private double wingspan;

    public AirAnimal() {
        super();
        wingspan = 0.0;
    }

    /**
     * Constructor for the AirAnimal class.
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

     * @param wingspan       the wingspan of the air animal
     */
    public AirAnimal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                     Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                     BufferedImage img1, double wingspan) {
        super(name, gender, weight, speed, medals, location,loc,orientation, size, id, maxEnergy, energyPerMeter, pan, img1);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public boolean setWingspan(double wingspan) {
        if (wingspan > 0) {
            this.wingspan = wingspan;
            return true;
        }
        return false;
    }
    public String getCategory() {
        return "Air";
    }
}