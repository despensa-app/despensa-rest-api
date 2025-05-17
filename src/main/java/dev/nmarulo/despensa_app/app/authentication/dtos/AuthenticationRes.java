package dev.nmarulo.despensa_app.app.authentication.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRes {
    
    @Schema(example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpX...")
    private String accessToken;
    
    private User user;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class User {
        
        @Schema(example = "1")
        private Long id;
        
        @Schema(example = "user1")
        private String username;
        
    }
    
}
