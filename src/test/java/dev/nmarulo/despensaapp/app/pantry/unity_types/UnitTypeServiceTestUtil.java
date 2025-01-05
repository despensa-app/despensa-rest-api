package dev.nmarulo.despensaapp.app.pantry.unity_types;

import dev.nmarulo.despensaapp.FakeTestUtil;
import dev.nmarulo.despensaapp.app.pantry.unity_types.dtos.FindAllUnitTypeRes;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

@Getter
public class UnitTypeServiceTestUtil {
    
    private final FindAllUnitTypeRes findAllUnitTypeRes;
    
    private final Page<UnitType> unitTypePage;
    
    public UnitTypeServiceTestUtil() {
        final var unityType = initUnitType();
        this.unitTypePage = initUnitTypePage(unityType);
        this.findAllUnitTypeRes = initFinalAllUnitTypeRes(this.unitTypePage);
    }
    
    private FindAllUnitTypeRes initFinalAllUnitTypeRes(Page<UnitType> unitTypePage) {
        final var findAllUnitTypeRes = new FindAllUnitTypeRes();
        final var unitTypeRes = new FindAllUnitTypeRes.UnitType();
        final var unitType = unitTypePage.getContent()
                                         .getFirst();
        
        unitTypeRes.setId(unitType.getId());
        unitTypeRes.setName(unitType.getName());
        
        findAllUnitTypeRes.setCurrentPage(unitTypePage.getNumber());
        findAllUnitTypeRes.setPageSize(unitTypePage.getNumberOfElements());
        findAllUnitTypeRes.setTotalPages(unitTypePage.getTotalPages());
        findAllUnitTypeRes.setTotal(unitTypePage.getTotalElements());
        findAllUnitTypeRes.setContent(Collections.singletonList(unitTypeRes));
        
        return findAllUnitTypeRes;
    }
    
    private UnitType initUnitType() {
        final var unitType = new UnitType();
        
        unitType.setId(FakeTestUtil.randomLong());
        unitType.setName(FakeTestUtil.randomWord());
        unitType.setCreatedAt(FakeTestUtil.randomPast());
        unitType.setUpdatedAt(FakeTestUtil.randomFuture());
        unitType.setProductHasShoppingList(Collections.emptySet());
        
        return unitType;
    }
    
    private Page<UnitType> initUnitTypePage(UnitType unityType) {
        final var content = Collections.singletonList(unityType);
        final var pageable = PageRequest.of(FakeTestUtil.randomInteger(), FakeTestUtil.randomInteger());
        
        return new PageImpl<>(content, pageable, FakeTestUtil.randomInteger());
    }
    
}
