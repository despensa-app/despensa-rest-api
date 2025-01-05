package dev.nmarulo.despensa_app.app.pantry.shopping_list;

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
class ShoppingListServiceTest {
    
    private static ShoppingListServiceTestUtil shoppingListServiceTestUtil;
    
    @InjectMocks
    private ShoppingListService shoppingListService;
    
    @Mock
    private Pageable pageable;
    
    @Mock
    private ShoppingListRepository shoppingListRepository;
    
    @BeforeAll
    static void beforeAll() {
        shoppingListServiceTestUtil = new ShoppingListServiceTestUtil();
    }
    
    @Test
    void testFindAll() {
        final var expected = shoppingListServiceTestUtil.getFindAllShoppingListRes();
        final var user = shoppingListServiceTestUtil.getUser();
        final var shoppingListPage = shoppingListServiceTestUtil.getShoppingListPage();
        
        when(shoppingListRepository.findAllByUser(eq(user), eq(pageable))).thenReturn(shoppingListPage);
        
        final var actual = shoppingListService.findAll(this.pageable, user);
        
        assertEquals(expected, actual);
    }
    
}
