public class TurnTaker {

    public static void takeTurn(Player p, String input){

        UserInput userInput = new UserInput(input);

        // first, check if user input was valid and acceptable
        if(!p.checkValidChoice(userInput.getCategoryChosen())) return;

        // if valid, then get the score and return that
        p.incrementScoreBy(CalculateScore.getTurnScore(userInput));

        // after this, it removes that choice from the arraylist
        p.removeChoice(userInput.getCategoryChosen());
    }

}
