package dev.nmarulo.despensa_app.app.pantry.unity_types;

import dev.nmarulo.despensa_app.app.pantry.unity_types.dtos.UnitTypeAdminReq;
import dev.nmarulo.despensa_app.app.pantry.unity_types.dtos.UnitTypeAdminRes;
import dev.nmarulo.despensa_app.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class UnitTypeAdminService extends CrudServiceImp<UnitTypeAdminReq, UnitTypeAdminRes, UnitType, Long> {
    
    private final UnitTypeRepository repository;
    
}
