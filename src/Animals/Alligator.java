package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Alligator extends WaterAnimal{
    private String AreaOfLiving;
    public Alligator(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept, String AreaOfLiving) {
        super(name, gender, weight, speed, medals, location, diveDept);
        this.AreaOfLiving = AreaOfLiving;
    }
}
