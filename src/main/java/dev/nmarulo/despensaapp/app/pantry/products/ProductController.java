package dev.nmarulo.despensaapp.app.pantry.products;

import dev.nmarulo.despensaapp.app.pantry.products.dtos.FindAllProductRes;
import dev.nmarulo.despensaapp.app.pantry.products.dtos.FindAllShoppingListProductRes;
import dev.nmarulo.despensaapp.app.pantry.products.dtos.SaveShoppingListProductReq;
import dev.nmarulo.despensaapp.app.pantry.products.dtos.SaveShoppingListProductRes;
import dev.nmarulo.despensaapp.commons.component.DataRequestScope;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product", description = "Endpoints for managing products")
public class ProductController {
    
    private final ProductService productService;
    
    private final DataRequestScope dataRequestScope;
    
    @GetMapping("/shopping-list/{id}")
    public ResponseEntity<FindAllShoppingListProductRes> findAllProductsByShoppingListId(@PathVariable("id") Integer shoppingListId,
                                                                                         @RequestParam(value = "exclude",
                                                                                                       required = false) boolean isExclude,
                                                                                         @PageableDefault Pageable pageable) {
        final var response = this.productService.findAllProductsByShoppingListId(shoppingListId,
                                                                                 isExclude,
                                                                                 pageable,
                                                                                 this.dataRequestScope.getAuthenticationPrincipal());
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/shopping-list")
    public ResponseEntity<SaveShoppingListProductRes> saveProductInShoppingList(@RequestBody SaveShoppingListProductReq request) {
        return ResponseEntity.ok(this.productService.saveProductInShoppingList(request,
                                                                               this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @GetMapping
    public ResponseEntity<FindAllProductRes> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.productService.findAll(pageable));
    }
    
}
