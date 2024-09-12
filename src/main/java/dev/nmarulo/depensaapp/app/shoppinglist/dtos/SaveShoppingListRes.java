package dev.nmarulo.depensaapp.app.shoppinglist.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveShoppingListRes {
    
    private Integer id;
    
    private String name;
    
}
