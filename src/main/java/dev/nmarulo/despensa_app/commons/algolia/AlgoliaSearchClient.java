package dev.nmarulo.despensa_app.commons.algolia;

import com.algolia.api.SearchClient;
import com.algolia.model.search.Hit;
import com.algolia.model.search.SearchParamsObject;
import dev.nmarulo.despensa_app.configuration.AlgoliaAppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AlgoliaSearchClient {
    
    private final AlgoliaAppProperties algoliaAppProperties;
    
    public ProductSearchAlgoliaRes searchByProductIndex(ProductSearchAlgoliaReq request) throws IOException {
        final var appID = this.algoliaAppProperties.getId();
        final var apiKey = this.algoliaAppProperties.getApiKey();
        final var indexName = this.algoliaAppProperties.getProductIndexName();
        final var searchableAttributes = this.algoliaAppProperties.getProductSearchableAttributes();
        
        try (final var client = new SearchClient(appID, apiKey)) {
            final var pageable = request.pageable();
            final var searchParams = new SearchParamsObject().setQuery(request.query())
                                                             .setRestrictSearchableAttributes(searchableAttributes)
                                                             .setHitsPerPage(pageable.getPageSize())
                                                             .setPage(pageable.getPageNumber());
            final var response = client.searchSingleIndex(indexName, searchParams, Hit.class);
            final var productAlgoliaRes = response.getHits()
                                                  .stream()
                                                  .map(value -> {
                                                      final var additionalProperties = value.getAdditionalProperties();
                                                      final var highlightResult = value.getHighlightResult();
                                                      
                                                      return ProductSearchAlgoliaMapper.toProduct(additionalProperties,
                                                                                                  highlightResult);
                                                  })
                                                  .toList();
            
            return new ProductSearchAlgoliaRes(response, productAlgoliaRes);
        }
    }
    
}
