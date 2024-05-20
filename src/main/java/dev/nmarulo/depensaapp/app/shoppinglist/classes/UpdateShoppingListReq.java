package dev.nmarulo.depensaapp.app.shoppinglist.classes;

import lombok.Data;

import java.util.List;

@Data
public class UpdateShoppingListReq {
    
    private String name;
    
    private List<ProductShoppingList> products;
    
    @Data
    public static class ProductShoppingList {
        
        private boolean selected;
        
        private Integer productId;
        
        private Integer unitTypeId;
        
    }
    
}
