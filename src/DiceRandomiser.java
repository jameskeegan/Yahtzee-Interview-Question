import java.util.Random;

public class DiceRandomiser {

    private static Random random = new Random();

    public static String getDiceRoll(){

        int[] diceRolls = new int[5];

        for (int i = 0; i < diceRolls.length; i++) {
            diceRolls[i] = getRandomRoll();
        }

        return formatRolls(diceRolls);
    }

    private static String formatRolls(int[] diceRolls) {
        return "(" + diceRolls[0] + ", " + diceRolls[1] + ", " + diceRolls[2] + ", " + diceRolls[3] + ", " + diceRolls[4]
                + ")";

    }

    private static int getRandomRoll() {return random.nextInt(6) + 1;}


}
