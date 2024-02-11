package dev.nmarulo.depensaapp.app.shoppinglist.classes;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class IndexByIdShoppingListRes {
    
    private Integer id;
    
    private String name;
    
    private List<Item> items;
    
    @Data
    public static class Item {
        
        private Integer unitsPerProduct;
        
        private boolean selected;
        
        private Product product;
        
        private UnitType unitType;
        
        private BigDecimal totalPrice;
        
        @Data
        public static class Product {
            
            private Integer id;
            
            private String name;
            
            private BigDecimal price;
            
        }
        
        @Data
        public static class UnitType {
            
            private Integer id;
            
            private String name;
            
        }
        
    }
    
}
