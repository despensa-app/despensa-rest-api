package dev.nmarulo.depensaapp.app.shoppinglist.classes;

import lombok.Data;

import java.util.List;

@Data
public class DeleteProductsShoppingListReq {
    
    private List<Integer> productsId;
    
}
