package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Snake extends TerrestrialAnimals implements IReptile{
    public enum Poisonous {YES,NO}
    private Poisonous poisonous;
    private double length;
    public Snake(){
        super();
        poisonous = Poisonous.YES;
        length = 0.0;
    }
    public Snake(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs, double length, Poisonous poisonous){
        super(name, gender, weight, speed, medals, location, noLegs);
        this.poisonous = poisonous;
        this.length = length;
    }
    public String getSound() {
        return "sssssss";
    }

    public boolean speedUp(int speeder) {
        return getSpeed() + speeder < MAX_SPEED && setSpeed(speeder);
    }

    public boolean setLength(double length) {
        if (length < 0 ){
            return false;
        }
        this.length = length;
        return true;
    }

    public boolean setPoisonous(Poisonous poisonous) {
        if(this.poisonous == poisonous){
            return false;
        }
        this.poisonous = poisonous;
        return true;
    }

    public double getLength() {return length;}
    public Poisonous getPoisonous() {return poisonous;}

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Snake other)) {
            return false;
        }
        return super.equals(obj) && other.poisonous == poisonous && other.length == length;
    }
    public String toString() {
        return super.toString() +"poisonous: " + poisonous + "\n " + "length: " + length + "\n";
    }
}

