package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.products.classes.*;
import dev.nmarulo.depensaapp.commons.controller.CrudController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Getter
public class ProductController extends CrudController<ProductReq, ProductRes, Integer> {
    
    private final ProductService service;
    
    @GetMapping("/index")
    public ResponseEntity<IndexProductRes> index(@RequestParam(value = "exclude_shopping_list_id",
                                                               required = false) Integer excludeShoppingListId) {
        return ResponseEntity.ok(this.service.index(excludeShoppingListId));
    }
    
    @PostMapping("/index/shopping-list")
    public ResponseEntity<IndexShoppingListProductRes> indexShoppingList(@RequestBody IndexShoppingListProductReq request) {
        return ResponseEntity.ok(this.service.indexShoppingList(request));
    }
    
}
