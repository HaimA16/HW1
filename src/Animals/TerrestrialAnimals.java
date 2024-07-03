package Animals;

import Mobility.Point;
import Olympics.Medal;

public class TerrestrialAnimals extends Animal{
    private int noLegs;

    public TerrestrialAnimals() {
        super();
        noLegs = 0;
    }

    public TerrestrialAnimals(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs) {
        super(name, gender, weight, speed, medals, new Point(0,20));
        if (noLegs < 0) {
            throw new IllegalArgumentException("legs number must be positive!");
        }
        this.noLegs = noLegs;
    }
}
