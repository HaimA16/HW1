package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Alligator extends WaterAnimal implements IReptile,terrestrial_feature{
    private String AreaOfLiving;
    public Alligator(){
        super();
        AreaOfLiving = null;
    }
    public Alligator(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept, String AreaOfLiving) {
        super(name, gender, weight, speed, medals, location, diveDept);
        this.AreaOfLiving = AreaOfLiving;
    }
    public String getSound() {
        return "Roar";
    }
    public boolean speedUp(int speeder) {
        return getSpeed() + speeder < MAX_SPEED && setSpeed(speeder);
    }
}
