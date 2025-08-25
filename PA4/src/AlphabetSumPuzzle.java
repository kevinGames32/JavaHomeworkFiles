import java.util.ArrayList;
import java.util.Scanner;

public class AlphabetSumPuzzle {
    private static ArrayList<Character> variables = new ArrayList<>();//all variables in the puzzle

    private static ArrayList<String>operands = new ArrayList<>();//all sum operands given by keyboard

    private static String result = null;

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        while(keyboard.hasNextLine()){
            String puzzle = keyboard.nextLine();
            String[] tokens = puzzle.split("[^a-zA-Z]");
            System.out.println("enter 1 for all answers, 2 for no leading zeroes");
            int option = keyboard.nextInt();

            for(int i = 0; i < tokens.length-1;i++)
                if(tokens[i].length() != 0)
                    operands.add(tokens[i]);//all tokens but the last one represent the sum operands
            result = tokens[tokens.length-1];//last token must be the sum result
            int[] digitValues = new int[256];//maps characters to digits
            for(int i = 0; i < 256;i++)//initialize digitValues to -1
                digitValues[i] = -1;//symbol for empty cell!
            //solve method is called here
            findAllVariables(puzzle);//detect every character participating in the puzzle and store it in the list of variables
            printAllCombinations(digitValues, option);
            break;
        }
    }

    private static void findAllVariables(String puzzle) {
        variables.clear();
        for(char c: puzzle.toCharArray())
            if(Character.isLetter(c) && !variables.contains(c))
                variables.add(c);
    }

    private static int numericalValue(String word, int[] digitValues) {
        int rv = 0;
        for(char c: word.toCharArray())
            if(digitValues[c] < 0)//if c is not assigned to any value
                return -1;//error
            else
                rv = 10 * rv + digitValues[c];
        return rv;
    }
    private static boolean checkleadingZeroes(int[] digitValues) {
        char[] opToken = null;

        for (int i = 0; i < operands.size(); i++) {
            opToken = operands.get(i).toCharArray();
            if(digitValues[opToken[0]] == 0)
                return false;
        }
        return true;
    }
    private static void printAllCombinations(int[] digitValues, int option){
        boolean Done = true;
        char uv = 0;
        for(char variable: variables){
            if(digitValues[variable] == -1) {
                Done = false;
                uv = variable;
                break;
            }
        }

        if(option == 1){
            if (Done) {
                int LHS = 0;
                for (String op : operands) {
                    LHS += numericalValue(op, digitValues);

                }
                int RHS = numericalValue(result, digitValues);
                if (LHS == RHS) {
                    for (char variable : variables)
                        //if(checkleadingZeroes(digitValues))
                        System.out.print(variable + ": " + digitValues[variable] + "|");
                    //if(checkleadingZeroes(digitValues))
                    System.out.println();
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    digitValues[uv] = i;
                    printAllCombinations(digitValues, option);
                }
                digitValues[uv] = -1;
            }
        }
        if(option == 2){
            if (Done) {
                int LHS = 0;
                for (String op : operands) {
                    LHS += numericalValue(op, digitValues);

                }
                int RHS = numericalValue(result, digitValues);
                if (LHS == RHS) {
                    for (char variable : variables)
                        if(checkleadingZeroes(digitValues)){
                            System.out.print(variable + ": " + digitValues[variable] + "|");
                        }
                    if(checkleadingZeroes(digitValues)){
                        System.out.println();
                    }
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    digitValues[uv] = i;
                    printAllCombinations(digitValues, option);
                }
                digitValues[uv] = -1;
            }
        }

    }
}