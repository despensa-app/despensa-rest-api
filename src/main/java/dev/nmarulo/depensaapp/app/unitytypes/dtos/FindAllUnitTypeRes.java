package dev.nmarulo.depensaapp.app.unitytypes.dtos;

import dev.nmarulo.depensaapp.commons.dtos.PagingAndSortingRes;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class FindAllUnitTypeRes extends PagingAndSortingRes<FindAllUnitTypeRes.UnitType> {
    
    @Data
    public static class UnitType {
        
        public Integer id;
        
        public String name;
        
    }
    
}
