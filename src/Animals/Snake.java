package Animals;

import Mobility.Point;
import Olympics.Medal;
enum Poisonous {yes,no};
public class Snake extends TerrestrialAnimals{
    private Poisonous poisonous;
    private double length;
    public Snake(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs, double lenght, Poisonous poisonous){
        super(name, gender, weight, speed, medals, location, noLegs);
        if(lenght < 0){
            throw new IllegalArgumentException("length number must be positive!");
        }
        this.poisonous = poisonous;
        this.length = lenght;
    }

}
