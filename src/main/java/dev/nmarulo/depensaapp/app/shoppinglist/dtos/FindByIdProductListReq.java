package dev.nmarulo.depensaapp.app.shoppinglist.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public class FindByIdProductListReq {
    
    private SelectedProducts selected;
    
    public FindByIdProductListReq() {
        this.selected = SelectedProducts.ALL;
    }
    
    @Getter
    @RequiredArgsConstructor
    public enum SelectedProducts {
        YES("yes"),
        NO("no"),
        ALL("all");
        
        private final String value;
        
    }
    
}
