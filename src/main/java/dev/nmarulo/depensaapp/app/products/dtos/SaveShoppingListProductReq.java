package dev.nmarulo.depensaapp.app.products.dtos;

import lombok.Data;

@Data
public class SaveShoppingListProductReq {
    
    private Integer productId;
    
    private Integer shoppingListId;
    
    private Integer unitsPerProduct;
    
    private Integer unitTypeId;
    
}
