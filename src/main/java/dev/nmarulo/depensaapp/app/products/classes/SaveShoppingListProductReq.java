package dev.nmarulo.depensaapp.app.products.classes;

import lombok.Data;

@Data
public class SaveShoppingListProductReq {
    
    private Integer productId;
    
    private Integer shoppingListId;
    
    private Integer unitsPerProduct;
    
    private Integer unitTypeId;
    
}
