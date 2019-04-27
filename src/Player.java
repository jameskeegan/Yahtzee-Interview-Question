import java.util.ArrayList;
import java.util.Arrays;

/**
 * Holds all of the assets for each player
 * Is initialised for each player
 */
public class Player {

    private String name;
    private int score;

    // TODO: 27/04/2019 Add more options 
    private final String[] choices = new String[]{"ones", "twos", "threes", "fours", "fives", "sixes", "fullhouse"};
    private ArrayList<String> choicesLeft;

    public Player(String playerName){
        choicesLeft = new ArrayList<>(Arrays.asList(choices));
        this.name = playerName;
    }

    // valid choice if the person hasn't picked that option yet
    public boolean checkValidChoice(String choice){
        return choicesLeft.contains(choice);
    }

    // removes a choice from the arraylist once it has been selected
    public void removeChoice(String choice){
        choicesLeft.remove(choice);
    }

    public String getName() {
        return name;
    }

    public int getScore(){
        return score;
    }

    public void incrementScoreBy(int add){
        score += add;
    }

}
