package dev.nmarulo.depensaapp.app.authentication.dtos;

import lombok.Data;

@Data
public class RegisterAuthenticationReq {
    
    private String username;
    
    private String password;
    
}
