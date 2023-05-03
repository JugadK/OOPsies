package oop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import oop.MancalaModel.MancalaSlot;
import oop.MancalaModel.Player;

public class MancalaController
{
	  
	MancalaModel model;
	MancalaView view;

	// Takes in the view and the model
	public MancalaController(MancalaModel model, MancalaView view) {
		this.model = model;
		this.view = view;

		// Get the view and add a listener for the hole
		view.addMancalaHoleListener(createMouseListeners());
		
		model.addSlotChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
			{
            	System.out.println(Arrays.toString(model.getBoard()));

				// Update the current status
				view.getStatus().setText(model.getCurrPlayer());
				view.getStatus().repaint();

				// Get the stones from the updated model
                view.board.paintHoles(model.getBoard());
                view.board.repaint();
            }
        });
	
		view.addUndoButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Pop from the stack
				model.undo();
			}
		});
		 
	}
	
	
	public void seedMancalaPit(MancalaSlot slot)
	{
		
		model.seedStones(slot);
	}
	
	public MouseListener[] createMouseListeners() {
		
		MouseListener[] listeners = new MouseListener[14];
		
		
		for(int i = 0; i < 14; i++) {
			
			MancalaSlot slot = MancalaSlot.getEnum(i);
			
			   listeners[i] = new MouseListener() {
		            @Override
		            public void mouseClicked(MouseEvent e)
					{
		                seedMancalaPit(slot);
		            }

		            @Override
		            public void mousePressed(MouseEvent e) {
		                // Implement mousePressed event handling here
		            }

		            @Override
		            public void mouseReleased(MouseEvent e) {
		                // Implement mouseReleased event handling here
		            }

		            @Override
		            public void mouseEntered(MouseEvent e) {
		                // Implement mouseEntered event handling here
		            }

		            @Override
		            public void mouseExited(MouseEvent e) {
		                // Implement mouseExited event handling here
		            }
		        };			
			
		}
		
		return listeners;
		
	}
	
}
