/**
 * Name: Haim Armias 315569061
 * Name: Yeuda Baza
 */
package Mobility;

public interface ILocatable {
    /**
     * Retrieves the current location.
     *
     * @return the current location as a Point object
     */
    Point getLocation();

    /**
     * Sets the current location.
     *
     * @param location the new location to set
     * @return true if the location was successfully set, false otherwise
     */
    boolean setLocation(Point location);
}
