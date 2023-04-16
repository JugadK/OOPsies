package oop;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Goal extends JPanel
{

    public Goal()
    {

    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double goal = new Rectangle2D.Double(0, 0, 500, 500);
        g2.draw(goal);

    }


}

