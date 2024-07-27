package Graphics;

import Mobility.Point;

public interface IMoveable {
    public String getAnimaleName();
    public double getSpeed();
    public double move(Point p);
}