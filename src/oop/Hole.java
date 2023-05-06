package oop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

/**
 * 
 * @author jewgad
 * JComponent that represents the mancala hole in the UI
 */
public class Hole extends JComponent
{
	
	int stones;
	String name;
    private static final int CIRCLE_SIZE = 20;
    
    /**
     * Constructor for the Hole
     * @param stones - number of stones in the hole
     * @param name - name that is printed on the hole
     */
    public Hole(int stones, String name)
    {
    	this.stones = stones;
    	this.name = name;
    }
    
    /**
     * update number of stones
     * @param stones - number of stones inside the hole
     */
    public void updateStones(int stones)
    {
    	this.stones = stones;
    }
    
    /**
     * Paints the componenet
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        // The hole
        Ellipse2D.Double hole = new Ellipse2D.Double(0, 0, 150, 150);
        g2.draw(hole);
        
        g2.setFont(new Font("Arial", Font.BOLD, 15));
        g2.drawString(this.name, 10, 10);
        
        
        int stonesAdded = 0;

        // Incrementing position of the stones, it shifts
        int x = 40;
        int y = 50;
                        
        for(int i = 0; i < stones && stonesAdded < stones; i++)
        {
        	for(int j = 0; j < 5 && stonesAdded < stones; j++)
            {
        		 //g2.setColor(Color.GRAY);
                 g2.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
                 //g2.setColor(Color.WHITE);
                 g2.drawOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
                 x += CIRCLE_SIZE;
             	stonesAdded++;
        	}
        	
        	x = 40;
        	y += CIRCLE_SIZE;
        }


    }


}

