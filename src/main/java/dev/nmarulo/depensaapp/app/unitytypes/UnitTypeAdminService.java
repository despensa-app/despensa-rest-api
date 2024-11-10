package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.dtos.UnitTypeAdminReq;
import dev.nmarulo.depensaapp.app.unitytypes.dtos.UnitTypeAdminRes;
import dev.nmarulo.depensaapp.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class UnitTypeAdminService extends CrudServiceImp<UnitTypeAdminReq, UnitTypeAdminRes, UnitType, Long> {
    
    private final UnitTypeRepository repository;
    
}
