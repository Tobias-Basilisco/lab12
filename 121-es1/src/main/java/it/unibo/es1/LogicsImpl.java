package it.unibo.es1;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private List<Integer> slots = new ArrayList<>();
    private final String START_RESULT = "<<";
    private final String END_RESULT = ">>";

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        if (size < 0){
            throw new InvalidParameterException("slot quantity must be higher than 0");
        }
        slots = new ArrayList<>(Collections.nCopies(size, 0));
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START_RESULT);
        for (int i = 0; i < slots.size(); i++){
            stringBuilder.append(String.valueOf(slots.get(i)));
            if (i < slots.size() -1){
                stringBuilder.append("|");
            } else{
                stringBuilder.append(END_RESULT);
            }
        } 

        return stringBuilder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        for (final int s : slots){
            if (s != slots.get(0)){
                return false;
            }
        }
        return true;
    }

}
