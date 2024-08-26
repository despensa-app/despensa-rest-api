package dev.nmarulo.depensaapp.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
@RequiredArgsConstructor
public class AppConfig implements WebMvcConfigurer {
    
    private final AppProperties appProperties;
    
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(appProperties.getPathPrefix(),
                                 HandlerTypePredicate.forAnnotation(RestController.class));
    }
    
    @Bean
    public LocaleResolver localeResolver() {
        var acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        
        acceptHeaderLocaleResolver.setSupportedLocales(this.appProperties.getSupportedLocales());
        acceptHeaderLocaleResolver.setDefaultLocale(this.appProperties.getDefaultLocale());
        
        return acceptHeaderLocaleResolver;
    }
    
}
