package dev.nmarulo.depensaapp.app.products.dtos;

import lombok.Data;

@Data
public class SaveShoppingListProductReq {
    
    private Long productId;
    
    private Long shoppingListId;
    
    private Integer unitsPerProduct;
    
    private Long unitTypeId;
    
}
