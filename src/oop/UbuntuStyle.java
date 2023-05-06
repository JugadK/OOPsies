package oop;

import java.awt.Color;

/**
 * 
 * @author jewgad
 * a board style thats modelled after the Ubuntu colors
 */
public class UbuntuStyle implements Style {

	/**
	 * Applies style to the board
	 */
	@Override
	public void applyStyle(Board board) {
		
		board.setBackground(new Color(44, 0, 30));
		board.setForeground(new Color(233, 84, 32));
		
		board.holesPanel.setBackground(new Color(119, 41, 83));
		board.holesPanel.setForeground(new Color(233, 84, 32));
	}

	/**
	 * returns name of the style as a string
	 */
	public String toString() {
		return "Ubuntu Style";
	}
}
