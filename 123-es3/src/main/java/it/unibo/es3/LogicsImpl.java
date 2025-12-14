package it.unibo.es3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics{

    private final Map<Pair<Integer, Integer>, Boolean> grid = new LinkedHashMap<>();
    private int gridWidth;
    private int stepInedex = -1;
    private final Set<Pair<Integer, Integer>> startingPoints = new LinkedHashSet<>();

    public LogicsImpl(final int gridWidth, final int startingPointsQuantity){

        if (gridWidth < 2){
            throw new IllegalArgumentException("grid width must be at least 2");
        }

        if (startingPointsQuantity < 1){
            throw new IllegalArgumentException("at least 1 starting point is required");
        }

        this.gridWidth = gridWidth;

        for (int i = 0; i < gridWidth; i++){
            for (int j = 0; j < gridWidth; j++){
                grid.put(new Pair<>(i,j), false);
            }    
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Integer> start(final int startingPointsQuantity){

        if (startingPointsQuantity >= gridWidth * gridWidth) {
            throw new IllegalArgumentException("too many starting points");
        }   

        final List<Integer> statingPointsIndex = new ArrayList<>();
        final Random random = new Random();
        int pointsCreated = 0;

        while (pointsCreated < startingPointsQuantity){

            int point = random.nextInt(gridWidth * gridWidth);
            if (!startingPoints.contains(intToPair(point))){
                startingPoints.add(intToPair(point));
                statingPointsIndex.add(point);
                pointsCreated++;
            }

        }

        stepInedex++;
        return Collections.unmodifiableList(statingPointsIndex);
    }

    /**
     * {@inheritDoc}
     */
    public List<Integer> nextStep(){
        
        startingPoints.forEach(x -> {
            expandPoint(x);
        });

        stepInedex++;
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean IsGameOver(){
        return false;
    }

    private int pairToInt(final Pair<Integer, Integer> pair){
        return pair.y() * gridWidth + pair.x();
    }

    private Pair<Integer, Integer> intToPair(final int i){
        return new Pair<>( i % gridWidth, i / gridWidth);
    }

    private void turnOn(final Pair<Integer, Integer> position){
        if (position.x() < 0 || position.x() >= gridWidth 
            || position.y() < 0 || position.y() >= gridWidth){
                return;
        }
        grid.put(position, true);
    }

    private void expandPoint(final Pair<Integer, Integer> position){

    }
}
