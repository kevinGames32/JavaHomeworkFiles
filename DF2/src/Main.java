//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public void test1() {
        Gradebook gradebook = new Gradebook(3);

        Student student1 = new Student("Kevin", "Quiceno", 6439955, 90);
        Student student2 = new Student("Juan", "Marcos", 6439966, 56);
        Student student3 = new Student("Mary", "Castano", 6439966, 120);
        gradebook.addStudent(student1);
        gradebook.addStudent(student2);
        gradebook.addStudent(student3);
        gradebook.DisplayAll();


        //DF2 Test Start Here________________________________
        System.out.println("The minimum score for the class is" + "\t" + gradebook.MinScore());
        System.out.println("The Maximum score for the class is" + "\t" + gradebook.MaxScore());
        //DF2 Test Stops Here________________________________

    }

    //3. Write a Java static method that receives a String as its input parameter and returns true if the given string
    // represents an integer from 0 to 100. The method returns false otherwise.
    public static String IntCheck(String x) {
        String Ans = "";
        int IntAns = Integer.parseInt(x);
        if (IntAns < 0 || IntAns > 100) {
            Ans = "false";
        } else if (IntAns >= 0 || IntAns <= 100) {
            Ans = "true";
        }
        return Ans;
    }
    //4. Write a Java static method that receives a String as its input parameter and returns true if the given string
    // represents a valid 7-digit Panther ID. The method returns false otherwise.
    public static String PantherID(String x) {
        if (x.length() < 7 || x.length() > 7) {
            return "false";
        } else {
            return "true";

        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.test1();

        String repeat = "yes";
        Scanner sc = new Scanner(System.in);

        //part 3 test code
        while (repeat.equals("yes")) {
            System.out.println("What is your integer: ");
            String x = sc.nextLine();
            System.out.println(IntCheck(x));


            System.out.println("would you like to retry (yes/no/end):");
            repeat = sc.nextLine();
            repeat.toLowerCase();
            if (repeat.equals("end")) {
                System.exit(0);
            }
        }

        //part 4 test code
        repeat = "yes";
        while (repeat.equals("yes")) {
            System.out.println("What is your PID?: ");
            String PID = sc.nextLine();
            System.out.println(PantherID(PID));
            System.out.println("would you like to retry (yes/no/end):");
            repeat = sc.nextLine();
            repeat.toLowerCase();
            if (repeat.equals("end")) {
                System.exit(0);
            }
        }


    }
}