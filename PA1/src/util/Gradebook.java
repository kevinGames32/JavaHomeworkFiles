/* This is part of the starter code!
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Gradebook {
    private ArrayList<Student> listOfStudents;


        //used to construct the class with its respective list of arrays for each student
        public Gradebook() {
            this.listOfStudents = new ArrayList<>();
        }
	//this method calculates the average score of all students.
    public double calculateAvg() {
        double sum = 0;
        for (Student s : listOfStudents)
            sum += s.getGrade().getScore();
        return sum / listOfStudents.size();
    }

    //takes 100(max grade) and compares it to all the student's grades to decide wwhat is the lowest grade in the group
    public double minScore(){
            int minScore = 100;
            for(Student s : listOfStudents){
                if(s.getGrade().getScore() < minScore){
                    minScore = s.getGrade().getScore();
                }

            }
        return minScore;
    }

    //same logic all around from the min score, but instead compares with 0(minimum score) and sets the variable
    // that will be returned to the lowest score found
    public double maxScore(){
            double maxScore = 0;
            for(Student s: listOfStudents){
                if(s.getGrade().getScore() > maxScore){
                    maxScore = s.getGrade().getScore();
                }
            }
        return maxScore;
    }

    //iterates over the student list given the ID of the student and returns the students full name if they exist
    public String getFullName(int givenID){
            for(Student s: listOfStudents){
                if(s.getPid() == givenID){
                    return  s.getFirstName() + " " + s.getLastName();
                }
            }
            return "No such student in list....";
    }

    //method that will take a parameter of Student type and add it to the list of students in the gradebook
    public void addStudent(Student s) {
        listOfStudents.add(s);
    }
    //takes the size of the list of students, iterates over them to set an integer array to each student's score
    //sorts the scores and checks if the list is even or odd, to then calculate the median with
    /*if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        else
            return scores[n / 2];
            */
    public float calculateMedian() {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for (Student s : listOfStudents)
            scores[i++] = s.getGrade().getScore();
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        else
            return scores[n / 2];
    }

    //iterates over every student in listOfStudents to print them with  formatting
    public void printAllStudents() {
        for (Student s : listOfStudents)
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }

    public String getLetterById(int id) {
        String Letter = "No such student found...";
        for(Student s : listOfStudents){
            if(s.getPid() == id){
                Letter =  Grade.convertScoreToLetter(s.getGrade().getScore());
            }
        }
        return Letter;
    }

    //wil outpput the score of said id that was referenced
    public int getGradeById(int id) {
        int score = 0;
        for(Student s : listOfStudents){
            if(s.getPid() == id){
                score =  s.getGrade().getScore();
            }
        }
        return score;
    }

    //sets a new Score to the student referenced by the id by searching through the list of students and assigning the
    // new value
    public void setNewScore(int score, int id) {
        for(Student s : listOfStudents){
            if(s.getPid() == id){
                s.setGrade(new Grade(score));
            }
        }
    }

    //will print the list of students and add more formatting to the already existing print
    //all students
    public void printTabScores() {
        System.out.println("FirstName\tLastName\tPID\tScore");
        printAllStudents();
        }
    //will print the list of students in a tab manner and will show their letter grades
    public void printTabLetter() {
        System.out.println("FirstName LastName PID Letter");
        for(Student s : listOfStudents) {
            System.out.println("\t"+s.getFirstName()+"\t"+s.getLastName()+"\t"+s.getPid()+"\t"+Grade.convertScoreToLetter(s.getGrade().getScore()));

        }
    }
}
