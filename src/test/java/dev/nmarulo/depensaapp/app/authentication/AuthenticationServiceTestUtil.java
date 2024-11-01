package dev.nmarulo.depensaapp.app.authentication;

import dev.nmarulo.depensaapp.FakeTestUtil;
import dev.nmarulo.depensaapp.app.authentication.dtos.AuthenticationReq;
import dev.nmarulo.depensaapp.app.authentication.dtos.AuthenticationRes;
import dev.nmarulo.depensaapp.app.authentication.dtos.RegisterAuthenticationReq;
import dev.nmarulo.depensaapp.app.authentication.dtos.RegisterAuthenticationRes;
import dev.nmarulo.depensaapp.app.users.User;
import lombok.Getter;

import java.util.Collections;

@Getter
public class AuthenticationServiceTestUtil {
    
    private final AuthenticationReq authenticationReq;
    
    private final AuthenticationRes authenticationRes;
    
    private final User user;
    
    private final String jwtIssuer;
    
    private final long plusSecondsJwtExpiresAt;
    
    private final User newUser;
    
    private final RegisterAuthenticationReq registerAuthenticationReq;
    
    private final RegisterAuthenticationRes registerAuthenticationRes;
    
    public AuthenticationServiceTestUtil() {
        this.user = initUser();
        
        final var userRes = initUserRes(this.user);
        
        this.authenticationReq = initAuthenticationReq(this.user);
        this.authenticationRes = initAuthenticationRes(userRes);
        this.jwtIssuer = FakeTestUtil.randomWord();
        this.plusSecondsJwtExpiresAt = FakeTestUtil.randomLong();
        this.newUser = initNewUser();
        this.registerAuthenticationReq = initRegisterAuthenticationReq(newUser);
        this.registerAuthenticationRes = new RegisterAuthenticationRes(this.newUser.getUsername());
    }
    
    private RegisterAuthenticationReq initRegisterAuthenticationReq(User newUser) {
        final var registerAuthenticationReq = new RegisterAuthenticationReq();
        
        registerAuthenticationReq.setUsername(newUser.getUsername());
        registerAuthenticationReq.setPassword(FakeTestUtil.randomPassword());
        
        return registerAuthenticationReq;
    }
    
    private AuthenticationRes.User initUserRes(User user) {
        AuthenticationRes.User userRes = new AuthenticationRes.User();
        
        userRes.setId(user.getId());
        userRes.setUsername(user.getUsername());
        
        return userRes;
    }
    
    private User initUser() {
        User user = new User();
        
        user.setId(FakeTestUtil.randomLong());
        user.setUsername(FakeTestUtil.randomUsername());
        user.setPassword(FakeTestUtil.randomPassword());
        user.setEmail(FakeTestUtil.randomEmail());
        user.setCreatedAt(FakeTestUtil.randomPast());
        user.setUpdatedAt(FakeTestUtil.randomFuture());
        user.setShoppingLists(Collections.emptySet());
        
        return user;
    }
    
    private AuthenticationRes initAuthenticationRes(AuthenticationRes.User user) {
        AuthenticationRes authenticationRes = new AuthenticationRes();
        
        authenticationRes.setAccessToken(FakeTestUtil.randomWord());
        authenticationRes.setUser(user);
        
        return authenticationRes;
    }
    
    private AuthenticationReq initAuthenticationReq(User user) {
        AuthenticationReq authenticationReq = new AuthenticationReq();
        
        authenticationReq.setUsername(user.getUsername());
        authenticationReq.setPassword(user.getPassword());
        
        return authenticationReq;
    }
    
    private User initNewUser() {
        final var user = new User();
        final var createdAt = FakeTestUtil.randomPast();
        
        user.setUsername(FakeTestUtil.randomUsername());
        user.setPassword(FakeTestUtil.randomPassword());
        user.setCreatedAt(createdAt);
        user.setUpdatedAt(createdAt);
        user.setShoppingLists(Collections.emptySet());
        
        return user;
    }
    
}
