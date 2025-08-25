//1. Write two public classes Gradebook and Student considering the following items:
//
//Class Student needs to store first name, last name, Panther ID, and score of a student (integer from 0 to 100).
//Class Gradebook needs to store an array of Student objects
//Both classes must have proper constructors that initialize their corresponding instance fields.
//Gradebook contains a public method to calculate average score, and another one that prints
// the list of students and their information in the form of a table (rows are separated by new lines, columns are separated by tabs).
//Gradebook contains a static method to convert score (out of 100) to a letter grade based on this course's grading policy available in the syllabus.

import java.util.Scanner;
public class Main {

    public void part1(){
        Gradebook gradebook = new Gradebook(3);

        Student student1 =new Student("Kevin", "Quiceno",6439955, 90);
        Student student2 =new Student("Juan", "Marcos",6439966, 56);
        Student student3 =new Student("Mary", "Castano",6439966, 120);
        gradebook.addStudent(student1);
        gradebook.addStudent(student2);
        gradebook.addStudent(student3);
        gradebook.DisplayAll();
        double ClassAverage = gradebook.Average();
        System.out.println("\n Class Average: "+ClassAverage);
        System.out.println("\nLetter Grade for class average: " + gradebook.LetterGrade(ClassAverage));



        //DF2 Test Start Here________________________________
        System.out.println("The minimum score for the class is" + "\t" + gradebook.MinScore());
        System.out.println("The Maximum score for the class is" + "\t" + gradebook.MaxScore());
        //DF2 Test Stops Here________________________________
    }

    public static boolean STRINGS (String s1){
        char Fchar = s1.charAt(0);
        return Character.isUpperCase(Fchar);
    }
    public static void main(String[] args) {
    Main main = new Main();
    System.out.println("This is the First part of the discussion");
    System.out.println("-----------------------------------------------------------");

    main.part1();



    //2. Write a Java static method that receives a String as its input parameter and returns true if the
    // given string starts with a capital letter and has no non-alphabetical characters. The method returns false otherwise. Share the method with your classmates
    System.out.println("___________________________________________________________");

        System.out.println("Second part of the discussion");
        String s1 = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("String to use? :");
        s1 = sc.nextLine();
    System.out.println(main.STRINGS(s1));



    //3. Write a Java program that (1) receives multiple lines from System.in, (2) split each line into its participating words
    // (use String.split method), and (3) print out the numbered list of words in each line. End the program after seeing the keyword
    // "end" in a line. Share your program with your classmates
    System.out.println("____________________________________________________________");
    System.out.println("Third part of the discussion");


    String line = "";
    String[] wordList = new String[0];
        while (true) {
            System.out.println("Enter word: ");
            line = sc.nextLine();
            if(line.equalsIgnoreCase("end")){
                break;
            }
            wordList = line.split(" ");
            for(int i = 0; i < wordList.length; i++){
                System.out.println(i + ". : " + wordList[i]);
            }


        }


        //4. Write a Java program that stores the content of the following table in a twoD array of integers. Share the program with your classmates
        //            {1, 6, 11, 16, 21},
        //            {2, 7, 12, 17, 22},
        //            {3, 8, 13, 18, 23},
        //            {4, 9, 14, 19, 24},
        //            {5, 10, 15, 20, 25}
        System.out.println("____________________________________________________________");
        System.out.println("last part of the discussion");
        int[][] TwoDArray = new int[5][5];
        for(int i = 0; i < TwoDArray[0].length; i++){
            TwoDArray[0][i] = 1 +(5*i)  ;
        }
        for(int i = 0; i < TwoDArray[1].length; i++){
            TwoDArray[1][i] = 2 +(5*i)  ;
        }
        for(int i = 0; i < TwoDArray[2].length; i++){
            TwoDArray[2][i] = 3 +(5*i)  ;
        }
        for(int i = 0; i < TwoDArray[3].length; i++){
            TwoDArray[3][i] = 4 +(5*i)  ;
        }
        for(int i = 0; i < TwoDArray[4].length; i++){
            TwoDArray[4][i] = 5 +(5*i)  ;
        }
        for(int i = 0; i < TwoDArray.length; i++){
            for(int j = 0; j< TwoDArray[i].length; j++){
                System.out.print(TwoDArray[i][j] + "\t");

            }
            System.out.println();
        }
    }


}
