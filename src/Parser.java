/**
 * Parses the input of the player
 * Assumes currently that the input is properly formatted
 */
public class Parser {

    private static int lengthOfDiceValues = 14;

    // String "in" is in the format "(x, y, z, a, b) fullhouse"
    public static int[] parseDiceValues(String in){

        // breaks down whole input into "(x, y, z, a, b"
        in = in.substring(0, lengthOfDiceValues);

        int[] toReturn = new int[5];

        int count = 1;

        for (int i = 0; i < toReturn.length; i++) {
            toReturn[i] = Integer.parseInt(Character.toString(in.charAt(count)));
            count = count+3;
        }

        return toReturn;
    }

    public static String parseCategoryChosen(String in){
        return in.substring(16);
    }

}
