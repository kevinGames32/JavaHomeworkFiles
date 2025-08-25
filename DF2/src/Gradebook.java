import java.util.logging.Level;

public class Gradebook {
    ////Class Gradebook needs to store an array of Student objects
    private Student[] students;
    private int C;

    ////Both classes must have proper constructors that initialize their corresponding instance fields.
    public Gradebook(int Number) {
        students = new Student[Number];
        C = 0;
    }


    public void addStudent(Student student) {
        if (C < students.length) {
            students[C] = student;
            C++;
        } else {
            System.out.println("GradeBook is full");
        }
    }

    ////Gradebook contains a public method to calculate average score, and another one that prints the list of students and their information in the form of a table (rows are separated by new lines, columns are separated by tabs).
    public void DisplayAll() {
        for (int i = 0; i < C; i++) {
            System.out.println(students[i].DisplayInf());
        }
    }

    public double Average() {
        int classTotal = 0;
        double classAverage = 0;
        for (int Count = 0; Count < C; Count++) {
            classTotal = students[Count].getScore() + classTotal;
        }
        return classAverage = (classTotal / C);

    }

    ////Gradebook contains a static method to convert score (out of 100) to a letter grade based on this course's grading policy available in the syllabus.
    public static String LetterGrade(double grade) {

        String LetterGrade = "";
        ;
        if (grade >= 95 && grade <= 100) {
            LetterGrade = "A";
        } else if (grade >= 90 && grade <= 94.99) {
            LetterGrade = "A-";
        } else if (grade >= 87 && grade <= 89.99) {
            LetterGrade = "B+";
        } else if (grade >= 83 && grade <= 86.99) {
            LetterGrade = "B";
        } else if (grade >= 80 && grade <= 82.99) {
            LetterGrade = "B-";
        } else if (grade >= 77 && grade <= 79.99) {
            LetterGrade = "C+";
        } else if (grade >= 70 && grade <= 76.99) {
            LetterGrade = "C";
        } else if (grade >= 60 && grade <= 69.99) {
            LetterGrade = "D";
        } else if (grade <= 60) {
            LetterGrade = "F";
        }
        return LetterGrade;
    }


    //method for DF2 start here----------------------------------------
    public int MinScore() {
        int minScore = students[0].getScore();
        int tempMinScore = 0;
        for (int i = 1; i < students.length; i++) {
            tempMinScore = students[i].getScore();
            if (tempMinScore < minScore) {
                minScore = tempMinScore;
            }

        }return minScore;
    }
    public int MaxScore() {
        int MaxScore = students[0].getScore();
        int tempMaxScore = 0;
        for (int i = 1; i < students.length; i++) {
            tempMaxScore = students[i].getScore();
            if (tempMaxScore > MaxScore) {
                MaxScore = tempMaxScore;
            }

        }return MaxScore;
    }
}
//method for DF2 Stop here----------------------------------------