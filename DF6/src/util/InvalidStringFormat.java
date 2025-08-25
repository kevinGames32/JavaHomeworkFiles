package util;

public class InvalidStringFormat extends Exception {
    String message;
    public InvalidStringFormat(String Message) {
        this.message = Message;
    }
    @Override
    public String getMessage() {
        return  message;
    }
}

