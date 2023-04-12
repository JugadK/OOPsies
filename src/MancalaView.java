import javax.swing.*;
import java.awt.*;

// This IS a JFrame
public class MancalaView extends JFrame
{
    private MancalaModel model;

    public MancalaView(MancalaModel model)
    {
        this.model = new MancalaModel();

        setSize(2000, 800);

        Board board = new Board();
        add(board, BorderLayout.CENTER);


        Goal goal1 = new Goal();
        add(goal1, BorderLayout.WEST);

        Goal goal2 = new Goal();
        add(goal2, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }



}



