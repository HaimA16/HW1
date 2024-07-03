package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Dog extends TerrestrialAnimals{
    private String breed;
    public Dog(){
        super();
        breed = null;
    }
    public Dog(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, int noLegs, String breed){
        super(name, gender, weight, speed, medals, location, noLegs);
        this.breed = breed;
    }
    public String getSound() {
        return "Woof Woof";
    }

    public boolean setBreed(String breed) {
        if (this.breed.equals(breed)){
            return false;
        }
        this.breed = breed;
        return true;
    }

    public String getCastrated() {return breed;}

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dog other)) {
            return false;
        }
        return super.equals(obj) && breed.equals(other.breed);
    }
    public String toString() {
        return super.toString() + "breed: " + breed + "\n";
    }
}
