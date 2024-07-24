package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import java.awt.image.BufferedImage;

public class Dog extends TerrestrialAnimals{
    private String breed;
    public Dog(){
        super();
        breed = null;
    }
    public Dog(String name, Gender gender, double weight, double speed, Medal[] medals, Point location,
               Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
               BufferedImage img1, int noLegs, String breed){
        super(name,  gender, weight,  speed,medals,  location,
                orientation,  size,  id,  maxEnergy, energyPerMeter, pan,
                img1, noLegs);
        this.breed = breed;
    }
    public String getSound() {
        return "Woof Woof";
    }
}