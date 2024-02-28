package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.classes.UnitTypeAdminReq;
import dev.nmarulo.depensaapp.app.unitytypes.classes.UnitTypeAdminRes;
import dev.nmarulo.depensaapp.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class UnitTypeAdminService extends CrudServiceImp<UnitTypeAdminReq, UnitTypeAdminRes, UnitType, Integer> {
    
    private final UnitTypeRepository repository;
    
}
