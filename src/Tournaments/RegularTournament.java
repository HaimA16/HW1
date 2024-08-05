package Tournaments;

import Animals.Animal;
import Animals.AnimalThread;

public class RegularTournament extends Tournament {

    public RegularTournament(Animal[][] animals) {
        super(animals);
    }

    @Override
    protected void setup(Animal[][] animals) {
        Boolean startFlag = false;
        Scores scores = new Scores();
        int numberOfGroups = animals.length;

        for (Animal[] group : animals) {
            Boolean finishFlag = false;
            AnimalThread animalThread = new AnimalThread(group[0], 1000.0, startFlag, finishFlag);
            new Thread(animalThread).start();

            Referee referee = new Referee(group[0].getClass().getSimpleName(), scores, finishFlag);
            new Thread(referee).start();
        }

        TournamentThread tt = new TournamentThread(scores, startFlag, numberOfGroups);
        new Thread(tt).start();
    }
}
