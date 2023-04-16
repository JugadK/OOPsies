package oop;
import javax.swing.*;

import oop.MancalaModel.MancalaSlot;

import java.awt.*;

public class Board extends JPanel
{

    public Board(int[] board)
    {
    	
    	
        setLayout(new GridLayout(2, 6));

        for (int i = 0; i < 14; i++)
        {
        	
        	if(i == 6 | i == 13) {
        		// Mancola goal values
        	} else {
        		add(new Hole(board[i]));
        	}
        }


    }

}