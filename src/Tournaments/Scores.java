
package Tournaments;

import java.util.*;

public class Scores {
    private Map<String, Date> scores = Collections.synchronizedMap(new HashMap<>());

    public void add(String name) {
        scores.put(name, new Date());
    }

    public Map<String, Date> getAll() {
        return scores;
    }
}
