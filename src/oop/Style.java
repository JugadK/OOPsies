package oop;

import javax.swing.JPanel;
/**
An interface for styles of the Mancala board.
*/
public interface Style {

	/**
    Applies the style to the given board.
    @param board The board to apply the style to.
    */
    public void applyStyle(Board board);
}