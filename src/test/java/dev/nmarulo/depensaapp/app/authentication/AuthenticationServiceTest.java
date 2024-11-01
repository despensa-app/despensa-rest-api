package dev.nmarulo.depensaapp.app.authentication;

import dev.nmarulo.depensaapp.app.authentication.dtos.AuthenticationRes;
import dev.nmarulo.depensaapp.app.users.User;
import dev.nmarulo.depensaapp.app.users.UserRepository;
import dev.nmarulo.depensaapp.configuration.AppProperties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {
    
    private static AuthenticationServiceTestUtil authenticationServiceTestUtil;
    
    @InjectMocks
    private AuthenticationService authenticationService;
    
    @Mock
    private UserRepository userRepository;
    
    @Mock
    private PasswordEncoder passwordEncoder;
    
    @Mock
    private AppProperties appProperties;
    
    @Mock
    private JwtEncoder encoder;
    
    @BeforeAll
    static void beforeAll() {
        authenticationServiceTestUtil = new AuthenticationServiceTestUtil();
    }
    
    @Test
    void testLogin() {
        final var builderJwsHeaderMock = mock(JwsHeader.Builder.class);
        final var builderJwtClaimsSetMock = mock(JwtClaimsSet.Builder.class);
        final var jwtEncoderParametersMock = mock(JwtEncoderParameters.class);
        final var buildJwsHeaderMock = mock(JwsHeader.class);
        final var buildJwtClaimsSetMock = mock(JwtClaimsSet.class);
        final var jwtMock = mock(Jwt.class);
        final var nowInstantMock = mock(Instant.class);
        final var jwtExpiresAtMock = mock(Instant.class);
        
        final var request = authenticationServiceTestUtil.getAuthenticationReq();
        final var expected = authenticationServiceTestUtil.getAuthenticationRes();
        final var user = authenticationServiceTestUtil.getUser();
        final var userOptional = Optional.of(user);
        final var jwtIssuer = authenticationServiceTestUtil.getJwtIssuer();
        final var plusSecondsJwtExpiresAt = authenticationServiceTestUtil.getPlusSecondsJwtExpiresAt();
        
        when(this.passwordEncoder.matches(eq(request.getPassword()), eq(user.getPassword()))).thenReturn(true);
        when(this.userRepository.findByUsername(eq(request.getUsername()))).thenReturn(userOptional);
        when(this.appProperties.getJwtIssuer()).thenReturn(jwtIssuer);
        when(this.appProperties.getJwtExpiresAt()).thenReturn(plusSecondsJwtExpiresAt);
        when(builderJwsHeaderMock.build()).thenReturn(buildJwsHeaderMock);
        when(this.encoder.encode(eq(jwtEncoderParametersMock))).thenReturn(jwtMock);
        when(jwtMock.getTokenValue()).thenReturn(expected.getAccessToken());
        when(nowInstantMock.plusSeconds(eq(plusSecondsJwtExpiresAt))).thenReturn(jwtExpiresAtMock);
        when(builderJwtClaimsSetMock.issuer(eq(jwtIssuer))).thenReturn(builderJwtClaimsSetMock);
        when(builderJwtClaimsSetMock.issuedAt(eq(nowInstantMock))).thenReturn(builderJwtClaimsSetMock);
        when(builderJwtClaimsSetMock.expiresAt(eq(jwtExpiresAtMock))).thenReturn(builderJwtClaimsSetMock);
        when(builderJwtClaimsSetMock.subject(eq(request.getUsername()))).thenReturn(builderJwtClaimsSetMock);
        when(builderJwtClaimsSetMock.build()).thenReturn(buildJwtClaimsSetMock);
        
        try (MockedStatic<Instant> instantMockedStatic = mockStatic(Instant.class);
             MockedStatic<JwsHeader> jwsHeaderMockedStatic = mockStatic(JwsHeader.class);
             MockedStatic<JwtClaimsSet> jwtClaimsSetMockedStatic = mockStatic(JwtClaimsSet.class);
             MockedStatic<JwtEncoderParameters> jwtEncoderParametersMockedStatic = mockStatic(JwtEncoderParameters.class)) {
            instantMockedStatic.when(Instant::now)
                               .thenReturn(nowInstantMock);
            jwsHeaderMockedStatic.when(() -> JwsHeader.with(eq(MacAlgorithm.HS256)))
                                 .thenReturn(builderJwsHeaderMock);
            jwtClaimsSetMockedStatic.when(JwtClaimsSet::builder)
                                    .thenReturn(builderJwtClaimsSetMock);
            jwtEncoderParametersMockedStatic.when(() -> JwtEncoderParameters.from(eq(buildJwsHeaderMock),
                                                                                  eq(buildJwtClaimsSetMock)))
                                            .thenReturn(jwtEncoderParametersMock);
            
            AuthenticationRes actual = this.authenticationService.login(request);
            
            assertEquals(expected, actual);
        }
    }
    
    @Test
    void testRegister() {
        final var request = authenticationServiceTestUtil.getRegisterAuthenticationReq();
        final var expected = authenticationServiceTestUtil.getRegisterAuthenticationRes();
        final var newUser = authenticationServiceTestUtil.getNewUser();
        final var userOptional = Optional.<User>empty();
        final var localDateTime = newUser.getCreatedAt();
        
        when(this.userRepository.findByUsername(eq(request.getUsername()))).thenReturn(userOptional);
        when(this.passwordEncoder.encode(eq(request.getPassword()))).thenReturn(newUser.getPassword());
        when(this.userRepository.save(eq(newUser))).thenReturn(newUser);
        
        try (MockedStatic<LocalDateTime> localDateTimeMockedStatic = mockStatic(LocalDateTime.class)) {
            localDateTimeMockedStatic.when(LocalDateTime::now)
                                     .thenReturn(localDateTime);
            
            final var actual = this.authenticationService.register(request);
            
            assertEquals(expected, actual);
        }
    }
    
}
