package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.unitytypes.classes.FindAllUnitTypeRes;
import dev.nmarulo.depensaapp.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class UnitTypeService extends BasicServiceImp {
    
    private final UnitTypeRepository unitTypeRepository;
    
    public FindAllUnitTypeRes findAll() {
        var response = new FindAllUnitTypeRes();
        var pageFindAll = this.unitTypeRepository.findAll(getDataRequestScope().getPageable());
        
        var unitTypeList = pageFindAll.stream()
                                      .map(this::mapperTo)
                                      .toList();
        
        response.setContent(unitTypeList);
        response.setCurrentPage(pageFindAll.getNumber());
        response.setPageSize(pageFindAll.getNumberOfElements());
        response.setTotalPages(pageFindAll.getTotalPages());
        response.setTotal(pageFindAll.getTotalElements());
        
        return response;
    }
    
    private FindAllUnitTypeRes.UnitType mapperTo(UnitType unitType) {
        var response = new FindAllUnitTypeRes.UnitType();
        
        response.setId(unitType.getId());
        response.setName(unitType.getName());
        
        return response;
    }
    
}
