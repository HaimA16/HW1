/**
 * @Author: Haim Armias 315569061
 * @Author: Yeuda Baza 208029819
 */
package Mobility;

/**
 * Abstract class representing a Mobile object that can be located.
 */
public abstract class Mobile implements ILocatable {
    private Point location;
    private double totalDistance;

    /**
     * Default constructor initializing the location at (0,0) and total distance traveled to 0.
     */
    public Mobile() {
        location = new Point(0, 0);
        totalDistance = 0;
    }

    /**
     * Constructor initializing the location with a specified point and total distance traveled to 0.
     *
     * @param location the initial location of the mobile object
     */
    public Mobile(Point location) {
        this.location = location;
        this.totalDistance = 0;
    }

    /**
     * Adds a distance to the total distance traveled by the mobile object.
     *
     * @param distance the distance to add
     */
    public void addTotalDistance(double distance) {
        totalDistance += distance;
    }

    /**
     * Calculates the Euclidean distance between the current location and a given point.
     *
     * @param point the point to calculate the distance to
     * @return the Euclidean distance between the current location and the given point
     */
    public double calcDistance(Point point) {
        if (point == null || point.equals(this.location)) {
            return 0;
        }
        int dx = point.getX() - this.location.getX();
        int dy = point.getY() - this.location.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Moves the mobile object to a new location and calculates the distance traveled.
     *
     * @param point the new location to move to
     * @return the distance traveled to reach the new location
     */
    public double move(Point point) {
        if (point == null || point.equals(this.location)) {
            return 0;
        }

        double distance = calcDistance(point);
        addTotalDistance(distance);
        this.location.setX(point.getX());
        this.location.setY(point.getY());

        return distance;
    }

    /**
     * Sets the location of the mobile object to a new point.
     *
     * @param point the new location to set
     * @return true if the location was successfully set, false otherwise
     */
    public boolean setLocation(Point point) {
        if (point == null || point.equals(this.location)) {
            return false;
        }
        this.location = point;
        return true;
    }

    /**
     * Retrieves the current location of the mobile object.
     *
     * @return the current location of the mobile object
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Retrieves the total distance traveled by the mobile object.
     *
     * @return the total distance traveled by the mobile object
     */
    public double getTotalDistance() {
        return totalDistance;
    }

    /**
     * Checks if two mobile objects are located at the same coordinates.
     *
     * @param obj the object to compare with
     * @return true if the mobile objects have the same location, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Mobile other))
            return false;
        return this.location.getX() == other.location.getX() && this.location.getY() == other.location.getY();
    }

    /**
     * Returns a string representation of the current location of the mobile object.
     *
     * @return a string representation of the current location
     */
    @Override
    public String toString() {
        return "Location: " + "(" + this.location.getX() + ", " + this.location.getY() + ")";
    }
}
