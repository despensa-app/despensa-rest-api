package dev.nmarulo.despensa_app.app.pantry.products;

import dev.nmarulo.despensa_app.FakeTestUtil;
import dev.nmarulo.despensa_app.app.pantry.product_images.ProductImage;
import dev.nmarulo.despensa_app.app.pantry.products.dtos.FindAllShoppingListProductRes;
import dev.nmarulo.despensa_app.app.users.User;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

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
        final var productImage = product.getProductImages()
                                        .stream()
                                        .toList()
                                        .getFirst();
        
        productRes.setId(product.getId());
        productRes.setName(product.getName());
        productRes.setPrice(product.getPrice());
        productRes.setImgUrl(productImage.getUrl());
        
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
    
    private Product initProduct() {
        final var product = new Product();
        final var productImage = initProductImage();
        
        product.setId(FakeTestUtil.randomLong());
        product.setName(FakeTestUtil.randomWord());
        product.setPrice(FakeTestUtil.randomBigDecimal());
        product.setCalories(FakeTestUtil.randomBigDecimal());
        product.setDescription(FakeTestUtil.randomSentence());
        product.setCreatedAt(FakeTestUtil.randomPast());
        product.setUpdatedAt(FakeTestUtil.randomFuture());
        product.setProductHasShoppingList(Collections.emptySet());
        product.setProductImages(Collections.singleton(productImage));
        
        return product;
    }
    
    private ProductImage initProductImage() {
        final var productImage = new ProductImage();
        
        productImage.setId(FakeTestUtil.randomLong());
        productImage.setUrl(FakeTestUtil.randomImage());
        productImage.setCreatedAt(FakeTestUtil.randomPast());
        productImage.setUpdatedAt(FakeTestUtil.randomFuture());
        
        return productImage;
    }
    
    private User initUser() {
        final var user = new User();
        
        user.setId(FakeTestUtil.randomLong());
        user.setUsername(FakeTestUtil.randomUsername());
        user.setPassword(FakeTestUtil.randomPassword());
        user.setEmail(FakeTestUtil.randomEmail());
        user.setCreatedAt(FakeTestUtil.randomPast());
        user.setUpdatedAt(FakeTestUtil.randomFuture());
        user.setShoppingLists(Collections.emptySet());
        
        return user;
    }
    
}
