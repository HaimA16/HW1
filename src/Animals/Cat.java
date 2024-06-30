package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Cat extends TerrestrialAnimals {
    private Boolean castrated;
    public Cat(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs, Boolean castrated) {
        super(name, gender, weight, speed, medals, location, noLegs);
        this.castrated = castrated;
    }
    protected String getSound() {
        return "Meow";
    }
}
