package dev.nmarulo.despensaapp.app.shoppinglist.dtos;

import dev.nmarulo.despensaapp.commons.dtos.PagingAndSortingRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FindByIdProductListRes extends PagingAndSortingRes<FindByIdProductListRes.ProductListRes> {
    
    @Data
    public static class ProductListRes {
        
        private Integer unitsPerProduct;
        
        private boolean selected;
        
        private ProductRes product;
        
        private UnitTypeRes unitType;
        
        private BigDecimal totalPrice;
        
        @Data
        public static class ProductRes {
            
            private Long id;
            
            private String name;
            
            private BigDecimal price;
            
            private String imgUrl;
            
        }
        
        @Data
        public static class UnitTypeRes {
            
            private Long id;
            
            private String name;
            
        }
        
    }
    
}
