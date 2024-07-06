/**
 * Name: Haim Armias 315569061
 * Name: Yeuda Baza
 */
package Mobility;

/**
 * Represents a point in a 2-dimensional space with non-negative coordinates.
 */
public class Point {
    private int x;
    private int y;

    /**
     * Default constructor initializing coordinates to (0, 0).
     */
    public Point() {
        x = 0;
        y = 0;
    }

    /**
     * Constructor initializing coordinates with specified values.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @throws IllegalArgumentException if either coordinate is negative
     */
    public Point(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates must be non-negative.");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieves the x-coordinate of the point.
     *
     * @return the x-coordinate of the point
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the point.
     *
     * @param x the new x-coordinate to set
     * @return true if the x-coordinate was successfully set (non-negative), false otherwise
     */
    public boolean setX(int x) {
        if (x < 0) {
            return false;
        }
        if (this.x != x) {
            this.x = x;
            return true;
        }
        return false;
    }

    /**
     * Retrieves the y-coordinate of the point.
     *
     * @return the y-coordinate of the point
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the point.
     *
     * @param y the new y-coordinate to set
     * @return true if the y-coordinate was successfully set (non-negative), false otherwise
     */
    public boolean setY(int y) {
        if (y < 0) {
            return false;
        }
        if (this.y != y) {
            this.y = y;
            return true;
        }
        return false;
    }

    /**
     * Checks if this point is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal (have the same coordinates), false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    /**
     * Returns a string representation of the point in the format "(x, y)".
     *
     * @return a string representation of the point
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
