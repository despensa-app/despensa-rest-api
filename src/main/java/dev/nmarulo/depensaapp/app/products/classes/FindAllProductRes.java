package dev.nmarulo.depensaapp.app.products.classes;

import dev.nmarulo.depensaapp.commons.classes.PagingAndSortingRes;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
public class FindAllProductRes extends PagingAndSortingRes<FindAllProductRes.Product> {
    
    @Data
    public static class Product {
        
        private Integer id;
        
        private String name;
        
        private BigDecimal price;
        
    }
    
}
