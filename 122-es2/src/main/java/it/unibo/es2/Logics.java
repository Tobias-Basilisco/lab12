package it.unibo.es2;


public interface Logics {

    /**
     * toggles the state of a spot in a given position x,y
     * @param position
     * @return true if game is over
     */
    boolean toggleSpot(Pair<Integer, Integer> position);
    
    /**
     * calculates if a new line is been created turning on the spot in the given osition
     * @param position
     * @return true if game is over
     */
    boolean isGameOver(Pair<Integer, Integer> position);
    
}
