package dev.nmarulo.despensa_app.commons.algolia;

import com.algolia.model.search.Hit;
import com.algolia.model.search.SearchResponse;

import java.math.BigDecimal;
import java.util.List;

public record ProductSearchAlgoliaRes(SearchResponse<Hit> response, List<Product> products) {
    
    public record Product(Long id, String name, String description, BigDecimal price, String imgUrl,
                          Highlight highlight) {
        
        public record Highlight(String name, String description) {}
        
    }
    
}
