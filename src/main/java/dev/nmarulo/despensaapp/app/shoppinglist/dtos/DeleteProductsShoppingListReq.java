package dev.nmarulo.despensaapp.app.shoppinglist.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DeleteProductsShoppingListReq {
    
    private List<Long> productsId;
    
}
