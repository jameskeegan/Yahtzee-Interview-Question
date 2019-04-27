import java.util.Random;

/**
 * Randomises the dice rolls for the player
 */
public class DiceRandomiser {

    private static Random random = new Random();

    /**
     * gets five random dice rolls to represent a player's roll
     * @return returns them in the format "(x, y, z, a, b)", where the letters are dice values
     */
    public static String getDiceRoll(){

        int[] diceRolls = new int[5];

        for (int i = 0; i < diceRolls.length; i++) {
            diceRolls[i] = getRandomRoll();
        }

        return formatRolls(diceRolls);
    }

    // creates the correct format for the dice rolls
    private static String formatRolls(int[] diceRolls) {
        return "(" + diceRolls[0] + ", " + diceRolls[1] + ", " + diceRolls[2] + ", " + diceRolls[3] + ", " + diceRolls[4]
                + ")";

    }

    // returns random value between 1 and 6
    private static int getRandomRoll() {return random.nextInt(6) + 1;}


}
