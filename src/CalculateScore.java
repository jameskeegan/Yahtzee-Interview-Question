import java.util.Arrays;
import java.util.HashMap;

public class CalculateScore {

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

    public static int numberChoice(int n, int[] valuesRolled){
        // filters list to only values that match n, then gets the length of said list
        return (int) Arrays.stream(valuesRolled).filter(value -> value == n).count() * n;
    }

    public static int fullHouse(int[] valuesRolled){

        HashMap<Integer, Integer> diceAndCount = new HashMap<>();

        for(int key : valuesRolled){
            if(diceAndCount.containsKey(key)){
                diceAndCount.put(key, diceAndCount.get(key) + 1);
            }else{
                diceAndCount.put(key, 1);
            }
        }

        if(diceAndCount.keySet().toArray().length != 2) return 0;

        if(!diceAndCount.containsValue(3) && !diceAndCount.containsValue(2)) return 0;

        int a = (Integer) diceAndCount.keySet().toArray()[0] * 2;

        int diceValue1 = (Integer) diceAndCount.keySet().toArray()[0];
        int diceValue2 = (Integer) diceAndCount.keySet().toArray()[1];

        return (Integer) diceValue1 * diceAndCount.get(diceValue1) + diceValue2 * diceAndCount.get(diceValue2);
    }

}
