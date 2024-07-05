package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.classes.FindAllUnitTypeRes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unit-types")
@RequiredArgsConstructor
@Getter
public class UnitTypeController {
    
    private final UnitTypeService service;
    
    @GetMapping
    public ResponseEntity<FindAllUnitTypeRes> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.service.findAll(pageable));
    }
    
}
