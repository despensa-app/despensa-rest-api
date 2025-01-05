package dev.nmarulo.despensa_app.app.pantry.shopping_list;

import dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos.*;
import dev.nmarulo.despensa_app.commons.component.DataRequestScope;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-lists")
@RequiredArgsConstructor
@Tag(name = "Shopping List", description = "Endpoints for managing shopping lists")
public class ShoppingListController {
    
    private final ShoppingListService shoppingListService;
    
    private final DataRequestScope dataRequestScope;
    
    @GetMapping
    public ResponseEntity<FindAllShoppingListRes> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.shoppingListService.findAll(pageable,
                                                                  this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FindByIdShoppingListRes> findById(@PathVariable Long id,
                                                            @ModelAttribute FindByIdProductListReq request,
                                                            @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.shoppingListService.findById(id,
                                                                   this.dataRequestScope.getAuthenticationPrincipal(),
                                                                   request,
                                                                   pageable));
    }
    
    @GetMapping("/{id}/products/{productId}")
    public ResponseEntity<FindByIdProductShoppingListRest> findByIdProduct(@PathVariable Long id,
                                                                           @PathVariable Long productId) {
        return ResponseEntity.ok(this.shoppingListService.findByIdProduct(id,
                                                                          productId,
                                                                          this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @DeleteMapping("/{id}/products")
    public ResponseEntity<?> deleteProducts(@PathVariable Long id, @RequestBody DeleteProductsShoppingListReq request) {
        this.shoppingListService.deleteProducts(id, request, this.dataRequestScope.getAuthenticationPrincipal());
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    @PostMapping
    public ResponseEntity<SaveShoppingListRes> save(@RequestBody SaveShoppingListReq request) {
        return ResponseEntity.ok(this.shoppingListService.save(request,
                                                               this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UpdateShoppingListRes> update(@PathVariable Long id,
                                                        @RequestBody UpdateShoppingListReq request) {
        return ResponseEntity.ok(this.shoppingListService.update(id,
                                                                 request,
                                                                 this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.shoppingListService.delete(id, this.dataRequestScope.getAuthenticationPrincipal());
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    @GetMapping("/{id}/products")
    public ResponseEntity<FindByIdProductListRes> findAllProducts(@PathVariable Long id,
                                                                  @ModelAttribute FindByIdProductListReq request,
                                                                  @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.shoppingListService.findByIdProductList(id,
                                                                              this.dataRequestScope.getAuthenticationPrincipal(),
                                                                              request,
                                                                              pageable));
    }
    
    @PutMapping("/{id}/products-selected")
    public ResponseEntity<Void> productsSelected(@PathVariable Long id, @RequestBody ProductsSelectedReq request) {
        this.shoppingListService.productsSelected(id, request, this.dataRequestScope.getAuthenticationPrincipal());
        
        return ResponseEntity.noContent()
                             .build();
    }
    
}
