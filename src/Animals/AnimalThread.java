package Animals;
import Mobility.Point;

public class AnimalThread extends Thread implements Runnable {
    private Animal participant;
    private double neededDistance;
    private Boolean startFlag;
    private Boolean finishFlag;
    private static long sleepTime = 100; // Default sleep time in milliseconds

    /**
     * Constructor
     * @param animal animal to run
     * @param distance Distance
     * @param startF Start flag
     * @param finalF Finish flag
     */
    public AnimalThread(Animal animal, double distance, Boolean startF, Boolean finalF) {
        participant = animal;
        neededDistance = distance;
        startFlag = startF;
        finishFlag = finalF;
    }

    @Override
    public void run() {
        // 1. Wait until startFlag is true
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

        double distanceCovered = 0;

        while (!Thread.interrupted() && distanceCovered < neededDistance) {
            // 2. Check if the thread is interrupted
            if (Thread.interrupted()) {
                return;
            }

            // 3. Move the animal forward
            synchronized (participant) {
                if (participant.move(new Point(participant.getLocation().getX() + (int) participant.getSpeed(), participant.getLocation().getY()))) {
                    distanceCovered += participant.getSpeed();
                    participant.consumeEnergy(participant.getSpeed());
                } else {
                    break;
                }

                // Check if the needed distance is covered
                if (distanceCovered >= neededDistance) {
                    synchronized (finishFlag) {
                        finishFlag = true;
                        finishFlag.notifyAll();
                    }
                    break;
                }
            }

            // 4. Sleep for the specified time
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
