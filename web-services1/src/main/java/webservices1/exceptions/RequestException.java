package webservices1.exceptions;

import lombok.Data;

@Data
public class RequestException extends Exception {
    private static final long serialVersionUID = -6377430375455572370L;

    private String error;
    private int code;
    private String description;

    public RequestException(String error, int code, String description) {
        super(error);
        this.error = error;
        this.code = code;
        this.description = description;
    }
}
