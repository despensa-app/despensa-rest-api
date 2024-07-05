package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.dtos.UnitTypeAdminReq;
import dev.nmarulo.depensaapp.app.unitytypes.dtos.UnitTypeAdminRes;
import dev.nmarulo.depensaapp.commons.controller.CrudController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/unit-types")
@RequiredArgsConstructor
@Getter
public class UnitTypeAdminController extends CrudController<UnitTypeAdminReq, UnitTypeAdminRes, Integer> {
    
    private final UnitTypeAdminService service;
    
}
