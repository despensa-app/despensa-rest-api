package dev.nmarulo.depensaapp.commons.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends DefaultHttpException {
    
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
    
    public NotFoundException(String message, Throwable cause) {
        super(HttpStatus.NOT_FOUND, message, cause);
    }
    
}
