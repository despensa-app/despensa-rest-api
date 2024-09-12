package dev.nmarulo.depensaapp.app.authentication;

import dev.nmarulo.depensaapp.app.authentication.dtos.AuthenticationReq;
import dev.nmarulo.depensaapp.app.authentication.dtos.AuthenticationRes;
import dev.nmarulo.depensaapp.app.authentication.dtos.RegisterAuthenticationReq;
import dev.nmarulo.depensaapp.app.authentication.dtos.RegisterAuthenticationRes;
import dev.nmarulo.depensaapp.app.users.User;
import dev.nmarulo.depensaapp.app.users.UserRepository;
import dev.nmarulo.depensaapp.commons.component.LocalMessage;
import dev.nmarulo.depensaapp.commons.exception.BadRequestException;
import dev.nmarulo.depensaapp.configuration.AppProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Getter
public class AuthenticationService {
    
    private final UserRepository userRepository;
    
    private final JwtEncoder encoder;
    
    private final AppProperties appProperties;
    
    private final PasswordEncoder passwordEncoder;
    
    private final LocalMessage localMessage;
    
    public AuthenticationRes login(final AuthenticationReq request) {
        final Supplier<BadRequestException> orElseThrow = () -> new BadRequestException(this.localMessage.getMessage(
            "error.user-password-incorrect"));
        final var user = this.userRepository.findByUsername(request.getUsername())
                                            .filter(value -> this.passwordEncoder.matches(request.getPassword(),
                                                                                          value.getPassword()))
                                            .orElseThrow(orElseThrow);
        
        final var tokenValue = getTokenValue(request);
        final var userResponse = new AuthenticationRes.User(user.getId(), user.getUsername());
        
        return new AuthenticationRes(tokenValue, userResponse);
    }
    
    public RegisterAuthenticationRes register(final RegisterAuthenticationReq request) {
        final var optionalUser = this.userRepository.findByUsername(request.getUsername());
        
        if (optionalUser.isPresent()) {
            throw new BadRequestException(this.localMessage.getMessage("error.user-already-exists"));
        }
        
        final var user = new User();
        final var now = LocalDateTime.now();
        
        user.setUsername(request.getUsername());
        user.setPassword(this.passwordEncoder.encode(request.getPassword()));
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        
        final var userSave = this.userRepository.save(user);
        
        return new RegisterAuthenticationRes(userSave.getUsername());
    }
    
    private String getTokenValue(final AuthenticationReq request) {
        final var nowInstant = Instant.now();
        final var jwsHeader = JwsHeader.with(MacAlgorithm.HS256)
                                       .build();
        final var claims = JwtClaimsSet.builder()
                                       .issuer(this.appProperties.getJwtIssuer())
                                       .issuedAt(nowInstant)
                                       .expiresAt(nowInstant.plusSeconds(this.appProperties.getJwtExpiresAt()))
                                       .subject(request.getUsername())
                                       .build();
        
        return this.encoder.encode(JwtEncoderParameters.from(jwsHeader, claims))
                           .getTokenValue();
    }
    
}
