
package Tournaments;

import java.util.concurrent.atomic.AtomicBoolean;

public class Referee implements Runnable {
    private String name;
    private Scores scores;
    private Boolean finishFlag;

    public Referee(String name, Scores scores, Boolean finishFlag) {
        this.name = name;
        this.scores = scores;
        this.finishFlag = finishFlag;
    }

    @Override
    public void run() {
        synchronized (finishFlag) {
            while (!finishFlag) {
                try {
                    finishFlag.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        scores.add(name);
    }
}

