package dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveShoppingListRes {
    
    private Long id;
    
    private String name;
    
}
