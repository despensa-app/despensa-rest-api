package dev.nmarulo.despensa_app.app.authentication;

import dev.nmarulo.despensa_app.app.authentication.dtos.AuthenticationReq;
import dev.nmarulo.despensa_app.app.authentication.dtos.AuthenticationRes;
import dev.nmarulo.despensa_app.app.authentication.dtos.RegisterAuthenticationReq;
import dev.nmarulo.despensa_app.app.authentication.dtos.RegisterAuthenticationRes;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Getter
@Tag(name = "Authentication")
public class AuthenticationController {
    
    private final AuthenticationService authenticationService;
    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationRes> login(@RequestBody AuthenticationReq request) {
        return ResponseEntity.ok(this.authenticationService.login(request));
    }
    
    @PostMapping("/register")
    public ResponseEntity<RegisterAuthenticationRes> register(@RequestBody RegisterAuthenticationReq request) {
        return ResponseEntity.ok(this.authenticationService.register(request));
    }
    
}
