package dev.nmarulo.despensa_app.app.authentication.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterAuthenticationRes {
    
    @Schema(example = "newUser")
    private String username;
    
}
