package it.unibo.es2;

import java.util.LinkedHashMap;
import java.util.Map;

public class LogicsImpl implements Logics {

    private final Map<Pair<Integer, Integer>, Boolean> grid = new LinkedHashMap<>();

    public LogicsImpl(final int size){

        if (size < 4 | size > 7 ){
            throw new IllegalArgumentException("Grid size must be in range 4-7 ");
        }

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                grid.put(new Pair<>(i,j), false);
            }    
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toggleSpot(Pair<Integer, Integer> position){
        if (true == grid.get(position)){
            grid.put(position, false);
            return false;
        } else{
            grid.put(position, true);
            return true;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isGameOver(Pair<Integer, Integer> position){
        return false;
    }

}
