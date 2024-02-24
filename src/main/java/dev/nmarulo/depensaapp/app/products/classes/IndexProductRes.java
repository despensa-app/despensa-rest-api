package dev.nmarulo.depensaapp.app.products.classes;

import dev.nmarulo.depensaapp.commons.classes.PagingAndSortingRes;
import lombok.Data;

import java.math.BigDecimal;

public class IndexProductRes extends PagingAndSortingRes<IndexProductRes.Product> {
    
    @Data
    public static class Product {
        
        private Integer id;
        
        private String name;
        
        private BigDecimal price;
        
    }
    
}
