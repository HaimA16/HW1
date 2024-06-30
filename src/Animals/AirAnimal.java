package Animals;

import Mobility.Point;
import Olympics.Medal;

public class AirAnimal extends Animal {
    private double wingspan;
    public AirAnimal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double wingspan) {
        super(name, gender, weight, speed, medals, location);
        this.wingspan = wingspan;
    }
}
