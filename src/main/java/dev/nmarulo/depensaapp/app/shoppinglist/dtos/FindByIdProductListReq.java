package dev.nmarulo.depensaapp.app.shoppinglist.dtos;

import dev.nmarulo.depensaapp.app.shoppinglist.enums.SelectedProducts;
import lombok.Data;

@Data
public class FindByIdProductListReq {
    
    private SelectedProducts selected;
    
    public FindByIdProductListReq() {
        this.selected = SelectedProducts.NO;
    }
    
}
