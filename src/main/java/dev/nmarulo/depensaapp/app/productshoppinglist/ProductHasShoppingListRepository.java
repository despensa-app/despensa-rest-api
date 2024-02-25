package dev.nmarulo.depensaapp.app.productshoppinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHasShoppingListRepository extends JpaRepository<ProductHasShoppingList, ProductHasShoppingListPK> {
    
}
