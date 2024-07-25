package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.xml.stream.Location;
import java.awt.image.BufferedImage;

public class Snake extends TerrestrialAnimals implements IReptile{
    public enum PoisonousLevel {LOW,MEDIUM,HIGH}
    private PoisonousLevel poisonousLevel;
    private double length;
    public Snake(){
        super();
        poisonousLevel = PoisonousLevel.LOW;
        length = 0.0;
    }
    public Snake(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                 Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                 BufferedImage img1, int noLegs, double length, PoisonousLevel poisonousLevel){
        super(name, gender, weight, speed, medals, location,loc, orientation, size, id, maxEnergy, energyPerMeter, pan, img1,noLegs);
        this.poisonousLevel = poisonousLevel;
        this.length = length;
    }
    public String getSound() {
        return "sssssss";
    }

    public boolean speedUp(int speeder) {
        return getSpeed() + speeder < MAX_SPEED && setSpeed(speeder);
    }
}
