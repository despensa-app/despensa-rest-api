package dev.nmarulo.depensaapp.app.users.dtos;

import lombok.Data;

import java.util.List;

@Data
public class FindByIdUserRes {
    
    private Integer id;
    
    private String username;
    
    private String email;
    
    private List<ShoppingList> shoppingList;
    
    @Data
    public static class ShoppingList {
        
        private Integer id;
        
        private String name;
        
    }
    
}
