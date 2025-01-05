package dev.nmarulo.despensaapp.app.pantry.unitytypes.dtos;

import dev.nmarulo.despensaapp.commons.dtos.PagingAndSortingRes;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class FindAllUnitTypeRes extends PagingAndSortingRes<FindAllUnitTypeRes.UnitType> {
    
    @Data
    public static class UnitType {
        
        public Long id;
        
        public String name;
        
    }
    
}
