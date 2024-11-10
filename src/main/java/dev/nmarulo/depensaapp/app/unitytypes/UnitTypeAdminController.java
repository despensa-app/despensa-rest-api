package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.dtos.UnitTypeAdminReq;
import dev.nmarulo.depensaapp.app.unitytypes.dtos.UnitTypeAdminRes;
import dev.nmarulo.depensaapp.commons.controller.CrudController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/unit-types")
@RequiredArgsConstructor
@Getter
@Tag(name = "Unit Type Admin", description = "Endpoints for managing unit types")
public class UnitTypeAdminController extends CrudController<UnitTypeAdminReq, UnitTypeAdminRes, Long> {
    
    private final UnitTypeAdminService service;
    
}
