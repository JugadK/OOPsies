package oop;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 
 * @author jewgad
 * Class that handles creating the Mancala Holes
 */
public class Goal extends Hole
{
	
	int stones;
	String name;
    private static final int CIRCLE_SIZE = 20;

    /**
     * constructor for Goal
     * @param stones - number of stones that should be inside the goal
     * @param name - name that should be printed inside the goal
     */
    public Goal(int stones, String name)
    {
    	super(stones, name);
    	this.stones = stones;
    	this.name = name;
    }
    
    /**
     * update the number of stones in goal
     */
    public void updateStones(int stones) {
    	this.stones = stones;
    }

    /**
     * paint the component
     * @param - Graphics g
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        Dimension size = getSize();
        
        setPreferredSize(new Dimension(100, 100));
        
        Rectangle2D.Double goal = new Rectangle2D.Double(0, 0, 98, 800);
        g2.draw(goal);
        
        
        g2.setFont(new Font("Arial", Font.BOLD, 15));
        g2.drawString(this.name, 10, 10);
        
        int stonesAdded = 0;
        
        int x = 0;
        int y = 0;
                                
        for(int i = 0; i < stones && stonesAdded < stones; i++) {
        	
            g2.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
            g2.drawOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
         	stonesAdded++;
        	
        	y += CIRCLE_SIZE;
        }
    }
}

