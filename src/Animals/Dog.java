package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Dog extends TerrestrialAnimals{
    private String breed;
    public Dog(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs, String breed){
        super(name, gender, weight, speed, medals, location, noLegs);
        this.breed = breed;
    }
}
