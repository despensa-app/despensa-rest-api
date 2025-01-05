package dev.nmarulo.despensa_app.app.pantry.products.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class SaveShoppingListProductRes {
    
    private ShoppingList shoppingList;
    
    private Product product;
    
    private UnitType unitType;
    
    private BigDecimal totalPrice;
    
    private Integer unitsPerProduct;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShoppingList {
        
        private Long id;
        
        private String name;
        
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Product {
        
        private Long id;
        
        private String name;
        
        private BigDecimal price;
        
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UnitType {
        
        private Long id;
        
        private String name;
        
    }
    
}
