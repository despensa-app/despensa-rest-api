package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.FakeTestUtil;
import dev.nmarulo.depensaapp.app.products.dtos.FindAllShoppingListProductRes;
import dev.nmarulo.depensaapp.app.users.User;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

@Getter
public class ProductServiceTestUtil {
    
    private final Integer shoppingListId;
    
    private final boolean excluded;
    
    private final User user;
    
    private final Page<Product> productsPage;
    
    private final FindAllShoppingListProductRes findAllShoppingListProductRes;
    
    private final boolean notExcluded;
    
    public ProductServiceTestUtil() {
        final var product = initProduct();
        this.shoppingListId = FakeTestUtil.randomInteger();
        this.excluded = true;
        this.user = initUser();
        this.productsPage = initProductsPage(product);
        this.findAllShoppingListProductRes = initFindAllShoppingListProductRes(this.productsPage);
        this.notExcluded = false;
    }
    
    private FindAllShoppingListProductRes initFindAllShoppingListProductRes(Page<Product> productsPage) {
        final var findAllShoppingListProductRes = new FindAllShoppingListProductRes();
        final var productRes = new FindAllShoppingListProductRes.Product();
        final var product = productsPage.getContent()
                                        .getFirst();
        
        productRes.setId(product.getId());
        productRes.setName(product.getName());
        productRes.setPrice(product.getPrice());
        productRes.setImgUrl(product.getImgUrl());
        
        findAllShoppingListProductRes.setCurrentPage(productsPage.getNumber());
        findAllShoppingListProductRes.setPageSize(productsPage.getNumberOfElements());
        findAllShoppingListProductRes.setTotalPages(productsPage.getTotalPages());
        findAllShoppingListProductRes.setTotal(productsPage.getTotalElements());
        findAllShoppingListProductRes.setContent(Collections.singletonList(productRes));
        
        return findAllShoppingListProductRes;
    }
    
    private Page<Product> initProductsPage(Product product) {
        final var products = Collections.singletonList(product);
        final var pageable = PageRequest.of(FakeTestUtil.randomInteger(), FakeTestUtil.randomInteger());
        
        return new PageImpl<>(products, pageable, FakeTestUtil.randomInteger());
    }
    
    private static Product initProduct() {
        final var product = new Product();
        
        product.setId(FakeTestUtil.randomLong());
        product.setName(FakeTestUtil.randomWord());
        product.setPrice(BigDecimal.ZERO);
        product.setImgUrl(FakeTestUtil.randomImage());
        product.setCalories(BigDecimal.ZERO);
        product.setDescription(FakeTestUtil.randomSentence());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(FakeTestUtil.randomFuture());
        product.setProductHasShoppingList(Collections.emptySet());
        
        return product;
    }
    
    private User initUser() {
        final var user = new User();
        
        user.setId(FakeTestUtil.randomLong());
        user.setUsername(FakeTestUtil.randomUsername());
        user.setPassword(FakeTestUtil.randomPassword());
        user.setEmail(FakeTestUtil.randomEmail());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(FakeTestUtil.randomFuture());
        user.setShoppingLists(Collections.emptySet());
        
        return user;
    }
    
}
