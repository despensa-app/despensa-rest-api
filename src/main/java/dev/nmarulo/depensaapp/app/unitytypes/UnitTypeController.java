package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.classes.UnitTypeReq;
import dev.nmarulo.depensaapp.app.unitytypes.classes.UnitTypeRes;
import dev.nmarulo.depensaapp.commons.controller.CrudController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unit-types")
@RequiredArgsConstructor
@Getter
public class UnitTypeController extends CrudController<UnitTypeReq, UnitTypeRes, Integer> {
    
    private final UnitTypeService service;
    
}
