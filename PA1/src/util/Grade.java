/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;
/*
* class used for storing of a single score of a student and also converts
* said score to letter grade*/
public class Grade {
    private int score;
    private String letterGrade;

    //class constructor to set the score variable and manipulate it
    public Grade(int score){
        this.score = score;
        this.letterGrade = Grade.convertScoreToLetter(score);/**/
    }


    //sets the score passed to the methods as the integer to be used in calculations
    public void setScore(int score) {
        this.score = score;
    }


    //calls the method
    public void setLetterGrade(int score) {
        this.letterGrade = Grade.convertScoreToLetter(score);/**/
    }

    /*
    * take the score as a double and generates a new string to output a letter grade depending of the
    * range the score is in depending on this class grading rubric*/
    public static String convertScoreToLetter(double score){
        String LetterGrade = "";
        if (score >= 95 && score <= 100) {
            LetterGrade = "A";
        } else if (score >= 90 && score <= 94.99) {
            LetterGrade = "A-";
        } else if (score >= 87 && score <= 89.99) {
            LetterGrade = "B+";
        } else if (score >= 83 && score <= 86.99) {
            LetterGrade = "B";
        } else if (score >= 80 && score <= 82.99) {
            LetterGrade = "B-";
        } else if (score >= 77 && score <= 79.99) {
            LetterGrade = "C+";
        } else if (score >= 70 && score <= 76.99) {
            LetterGrade = "C";
        } else if (score >= 60 && score <= 69.99) {
            LetterGrade = "D";
        } else if (score <= 60) {
            LetterGrade = "F";
        }
        return LetterGrade;
    }

    //getter for the student score to be called at any time
    public int getScore() {
        return score;
    }

    //public display of the student's letter grade after being set by the
    //convertScoreToLetter method
    public String getLetterGrade() {
        return letterGrade;
    }


}
