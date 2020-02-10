package webservices1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.Data;
import webservices1.exceptions.RequestException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<ExceptionDTO> requestExceptionHandler(RequestException exception, WebRequest request) {
        ExceptionDTO dto = new ExceptionDTO(exception.getError(), exception.getCode(), exception.getDescription());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> requestExceptionHandler(Exception exception, WebRequest request) {
        ExceptionDTO dto = new ExceptionDTO("exception", -1, exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Data
    private static class ExceptionDTO {
        private String Error;
        private int Code;
        private String Description;

        public ExceptionDTO(String error, int code, String description) {
            Error = error;
            Code = code;
            Description = description;
        }
    }
}
