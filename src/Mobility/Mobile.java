package Mobility;

public abstract class Mobile implements ILocatable {
    private Point location;
    private double totalDistance;

    public Mobile(){
        location = new Point(0,0);
        totalDistance = 0;
    }

    public Mobile(Point location) {
        this.location = location;
        this.totalDistance = 0;
    }

    public void addTotalDistance(double distance) {
       totalDistance += distance;
    }

    public double calcDistance(Point point) {
        if (point == null || point.equals(this.location)) {
            return 0;
        }
        int dx = point.getX() - this.location.getX();
        int dy = point.getY() - this.location.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double move(Point point){
        if (point == null || point.equals(this.location)) {
            return 0;
        }

        double distance = calcDistance(point);
        addTotalDistance(distance);
        this.location.setX(point.getX());
        this.location.setY(point.getY());

        return distance;
    }

    public boolean setLocation(Point point) {
        if (point == null || point.equals(this.location)) {
            return false;
        }
        this.location = point;
        return true;
    }

    public Point getLocation() {
        return location;
    }

    public double getTotalDistance() {
        return totalDistance;
    }


    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Mobile other))
            return false;
        return this.location.getX() == other.location.getX() && this.location.getY() == other.location.getY();
    }


    public String toString() {
        return "(" + this.location.getX() + ", " + this.location.getY() + ")";

    }
}