package dev.nmarulo.depensaapp.app.shoppinglist.classes;

import dev.nmarulo.depensaapp.commons.classes.PagingAndSortingRes;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
public class FindAllShoppingListRes extends PagingAndSortingRes<FindAllShoppingListRes.ShoppingList> {
    
    @Data
    public static class ShoppingList {
        
        private Integer id;
        
        private String name;
        
        private Integer totalProducts;
        
        private LocalDateTime createdAt;
        
    }
    
}
