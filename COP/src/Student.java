

public class Student{
    //Class Student needs to store first name, last name, Panther ID, and score of a student (integer from 0 to 100).
    private String FirstName;
    private String LastName;
    private int PID;
    private int Score;


    ////Both classes must have proper constructors that initialize their corresponding instance fields.
    public Student(String firstName, String lastName, int PID, int Score){
        this.FirstName = firstName;
        this.LastName = lastName;
        this.PID = PID;
        this.Score = Score;

    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getFirstName(){
        return FirstName;
    }
    public void setLastName(String LastName){
        this.LastName = LastName;
    }
    public String getLastName(){
        return LastName;
    }
    public void setPID(int PID){
        this.PID = PID;
    }
    public int getPID(){
        return PID;
    }
    public void setScore(int Score){
        this.Score = Score;
    }
    public int getScore(){
        return Score;
    }
    public String DisplayInf() {
        return "FN: "+ FirstName + "\t"+ "LN: "+ LastName + "\t" + "PID: " + PID + "\t" + "SCORE: " + Score;
    }
}
