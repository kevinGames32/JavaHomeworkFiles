package util;

public class Event implements Comparable<Event> {
    private String eventName;
    private DateTime StartDateTime;
    private DateTime EndDateTime;
    private String hostName;
    private int numberOfInvites;
    private String locationName;

    public Event(String eventName, DateTime StartDateTime, DateTime EndDateTime, String hostName, int numberOfInvites, String locationName) {
        this.eventName = eventName;
        this.StartDateTime = StartDateTime;
        this.EndDateTime = EndDateTime;
        this.hostName = hostName;
        this.numberOfInvites = numberOfInvites;
        this.locationName = locationName;

    }
    public String getEventName() {
        return eventName;
    }
    public DateTime getStartDateTime() {
        return StartDateTime;
    }
    public DateTime getEndDateTime() {
        return EndDateTime;
    }
    public String getHostName() {
        return hostName;
    }
    public int getNumberOfInvites() {
        return numberOfInvites;
    }
    public String getLocationName() {
        return locationName;
    }


    @Override
    public int compareTo(Event other) {
        if(this.StartDateTime.compareTo(other.StartDateTime) != 0) {
            return this.StartDateTime.compareTo(other.StartDateTime);
        }
        if(this.EndDateTime.compareTo(other.EndDateTime) != 0) {
            return this.EndDateTime.compareTo(other.EndDateTime);
        }
        if(this.hostName.compareTo(other.hostName) != 0) {
            return this.hostName.compareTo(other.hostName);
        }
        if(this.numberOfInvites != other.numberOfInvites) {
            return this.numberOfInvites - other.numberOfInvites;
        }
        if(this.locationName.compareTo(other.locationName) != 0) {
            return this.locationName.compareTo(other.locationName);
        }
        return this.eventName.compareTo(other.eventName);

    }
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %d, %s, \n", eventName, StartDateTime, EndDateTime, hostName, numberOfInvites, locationName);
    }
}
