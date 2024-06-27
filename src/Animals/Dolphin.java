package Animals;

import Mobility.Point;
import Olympics.Medal;


public class Dolphin extends WaterAnimal{
    public enum WaterType { SEA, SWEET }
    WaterType waterType;
    public Dolphin(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept, WaterType waterType){
        super(name, gender, weight, speed, medals, location, diveDept);
        this.waterType = waterType;
    }

}
