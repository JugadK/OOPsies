import javax.swing.*;

// This IS a JFrame
public class MancalaView extends JFrame
{
    private MancalaModel model;

    public MancalaView(MancalaModel model)
    {
        this.model = new MancalaModel();

        setSize(500, 200);

    }
}



