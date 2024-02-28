package dev.nmarulo.depensaapp.app.productshoppinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductHasShoppingListRepository extends JpaRepository<ProductHasShoppingList, ProductHasShoppingListPK> {
    
    Optional<ProductHasShoppingList> findByShoppingListIdAndProductId(Integer shoppingListId, Integer productId);
    
}
