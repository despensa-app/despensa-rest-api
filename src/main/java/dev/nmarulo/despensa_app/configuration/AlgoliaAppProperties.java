package dev.nmarulo.despensa_app.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Getter
public class AlgoliaAppProperties {
    
    @Value("${app.algolia.id:}")
    private String id;
    
    @Value("${app.algolia.api-key:}")
    private String apiKey;
    
    @Value("${app.algolia.products-index-name:}")
    private String productIndexName;
    
    @Value("${app.algolia.product-searchable-attributes:}")
    private List<String> productSearchableAttributes;
    
}
