package Main;

import util.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EventOrganizer {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Event> events = new ArrayList<>();
        System.out.println("enter list of all events! enter \"Done\" when finished");
        while (keyboard.hasNextLine()) {
            String givenEvent = keyboard.nextLine(); //get user input for event
            if (givenEvent.equalsIgnoreCase("Done")) {
                break;
            }//break program


            // split event is all of its parts
            String[] eventProperties = givenEvent.split(",");
            String[] tokens = null;
            String[] tokenizedStartDate = null;
            String[] tokenizedStartTime = null;
            String[] tokenizedEndTime = null;
            String[] tokenizedEndDate = null;
            // end of split

            try {
                if (eventProperties.length != 6) { //check if input has enough length
                    throw new InvalidInputLength("Input Length is not the specified amount, please try again.");
                }
            } catch (InvalidInputLength IIL) {
                System.out.println(IIL.getMessage());
                continue;
            }// try throw catch for checking if input is length 6

            //big Try block to split input and populate the DateTime object parameters for the Event list.
            try {
                String eventName = eventProperties[0].trim();
                String hostName = eventProperties[3].trim();
                int invites = Integer.parseInt(eventProperties[4].trim());
                String location = eventProperties[5].trim();

                //start date parameters
                tokens = eventProperties[1].trim().split(" ");
                tokenizedStartDate = tokens[0].trim().split("/");
                tokenizedStartTime = tokens[2].trim().split(":");

                int Smonth = Integer.parseInt(tokenizedStartDate[0].trim()),
                        Sday = Integer.parseInt(tokenizedStartDate[1].trim()),
                        Syear = Integer.parseInt(tokenizedStartDate[2].trim()),
                        Shour = Integer.parseInt(tokenizedStartTime[0].trim()),
                        Sminute = Integer.parseInt(tokenizedStartTime[1].trim()),
                        Ssecond = Integer.parseInt(tokenizedStartTime[2].trim());
                DateTime StartdateTime = new DateTime(new Date(Sday, Smonth, Syear), Shour, Sminute, Ssecond, tokens[3].equalsIgnoreCase("am"));


                if (!DateTime.isValidDateTime(StartdateTime)) {
                    throw new DateTimeInvalidException(StartdateTime);
                } // check if StartDate has the valid format of MM/DD/YYYY @ HH:MM:SS am/pm (see DateTime class for constraints)


                //end date parameters
                tokens = eventProperties[2].trim().split(" ");
                tokenizedEndDate = tokens[0].trim().split("/");
                tokenizedEndTime = tokens[2].trim().split(":");


                int Emonth = Integer.parseInt(tokenizedEndDate[0].trim()),
                        Eday = Integer.parseInt(tokenizedEndDate[1].trim()),
                        Eyear = Integer.parseInt(tokenizedEndDate[2].trim()),
                        Ehour = Integer.parseInt(tokenizedEndTime[0].trim()),
                        Eminute = Integer.parseInt(tokenizedEndTime[1].trim()),
                        Esecond = Integer.parseInt(tokenizedEndTime[2].trim());
                DateTime EndDateTime = new DateTime(new Date(Eday, Emonth, Eyear), Ehour, Eminute, Esecond, tokens[3].equalsIgnoreCase("am"));


                if (!DateTime.isValidDateTime(EndDateTime)) {
                    throw new DateTimeInvalidException(EndDateTime);
                } // check if EndDate has the valid format of MM/DD/YYYY @ HH:MM:SS am/pm (see DateTime class for constraints)

                Event event = new Event(eventName, StartdateTime, EndDateTime, hostName, invites, location);
                events.add(event);

            }
            catch (NumberFormatException NFE) {
                System.out.println("Wrong number format: " + NFE.getMessage());
            } // Number format Exception catch for ParseInt problems
            catch (ArrayIndexOutOfBoundsException AIOE) {
                System.out.println("Too much information (out of bounds): " + AIOE.getMessage());
            } // Making sure arrays stay inside specified bounds
            catch (DateTimeInvalidException DTIE) {
                System.out.println("Wrong date/time format: " + DTIE.getMessage());
            } // catching the invalid DateTime format thrown earlier
            System.out.println("input DONE if done");

        }
        //sorting all the events for later printing
        Collections.sort(events);


        while (true) {

            System.out.println("specify a command: print, hosted by ..., happening on MM/DD/YYYY @ hh:mm:ss am/pm,");

            String command = keyboard.nextLine();

            //start of command handling
            if (command.equalsIgnoreCase("quit")) {
                break;
            }

            if (command.equalsIgnoreCase("print")) {
                System.out.println("here is the sorted list of all of the events: ");
                for (Event event : events) {
                    System.out.println(event);
                }
            }
            if (command.startsWith("hosted by ")) {
                String givenHostName = command.substring("hosted by ".length());
                for (Event event : events) {
                     String wantedHost = event.getHostName();
                    if (wantedHost.equalsIgnoreCase(givenHostName)) {
                        System.out.println(event);
                    }
                }
            }
            if (command.startsWith("happening on ")) {

                String givenDate = command.substring("happening on ".length());
                for (Event event : events) {
                    String WantedDate = event.getStartDateTime().toString();
                    if (WantedDate.equalsIgnoreCase(givenDate)) {
                        System.out.println(event);
                    }
                }
            }
        }

    }
}
