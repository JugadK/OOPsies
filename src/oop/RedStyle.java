package oop;

import java.awt.Color;

import javax.swing.JPanel;

/*
Represents a style of the Mancala board with a red color scheme.
*/
public class RedStyle implements Style {

	/**
    Applies the RedStyle to the given board by setting the background and foreground colors of the holes panel
    and the board panel.
    @param board The board to apply the style to.
    */
    public void applyStyle(Board board) {

    board.setBackground(new Color(111,47,55));

    board.holesPanel.setBackground(new Color(30,1,5));
    board.holesPanel.setForeground(new Color(208, 61, 86));
    }

    /**
    Returns the name of the RedStyle as a String.
    @return The name of the RedStyle.
    */
    public String toString() {
    return "Red Style";
    }

}