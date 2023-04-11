import java.util.HashMap;
import java.util.Map;

public class MancalaModel
{

    // Mancalla, 2 goal end, 6 x 2 circles, each can hold 4 marbles max
    // A1, A2, A3, A4, A5, A6, B1, B2, B3, B4, B5, B6 are the circles respectively

    // Maybe for data structure a HashMap of Integers? Where each "A1, A2" can be the key and the value is an Integer?


    private Map<String, Integer> hold;
    public MancalaModel()
    {
        hold = new HashMap<>();
        hold.put("A1", 3);
        hold.put("A2", 3);
        hold.put("A3", 3);
        hold.put("A4", 3);
        hold.put("A5", 3);
        hold.put("A6", 3);

        // This will be the score for Player A. I'm thinking about just incrementing and then when it gets to 6 and then you +1, it will be 7 so it'll go to Player A
        hold.put("A7", 0);

        hold.put("B1", 3);
        hold.put("B2", 3);
        hold.put("B3", 3);
        hold.put("B4", 3);
        hold.put("B5", 3);
        hold.put("B6", 3);

        // This will be the score for Player B. Similar logical process to Player A
        hold.put("B7", 0);

    }


}