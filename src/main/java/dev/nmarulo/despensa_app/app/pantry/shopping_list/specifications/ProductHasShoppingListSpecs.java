package dev.nmarulo.despensa_app.app.pantry.shopping_list.specifications;

import dev.nmarulo.despensa_app.app.pantry.product_shopping_list.ProductHasShoppingList;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.ShoppingList;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos.FindByIdProductListReq;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.enums.SelectedProducts;
import dev.nmarulo.despensa_app.app.users.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.LinkedList;

public class ProductHasShoppingListSpecs {
    
    /*
     * SELECT * FROM product_has_shopping_list phsl JOIN shopping_list sl on phsl.shopping_list_id = sl.id JOIN user u on sl.user_id = u.id  WHERE selected = 1 AND sl.id = 1 and u.id = 1
     */
    public static Specification<ProductHasShoppingList> findAll(final FindByIdProductListReq request,
                                                                final User user,
                                                                final ShoppingList shoppingList) {
        return (root, query, builder) -> {
            final var predicates = new LinkedList<Predicate>();
            final var selectedReq = request.getSelected();
            final var shoppingListRoot = root.get("shoppingList");
            final var userRoot = shoppingListRoot.get("user");
            
            predicates.add(builder.equal(shoppingListRoot.get("id"), shoppingList.getId()));
            predicates.add(builder.equal(userRoot.get("id"), user.getId()));
            
            if (selectedReq != null && !SelectedProducts.ALL.equals(selectedReq)) {
                final var selectedRoot = root.<Boolean>get("selected");
                final var selectedPredicate = switch (selectedReq) {
                    case YES -> builder.isTrue(selectedRoot);
                    case NO -> builder.isFalse(selectedRoot);
                    default -> throw new IllegalArgumentException("Invalid selected value: " + selectedReq);
                };
                
                predicates.add(selectedPredicate);
            }
            
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
    
}
