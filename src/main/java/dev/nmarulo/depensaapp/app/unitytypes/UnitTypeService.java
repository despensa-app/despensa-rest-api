package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.dtos.FindAllUnitTypeRes;
import dev.nmarulo.depensaapp.commons.service.BasicServiceImp;
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
        var response = new FindAllUnitTypeRes();
        var pageFindAll = this.unitTypeRepository.findAll(pageable);
        
        var unitTypeList = pageFindAll.stream()
                                      .map(UnitTypeMapper::toFindAllUnitTypeResUnitType)
                                      .toList();
        
        response.setContent(unitTypeList);
        response.setCurrentPage(pageFindAll.getNumber());
        response.setPageSize(pageFindAll.getNumberOfElements());
        response.setTotalPages(pageFindAll.getTotalPages());
        response.setTotal(pageFindAll.getTotalElements());
        
        return response;
    }
    
    
}
