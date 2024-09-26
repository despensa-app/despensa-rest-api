package dev.nmarulo.depensaapp.app.products.dtos;

import dev.nmarulo.depensaapp.commons.dtos.PagingAndSortingRes;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
public class FindAllProductRes extends PagingAndSortingRes<FindAllProductRes.Product> {
    
    @Data
    public static class Product {
        
        private Long id;
        
        private String name;
        
        private BigDecimal price;
        
        private String imgUrl;
        
        private BigDecimal calories;
        
        private String description;
        
    }
    
}
