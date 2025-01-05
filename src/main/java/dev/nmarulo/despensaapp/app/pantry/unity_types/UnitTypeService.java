package dev.nmarulo.despensaapp.app.pantry.unity_types;

import dev.nmarulo.despensaapp.app.pantry.unity_types.dtos.FindAllUnitTypeRes;
import dev.nmarulo.despensaapp.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class UnitTypeService extends BasicServiceImp {
    
    private final UnitTypeRepository unitTypeRepository;
    
    public FindAllUnitTypeRes findAll(Pageable pageable) {
        var pageFindAll = this.unitTypeRepository.findAll(pageable);
        
        return UnitTypeMapper.toFindAllUnitTypeRes(pageFindAll);
    }
    
}
