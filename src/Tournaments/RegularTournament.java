package Tournaments;
import Animals.Animal;
import Animals.AnimalThread;


public class RegularTournament extends Tournament {
    public RegularTournament(Animal[][] animals) {
        super(animals);
    }
    @Override
    protected void setup(Animal[][] animals) {
        System.out.println("Setting up Regular Tournament");
        Scores scores = new Scores();
        Boolean startFlag;
        Boolean finishFlag;

    }
}