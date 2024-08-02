package Animals;

import java.awt.*;
import Mobility.Point;

public class AnimalThread extends Thread implements Runnable {
    private Animal participant;
    private double neededDistance;
    private Boolean startFlag;
    private Boolean finishFlag;
    private static long sleepTime = 100; // Default sleep time in milliseconds

    /**
     * Constructor
     * @param ani animal to run
     * @param nD Distance
     * @param sf Start flag
     * @param ff Finish flag
     */
    public AnimalThread(Animal ani, double nD, Boolean sf, Boolean ff) {
        participant = ani;
        neededDistance = nD;
        startFlag = sf;
        finishFlag = ff;
    }

    @Override
    public void run() {
        double moved = 0;

        // Wait for the start signal
        synchronized (startFlag) {
            while (!startFlag) {
                try {
                    startFlag.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        // Running loop
        while (true) {
            // Check if the thread is interrupted
            if (Thread.interrupted()) {
                return;
            }

            synchronized (participant) {
                // Move the animal forward
                Point currentLocation = participant.getLocation();
                boolean movedSuccessfully = participant.move(currentLocation);

                if (movedSuccessfully) {
                    moved += participant.getSpeed();
                    participant.consumeEnergy(participant.getSpeed());

                    // Check if the required distance has been reached
                    if (moved >= neededDistance) {
                        synchronized (finishFlag) {
                            finishFlag = true;
                            finishFlag.notify();
                        }
                        return;
                    }
                } else {
                    // If the animal cannot move, break the loop
                    return;
                }
            }

            // Sleep for a certain amount of time
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    // Function to change the sleep time
    public static void setSleepTime(long time) {
        sleepTime = time;
    }
}
