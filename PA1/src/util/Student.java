/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;


/*
* class student is a class to fill the class gradebook and has all the parameters
* to calculate the desired commands like average, median, get name etc.*/
public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;

    //constructor to initialize all the parameters needed to work with student class
    public Student(String firstName, String lastName, int pid, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;

    }


    //sets the passed parameter of type Grade(class) to be the grade of the student
    //setter
    public void setGrade(Grade grade) {
        this.grade = grade;
    }


    //first name setter, used to change the first name at any time it might be called
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //setter for the last name to change the value at a later time
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    // setter for the id so that it may be later modified outise the initializer
    public void setPid(int pid) {
        this.pid = pid;
    }

    //returns the students first name that was set by the user in the main program
    //getter
    public String getFirstName() {
        return firstName;
    }

    //returns the students last name that was set by the user in the main program
    //getter
    public String getLastName() {
        return lastName;
    }

    //part of the tokenized input of the user in the main program that describes the student's id
    //getter
    public int getPid() {
        return pid;
    }

    //getter from the passed argument of grade that will later be used to calculate letter score
    public Grade getGrade() {
        return grade;
    }
}
