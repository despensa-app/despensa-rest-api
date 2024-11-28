package dev.nmarulo.despensaapp.app.unitytypes;

import dev.nmarulo.despensaapp.app.unitytypes.dtos.UnitTypeAdminReq;
import dev.nmarulo.despensaapp.app.unitytypes.dtos.UnitTypeAdminRes;
import dev.nmarulo.despensaapp.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class UnitTypeAdminService extends CrudServiceImp<UnitTypeAdminReq, UnitTypeAdminRes, UnitType, Long> {
    
    private final UnitTypeRepository repository;
    
}
