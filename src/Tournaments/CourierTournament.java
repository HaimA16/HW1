/**

 */
package Tournaments;

import Animals.Animal;
import Animals.AnimalThread;



/**
 * the Courier tournament class
 */
public class CourierTournament extends Tournament {
    public CourierTournament(Animal[][] animals) {
        super(animals);
    }

    @Override
    protected void setup(Animal[][] animals) {
        System.out.println("Setting Courier");
        Scores scores = new Scores();
        Boolean startFlag;

    }
}
