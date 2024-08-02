
package Tournaments;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * the tournament thread class
 */
public class TournamentThread implements Runnable {
    private Scores scores;
    private Boolean startSignal;
    private int groups;

    /**
     * Constructor
     * @param score Scores
     * @param start StartSignal
     * @param group number of groups
     */
    public TournamentThread(Scores score, Boolean start,int group){
        scores=score;
        startSignal=start;
        groups=group;
    }




    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        int teamsFinished=0;
        synchronized (startSignal){

            startSignal.notifyAll();
        }
        while (true){
            synchronized (scores){
                try {
                    scores.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            teamsFinished++;

            System.out.println("Scores updated");
            if(teamsFinished==groups){
                break;
            }
        }
    }
}
