package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.dtos.FindAllUnitTypeRes;
import dev.nmarulo.depensaapp.commons.mapper.CommonMapper;
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
