package dev.nmarulo.despensaapp.app.pantry.shopping_list.dtos;

import lombok.Data;

@Data
public class ProductsSelectedReq {
    
    private ActionType action;
    
    public enum ActionType {
        SELECT,
        DESELECT
    }
    
}
