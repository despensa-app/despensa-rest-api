package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.classes.UnitTypeReq;
import dev.nmarulo.depensaapp.app.unitytypes.classes.UnitTypeRes;
import dev.nmarulo.depensaapp.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class UnitTypeService extends CrudServiceImp<UnitTypeReq, UnitTypeRes, UnitType, Integer> {
    
    private final UnitTypeRepository repository;
    
}
