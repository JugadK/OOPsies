package oop;
import javax.swing.*;

import oop.MancalaModel.MancalaSlot;

import java.awt.*;
import java.awt.event.MouseListener;

/**
 * 
 * @author jewgad
 * Class that handles the ui for the Board 
 */
public class Board extends JPanel {

    // Array of Holes
    private Hole[] holes;
    
    
    JPanel holesPanel;

    /**
     * constructor for the Board
     * @param board - a 14 size array that represents the mancala board
     */
    public Board(int[] board)
    {
        // 2 x 6 holes, the remaining is for the goals
        holes = new Hole[14];
        setLayout(new BorderLayout());

        holesPanel = new JPanel(new GridLayout(2, 6));
        
        // Loop to make the holes, starting from Player B
        for (int i = 13; i > 6; i--)
        {
            Hole hole = new Hole(board[i], MancalaModel.MancalaSlot.getEnum(i).toString());
            holes[i] = hole;

            // Add holes
            if (i != 13)
            {
                holesPanel.add(hole);
            }

            // Add the goal
            else
            {
            	holes[i] = new Goal(board[i], "Mancala B");
            	add(holes[i], BorderLayout.WEST);
            }
            
        }

        // Holes for Player A
        for (int i = 0; i < 7; i++)
        {

            Hole hole = new Hole(board[i], MancalaModel.MancalaSlot.getEnum(i).toString());
            holes[i] = hole;

            // Add holes
            if (i != 6)
            {
                holesPanel.add(hole);
            }

            // Add the goals
            else
            {
            	holes[i] = new Goal(board[i], "Mancala A");
            	add(holes[i], BorderLayout.EAST);
            }
        }

        JPanel boardPanel = new JPanel(new BorderLayout());
                
        boardPanel.add(holesPanel, BorderLayout.CENTER);

        add(boardPanel, BorderLayout.CENTER);
        
        // Recalculate the layout and repaint the components
        // This fixes the mancala boards not showing up sometimes
        revalidate();
        repaint();
    }

    /**
     * repaint hole with updates values 
     * @param js - 14 size array that stores the values
     */
    public void paintHoles(int[] js)
    {
        for (int i = 0; i < 14; i++)
        {
            holes[i].updateStones(js[i]);
            holes[i].repaint();
        }
    }

    /**
     * adds listeners to each of the mancala holes
     * @param listeners - array of listeners that can be assigned to each slot;
     */
    public void addMancalaHoleListeners(MouseListener[] listeners) {
        for (int i = 0; i < 14; i++)
        {
            if (i == 6 | i == 13)
                continue;
            else {
                holes[i].addMouseListener(listeners[i]);
            }
        }
    }

}