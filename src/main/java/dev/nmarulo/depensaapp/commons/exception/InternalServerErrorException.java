package dev.nmarulo.depensaapp.commons.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends DefaultHttpException {
    
    public InternalServerErrorException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
    
    public InternalServerErrorException(String message, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
    }
    
}
