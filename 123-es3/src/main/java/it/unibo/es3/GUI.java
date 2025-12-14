package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();
    private final String NEXT_TEXT = ">";
    private final int STARTING_POINTS_QUANTITY = 3;
    private Logics logics;
    private final String ON = "*";
    private final String OFF = " ";

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.logics = new LogicsImpl(width);
        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new GridLayout(width, width));
        this.getContentPane().add(BorderLayout.CENTER, panel);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final JButton button = new JButton(OFF);
                this.cells.add(button);
                panel.add(button);
            }
        }
        //turn on starting points
        var startingPoints = logics.start(STARTING_POINTS_QUANTITY);
        startingPoints.forEach( x -> {
            cells.get(x).setText(ON);
        });

        //Create nextStep button and add it to the panel
        final JButton nextStep = new JButton(NEXT_TEXT);
        nextStep.addActionListener(e -> {

        });
        this.getContentPane().add(BorderLayout.SOUTH, nextStep);
        pack();
        this.setVisible(true);
    }
}
