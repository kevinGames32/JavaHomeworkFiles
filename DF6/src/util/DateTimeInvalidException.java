package util;

public class DateTimeInvalidException extends Exception {
    DateTime invalidDateTime;
    public DateTimeInvalidException(DateTime invalidDateTime) {
        this.invalidDateTime = invalidDateTime;
    }
    @Override
    public String getMessage() {
        return "Invalid Date/Time: " + invalidDateTime + " ";
    }
}

