package it.unibo.es3;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics{

    private final Map<Pair<Integer, Integer>, Boolean> grid = new LinkedHashMap<>();
    private int gridSize;
    private int stageInedex;
    private final Set<Pair<Integer, Integer>> startingPoints = new LinkedHashSet<>();

    public LogicsImpl(final int gridSize){
        
        if (gridSize < 2){
            throw new IllegalArgumentException("grid size must be at least 2");
        }

        this.gridSize = gridSize;

        for (int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridSize; j++){
                grid.put(new Pair<>(i,j), false);
            }    
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public List<Integer> start(){
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public List<Integer> nextStep(){
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean IsGameOver(){
        return false;
    }
}
