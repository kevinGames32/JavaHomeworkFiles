package Main;
import util.Date;
import util.DateTime;
import util.DateTimeInvalidException;
import java.util.*;




public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<DateTime> list = new ArrayList<>();

        while (keyboard.hasNextLine()) {
            System.out.println("enter next date/time, press Ctrl + D at any time to stop date/time addition");
            String[] tokens = null;
            String[] tokenizedDate = null;
            String[] tokenizedTime = null;
            try {
                tokens = keyboard.nextLine().split(" ");
                 tokenizedDate= tokens[0].split("/");
                 tokenizedTime = tokens[2].split(":");
            } catch (ArrayIndexOutOfBoundsException a){
                System.out.println(a.getMessage()+" please ensure you are using the following format MM/DD/YYYY @ hh:mm:ss am/pm");
                continue;
            }
            try{
                int month = Integer.parseInt(tokenizedDate[0]),
                    day = Integer.parseInt(tokenizedDate[1]),
                    year = Integer.parseInt(tokenizedDate[2]),
                    hour = Integer.parseInt(tokenizedTime[0]),
                    minute = Integer.parseInt(tokenizedTime[1]),
                    second = Integer.parseInt(tokenizedTime[2]);

                DateTime dateTime = new DateTime(new Date(day, month, year), hour, minute, second, tokens[3].equalsIgnoreCase("am") );
                if(!DateTime.isValidDateTime(dateTime)){
                    throw new DateTimeInvalidException(dateTime);
                }
                list.add(dateTime);

            } catch (DateTimeInvalidException e){
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e){
                System.out.println("Wrong number format please try again");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage()+" please ensure you are using the following format MM/DD/YYYY @ hh:mm:ss am/pm");
            }

        }
        Collections.sort(list);
        System.out.println("here is the sorted list of all of the dates: ");
        for (DateTime dateTime : list) {
            System.out.println(dateTime);
        }
    }
}