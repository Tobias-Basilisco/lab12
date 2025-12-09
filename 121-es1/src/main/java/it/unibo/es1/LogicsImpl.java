package it.unibo.es1;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private static final String ERROR_MESSAGE = "Unimplemented method";
    private List<Integer> slots = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        if (size < 0){
            throw new InvalidParameterException("slot quantity must be higher than 0");
        }
        slots = new ArrayList<>(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return slots.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return Collections.unmodifiableList(slots);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        List<Boolean> states = new ArrayList<>();
        slots.forEach( s -> {
            if (s < slots.size()){
                states.add(true);
            } else{
                states.add(false);
            }
        });
        return states;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        slots.set(elem, slots.get(elem) + 1 );
        return slots.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        throw new UnsupportedOperationException(ERROR_MESSAGE);
    }

    // private class slot{
    //     private int hits = 0;
    //     private boolean enabled = true;

    //     public int getHits() {
    //         return hits;
    //     }

    //     public boolean isEnabled() {
    //         return enabled;
    //     }

    //     public void increment(){
    //         hits++;
    //     }

    //     public void disable(){
    //         enabled = false;
    //     }
    // }
}
