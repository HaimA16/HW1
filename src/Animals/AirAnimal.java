package Animals;

import Mobility.Point;
import Olympics.Medal;

public class AirAnimal extends Animal {
    private double wingspan;
    public AirAnimal() {
        super();
        wingspan = 0.0;
    }
    public AirAnimal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double wingspan) {
        super(name, gender, weight, speed, medals, new Point(0,100));
        this.wingspan = wingspan;
    }
    boolean setWingspan(double wingspan) {
        if (wingspan < 0.0) {
            return false;
        }
        this.wingspan = wingspan;
        return true;
    }
    public double getWingspan() {
        return wingspan;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirAnimal other)) {
            return false;
        }
        return super.equals(obj) && wingspan == other.wingspan;
    }
}
