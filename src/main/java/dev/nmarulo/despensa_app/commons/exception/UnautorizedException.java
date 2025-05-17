package dev.nmarulo.despensa_app.commons.exception;

import org.springframework.http.HttpStatus;

public class UnautorizedException extends DefaultHttpException {
    
    public UnautorizedException(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }
    
    public UnautorizedException(String reason, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, reason, cause);
    }
    
}
