package Animals;

import Mobility.Point;
import Olympics.Medal;

enum WaterType{Sea, Sweet}
public class Dolphin extends WaterAnimal{
    WaterType waterType;
    public Dolphin(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept, WaterType waterType){
        super(name, gender, weight, speed, medals, location, diveDept);
        this.waterType = waterType;
    }

}
