package Animals;
import Mobility.Mobile;
import Olympics.Medal;
import Mobility.Point;

import java.util.Arrays;


enum Gender{Male, Female, Hermaphrodite}

public abstract class Animal extends Mobile {
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

    }
    public void makeSound(){
        System.out.println("Animal " + name + " said ");
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


