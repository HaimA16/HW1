package Animals;
import Mobility.Mobile;
import Olympics.Medal;
import Mobility.Point;
import java.util.Arrays;



public abstract class Animal extends Mobile {


    public enum Gender{MALE, FEMALE, HERMAPHHRODITE}
    private final String name;
    private final Gender gender;
    private double weight, speed;
    private Medal [] medals;
    public Animal(String name, Gender gender, double weight, double speed, Medal [] medals, Point location) {
        super(location);
        if(name == null || gender == null || weight <= 0 || speed <= 0){
            throw new IllegalArgumentException("Invalid animal value!");
        }
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.speed = speed;
        this.medals = new Medal[medals.length];
        for (int i = 0; i < medals.length; i++) {
            if (medals[i] == null) {
                throw new IllegalArgumentException("Medal cannot be null!");
            }
            this.medals[i] = medals[i];
        }

    }
    protected abstract String getSound();

    public final void makeSound() {
        System.out.println("Animal: " + getClass().getSimpleName() + " name: " + name + " said " + getSound());
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Animal other))
            return false;
        return this.name.equals(other.name) &&
                this.gender == other.gender &&
                this.weight == other.weight &&
                this.speed == other.speed &&
                Arrays.equals(this.medals, other.medals);
    }

    @Override
    public String toString() {
        return "Animal: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Weight: " + weight + "\n" +
                "Speed: " + speed + "\n" +
                "Medals: \n" + Arrays.toString(medals) + "\n" +
                "Location: " + getLocation() + "\n" +
                "****************************************************";


    }
}


