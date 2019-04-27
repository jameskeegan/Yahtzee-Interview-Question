import java.util.ArrayList;
import java.util.Scanner;

/**
 * The actual main hub for the game
 * Gets players, runs the game, and produces the end screen
 */
public class GameManager {

    private final int gameLength = 4;
    private final int maxNumberPlayers = 4;

    private ArrayList<Player> players = new ArrayList<>();


    public GameManager(){

        System.out.println("Welcome to the game!");

        getPlayers();
        runGame();
        endGame();

    }

    /**
     * Players are entered in at the command line at the start of the game
     */
    private void getPlayers() {

        System.out.println("To add a new player, enter them here. To finish entering, enter 'd'.");

        // can only have a maximum of four players, so that's the max number of times we loop
        while(players.size() != maxNumberPlayers){
            System.out.print("Add a player (or 'f'): ");
            String input = getInput();
            if(input.equals("f")) break;

            // the name is the unique id of each player, and so must be unique
            if(playerNameIsUnique(input)){
                // name is unique, so player is added to the list of players
                players.add(new Player(input));

                // print list of all players each time
                System.out.println("Current players: " + printAllPlayers());
            }else{
                // name is invalid, and so isn't added to list of players
                System.out.println("Invalid name: can't have two players with the same name. Idiot.");
            }

        }


    }

    // prints all players in the format: "Name1, Name2 ..."
    private String printAllPlayers() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < players.size(); i++) {
            str.append(players.get(i).getName());

            if(i != players.size()-1){
                str.append(", ");
            }

        }

        return str.toString();
    }

    // checks if player name doesn't match an existing name
    private boolean playerNameIsUnique(String input) {

        // no need to check as no players have been initialised so far
        if(players.size() == 0) return true;

        for(Player p : players){
            if(input.equals(p.getName())) return false;
        }

        return true;

    }

    private void runGame(){

        // flushes console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("The game begins... now!\n\n\n");

        // each player takes a turn until max number of turns has been reached
        for(int i=0; i<gameLength; i++){
            for(Player p : players){
                turn(p);
            }
        }
    }

    // once game has ended, the winner is produced
    private void endGame(){
        int highestScore = 0;
        String winnerName = "";

        for(Player p : players){
            if(p.getScore() > highestScore){
                winnerName = p.getName();
                highestScore = p.getScore();
            }
        }

        System.out.println("\n\n\nWinner: " + winnerName + " with " + highestScore + " points!");
    }

    // gets random dice roll, then player input, then passes that to turn taker
    private void turn(Player p) {

        String randomDiceValues = DiceRandomiser.getDiceRoll();

        System.out.println("Player " + p.getName() + " - you rolled " + randomDiceValues);
        System.out.println("Enter in your choice of category: ");

        String choice = randomDiceValues + " " + getInput();

        TurnTaker.takeTurn(p, choice);
    }

    // gets player input from the command line
    private String getInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

}