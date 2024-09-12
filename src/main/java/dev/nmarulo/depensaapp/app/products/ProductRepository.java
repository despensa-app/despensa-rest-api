package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    @Query(value = "SELECT p FROM Product p WHERE p.id NOT IN (SELECT phs.product.id FROM ProductHasShoppingList phs WHERE phs.shoppingList.id = :id AND phs.shoppingList.user = :user)")
    Page<Product> findAllByIdNotInShoppingListIdAndUser(Integer id, User user, Pageable pageable);
    
    @Query(value = "SELECT p FROM Product p WHERE p.id IN (SELECT phs.product.id FROM ProductHasShoppingList phs WHERE phs.shoppingList.id = :id AND phs.shoppingList.user = :user)")
    Page<Product> findAllByIdInShoppingListIdAndUser(Integer id, User user, Pageable pageable);
    
}
