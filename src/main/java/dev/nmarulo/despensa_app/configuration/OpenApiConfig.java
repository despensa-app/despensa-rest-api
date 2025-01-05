package dev.nmarulo.despensa_app.configuration;

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
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {
    
    private final AppProperties appProperties;
    
    private final String pathAdmin = "/**/admin/**";
    
    private final String bearerKeySecurityScheme = "bearer-key";
    
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
        final var components = new Components().addSecuritySchemes(bearerKeySecurityScheme, securityScheme);
        
        return new OpenAPI().info(info)
                            .components(components);
    }
    
    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomizer() {
        final var securityRequirement = new SecurityRequirement().addList(bearerKeySecurityScheme);
        
        return openApi -> openApi.getPaths()
                                 .values()
                                 .stream()
                                 .map(PathItem::readOperations)
                                 .flatMap(Collection::stream)
                                 .forEach(operation -> operation.addSecurityItem(securityRequirement));
    }
    
    @Bean
    public GroupedOpenApi adminOpenApi() {
        return GroupedOpenApi.builder()
                             .group("Admin")
                             .pathsToMatch(pathAdmin)
                             .build();
    }
    
    @Bean
    public GroupedOpenApi publicOpenApi() {
        return GroupedOpenApi.builder()
                             .group("Public")
                             .pathsToExclude(pathAdmin)
                             .pathsToMatch("/**")
                             .build();
    }
    
}
