package dev.nmarulo.despensa_app.app.pantry.unity_types;

import dev.nmarulo.despensa_app.app.pantry.unity_types.dtos.FindAllUnitTypeRes;
import dev.nmarulo.despensa_app.commons.mapper.CommonMapper;
import org.springframework.data.domain.Page;

public final class UnitTypeMapper extends CommonMapper {
    
    private UnitTypeMapper() {
    }
    
    public static FindAllUnitTypeRes.UnitType toFindAllUnitTypeResUnitType(final UnitType unitType) {
        final var response = new FindAllUnitTypeRes.UnitType();
        
        response.setId(unitType.getId());
        response.setName(unitType.getName());
        
        return response;
    }
    
    public static FindAllUnitTypeRes toFindAllUnitTypeRes(final Page<UnitType> page) {
        return pageTo(page, FindAllUnitTypeRes::new, UnitTypeMapper::toFindAllUnitTypeResUnitType);
    }
    
}
