package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Snake extends TerrestrialAnimals implements IReptile{
    public enum Poisonous {YES,NO}
    private Poisonous poisonous;
    private double length;
    public Snake(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs, double length, Poisonous poisonous){
        super(name, gender, weight, speed, medals, location, noLegs);
        this.poisonous = poisonous;
        this.length = length;
    }
    protected String getSound() {
        return "sssssss";
    }

    public boolean speedUp(int speeder) {
        return getSpeed() + speeder < MAX_SPEED && setSpeed(speeder);
    }
}

