package dev.nmarulo.despensa_app.commons.component;

import dev.nmarulo.despensa_app.app.users.User;
import dev.nmarulo.despensa_app.app.users.UserRepository;
import dev.nmarulo.despensa_app.configuration.AppProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.LocaleResolver;

@RequestScope
@Component
@RequiredArgsConstructor
@Data
public class DataRequestScope {
    
    private final AppProperties appProperties;
    
    private final LocaleResolver localeResolver;
    
    private final UserRepository userRepository;
    
    public User getAuthenticationPrincipal() {
        final var principal = SecurityContextHolder.getContext()
                                                   .getAuthentication()
                                                   .getPrincipal();
        
        if (principal instanceof String) {
            //Cuando no hay ningún tipo de autenticación el usuario es "anonymousUser".
            //TODO: Por el momento lo dejo implementado aquí. Debería moverlo a otro sitio mejor localizado.
            return this.userRepository.findByUsername((String) principal)
                                      .orElseGet(User::new);
        }
        
        return (User) principal;
    }
    
}
