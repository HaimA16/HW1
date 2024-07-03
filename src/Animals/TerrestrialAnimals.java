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

    public boolean setNoLegs(int noLegs) {
        if (noLegs < 0) {
            return false;
        }
        this.noLegs = noLegs;
        return true;
    }

    public int getNoLegs() {return noLegs;}

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TerrestrialAnimals other)) {
            return false;
        }
        return super.equals(obj) && noLegs == other.noLegs;
    }
}
