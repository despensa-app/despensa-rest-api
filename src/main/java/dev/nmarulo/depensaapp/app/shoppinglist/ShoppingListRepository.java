package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {
    
    Page<ShoppingList> findAllByUser(User user, Pageable pageable);
    
    Optional<ShoppingList> findByIdAndUser(Integer id, User user);
    
}
