package dev.nmarulo.despensaapp.app.shoppinglist.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class FindByIdProductShoppingListRest {
    
    private String name;
    
    private BigDecimal price;
    
    private Integer unitsPerProduct;
    
    private BigDecimal totalPrice;
    
    private String imgUrl;
    
    private UnitTypeRes unitType;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UnitTypeRes {
        
        private Long id;
        
        private String name;
        
    }
    
}
