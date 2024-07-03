package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Whale extends WaterAnimal{
    private String foodType;
    public Whale(){
        super();
        foodType = null;
    }
    public Whale(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept, String foodType) {
        super(name, gender, weight, speed, medals, location, diveDept);
        this.foodType = foodType;
    }
    public String getSound() {
        return "Splash";
    }

    public boolean setFood(String foodType) {
        if (this.foodType.equals(foodType)){
            return false;
        }
        this.foodType = foodType;
        return true;
    }

    public String getCastrated() {return foodType;}

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Whale other)) {
            return false;
        }
        return super.equals(obj) && other.foodType.equals(foodType);
    }
    public String toString() {
        return super.toString() + "food type: " + foodType + "\n";
    }
}
