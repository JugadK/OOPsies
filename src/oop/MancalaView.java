package oop;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import oop.MancalaModel.MancalaSlot;
import oop.MancalaModel.Player;

import java.awt.*;

// This IS a JFrame
public class MancalaView extends JFrame
{
    private MancalaModel model;

    public MancalaView(MancalaModel model)
    {
        this.model = new MancalaModel();
        
        setSize(2000, 800);

        Board board = new Board(this.model.getBoard());
        add(board, BorderLayout.CENTER);
        
        model.addSlotChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                board.repaint();
            }
        });


        Goal goal1 = new Goal();
        add(goal1, BorderLayout.WEST);

        Goal goal2 = new Goal();
        add(goal2, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);

    }

}



