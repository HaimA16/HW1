package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Cat extends TerrestrialAnimals {
    private Boolean castrated;
    public Cat(){
        super();
        castrated = null;
    }
    public Cat(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs, Boolean castrated) {
        super(name, gender, weight, speed, medals, location, noLegs);
        this.castrated = castrated;
    }
    public String getSound() {
        return "Meow";
    }
}
