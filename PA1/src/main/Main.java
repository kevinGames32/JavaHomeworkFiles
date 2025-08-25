/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package main;
import util.*;

import java.util.Scanner;

public class Main {
    /*
     * Method used to check if received word is under the conditions of no non-alphabetical character
     * and capitalized initial letter*/
    private static boolean checkFirstName(String input) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c))
                return false;
        }
        return Character.isUpperCase(chars[0]);
    }


    //check if the last name matches conditions of capital letter and max 1 dot
    private static boolean checkLastName(String input) {
        char[] chars = input.toCharArray();
        int dotFound = 0;

        //check upper case
        if (Character.isUpperCase(chars[0])) {
            return true;
        }

        //loop around to check for dots
        for (char c : chars) {
            if (c == '.') {
                dotFound++;
                if (dotFound > 1) {
                    return false;
                }
                //check if name is only alphabetical
            } else if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    //method to check if the id has the correct specifications
    //the method will take the int input and convert it to a string so a char array can manipulate
    // and iterate the string, checking if there are laeding zeroes. if ther check passes
    //then if the charr array is the correct lenght it will completely pass the check
    private static boolean checkId(int input) {
        String temp = Integer.toString(input);
        char[] ints = temp.toCharArray();
        if ((ints[0] == 0)) {
            return false;
        }
        if (ints.length < 7 || ints.length > 7) {
            return false;
        }
//        for(char c : ints) {
//            if (Character.isDigit(c) == false) {
//            }
//            return false;
//        }
        return true;
    }

    private static boolean checkGrade(int score) {
        // Check if score is a non-negative integer that doesn't exceed 100
        return score >= 0 && score <= 100;
    }

    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to my grade book!\n" + "Please enter the information of the first student using the following format:");
        System.out.println("“first Name(capital first) last Name(Capital first and may have a dot) PID grade(max 7 digits no leading 0's)”\n");
        System.out.println("EXAMPLE: Ann Smith 1234567 93...");

	    while(true){//input handling phase
            System.out.println("");
            System.out.println("Press Enter when you are done or type DONE.");


            String input = keyboard.nextLine(); // take input as Kevin Quiceno 1234567 80


            //Checks if the word DONE is typed to quit out of the adding info phase
            if(input.equals("DONE")) break;
            String[] tokens = input.split(" "); // splits input as Kevin, Quiceno, 1234567, 80

            //check number of arguments passed
            if(tokens.length != 4){
                System.out.println("Invalid number of arguments, please try again:");
                continue;
            }

            //tokenize the input from the user to check and store if check is passed
            String firstName = tokens[0];
            String lastName = tokens[1];
            int id = Integer.parseInt(tokens[2]);
            int score = Integer.parseInt(tokens[3]);
            //check for first name correctness
            if(checkFirstName(firstName) == false){
                System.out.println("incorrect entry for first name, please try again: ");
                continue;
            }
            //check for first name correctness
            if(checkLastName(lastName) == false){
                System.out.println("incorrect entry for Last name, please try again: ");
                continue;
            }
            //check for ID correctness
            if(checkId(id) == false){
                System.out.println("incorrect entry for id, please try again: ");
                continue;
            }
            //check for score correctness
            if(checkGrade(score) == false){
                System.out.println("incorrect entry for score, please try again: ");
                continue;
            }
            //iff all checks are passed then the student will be added to the gradebook for later manipulation

            //make new object of grade
            Grade currentGrade = new Grade(score);
            //make new object of student and pass all the arguments to it
            Student CurrentStudent = new Student(firstName, lastName, id, currentGrade);
            gradebook.addStudent(CurrentStudent);


            //will asks the user to keep adding information until they are done
            System.out.println("");
            System.out.println("Please enter the information of the next student using the same format.");
            System.out.println("If there is no more students, please enter the keyword “DONE”");


        }
        //section to show the user all the possible commands to manipulate the gradebook to their desire
        System.out.println("This is the start of the command menu, Please select a command from this list.");
        System.out.println("");
        System.out.println("min score- min letter -max score -max letter -letter XXXXXXX (PID)");
        System.out.println("name XXXXXXX(PID) - change XXXXXXX YY (PID)(NEW GRADE)");
        System.out.println("-average score -average letter -median score -median letter -tab scores");
        System.out.println("tab letters -quit:");
        while(true){//command handling phase!

            //asks for the user input
            String command = keyboard.nextLine();
            if(command.equals("quit"))
                break;
            //will calculate the media score using the gradebook method calculateMedian
            else if (command.equals("median score")) {
                System.out.println("The median Score is: " + gradebook.calculateMedian());

            //Will calculate the median letter grade using the Grade class method
            }else if (command.equals("median letter")) {
                double medianScore = gradebook.calculateMedian();
                System.out.println("The Median letter is: " + Grade.convertScoreToLetter(medianScore));
            }
            //Will calculate the Average score by taking the input and will print the average
            else if (command.equals("average score")) {
                System.out.println("The average score is: " + gradebook.calculateAvg());


                //will find the student given the ID by spliting the command and using the method in the gradebook to
                // find the student
            }else if (command.startsWith("name ")) {
                String[] commandTokens = command.split(" ");
                int givenId = Integer.parseInt(commandTokens[1]);
                System.out.println("Full name is: "+ gradebook.getFullName(givenId));

                //will find the minimum score of the whole list of students
            }else if (command.equals("min score")) {
                System.out.println("The min score is: " + gradebook.minScore());

             //finds the same number as min.Score but transforms it to a letter using Grade's methods
            }else if (command.equals("min letter")) {

                System.out.println("The min letter is: " + Grade.convertScoreToLetter(gradebook.minScore()));

                //finds the max score of the whole list of students
            }else if (command.equals("max score")) {
                System.out.println("The Max score is: " + gradebook.maxScore());

                //finds the same value as max score but sets it to a letter grade
            }else if (command.equals("max letter")) {

                System.out.println("The max score letter is : " + Grade.convertScoreToLetter(gradebook.maxScore()));
            }

            //will find the exact letter grade of the students referenced by said ID
            else if (command.startsWith("letter ")) {
                String[] commandTokens = command.split(" ");
                int id = Integer.parseInt(commandTokens[1]);
                System.out.println("Letter grade of said ID is: " + gradebook.getLetterById(id));

                //will print the same info as average but in letter form using the Grade method
            } else if (command.equals("average letter")) {
                System.out.println("The letter average is: " + Grade.convertScoreToLetter(gradebook.calculateAvg()));
            }
            //will find and update the grade of the student referenced by the inputed PID to the inputed grade
            else if (command.startsWith("change ")) {
                String[] commandTokens = command.split(" ");
                int id = Integer.parseInt(commandTokens[1]);
                int score = Integer.parseInt(commandTokens[2]);
                gradebook.setNewScore(score, id);
                System.out.println("Score of: " + gradebook.getFullName(id) + ", has been changed to: " + gradebook.getGradeById(id));


                //will print all students in a table manner with 4 columns
                //First name - last Name - PID - Score
            } else if (command.equals("tab scores")) {
                gradebook.printTabScores();

                //will print all students in a table but will show the letter grades
            }else if (command.equals("tab letters")) {
                gradebook.printTabLetter();

                //warns user about the use of an incorrect command
            }else{
                System.out.println("incorrect Command please try again: ");
            }

      }
    }
 }
