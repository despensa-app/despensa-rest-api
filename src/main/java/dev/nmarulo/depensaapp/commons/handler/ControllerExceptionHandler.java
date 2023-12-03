package dev.nmarulo.depensaapp.commons.handler;

import dev.nmarulo.depensaapp.commons.classes.ErrorRes;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        return ResponseEntity.internalServerError()
                             .body(newErrorRes(ex, HttpStatus.INTERNAL_SERVER_ERROR));
    }
    
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                             .body(new ErrorRes(ex.getBody()));
    }
    
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        return ResponseEntity.status(statusCode)
                             .body(newErrorRes(ex, statusCode));
    }
    
    private ErrorRes newErrorRes(Exception ex, HttpStatusCode statusCode) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(statusCode, ex.getMessage());
        
        return new ErrorRes(problemDetail);
    }
    
}
