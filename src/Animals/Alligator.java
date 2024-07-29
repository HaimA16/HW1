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
 * Represents an Alligator, which is both a water and terrestrial animal.
 */
public class Alligator extends WaterAnimal implements IAquaticTerrestrial, IReptile {
    private String areaOfLiving;
    private int noLegs;

    /**
     * Constructs an Alligator object.
     *
     * @param name           the name of the alligator
     * @param gender         the gender of the alligator
     * @param weight         the weight of the alligator
     * @param speed          the speed of the alligator
     * @param medals         an array of medals won by the alligator
     * @param location       the initial location of the alligator
     * @param loc            the location object (unused in this context)
     * @param orientation    the initial orientation of the alligator
     * @param size           the size of the alligator
     * @param id             the id of the alligator
     * @param maxEnergy      the maximum energy of the alligator
     * @param energyPerMeter the energy consumption per meter of the alligator
     * @param pan            the competition panel associated with the alligator
     * @param img1           the first image of the alligator
     * @param diveDepth      the diving depth of the alligator
     * @param noLegs         the number of legs of the alligator
     * @param areaOfLiving   the area of living of the alligator
     */
    public Alligator(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                     Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                     BufferedImage img1, double diveDepth, int noLegs, String areaOfLiving) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, diveDepth);
        this.noLegs = noLegs;
        this.areaOfLiving = areaOfLiving;
        loadImages("alligator");
    }

    /**
     * Gets the number of legs of the alligator.
     *
     * @return the number of legs
     */
    @Override
    public int getNoLegs() {
        return noLegs;
    }

    /**
     * Sets the number of legs of the alligator.
     *
     * @param noLegs the number of legs to set
     */
    @Override
    public void setNoLegs(int noLegs) {
        if (noLegs >= 0) {
            this.noLegs = noLegs;
        }
    }

    /**
     * Gets the area of living of the alligator.
     *
     * @return the area of living
     */
    public String getAreaOfLiving() {
        return areaOfLiving;
    }

    /**
     * Sets the area of living of the alligator.
     *
     * @param areaOfLiving the area of living to set
     */
    public void setAreaOfLiving(String areaOfLiving) {
        this.areaOfLiving = areaOfLiving;
    }

    /**
     * Gets the sound made by the alligator.
     *
     * @return the sound of the alligator
     */
    @Override
    public String getSound() {
        return "Roar";
    }


    /**
     * Increases the speed of the alligator.
     *
     * @param speeder the amount to increase the speed by
     * @return true if the speed was successfully increased, false otherwise
     */
    @Override
    public boolean speedUp(int speeder) {
        double newSpeed = getSpeed() + speeder;
        if (newSpeed < MAX_SPEED) {
            setSpeed(newSpeed);
            return true;
        }
        return false;
    }

    /**
     * Gets the category of the alligator.
     *
     * @return the category of the alligator
     */
    @Override
    public String getCategory() {
        // This method should return a category that reflects both terrestrial and aquatic nature.
        return "Water/Terrestrial";
    }
}
