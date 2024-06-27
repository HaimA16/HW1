import Mobility.Mobile;
import Olympics.Medal;
import Mobility.Point;
package Animals;

enum Gender{Male, Female, Hermaphrodite}

public abstract class Animal extends Mobile {
    private String name;
    private Gender gender;
    private double weight, speed;
    private Medal [] medals;
    public Animal(String name, Gender gender, double weight, double speed, Medal [] medals, Point location, double totalDistance) {
        super(location);
        if(name == null || gender == null || weight <= 0 || speed <= 0){
            throw new IllegalArgumentException("Invalid animal value!");
        }
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.speed = speed;
        this.medals = medals;
    }
    public void makeSound(){
        System.out.println("Animal " + name + " said " + )
    }
}
