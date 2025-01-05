package dev.nmarulo.despensaapp.app.pantry.products;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    
    private static ProductServiceTestUtil productServiceTestUtil;
    
    @InjectMocks
    private ProductService productService;
    
    @Mock
    private ProductRepository productRepository;
    
    @Mock
    private Pageable pageable;
    
    @BeforeAll
    static void beforeAll() {
        productServiceTestUtil = new ProductServiceTestUtil();
    }
    
    @Test
    void testFindAllProductsByShoppingListId_excluded() {
        final var shoppingListId = productServiceTestUtil.getShoppingListId();
        final var isExclude = productServiceTestUtil.isExcluded();
        final var user = productServiceTestUtil.getUser();
        final var productsPage = productServiceTestUtil.getProductsPage();
        final var expected = productServiceTestUtil.getFindAllShoppingListProductRes();
        
        when(this.productRepository.findAllByIdNotInShoppingListIdAndUser(eq(shoppingListId),
                                                                          eq(user),
                                                                          eq(this.pageable))).thenReturn(productsPage);
        
        final var actual = this.productService.findAllProductsByShoppingListId(shoppingListId,
                                                                               isExclude,
                                                                               this.pageable,
                                                                               user);
        
        assertEquals(expected, actual);
        
        verify(this.productRepository, never()).findAllByIdInShoppingListIdAndUser(any(), any(), any());
    }
    
    @Test
    void testFindAllProductsByShoppingListId_notExcluded() {
        final var shoppingListId = productServiceTestUtil.getShoppingListId();
        final var isExclude = productServiceTestUtil.isNotExcluded();
        final var user = productServiceTestUtil.getUser();
        final var productsPage = productServiceTestUtil.getProductsPage();
        final var expected = productServiceTestUtil.getFindAllShoppingListProductRes();
        
        when(this.productRepository.findAllByIdInShoppingListIdAndUser(eq(shoppingListId),
                                                                       eq(user),
                                                                       eq(this.pageable))).thenReturn(productsPage);
        
        final var actual = this.productService.findAllProductsByShoppingListId(shoppingListId,
                                                                               isExclude,
                                                                               this.pageable,
                                                                               user);
        
        assertEquals(expected, actual);
        
        verify(this.productRepository, never()).findAllByIdNotInShoppingListIdAndUser(any(), any(), any());
    }
    
}
