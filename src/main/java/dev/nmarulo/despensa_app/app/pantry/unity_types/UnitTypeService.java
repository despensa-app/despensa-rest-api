package dev.nmarulo.despensa_app.app.pantry.unity_types;

import dev.nmarulo.despensa_app.app.pantry.unity_types.dtos.FindAllUnitTypeRes;
import dev.nmarulo.despensa_app.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Getter
public class UnitTypeService extends BasicServiceImp {
    
    private final UnitTypeRepository unitTypeRepository;
    
    @Transactional(readOnly = true)
    public FindAllUnitTypeRes findAll(Pageable pageable) {
        var pageFindAll = this.unitTypeRepository.findAll(pageable);
        
        return UnitTypeMapper.toFindAllUnitTypeRes(pageFindAll);
    }
    
}
