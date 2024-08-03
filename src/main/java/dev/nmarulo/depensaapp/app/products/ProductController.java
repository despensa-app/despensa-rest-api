package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.products.dtos.FindAllProductRes;
import dev.nmarulo.depensaapp.app.products.dtos.FindAllShoppingListProductRes;
import dev.nmarulo.depensaapp.app.products.dtos.SaveShoppingListProductReq;
import dev.nmarulo.depensaapp.app.products.dtos.SaveShoppingListProductRes;
import dev.nmarulo.depensaapp.commons.component.DataRequestScope;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Getter
public class ProductController {
    
    private final ProductService service;
    
    private final DataRequestScope dataRequestScope;
    
    @GetMapping("/shopping-list/{id}")
    public ResponseEntity<FindAllShoppingListProductRes> findAllShoppingList(@PathVariable("id") Integer shoppingListId,
                                                                             @RequestParam(value = "exclude",
                                                                                           required = false) boolean isExclude,
                                                                             @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.service.findAllShoppingList(shoppingListId,
                                                                  isExclude,
                                                                  pageable,
                                                                  this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @PostMapping("/shopping-list")
    public ResponseEntity<SaveShoppingListProductRes> saveShoppingList(@RequestBody SaveShoppingListProductReq request) {
        return ResponseEntity.ok(this.service.saveShoppingList(request));
    }
    
    @GetMapping
    public ResponseEntity<FindAllProductRes> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.service.findAll(pageable));
    }
    
}
