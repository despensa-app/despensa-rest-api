package dev.nmarulo.despensaapp.app.pantry.shopping_list.dtos;

import dev.nmarulo.despensaapp.app.pantry.shopping_list.enums.SelectedProducts;
import lombok.Data;

@Data
public class FindByIdProductListReq {
    
    private SelectedProducts selected;
    
    public FindByIdProductListReq() {
        this.selected = SelectedProducts.NO;
    }
    
}
