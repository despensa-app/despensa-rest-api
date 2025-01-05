package dev.nmarulo.despensa_app.app.pantry.unity_types.dtos;

import dev.nmarulo.despensa_app.commons.dtos.PagingAndSortingRes;
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
