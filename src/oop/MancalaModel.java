package oop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


import oop.MancalaModel.MancalaSlot;
import oop.MancalaModel.Player;

public class MancalaModel 
{

    // Mancalla, 2 goal end, 6 x 2 circles, each can hold 4 marbles max
    // A1, A2, A3, A4, A5, A6, B1, B2, B3, B4, B5, B6 are the circles respectively

    // Maybe for data structure a HashMap of Integers? Where each "A1, A2" can be the key and the value is an Integer?
	
	public enum Player {
		PLAYERA,
		PLAYERB
	}
	
	public enum MancalaSlot {
        A1(0), A2(1), A3(2), A4(3), A5(4), A6(5), A7(6),
        B1(7), B2(8), B3(9), B4(10), B5(11), B6(12), B7(13);
        
        private final int index;
        
        MancalaSlot(int index) {
            this.index = index;
        }
        
        public int getIndex() {
            return index;
        }
        
        public static MancalaSlot getEnum(int index) {
        	
        	MancalaSlot slot = null;
        	
        	for (MancalaSlot s : MancalaSlot.values()) {
        	    if (s.getIndex() == index) {
        	        slot = s;
        	        break;
        	    }
        	}
        	
        	return slot;
        }
    }

	
	final static int BOARD_SIZE = 14;
    
    private int[] board;
    private ArrayList<ChangeListener> slotListeners;   
    
    Player currPlayer;
    
    public MancalaModel() 
    { 
		
    	 this.slotListeners = new ArrayList<>();
    	 
    	 this.currPlayer = Player.PLAYERA;
    	
		 board = new int[BOARD_SIZE];
		 
		 board[MancalaSlot.A1.getIndex()] = 3;
		 board[MancalaSlot.A2.getIndex()] = 3;
		 board[MancalaSlot.A3.getIndex()] = 3;
		 board[MancalaSlot.A4.getIndex()] = 3;
		 board[MancalaSlot.A5.getIndex()] = 3;
		 board[MancalaSlot.A6.getIndex()] = 3;
		 
		 // This will be the score for Player A. I'm thinking 
		 //about just incrementing and then when it gets to 6 and then you +1, it will be 7 so it'll go to Player A
		 
		 board[MancalaSlot.A7.getIndex()] = 0;
		 
		 board[MancalaSlot.B1.getIndex()] = 3;
		 board[MancalaSlot.B2.getIndex()] = 3;
		 board[MancalaSlot.B3.getIndex()] = 3;
		 board[MancalaSlot.B4.getIndex()] = 3;
		 board[MancalaSlot.B5.getIndex()] = 3;
		 board[MancalaSlot.B6.getIndex()] = 3;
		 
			 // Player B score
		 board[MancalaSlot.B7.getIndex()] = 0;
    }
    
    public int[] getBoard() {
    	return this.board;
    }
    
	
	// Returns ending slot
	public MancalaSlot seedStones(MancalaSlot slot) {
		
		
		System.out.println("Hello");
		Player player = currPlayer;
		
    	int index = slot.getIndex();
    	
    	int stones = board[index];
    	board[index] = 0;
    	
    	while(stones > 0) {
    		
    		index = (index - 1);
    		
    		if(index < 0)
    			index = BOARD_SIZE-1;
    			
    		
    		System.out.println(index % 14);
    		
    		if(index == MancalaSlot.B7.getIndex() && player == Player.PLAYERA ||
    		   index == MancalaSlot.A7.getIndex() && player == Player.PLAYERB) {
    			continue;
    		}
    		
    		board[index]++;
    		stones--;
    	}
    	
    	notifySlotListeners();
    	
    	MancalaSlot mSlot = MancalaSlot.getEnum(index);
    	
    	handlePlayerSwap(mSlot);
    	    		
    	
    	return mSlot;
	}
	
	
	public void handlePlayerSwap(MancalaSlot slot) {
		
		if(currPlayer == Player.PLAYERA && slot != MancalaSlot.A7) 
			this.currPlayer = Player.PLAYERB;
		else if (currPlayer == Player.PLAYERB && slot != MancalaSlot.B7)
			this.currPlayer = Player.PLAYERA;
		
		
		
	}
	
	public void notifySlotListeners() {
		
		ChangeEvent event = new ChangeEvent(this);
    	for(ChangeListener l : slotListeners) {
    		l.stateChanged(event);
    	}
	}
	
	public void addSlotChangeListener(ChangeListener listener) {
		slotListeners.add(listener);
	}
}
