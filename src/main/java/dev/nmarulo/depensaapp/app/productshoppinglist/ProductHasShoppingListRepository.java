package dev.nmarulo.depensaapp.app.productshoppinglist;

import dev.nmarulo.depensaapp.app.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductHasShoppingListRepository extends JpaRepository<ProductHasShoppingList, ProductHasShoppingListPK> {
    
    @Query(
        "SELECT p FROM ProductHasShoppingList p WHERE p.shoppingList.id = :shoppingListId AND p.shoppingList.user = :user AND p.product.id = :productId")
    Optional<ProductHasShoppingList> findByShoppingListIdAndUserAndProductId(Integer shoppingListId,
                                                                             User user,
                                                                             Integer productId);
    
    @Query(
        "SELECT p FROM ProductHasShoppingList p WHERE p.shoppingList.id = :id AND p.shoppingList.user = :user AND p.product.id IN :productsId")
    List<ProductHasShoppingList> findAllByShoppingListIdAndUserAndProductIdIn(Integer id,
                                                                              User user,
                                                                              List<Integer> productsId);
    
    @Query(
        "SELECT p FROM ProductHasShoppingList p WHERE p.shoppingList.id = :id AND p.shoppingList.user = :user AND p.product.id IN :productsId AND p.unitType.id IN :unitTypesId")
    List<ProductHasShoppingList> findAllByShoppingListIdAndUserAndProductIdInAndUnitTypeIdIn(Integer id,
                                                                                             User user,
                                                                                             List<Integer> productsId,
                                                                                             List<Integer> unitTypesId);
    
}
