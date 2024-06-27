package Mobility;


public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public boolean setX(int x) {
        this.x = Math.max(0, x);
        return x > 0;
    }
    public int getY() {
        return y;
    }

    public boolean setY(int y) {
        this.y = Math.max(0, y);
        return y > 0;
    }
}
