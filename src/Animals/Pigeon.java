package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Pigeon extends AirAnimal{
    private String family;
    public Pigeon(){
        super();
        family = null;
    }
    public Pigeon(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double wingspan, String family) {
        super(name, gender, weight, speed, medals, location, wingspan);
        this.family = family;
    }
    public String getSound() {
        return "Arr-rar-rar-rar-raah";
    }

    public boolean setFamily(String family) {
        if (this.family.equals(family)){
            return false;
        }
        this.family = family;
        return true;
    }

    public String getFamily() {return family;}

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pigeon other)) {
            return false;
        }
        return super.equals(obj) && family.equals(other.family);
    }
    public String toString() {
        return super.toString() + "family: " + family + "\n";
    }
}
