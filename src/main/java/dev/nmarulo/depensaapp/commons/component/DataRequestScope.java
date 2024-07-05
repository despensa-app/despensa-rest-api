package dev.nmarulo.depensaapp.commons.component;

import dev.nmarulo.depensaapp.configuration.AppProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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
    
}
