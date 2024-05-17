package dev.nmarulo.depensaapp.app.unitytypes.classes;

import dev.nmarulo.depensaapp.commons.classes.PagingAndSortingRes;
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
