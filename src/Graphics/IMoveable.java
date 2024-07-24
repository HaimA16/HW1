package Graphics;

import Mobility.Point;

public interface IMoveable {
    public String getAnimaleName();
    public int getSpeed();
    public boolean move(Point p);
}