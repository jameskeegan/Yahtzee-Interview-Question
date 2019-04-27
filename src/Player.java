import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private String name;
    private int score;

    private final String[] choices = new String[]{"ones", "twos", "threes", "fours", "fives", "sixes", "fullhouse"};
    private ArrayList<String> choicesLeft;

    public Player(String playerName){
        choicesLeft = new ArrayList<>(Arrays.asList(choices));
        this.name = playerName;
    }

    public boolean checkValidChoice(String choice){
        return choicesLeft.contains(choice);
    }

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
