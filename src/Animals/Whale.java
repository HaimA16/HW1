package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.xml.stream.Location;
import java.awt.image.BufferedImage;

public class Whale extends WaterAnimal{
    private String foodType;
    public Whale(){
        super();
        foodType = null;
    }
    public Whale(String name, Gender gender, double weight, double speed, Medal[] medals, Point location, Location loc,
                 Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                 BufferedImage img1,  double diveDept, String foodType) {
        super( name, gender, weight, speed,medals, location,loc,
                orientation, size, id, maxEnergy, energyPerMeter, pan,
                img1, diveDept);
        this.foodType = foodType;
    }
    public String getSound() {
        return "Splash";
    }
}