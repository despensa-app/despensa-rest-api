package dev.nmarulo.despensaapp.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Locale;

@Configuration
@Getter
public class AppProperties {
    
    @Value("${app.security.jwt.secret:}")
    private String secretKey;
    
    @Value("${app.name}")
    private String appName;
    
    @Value("${app.description}")
    private String appDescription;
    
    @Value("${app.version:0}")
    private String appVersion;
    
    @Value("${app.licenses.name}")
    private String appLicensesName;
    
    @Value("${app.licenses.url:}")
    private String appLicensesUrl;
    
    @Value("${app.github.url:}")
    private String appGithubUrl;
    
    @Value("${app.http.path.prefix}")
    private String pathPrefix;
    
    @Value("${app.http.paths.permit-all:}")
    private String[] permitAllPaths;
    
    @Value("${app.pageable.size:10}")
    private int pageableSize;
    
    @Value("${app.jwt.expires-at:36000}")
    private long jwtExpiresAt;
    
    @Value("${app.jwt.issuer:self}")
    private String jwtIssuer;
    
    @Value("${app.locale.default:}")
    private Locale defaultLocale;
    
    @Value("${app.locale.supported:}")
    private List<Locale> supportedLocales;
    
}
