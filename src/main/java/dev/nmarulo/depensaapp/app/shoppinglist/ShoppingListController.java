package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.shoppinglist.classes.IndexByIdShoppingListRes;
import dev.nmarulo.depensaapp.app.shoppinglist.classes.IndexShoppingListRes;
import dev.nmarulo.depensaapp.app.shoppinglist.classes.ShoppingListReq;
import dev.nmarulo.depensaapp.app.shoppinglist.classes.ShoppingListRes;
import dev.nmarulo.depensaapp.commons.controller.CrudController;
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
public class ShoppingListController extends CrudController<ShoppingListReq, ShoppingListRes, Integer> {
    
    private final ShoppingListService service;
    
    @GetMapping("/index")
    public ResponseEntity<IndexShoppingListRes> index() {
        return ResponseEntity.ok(this.service.index());
    }
    
    @GetMapping("/{id}/index")
    public ResponseEntity<IndexByIdShoppingListRes> indexById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.indexById(id));
    }
    
}
