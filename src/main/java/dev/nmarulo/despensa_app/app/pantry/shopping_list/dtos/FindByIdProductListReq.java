package dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos;

import dev.nmarulo.despensa_app.app.pantry.shopping_list.enums.SelectedProducts;
import lombok.Data;

@Data
public class FindByIdProductListReq {
    
    private SelectedProducts selected;
    
    public FindByIdProductListReq() {
        this.selected = SelectedProducts.NO;
    }
    
}
