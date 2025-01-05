package dev.nmarulo.despensaapp.app.pantry.shoppinglist.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateShoppingListRes {
    
    private Long id;
    
    private String name;
    
}
