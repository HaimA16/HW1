
package Tournaments;

import java.util.*;

/**
 * the scores class
 */
public class Scores {
    private Map<String, Date> scores;

    /**
     * Constructor
     */
    public Scores(){
        scores= Collections.synchronizedMap(new HashMap<>());
    }

    /**
     * Adding String,Date to scores
     * @param name of the team
     */
    public void add(String name){
        scores.put(name,new Date());
        System.out.println(scores);
    }

    /**
     * get all
     * @return Scores
     */
    public Map getAll(){
        return scores;
    }
}
