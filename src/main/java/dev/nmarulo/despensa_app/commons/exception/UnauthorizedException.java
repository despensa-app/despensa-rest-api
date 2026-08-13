package dev.nmarulo.despensa_app.commons.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends DefaultHttpException {
    
    public UnauthorizedException(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }
    
    public UnauthorizedException(String reason, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, reason, cause);
    }
    
}
