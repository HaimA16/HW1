package Animals;

import Mobility.Point;
import Olympics.Medal;

public class WaterAnimal extends Animal{
    private static final int MAX_DIVE = -800;
    private double diveDept;
    public WaterAnimal(){
        super();

        diveDept=0.0;
    }
    public WaterAnimal(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, double diveDept){
        super(name, gender, weight, speed, medals, new Point(50,0));
        this.diveDept = diveDept;
    }
    public double Dive(double dive){
        if(Math.abs(dive) > MAX_DIVE && dive > 0 && diveDept + dive > MAX_DIVE ) {
            diveDept = diveDept + dive;
        }
        return diveDept;
    }

     public boolean setDiveDept(double dive){
        if (dive > MAX_DIVE && diveDept + dive > MAX_DIVE) {
            return false;
        }
        diveDept = dive;
        return true;
     }

     public double getDiveDept(){return diveDept;}

    /**
     * Checks if two water animals are equal.
     *
     * @param obj the object to compare with
     * @return true if the water animals are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WaterAnimal other)) {
            return false;
        }
        return super.equals(obj) && diveDept == other.diveDept;
    }
}
