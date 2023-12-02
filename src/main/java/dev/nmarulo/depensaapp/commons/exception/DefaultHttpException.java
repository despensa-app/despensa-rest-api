package dev.nmarulo.depensaapp.commons.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.server.ResponseStatusException;

@Getter
public class DefaultHttpException extends ResponseStatusException {
    
    private final ProblemDetail problemDetail;
    
    public DefaultHttpException(HttpStatus status, String message) {
        this(status, message, null);
    }
    
    public DefaultHttpException(int rawStatusCode, String message) {
        this(rawStatusCode, message, null);
    }
    
    public DefaultHttpException(HttpStatus status, String message, Throwable cause) {
        super(status, null, cause);
        this.problemDetail = ProblemDetail.forStatusAndDetail(status, message);
    }
    
    public DefaultHttpException(int rawStatusCode, String message, Throwable cause) {
        super(rawStatusCode, null, cause);
        this.problemDetail = ProblemDetail.forStatus(rawStatusCode);
        
        this.problemDetail.setDetail(message);
    }
    
}
