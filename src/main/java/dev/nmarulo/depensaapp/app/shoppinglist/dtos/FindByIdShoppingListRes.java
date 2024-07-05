package dev.nmarulo.depensaapp.app.shoppinglist.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FindByIdShoppingListRes {
    
    private Integer id;
    
    private String name;
    
    private Integer totalProducts;
    
    private BigDecimal totalPrice;
    
    private List<ProductShoppingList> products;
    
    @Data
    public static class ProductShoppingList {
        
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
            
            private String imgUrl;
            
        }
        
        @Data
        public static class UnitType {
            
            private Integer id;
            
            private String name;
            
        }
        
    }
    
}
