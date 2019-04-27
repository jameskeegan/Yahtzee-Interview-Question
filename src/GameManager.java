import java.util.ArrayList;
import java.util.Scanner;

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

    private void getPlayers() {

        System.out.println("To add a new player, enter them here. To finish entering, enter 'd'.");

        while(players.size() != maxNumberPlayers){
            System.out.print("Add a player (or 'f'): ");
            String input = getInput();
            if(input.equals("f")) break;

            if(playerNameIsUnique(input)){
                players.add(new Player(input));
                System.out.println("Current players: " + printAllPlayers());
            }else{
                System.out.println("Invalid name: can't have two players with the same name. Idiot.");
            }

        }


    }

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

    private boolean playerNameIsUnique(String input) {

        if(players.size() == 0) return true;

        for(Player p : players){
            if(input.equals(p.getName())) return false;
        }

        return true;

    }

    private void runGame(){

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("The game begins... now!\n\n\n");

        for(int i=0; i<gameLength; i++){
            for(Player p : players){
                turn(p);
            }
        }
    }

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

    private void turn(Player p) {

        String randomDiceValues = DiceRandomiser.getDiceRoll();

        System.out.println("Player " + p.getName() + " - you rolled " + randomDiceValues);
        System.out.println("Enter in your choice of category: ");

        String choice = randomDiceValues + " " + getInput();

        TurnTaker.takeTurn(p, choice);
    }

    private String getInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

}