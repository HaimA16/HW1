package Graphics;

import java.awt.*;

/**
 * Interface representing an animal with basic functionalities.
 */
public interface IAnimal {

    /**
     * Method to feed the animal.
     *
     * @param energy the amount of energy (food) to be given to the animal.
     * @return true if the animal successfully eats the given amount of energy, false otherwise.
     */
    public boolean eat(int energy);

}
