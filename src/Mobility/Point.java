package Mobility;

public class Point {
    private int x;
    private int y;
    public Point() {
        x=0;
        y=0;
    }

    public Point(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates must be non-negative.");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

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

    public int getY() {
        return y;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
