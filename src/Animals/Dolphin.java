package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import java.awt.image.BufferedImage;


public class Dolphin extends WaterAnimal{
    public enum WaterType { SEA, SWEET }
    WaterType waterType;
    public Dolphin(){
        super();
        waterType = null;
    }
    public Dolphin(String name, Gender gender, double weight, double speed, Medal[] medals, Point location,
                   Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                   BufferedImage img1, double diveDept, WaterType waterType){
        super( name,gender,weight, speed, medals, location,
                orientation, size, id,maxEnergy, energyPerMeter, pan,
                img1, diveDept);
        this.waterType = waterType;
    }

    @Override
    public String getSound() {
        return "Click-click";
    }
}