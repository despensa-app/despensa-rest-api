package dev.nmarulo.despensaapp.app.shoppinglist.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectOption<V, L> {
    
    private V value;
    
    private L label;
    
    private boolean selected;
    
    public SelectOption(V value, L label) {
        this.value = value;
        this.label = label;
        this.selected = false;
    }
    
}
