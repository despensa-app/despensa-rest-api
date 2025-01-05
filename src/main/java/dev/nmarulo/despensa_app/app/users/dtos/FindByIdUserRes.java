package dev.nmarulo.despensa_app.app.users.dtos;

import lombok.Data;

import java.util.List;

@Data
public class FindByIdUserRes {
    
    private Long id;
    
    private String username;
    
    private String email;
    
    private List<ShoppingList> shoppingList;
    
    @Data
    public static class ShoppingList {
        
        private Long id;
        
        private String name;
        
    }
    
}
