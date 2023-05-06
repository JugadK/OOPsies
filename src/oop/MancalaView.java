package oop;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import oop.MancalaModel.MancalaSlot;
import oop.MancalaModel.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Arrays;
// This IS a JFrame

/**
 * 
 * @author jewgad
 * View for the Mancala
 */
public class MancalaView extends JFrame
{
    private MancalaModel model;
    private JButton undo;

    private JLabel status;
    
    public JButton confirmButton;
    
    JComboBox<String> startingSlotSizeCombo;
    JComboBox<Style> styleCombo;
    JDialog optionsDialog;
    
    Board board;

    /**
     * Constructs a new MancalaView object with the given model.
     *
     * @param model The model that this view is associated with.
     */
    public MancalaView(MancalaModel model)
    {
        this.model = new MancalaModel();

        setSize(1800, 800);
        //setLayout(new BorderLayout());
        
        optionsDialog = new JDialog(this, "Options", false);
        optionsDialog.setLayout(new GridLayout(0, 2));
        
        String[] startingSlotSizes = {"3", "4"};
        startingSlotSizeCombo = new JComboBox<>(startingSlotSizes);
        JLabel startingSlotSizeLabel = new JLabel("Starting Slot Size:");
        optionsDialog.add(startingSlotSizeLabel);
        optionsDialog.add(startingSlotSizeCombo);

        // Add a combo box for choosing the style
        Style[] styles = {new UbuntuStyle(), new BlackAndWhiteStyle(), new RedStyle(), };
        styleCombo = new JComboBox<>(styles);
        JLabel styleLabel = new JLabel("Style:");
        optionsDialog.add(styleLabel);
        optionsDialog.add(styleCombo);
        
        confirmButton = new JButton("Confirm");
       
        
        optionsDialog.add(confirmButton);

        
        optionsDialog.pack();
        optionsDialog.setLocationRelativeTo(this);
        optionsDialog.setVisible(true);
   
        
        this.board = new Board(this.model.getBoard());

        add(board, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        undo = new JButton("Undo");

        bottomPanel.add(undo);

        status = new JLabel(this.model.getCurrPlayer());
        bottomPanel.add(status);

        add(bottomPanel, BorderLayout.SOUTH);
        
		model.addSlotChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
			{
            	System.out.println(Arrays.toString(model.getBoard()));

				// Update the current status
				getStatus().setText(model.getCurrPlayer());
				
				if(model.winningPlayer != null) {
					getStatus().setText(model.winningPlayer);
				}
				
				getStatus().repaint();

				// Get the stones from the updated model
                board.paintHoles(model.getBoard());
                board.repaint();
            }
        });
		
		model.addStyleChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				model.style.applyStyle(board);
			}
		});


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        setVisible(true);
        
    }
    

	/**
	 * Adds an ActionListener to the undo button.
	 * @param listener The ActionListener to add.
	 */
    public void addUndoButton(ActionListener listener)
    {
    	undo.addActionListener(listener);
    }

    /**
     * Adds MouseListeners to the mancala holes on the board.
     * @param listeners An array of MouseListeners to add.
     */
    public void addMancalaHoleListener(MouseListener[] listeners) {
    	
    	this.board.addMancalaHoleListeners(listeners);
    }
    
    /**
     * Returns the JLabel that displays the current status of the game.
     * @return The JLabel that displays the current status of the game.
     */
    public JLabel getStatus()
    {
        return status;
    }

}



