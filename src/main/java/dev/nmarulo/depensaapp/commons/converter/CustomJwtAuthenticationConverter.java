package dev.nmarulo.depensaapp.commons.converter;

import dev.nmarulo.depensaapp.app.users.UserRepository;
import dev.nmarulo.depensaapp.commons.component.LocalMessage;
import dev.nmarulo.depensaapp.commons.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collections;

@RequiredArgsConstructor
public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    
    private final UserRepository userRepository;
    
    private final LocalMessage localeMessage;
    
    @Override
    public AbstractAuthenticationToken convert(Jwt source) {
        final var userOptional = this.userRepository.findByUsername(String.valueOf(source.getSubject()));
        
        if (userOptional.isEmpty()) {
            throw new NotFoundException(localeMessage.getMessage("error.record-not-exist"));
        }
        
        return new UsernamePasswordAuthenticationToken(userOptional.get(), null, Collections.emptyList());
    }
    
}
