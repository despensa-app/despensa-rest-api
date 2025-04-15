package dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos;

import dev.nmarulo.despensa_app.commons.dtos.PagingAndSortingRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

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
            
            private List<String> images;
            
        }
        
        @Data
        public static class UnitTypeRes {
            
            private Long id;
            
            private String name;
            
        }
        
    }
    
}
