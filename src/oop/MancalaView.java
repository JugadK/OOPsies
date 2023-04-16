package oop;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import oop.MancalaModel.MancalaSlot;
import oop.MancalaModel.Player;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Arrays;

// This IS a JFrame
public class MancalaView extends JFrame
{
    private MancalaModel model;
    
    Board board;

    public MancalaView(MancalaModel model)
    {
        this.model = new MancalaModel();
        
        setSize(2000, 800);

        this.board = new Board(this.model.getBoard());
        
        add(board, BorderLayout.CENTER);


        Goal goal1 = new Goal();
        add(goal1, BorderLayout.WEST);

        Goal goal2 = new Goal();
        add(goal2, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    
    public void addMancalaHoleListener(MouseListener[] listeners) {
    	
    	this.board.addMancalaHoleListeners(listeners);
    }

}



