package dev.nmarulo.despensa_app.commons.algolia;

import com.algolia.model.search.HighlightResult;
import com.algolia.model.search.HighlightResultOption;

import java.math.BigDecimal;
import java.util.Map;

public final class ProductSearchAlgoliaMapper {
    
    private ProductSearchAlgoliaMapper() {
    }
    
    public static ProductSearchAlgoliaRes.Product.Highlight toHighlightProduct(Map<String, HighlightResult> highlightResult) {
        if (highlightResult == null) {
            return null;
        }
        
        final var nameHighlight = (HighlightResultOption) highlightResult.get("name");
        final var descriptionHighlight = (HighlightResultOption) highlightResult.get("description");
        
        return new ProductSearchAlgoliaRes.Product.Highlight(nameHighlight.getValue(), descriptionHighlight.getValue());
    }
    
    public static ProductSearchAlgoliaRes.Product toProduct(Map<String, Object> additionalProperties,
                                                            Map<String, HighlightResult> highlightResult) {
        final var id = Long.valueOf(getByKey(additionalProperties, "id"));
        final var name = getByKey(additionalProperties, "name");
        final var description = getByKey(additionalProperties, "description");
        final var price = new BigDecimal(getByKey(additionalProperties, "price"));
        final var imgUrl = getByKey(additionalProperties, "img_url");
        final var highlightProductRes = toHighlightProduct(highlightResult);
        
        return new ProductSearchAlgoliaRes.Product(id, name, description, price, imgUrl, highlightProductRes);
    }
    
    private static String getByKey(Map<String, Object> additionalProperties, String key) {
        return String.valueOf(additionalProperties.get(key));
    }
    
}
