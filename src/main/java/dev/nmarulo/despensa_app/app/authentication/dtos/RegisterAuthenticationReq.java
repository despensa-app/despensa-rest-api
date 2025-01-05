package dev.nmarulo.despensa_app.app.authentication.dtos;

import lombok.Data;

@Data
public class RegisterAuthenticationReq {
    
    private String username;
    
    private String password;
    
}
