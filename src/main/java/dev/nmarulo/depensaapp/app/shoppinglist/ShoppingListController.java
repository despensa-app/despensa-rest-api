package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.shoppinglist.classes.FindAllShoppingListRes;
import dev.nmarulo.depensaapp.app.shoppinglist.classes.FindByIdProductShoppingListRest;
import dev.nmarulo.depensaapp.app.shoppinglist.classes.FindByIdShoppingListRes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-lists")
@RequiredArgsConstructor
@Getter
public class ShoppingListController {
    
    private final ShoppingListService service;
    
    @GetMapping
    public ResponseEntity<FindAllShoppingListRes> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FindByIdShoppingListRes> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.findById(id));
    }
    
    @GetMapping("/{id}/products/{productId}")
    public ResponseEntity<FindByIdProductShoppingListRest> findByIdProduct(@PathVariable Integer id, @PathVariable Integer productId) {
        return ResponseEntity.ok(this.service.findByIdProduct(id, productId));
    }
    
}
