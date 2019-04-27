public class UserInput {

    private String categoryChosen;
    private int[] valuesRolled;

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
