package Tournaments;

import Animals.Animal;
import Animals.AnimalThread;

import java.util.Arrays;

/**
 * the Courier tournament class
 */
public class CourierTournament extends Tournament {
    private Boolean startFlag;
    private Scores scores;
    private int numberOfGroups;

    public CourierTournament(Animal[][] animals) {
        super(animals);
    }

    @Override
    protected void setup(Animal[][] animals) {
        System.out.println("Setting Courier");
        startFlag = false;
        scores = new Scores();
        numberOfGroups = animals.length;

        for (Animal[] group : animals) {
            int n = group.length;
            Boolean[] flags = new Boolean[n];
            Arrays.fill(flags, false);

            for (int i = 0; i < n; i++) {
                Boolean start;
                if (i == 0) {
                    start = flags[i];
                } else {
                    start = flags[i - 1];
                }
                Boolean finish = flags[i];
                double neededDistance = 1000.0 / n; // דוגמה לחישוב מרחק נדרש
                AnimalThread animalThread = new AnimalThread(group[i], neededDistance, start, finish);
                new Thread(animalThread).start();
            }

            Referee referee = new Referee(group[0].getClass().getSimpleName(),scores, flags[animals.length - 1]);
            new Thread(referee).start();

            TournamentThread tt = new TournamentThread(scores, startFlag, numberOfGroups);
            new Thread(tt).start();
        }
    }

    public Boolean getStartFlag() {
        return startFlag;
    }

    public Scores getScores() {
        return scores;
    }

    public int getNumberOfGroups() {
        return numberOfGroups;
    }
}
