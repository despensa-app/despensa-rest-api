package dev.nmarulo.despensaapp.app.productshoppinglist;

import dev.nmarulo.despensaapp.app.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductHasShoppingListRepository extends JpaRepository<ProductHasShoppingList, ProductHasShoppingListPK>, JpaSpecificationExecutor<ProductHasShoppingList> {
    
    Optional<ProductHasShoppingList> findByShoppingList_IdAndShoppingList_UserAndProduct_Id(Long shoppingListId,
                                                                                            User user,
                                                                                            Long productId);
    
    List<ProductHasShoppingList> findAllByShoppingList_IdAndShoppingList_UserAndProduct_IdIn(Long id,
                                                                                             User user,
                                                                                             List<Long> productsId);
    
    List<ProductHasShoppingList> findAllByShoppingList_IdAndShoppingList_UserAndProduct_IdInAndUnitType_IdIn(Long shoppingListId,
                                                                                                             User user,
                                                                                                             List<Long> productsId,
                                                                                                             List<Long> unitTypesId);
    
}
