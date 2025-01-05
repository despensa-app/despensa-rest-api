package dev.nmarulo.despensaapp.app.pantry.shoppinglist.dtos;

import dev.nmarulo.despensaapp.app.pantry.shoppinglist.enums.SelectedProducts;
import lombok.Data;

@Data
public class FindByIdProductListReq {
    
    private SelectedProducts selected;
    
    public FindByIdProductListReq() {
        this.selected = SelectedProducts.NO;
    }
    
}
