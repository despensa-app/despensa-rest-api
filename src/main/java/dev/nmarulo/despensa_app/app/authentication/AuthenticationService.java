package dev.nmarulo.despensa_app.app.authentication;

import dev.nmarulo.despensa_app.app.authentication.dtos.AuthenticationReq;
import dev.nmarulo.despensa_app.app.authentication.dtos.AuthenticationRes;
import dev.nmarulo.despensa_app.app.authentication.dtos.RegisterAuthenticationReq;
import dev.nmarulo.despensa_app.app.authentication.dtos.RegisterAuthenticationRes;
import dev.nmarulo.despensa_app.app.users.UserRepository;
import dev.nmarulo.despensa_app.commons.component.LocalMessage;
import dev.nmarulo.despensa_app.commons.exception.BadRequestException;
import dev.nmarulo.despensa_app.commons.exception.UnautorizedException;
import dev.nmarulo.despensa_app.configuration.AppProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
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
    
    @Transactional(readOnly = true)
    public AuthenticationRes login(final AuthenticationReq request) {
        final Supplier<UnautorizedException> orElseThrow = () -> new UnautorizedException(this.localMessage.getMessage(
            "error.user-password-incorrect"));
        final var user = this.userRepository.findByUsername(request.getUsername())
                                            .filter(value -> this.passwordEncoder.matches(request.getPassword(),
                                                                                          value.getPassword()))
                                            .orElseThrow(orElseThrow);
        final var tokenValue = getTokenValue(request);
        
        return AuthenticationMapper.toAuthenticationRes(user, tokenValue);
    }
    
    @Transactional
    public RegisterAuthenticationRes register(final RegisterAuthenticationReq request) {
        final var optionalUser = this.userRepository.findByUsername(request.getUsername());
        
        if (optionalUser.isPresent()) {
            throw new BadRequestException(this.localMessage.getMessage("error.registering-user"));
        }
        
        final var encodePassword = this.passwordEncoder.encode(request.getPassword());
        final var user = AuthenticationMapper.toUser(request, encodePassword);
        final var userSave = this.userRepository.save(user);
        
        return AuthenticationMapper.toRegisterAuthenticationRes(userSave);
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
