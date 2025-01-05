package dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos;

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
        
        private Long unitTypeId;
        
    }
    
}
