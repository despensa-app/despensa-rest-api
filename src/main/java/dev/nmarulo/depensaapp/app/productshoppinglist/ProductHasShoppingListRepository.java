package dev.nmarulo.depensaapp.app.productshoppinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductHasShoppingListRepository extends JpaRepository<ProductHasShoppingList, ProductHasShoppingListPK> {
    
    Optional<ProductHasShoppingList> findByShoppingListIdAndProductId(Integer shoppingListId, Integer productId);
    
    List<ProductHasShoppingList> findAllByShoppingListIdAndProductIdIn(Integer id, List<Integer> productsId);
    
    List<ProductHasShoppingList> findAllByShoppingListIdAndProductIdInAndUnitTypeIdIn(Integer id, List<Integer> productsId, List<Integer> unitTypesId);
    
}
