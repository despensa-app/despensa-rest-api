package dev.nmarulo.depensaapp.commons.classes;

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
