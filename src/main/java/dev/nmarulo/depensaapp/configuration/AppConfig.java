package dev.nmarulo.depensaapp.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Collection;

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
    
    @Bean
    public OpenAPI openAPI() {
        final var license = new License().name(appProperties.getAppLicensesName())
                                         .url(appProperties.getAppLicensesUrl());
        final var contact = new Contact().url(appProperties.getAppGithubUrl())
                                         .name("GitHub");
        final var info = new Info().title(appProperties.getAppName())
                                   .description(appProperties.getAppDescription())
                                   .version(appProperties.getAppVersion())
                                   .contact(contact)
                                   .license(license);
        final var securityScheme = new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                                       .scheme("bearer")
                                                       .bearerFormat("JWT");
        final var components = new Components().addSecuritySchemes("bearer-key", securityScheme);
        
        return new OpenAPI().info(info)
                            .components(components);
    }
    
    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomizer() {
        final var securityRequirement = new SecurityRequirement().addList("bearer-key");
        
        return openApi -> openApi.getPaths()
                                 .values()
                                 .stream()
                                 .map(PathItem::readOperations)
                                 .flatMap(Collection::stream)
                                 .forEach(operation -> operation.addSecurityItem(securityRequirement));
    }
    
}
