package Animals;
import Mobility.Mobile;
import Olympics.Medal;
import Mobility.Point;

import java.util.Arrays;



public abstract class Animal extends Mobile {
    enum Gender{Male, Female, Hermaphrodite}
    private String name;
    private Gender gender;
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
    /*public void makeSound(){
        System.out.println("Animal " + name + " said ");
    }*/

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Animal))
            return false;
        Animal other = (Animal) obj;
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
                "Medals: " + Arrays.toString(medals) + "\n" +
                "Location: " + getLocation();
    }
}


