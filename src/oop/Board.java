package oop;
import javax.swing.*;

import oop.MancalaModel.MancalaSlot;

import java.awt.*;
import java.awt.event.MouseListener;

public class Board extends JPanel
{
	
	Hole[] holes;

    public Board(int[] board)
    {
    	
    	holes = new Hole[14];
        setLayout(new GridLayout(2, 6));

        // Player B
        for (int i = 13; i > 6; i--)
        {
        	
        	Hole hole = new Hole(board[i]);
    		
    		holes[i] = hole;
        	
        	if(i != 13) {
        		// Mancola goal values
        		add(hole);
        	} 	
        }
        
        // Player A
        for(int i = 0; i < 7; i++) {
        	
        	Hole hole = new Hole(board[i]);
    		holes[i] = hole;
    		
    		if(i != 6)
    			add(hole);
        }


    }
    
    
    public void paintHoles(int[] js) {
    	for(int i = 0; i < 14; i++) {
    		holes[i].updateStones(js[i]);
    		holes[i].repaint();
    	}
    }

	public void addMancalaHoleListeners(MouseListener[] listeners) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 14; i++) {
			if(i == 6 | i == 13)
				continue;
			else {
				
				holes[i].addMouseListener(listeners[i]);
			}
		}
		
	}

}