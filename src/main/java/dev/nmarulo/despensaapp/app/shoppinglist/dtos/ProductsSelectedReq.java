package dev.nmarulo.despensaapp.app.shoppinglist.dtos;

import lombok.Data;

@Data
public class ProductsSelectedReq {
    
    private ActionType action;
    
    public enum ActionType {
        SELECT,
        DESELECT
    }
    
}
