package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.FakeTestUtil;
import dev.nmarulo.depensaapp.app.shoppinglist.dtos.FindAllShoppingListRes;
import dev.nmarulo.depensaapp.app.users.User;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

@Getter
public class ShoppingListServiceTestUtil {
    
    private final FindAllShoppingListRes findAllShoppingListRes;
    
    private final User user;
    
    private final Page<ShoppingList> shoppingListPage;
    
    public ShoppingListServiceTestUtil() {
        this.user = initUser();
        final var shoppingList = initShoppingList(this.user);
        this.shoppingListPage = initShoppingListPage(shoppingList);
        this.findAllShoppingListRes = initFindAllShoppingListRes(this.shoppingListPage);
    }
    
    private User initUser() {
        final var user = new User();
        
        user.setId(FakeTestUtil.randomLong());
        user.setUsername(FakeTestUtil.randomUsername());
        user.setPassword(FakeTestUtil.randomPassword());
        user.setEmail(FakeTestUtil.randomEmail());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setShoppingLists(Collections.emptySet());
        
        return user;
    }
    
    private ShoppingList initShoppingList(User user) {
        final var shoppingList = new ShoppingList();
        
        shoppingList.setId(FakeTestUtil.randomInteger());
        shoppingList.setName(FakeTestUtil.randomSentence());
        shoppingList.setTotalProducts(0);
        shoppingList.setTotalCalories(BigDecimal.ZERO);
        shoppingList.setTotalPrice(BigDecimal.ZERO);
        shoppingList.setCreatedAt(LocalDateTime.now());
        shoppingList.setUpdatedAt(LocalDateTime.now());
        shoppingList.setProductHasShoppingList(Collections.emptySet());
        shoppingList.setUser(user);
        
        return shoppingList;
    }
    
    private Page<ShoppingList> initShoppingListPage(ShoppingList shoppingList) {
        final var content = Collections.singletonList(shoppingList);
        final var pageable = PageRequest.of(FakeTestUtil.randomInteger(), FakeTestUtil.randomInteger());
        
        return new PageImpl<>(content, pageable, FakeTestUtil.randomInteger());
    }
    
    private FindAllShoppingListRes initFindAllShoppingListRes(Page<ShoppingList> shoppingListPage) {
        final var findAllShoppingListRes = new FindAllShoppingListRes();
        final var shoppingListRest = new FindAllShoppingListRes.ShoppingList();
        final var shoppingList = shoppingListPage.getContent()
                                                 .getFirst();
        
        shoppingListRest.setId(shoppingList.getId());
        shoppingListRest.setName(shoppingList.getName());
        shoppingListRest.setTotalProducts(shoppingList.getTotalProducts());
        shoppingListRest.setCreatedAt(shoppingList.getCreatedAt());
        
        findAllShoppingListRes.setCurrentPage(shoppingListPage.getNumber());
        findAllShoppingListRes.setPageSize(shoppingListPage.getNumberOfElements());
        findAllShoppingListRes.setTotalPages(shoppingListPage.getTotalPages());
        findAllShoppingListRes.setTotal(shoppingListPage.getTotalElements());
        findAllShoppingListRes.setContent(Collections.singletonList(shoppingListRest));
        
        return findAllShoppingListRes;
    }
    
}
