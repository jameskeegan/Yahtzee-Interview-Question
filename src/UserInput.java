/**
 * Holds the values of the dice roll and category chosen for this user's turn
 */
public class UserInput {

    private String categoryChosen;
    private int[] valuesRolled;

    // saves the parsed input in the variables shown
    public UserInput(String input){
        valuesRolled = Parser.parseDiceValues(input);
        categoryChosen = Parser.parseCategoryChosen(input);
    }

    public String getCategoryChosen(){
        return categoryChosen;
    }

    public int[] getValuesRolled(){
        return valuesRolled;
    }

}
