package dev.nmarulo.depensaapp.commons.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends DefaultHttpException {
    
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
    
    public BadRequestException(String message, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, message, cause);
    }
    
}
