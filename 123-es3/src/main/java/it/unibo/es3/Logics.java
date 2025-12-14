package it.unibo.es3;

import java.util.List;

public interface Logics {
    
    /**
     * turns on the starting spots
     * @return list of indexes to turn on
     */
    List<Integer> start(final int startingPointsQuantity);

    /**
     * turns on the required spots from game logic
     * @return list of indexes to turn on
     */
    List<Integer> nextStep();

    /**
     * checks if game is over
     * @return true if game is over
     */
    boolean IsGameOver();
}
