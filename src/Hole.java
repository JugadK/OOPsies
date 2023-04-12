import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Hole extends JComponent
{

    public Hole()
    {

    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double hole = new Ellipse2D.Double(0, 0, 200, 200);
        g2.draw(hole);


    }


}

