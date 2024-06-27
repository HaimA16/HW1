package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Whale extends WaterAnimal{
    private String foodType;
    public Whale(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept, String foodType) {
        super(name, gender, weight, speed, medals, location, diveDept);
        this.foodType = foodType;
    }
}
