package util;

public class InvalidInputLength extends Exception {
    String message;
    public InvalidInputLength(String Message) {
        this.message = Message;
    }

    @Override
    public String getMessage() { return message;
    }
}
