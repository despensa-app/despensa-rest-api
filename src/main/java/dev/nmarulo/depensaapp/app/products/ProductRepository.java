package dev.nmarulo.depensaapp.app.products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    @Query(value = "SELECT p FROM Product p WHERE p.id NOT IN (SELECT phs.product.id FROM ProductHasShoppingList phs WHERE phs.shoppingList.id = :id)")
    Page<Product> findAllByIdNotInShoppingList(Integer id, Pageable pageable);
    
    @Query(value = "SELECT p FROM Product p WHERE p.id IN (SELECT phs.product.id FROM ProductHasShoppingList phs WHERE phs.shoppingList.id = :id)")
    Page<Product> findAllByIdInShoppingList(Integer id, Pageable pageable);
    
}
