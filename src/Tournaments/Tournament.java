
package Tournaments;

import Animals.Animal;


/**
 * the Tournament abstract class
 */
public abstract class Tournament {
    protected TournamentThread thread;
    public Tournament(Animal[][] animals){
        setup(animals);
    }

    /**
     * Setting up the tournament.
     * @param animals The animals in the tournament.
     */
    protected abstract void setup(Animal[][] animals);

    /**
     * Return the thread of the tournament.
     * @return Thread.
     */
    public TournamentThread getThread() {
        return thread;
    }

}
