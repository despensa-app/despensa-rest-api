package dev.nmarulo.depensaapp.app.unitytypes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unit-types")
@RequiredArgsConstructor
@Getter
public class UnitTypeController {
    
    private final UnitTypeAdminService service;
    
}
