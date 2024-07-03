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
        this.wingspan = wn;
    }
}
