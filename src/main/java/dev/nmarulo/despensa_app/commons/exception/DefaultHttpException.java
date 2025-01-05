package dev.nmarulo.despensa_app.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DefaultHttpException extends ResponseStatusException {
    
    public DefaultHttpException(HttpStatus status, String reason) {
        this(status, reason, null);
    }
    
    public DefaultHttpException(int rawStatusCode, String reason) {
        this(rawStatusCode, reason, null);
    }
    
    public DefaultHttpException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
    
    public DefaultHttpException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }
    
}
