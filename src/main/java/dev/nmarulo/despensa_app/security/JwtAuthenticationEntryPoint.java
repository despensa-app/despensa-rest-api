package dev.nmarulo.despensa_app.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.nmarulo.despensa_app.commons.dtos.ErrorRes;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
    private final AuthenticationEntryPoint delegate = new BearerTokenAuthenticationEntryPoint();
    
    private final ObjectMapper objectMapper;
    
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        
        this.delegate.commence(request, response, authException);
        
        if (authException instanceof InvalidBearerTokenException bearerTokenException) {
            final var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED,
                                                                 bearerTokenException.getMessage());
            
            problemDetail.setTitle("Invalid Token");
            
            response.setContentType("application/json");
            
            objectMapper.writeValue(response.getWriter(), new ErrorRes(problemDetail));
        }
    }
    
}
