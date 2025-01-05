package dev.nmarulo.despensaapp.app.pantry.unity_types;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UnitTypeServiceTest {
    
    private static UnitTypeServiceTestUtil unitTypeServiceTestUtil;
    
    @InjectMocks
    private UnitTypeService unitTypeService;
    
    @Mock
    private Pageable pageable;
    
    @Mock
    private UnitTypeRepository unitTypeRepository;
    
    @BeforeAll
    static void beforeAll() {
        unitTypeServiceTestUtil = new UnitTypeServiceTestUtil();
    }
    
    @Test
    void testFindAll() {
        final var expected = unitTypeServiceTestUtil.getFindAllUnitTypeRes();
        final var unitTypePage = unitTypeServiceTestUtil.getUnitTypePage();
        
        when(this.unitTypeRepository.findAll(eq(this.pageable))).thenReturn(unitTypePage);
        
        final var actual = this.unitTypeService.findAll(this.pageable);
        
        assertEquals(expected, actual);
    }
    
}
