package dev.nmarulo.despensa_app.app.authentication.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RegisterAuthenticationReq {
    
    @Schema(example = "newUser", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;
    
    @Schema(example = "password123", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    
}
