package dev.nmarulo.despensaapp.app.pantry.shopping_list.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DeleteProductsShoppingListReq {
    
    private List<Long> productsId;
    
}
