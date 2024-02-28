package dev.nmarulo.depensaapp.app.products.classes;

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
        
        private Integer id;
        
        private String name;
        
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Product {
        
        private Integer id;
        
        private String name;
        
        private BigDecimal price;
        
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UnitType {
        
        private Integer id;
        
        private String name;
        
    }
    
}
