package dev.nmarulo.depensaapp.app.authentication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRes {
    
    private String accessToken;
    
    private User user;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class User {
        
        private Integer id;
        
        private String username;
        
    }
    
}
