package it.unibo.es3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics{

    private final Map<Pair<Integer, Integer>, Boolean> grid = new LinkedHashMap<>();
    private int gridWidth;
    private int stepIndex = -1;
    private final Set<Pair<Integer, Integer>> startingPoints = new LinkedHashSet<>();
    private List<Integer> onPointsBuffer = new LinkedList<>();

    public LogicsImpl(final int gridWidth){

        if (gridWidth < 2){
            throw new IllegalArgumentException("grid width must be at least 2");
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

        if (startingPointsQuantity < 1){
            throw new IllegalArgumentException("at least 1 starting point is required");
        }

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

        stepIndex++;
        return Collections.unmodifiableList(statingPointsIndex);
    }

    /**
     * {@inheritDoc}
     */
    public List<Integer> nextStep(){

        onPointsBuffer = new ArrayList<>();
        stepIndex++;
        
        startingPoints.forEach(x -> {
            expandPoint(x);
        });

        return Collections.unmodifiableList(onPointsBuffer);
    }

    /**
     * {@inheritDoc}
     */
    public boolean IsGameOver(){

        for (Boolean value : grid.values()) {
            if (false == value){
                return false;
            }
        };

        return true;
    }

    private int pairToInt(final Pair<Integer, Integer> pair){
        return pair.y() * gridWidth + pair.x();
    }

    private Pair<Integer, Integer> intToPair(final int i){
        return new Pair<>( i % gridWidth, i / gridWidth);
    }

    private void turnOn(final Pair<Integer, Integer> position){
        if (position.x() < 0 
            || position.x() >= gridWidth 
            || position.y() < 0 
            || position.y() >= gridWidth
            || true == grid.get(position)){
            return;
        }
        grid.put(position, true);
        onPointsBuffer.add(pairToInt(position));
    }

    private void expandPoint(final Pair<Integer, Integer> position){
        
        for (int i = (position.x() - stepIndex); i <= (position.x() + stepIndex); i++){
            turnOn(new Pair<>(i, position.y() - stepIndex));
            turnOn(new Pair<>(i, position.y() + stepIndex));
        }

        for (int j = (position.y() + 1 - stepIndex); j < (position.y() + stepIndex); j++){
            turnOn(new Pair<>(position.x() - stepIndex, j));
            turnOn(new Pair<>(position.x() + stepIndex, j));
        }
    }
}
