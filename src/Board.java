import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{

    public Board()
    {
        setLayout(new GridLayout(2, 6));

        for (int i = 0; i < 12; i++)
        {
            add(new Hole());
        }


    }

}