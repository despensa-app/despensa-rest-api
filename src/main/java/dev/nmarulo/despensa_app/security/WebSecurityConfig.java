package dev.nmarulo.despensa_app.security;

import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import dev.nmarulo.despensa_app.app.users.UserRepository;
import dev.nmarulo.despensa_app.commons.component.LocalMessage;
import dev.nmarulo.despensa_app.commons.converter.CustomJwtAuthenticationConverter;
import dev.nmarulo.despensa_app.configuration.AppProperties;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    
    private final AppProperties appProperties;
    
    private final UserRepository userRepository;
    
    private final LocalMessage localeMessage;
    
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.securityMatcher(appProperties.getPathPrefix() + "/**")
            .authorizeHttpRequests(authorize -> {
                if (ArrayUtils.isNotEmpty(appProperties.getPermitAllPaths())) {
                    authorize.requestMatchers(appProperties.getPermitAllPaths())
                             .permitAll();
                }
                
                authorize.anyRequest()
                         .authenticated();
            })
            .httpBasic(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .oauth2ResourceServer(configOAuth2())
            .cors(value -> value.configurationSource(corsConfigurationSource()));
        
        return http.build();
    }
    
    private CorsConfigurationSource corsConfigurationSource() {
        var source = new UrlBasedCorsConfigurationSource();
        var configuration = new CorsConfiguration();
        
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        source.registerCorsConfiguration(appProperties.getPathPrefix() + "/**", configuration);
        
        return source;
    }
    
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public JwtEncoder jwtEncoder() throws KeyLengthException {
        MACSigner macSigner = new MACSigner(appProperties.getSecretKey());
        JWKSource<SecurityContext> jwkSource = new ImmutableSecret<>(macSigner.getSecretKey());
        
        return new NimbusJwtEncoder(jwkSource);
    }
    
    @Bean
    public JwtDecoder jwtDecoder() throws KeyLengthException {
        MACSigner macSigner = new MACSigner(appProperties.getSecretKey());
        final var withClockSkew = new DelegatingOAuth2TokenValidator<>(new JwtTimestampValidator(Duration.ZERO));
        NimbusJwtDecoder build = NimbusJwtDecoder.withSecretKey(macSigner.getSecretKey())
                                                 .macAlgorithm(MacAlgorithm.HS256)
                                                 .build();
        
        build.setJwtValidator(withClockSkew);
        
        return build;
    }
    
    private Customizer<OAuth2ResourceServerConfigurer<HttpSecurity>> configOAuth2() {
        final var converter = new CustomJwtAuthenticationConverter(this.userRepository, this.localeMessage);
        
        return oauth -> oauth.authenticationEntryPoint(jwtAuthenticationEntryPoint)
                             .jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(converter));
    }
    
}
