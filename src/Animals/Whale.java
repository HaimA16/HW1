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
 * The Whale class represents a whale, which is a type of WaterAnimal.
 * It includes specific attributes such as food type and methods to load images and get the sound of the whale.
 */
public class Whale extends WaterAnimal {
    private String foodType;

    /**
     * Default constructor for Whale.
     * Initializes the foodType to null.
     */
    public Whale() {
        super();
        foodType = null;
    }

    /**
     * Parameterized constructor for Whale.
     *
     * @param name            the name of the whale
     * @param gender          the gender of the whale
     * @param weight          the weight of the whale
     * @param speed           the speed of the whale
     * @param medals          the medals won by the whale
     * @param location        the location of the whale
     * @param loc             the XML location of the whale
     * @param orientation     the orientation of the whale
     * @param size            the size of the whale
     * @param id              the ID of the whale
     * @param maxEnergy       the maximum energy of the whale
     * @param energyPerMeter  the energy consumed per meter by the whale
     * @param pan             the competition panel
     * @param img1            the image of the whale
     * @param diveDept        the dive depth of the whale
     * @param foodType        the type of food the whale eats
     */
    public Whale(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                 Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                 BufferedImage img1, double diveDept, String foodType) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, diveDept);
        this.foodType = foodType;
        loadImages("whale");
    }

    /**
     * Gets the sound made by the whale.
     *
     * @return the sound of the whale
     */
    public String getSound() {
        return "Splash";
    }


}
