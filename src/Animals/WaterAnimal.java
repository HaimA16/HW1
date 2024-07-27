package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.xml.stream.Location;
import java.awt.image.BufferedImage;

public abstract class WaterAnimal extends Animal {
    private static final int MAX_DIVE = -800;
    private double diveDept;

    public WaterAnimal() {
        super();
        diveDept = 0.0;
    }

    /**
     * Constructor for the WaterAnimal class.
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

     * @param diveDept       the dive depth of the water animal
     */
    public WaterAnimal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                       Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                       BufferedImage img1, double diveDept) {
        super(name, gender, weight, speed, medals, location,loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1);
        this.diveDept = diveDept;
    }

    /**
     * Simulates the diving of the water animal.
     *
     * @param dive the amount to dive
     * @return the new dive depth of the animal
     */
    public double Dive(double dive) {
        if (Math.abs(dive) > MAX_DIVE && dive > 0 && diveDept + dive > MAX_DIVE) {
            diveDept = diveDept + dive;
        }
        return diveDept;
    }
    public String getCategory() {
        return "Water";
    }
}