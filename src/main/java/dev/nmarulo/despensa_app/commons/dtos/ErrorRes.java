package dev.nmarulo.despensa_app.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ProblemDetail;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRes {
    
    private ProblemDetail error;
    
}
