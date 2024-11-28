package dev.nmarulo.despensaapp.app.shoppinglist.dtos;

import dev.nmarulo.despensaapp.commons.dtos.PagingAndSortingRes;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
public class FindAllShoppingListRes extends PagingAndSortingRes<FindAllShoppingListRes.ShoppingList> {
    
    @Data
    public static class ShoppingList {
        
        private Long id;
        
        private String name;
        
        private Integer totalProducts;
        
        private LocalDateTime createdAt;
        
    }
    
}
