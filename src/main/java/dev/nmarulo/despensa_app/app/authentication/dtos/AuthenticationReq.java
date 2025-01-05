package dev.nmarulo.despensa_app.app.authentication.dtos;

import lombok.Data;

@Data
public class AuthenticationReq {
    
    private String username;
    
    private String password;
    
}
