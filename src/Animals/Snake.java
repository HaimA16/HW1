package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import java.awt.image.BufferedImage;

public class Snake extends TerrestrialAnimals implements IReptile{
    public enum Poisonous {YES,NO}
    private Poisonous poisonous;
    private double length;
    public Snake(){
        super();
        poisonous = Poisonous.YES;
        length = 0.0;
    }
    public Snake(String name, Gender gender, double weight, double speed, Medal[] medals, Point location,
                 Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                 BufferedImage img1, int noLegs,double length, Poisonous poisonous){
        super(name, gender, weight, speed, medals, location, orientation, size, id, maxEnergy, energyPerMeter, pan, img1,noLegs);
        this.poisonous = poisonous;
        this.length = length;
    }
    public String getSound() {
        return "sssssss";
    }

    public boolean speedUp(int speeder) {
        return getSpeed() + speeder < MAX_SPEED && setSpeed(speeder);
    }
}

