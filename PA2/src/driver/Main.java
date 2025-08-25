package driver;
import util.BackgammonGame;

import java.util.*;
public class Main {
    private static Random random = new Random();
    private static int[] dice = new int[2];
    private static String first, second;
    private static BackgammonGame game;
    private static boolean blacksTurn;
    private static char intToDie(int die){
        return (char)(die + '\u267F');
    }
    private static void roleDice(){
        System.out.print((blacksTurn ? first : second) + " rolls the dice... ");
        dice[0] = random.nextInt(6) + 1;
        dice[1] = random.nextInt(6) + 1;
        System.out.printf("%c %c\n", intToDie(dice[0]), intToDie(dice[1]));
    }
    private static Scanner keyboard = new Scanner(System.in);
    private static void initialize(){
        System.out.println("Backgammon Game!");
        System.out.println("Enter the name of first player " +
                "playing with black pieces: ");
        first = keyboard.nextLine();
        System.out.println("Enter the name of second player " +
                "playing with white pieces: ");
        second = keyboard.nextLine();
        System.out.println("Starting the game...");
        System.out.println("Let's determine who plays first...");
        do {
            System.out.print(first + " rolls a die: ");
            dice[0] = random.nextInt(6) + 1;
            System.out.println(intToDie(dice[0]));
            System.out.print(second + " rolls the other die: ");
            dice[1] = random.nextInt(6) + 1;
            System.out.println(intToDie(dice[1]));
            if (dice[0] == dice[1])
                System.out.println("It's a tie! Let's try again");
        }while(dice[0] == dice[1]);
        if(dice[0] > dice[1]) {
            System.out.println("It's " + first + "'s turn to move!");
            blacksTurn = true;
        }
        else {
            System.out.println("It's " + second + "'s turn to move!");
            blacksTurn = false;
        }
    }
    private static void playPair(){
        System.out.println((blacksTurn ? first : second) + " has four " +
                intToDie(dice[0]) + "'s to play:");
        for(int i = 0; i < 4;i++) {
            System.out.print((blacksTurn ? first : second) + ": enter a move (n-m) for " +
                    intToDie(dice[0]) + ": ");
            while(!game.makeMove(keyboard.nextLine(),blacksTurn, dice[0]))
                System.out.println("Illegal move! Try again!");
            System.out.println(game);
        }
    }
    private static void playFirstDie(){
        System.out.print((blacksTurn ? first : second) + ": enter a move (n-m) for " +
                intToDie(dice[0]) + ": ");
        while(true){
            String move = keyboard.nextLine();
            if(move.equalsIgnoreCase("swap")) {
                int temp = dice[0];
                dice[0] = dice[1];
                dice[1] = temp;
                System.out.print("Swapped! " + (blacksTurn ? first : second) + ": enter a move (n-m) for " +
                        intToDie(dice[0]) + ": ");
                continue;
            }
            if (!game.makeMove(move, blacksTurn, dice[0]))
                System.out.println("Illegal move! Try again!");
            else
                break;
        }
        System.out.println(game);
    }
    private static void playSecondDie(){
        System.out.print((blacksTurn ? first : second) + ": enter a move (n-m) for " +
                intToDie(dice[1]) + ": ");
        while(!game.makeMove(keyboard.nextLine(),blacksTurn, dice[1]))
            System.out.println("Illegal move! Try again!");
        System.out.println(game);
    }
    public static void main(String[] args){
        initialize();
        game = new BackgammonGame(first, second);
        System.out.println(game);
        int count = 0;
        while (count++ != 10) {
            roleDice();
            if(dice[0] == dice[1]){//pair of dice has double values...
                playPair();
            }else{
                playFirstDie();
                playSecondDie();
            }
            blacksTurn = !blacksTurn;
        }
    }
}
