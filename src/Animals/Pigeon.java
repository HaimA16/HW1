package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Pigeon extends AirAnimal{
    private String family;
    public Pigeon(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double wingspan, String family) {
        super(name, gender, weight, speed, medals, location, wingspan);
        this.family = family;
    }
    protected String getSound() {
        return "Arr-rar-rar-rar-raah";
    }
}
