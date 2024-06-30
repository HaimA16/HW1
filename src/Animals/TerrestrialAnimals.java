package Animals;

import Mobility.Point;
import Olympics.Medal;

public abstract class TerrestrialAnimals extends Animal{
    private int noLegs;
    public TerrestrialAnimals(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs) {
        super(name, gender, weight, speed, medals, location);
        if (noLegs < 0) {
            throw new IllegalArgumentException("legs number must be positive!");
        }
        this.noLegs = noLegs;
    }
}
