package dev.nmarulo.depensaapp.app.authentication.dtos;

import lombok.Data;

@Data
public class AuthenticationReq {
    
    private String username;
    
    private String password;
    
}
