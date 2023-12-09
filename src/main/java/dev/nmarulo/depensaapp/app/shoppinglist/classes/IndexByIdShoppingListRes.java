package dev.nmarulo.depensaapp.app.shoppinglist.classes;

import lombok.Data;

import java.util.List;

@Data
public class IndexByIdShoppingListRes {
    
    private Integer id;
    
    private String name;
    
    private List<Item> items;
    
    @Data
    public static class Item {
        
        private Integer unitsPerProduct;
        
        private Boolean selected;
        
        private Product product;
        
        private UnitType unitType;
        
        @Data
        public static class Product {
            
            private Integer id;
            
            private String name;
            
        }
        
        @Data
        public static class UnitType {
            
            private Integer id;
            
            private String name;
            
        }
        
    }
    
}
