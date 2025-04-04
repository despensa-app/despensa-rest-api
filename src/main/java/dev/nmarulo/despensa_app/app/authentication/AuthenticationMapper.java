package dev.nmarulo.despensa_app.app.authentication;

import dev.nmarulo.despensa_app.app.authentication.dtos.AuthenticationRes;
import dev.nmarulo.despensa_app.app.authentication.dtos.RegisterAuthenticationReq;
import dev.nmarulo.despensa_app.app.authentication.dtos.RegisterAuthenticationRes;
import dev.nmarulo.despensa_app.app.users.User;
import dev.nmarulo.despensa_app.commons.mapper.CommonMapper;

import java.time.LocalDateTime;

public final class AuthenticationMapper extends CommonMapper {
    
    private AuthenticationMapper() {
    }
    
    public static User toUser(final RegisterAuthenticationReq request, final String password) {
        final var user = new User();
        final var now = LocalDateTime.now();
        
        user.setUsername(request.getUsername());
        user.setPassword(password);
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        
        return user;
    }
    
    public static RegisterAuthenticationRes toRegisterAuthenticationRes(final User user) {
        return new RegisterAuthenticationRes(user.getUsername());
    }
    
    public static AuthenticationRes toAuthenticationRes(final User user, final String tokenValue) {
        final var userResponse = new AuthenticationRes.User(user.getId(), user.getUsername());
        
        return new AuthenticationRes(tokenValue, userResponse);
    }
    
}
