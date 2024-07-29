package Graphics;

import Mobility.Point;

/**
 * Interface representing moveable objects.
 * Provides methods for getting the name and speed of the object, and for moving the object to a new point.
 */
public interface IMoveable {
    /**
     * Gets the name of the animal.
     *
     * @return the name of the animal
     */
    public String getAnimaleName();

    /**
     * Gets the speed of the object.
     *
     * @return the speed of the object
     */
    public int getSpeed();

    /**
     * Moves the object to the specified point.
     *
     * @param p the point to move the object to
     * @return true if the move was successful, false otherwise
     */
    public boolean move(Point p);
}
