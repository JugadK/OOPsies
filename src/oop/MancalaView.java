package oop;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import oop.MancalaModel.MancalaSlot;
import oop.MancalaModel.Player;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Arrays;

// This IS a JFrame
public class MancalaView extends JFrame
{
    private MancalaModel model;
    private JButton undo;
    
    Board board;

    public MancalaView(MancalaModel model)
    {
        this.model = new MancalaModel();
        
        setSize(2000, 800);
        //setLayout(new BorderLayout());
        
        this.board = new Board(this.model.getBoard());
        
        
        
        add(board, BorderLayout.CENTER);
        
        undo = new JButton("Undo");
        add(undo, BorderLayout.SOUTH);
        


        //Goal goal1 = new Goal();
        //add(goal1);

        //Goal goal2 = new Goal();
        //add(goal2);
        
        

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    


    public void addUndoButton(ActionListener listener) {
    	undo.addActionListener(listener);
    }

    
    public void addMancalaHoleListener(MouseListener[] listeners) {
    	
    	this.board.addMancalaHoleListeners(listeners);
    }

}



