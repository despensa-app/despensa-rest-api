package dev.nmarulo.depensaapp.commons.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends DefaultHttpException {
    
    public NotFoundException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
    
    public NotFoundException(String reason, Throwable cause) {
        super(HttpStatus.NOT_FOUND, reason, cause);
    }
    
}
