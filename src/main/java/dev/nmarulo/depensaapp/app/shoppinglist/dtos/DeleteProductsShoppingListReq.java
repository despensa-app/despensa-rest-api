package dev.nmarulo.depensaapp.app.shoppinglist.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DeleteProductsShoppingListReq {
    
    private List<Integer> productsId;
    
}
