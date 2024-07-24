package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import java.awt.image.BufferedImage;

public class Pigeon extends AirAnimal{
    private String family;
    public Pigeon(){
        super();
        family = null;
    }
    public Pigeon(String name, Gender gender, double weight, double speed, Medal[] medals, Point location,
                  Orientation orientation, int size, int id, int maxEnergy, int energyPerMeter, CompetitionPanel pan,
                  BufferedImage img1, double wingspan, String family) {
        super(name, gender, weight, speed, medals, location,
                orientation, size,  id, maxEnergy, energyPerMeter,  pan,
                img1, wingspan);
        this.family = family;
    }
    public String getSound() {
        return "Arr-rar-rar-rar-raah";
    }
}