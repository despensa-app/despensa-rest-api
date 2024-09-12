package dev.nmarulo.depensaapp.commons.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends DefaultHttpException {
    
    public InternalServerErrorException(String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
    }
    
    public InternalServerErrorException(String reason, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason, cause);
    }
    
}
