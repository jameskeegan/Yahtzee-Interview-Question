import java.util.Arrays;
import java.util.HashMap;

/**
 * Main scorer class, which takes the input and calculates a score from that
 */
public class Scorer {

    /**
     * checks which option has been inputted, then returns a score from taht
     * @param userInput the dice values rolled and category choice chosen
     * @return score gained from turn
     */
    public static int getTurnScore(UserInput userInput){

        switch (userInput.getCategoryChosen()){
            case "ones":
                return numberChoice(1, userInput.getValuesRolled());
            case "twos":
                return numberChoice(2, userInput.getValuesRolled());
            case "threes":
                return numberChoice(3, userInput.getValuesRolled());
            case "fours":
                return numberChoice(4, userInput.getValuesRolled());
            case "fives":
                return numberChoice(5, userInput.getValuesRolled());
            case "sixes":
                return numberChoice(6, userInput.getValuesRolled());
            case "fullhouse":
                return fullHouse(userInput.getValuesRolled());

        }

        return 0;
    }

    /**
     * For categories counting single values, returns score
     * @param n The number value chosen (e.g. "ones", "twos", etc) as an int
     * @param valuesRolled The dice values rolled
     * @return score gained from turn
     */
    public static int numberChoice(int n, int[] valuesRolled){
        // filters list to only values that match n, then gets the length of said list and multiplies by n
        return (int) Arrays.stream(valuesRolled).filter(value -> value == n).count() * n;
    }

    /**
     * Checks if user got a full house
     * @param valuesRolled The dice values rolled
     * @return score gained from turn
     */
    public static int fullHouse(int[] valuesRolled){

        // contains each unique value rolled in the dice, plus the number of time it appears
        HashMap<Integer, Integer> diceAndCount = new HashMap<>();

        // for each dice roll...
        for(int key : valuesRolled){
            // increment dice count if dice appears more than once
            if(diceAndCount.containsKey(key)){
                diceAndCount.put(key, diceAndCount.get(key) + 1);
            }else{
                // create entry in hash map for this value
                diceAndCount.put(key, 1);
            }
        }

        // means more than two different types of values were rolled, thus is invalid
        if(diceAndCount.keySet().toArray().length != 2) return 0;

        // there wasn't three of one type and two of the other, so was invalid
        if(!diceAndCount.containsValue(3) && !diceAndCount.containsValue(2)) return 0;


        // fullhouse is valid, so get score
        int diceValue1 = (Integer) diceAndCount.keySet().toArray()[0];
        int diceValue2 = (Integer) diceAndCount.keySet().toArray()[1];

        return (Integer) diceValue1 * diceAndCount.get(diceValue1) + diceValue2 * diceAndCount.get(diceValue2);
    }

}
