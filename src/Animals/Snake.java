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
 * The Snake class represents a snake, which is a type of terrestrial animal and implements the IReptile interface.
 */
public class Snake extends TerrestrialAnimals implements IReptile {

    /**
     * Enum representing the poisonous level of the snake.
     */
    public enum PoisonousLevel {LOW, MEDIUM, HIGH}

    private PoisonousLevel poisonousLevel;
    private double length;

    /**
     * Default constructor for the Snake class.
     * Initializes the snake with default values.
     */
    public Snake() {
        super();
        poisonousLevel = PoisonousLevel.LOW;
        length = 0.0;
    }

    /**
     * Parameterized constructor for the Snake class.
     *
     * @param name The name of the snake.
     * @param gender The gender of the snake.
     * @param weight The weight of the snake.
     * @param speed The speed of the snake.
     * @param medals The medals won by the snake.
     * @param location The location of the snake.
     * @param loc The XML location of the snake.
     * @param orientation The orientation of the snake.
     * @param size The size of the snake.
     * @param id The ID of the snake.
     * @param maxEnergy The maximum energy of the snake.
     * @param energyPerMeter The energy per meter of the snake.
     * @param pan The competition panel.
     * @param img1 The image of the snake.
     * @param noLegs The number of legs of the snake (usually 0).
     * @param length The length of the snake.
     * @param poisonousLevel The poisonous level of the snake.
     */
    public Snake(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                 Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                 BufferedImage img1, int noLegs, double length, PoisonousLevel poisonousLevel) {
        super(name, gender, weight, speed, medals, location, loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1, noLegs);
        this.poisonousLevel = poisonousLevel;
        this.length = length;
        loadImages("snake");
    }

    /**
     * Gets the sound made by the snake.
     *
     * @return The sound made by the snake.
     */
    public String getSound() {
        return "sssssss";
    }

    /**
     * Increases the speed of the snake.
     *
     * @param speeder The amount to increase the speed by.
     * @return True if the speed was successfully increased, false otherwise.
     */
    public boolean speedUp(int speeder) {
        return getSpeed() + speeder < MAX_SPEED && setSpeed(speeder);
    }


}
