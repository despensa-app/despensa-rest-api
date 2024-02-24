package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.products.classes.IndexProductRes;
import dev.nmarulo.depensaapp.app.products.classes.ProductReq;
import dev.nmarulo.depensaapp.app.products.classes.ProductRes;
import dev.nmarulo.depensaapp.commons.controller.CrudController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    
}
