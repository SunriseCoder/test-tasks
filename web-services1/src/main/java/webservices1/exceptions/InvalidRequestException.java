package webservices1.exceptions;

public class InvalidRequestException extends Exception {
    private static final long serialVersionUID = -6377430375455572370L;

    public InvalidRequestException(String message) {
        super(message);
    }
}
