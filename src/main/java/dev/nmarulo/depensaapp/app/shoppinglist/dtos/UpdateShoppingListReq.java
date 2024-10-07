package dev.nmarulo.depensaapp.app.shoppinglist.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UpdateShoppingListReq {
    
    private String name;
    
    private List<ProductShoppingList> products;
    
    @Data
    public static class ProductShoppingList {
        
        private boolean selected;
        
        private Long productId;
        
        private Integer unitTypeId;
        
    }
    
}
