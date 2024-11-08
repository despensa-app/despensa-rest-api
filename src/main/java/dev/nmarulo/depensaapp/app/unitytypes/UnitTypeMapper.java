package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.dtos.FindAllUnitTypeRes;

public final class UnitTypeMapper {
    
    private UnitTypeMapper() {
    }
    
    public static FindAllUnitTypeRes.UnitType toFindAllUnitTypeResUnitType(final UnitType unitType) {
        final var response = new FindAllUnitTypeRes.UnitType();
        
        response.setId(unitType.getId());
        response.setName(unitType.getName());
        
        return response;
    }
    
}
