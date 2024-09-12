package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.shoppinglist.dtos.*;
import dev.nmarulo.depensaapp.commons.component.DataRequestScope;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-lists")
@RequiredArgsConstructor
@Getter
@Tag(name = "Shopping List", description = "Endpoints for managing shopping lists")
public class ShoppingListController {
    
    private final ShoppingListService service;
    
    private final DataRequestScope dataRequestScope;
    
    @GetMapping
    public ResponseEntity<FindAllShoppingListRes> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.service.findAll(pageable, this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FindByIdShoppingListRes> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.findById(id, this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @GetMapping("/{id}/products/{productId}")
    public ResponseEntity<FindByIdProductShoppingListRest> findByIdProduct(@PathVariable Integer id,
                                                                           @PathVariable Integer productId) {
        return ResponseEntity.ok(this.service.findByIdProduct(id,
                                                              productId,
                                                              this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @DeleteMapping("/{id}/products")
    public ResponseEntity<?> deleteProducts(@PathVariable Integer id,
                                            @RequestBody DeleteProductsShoppingListReq request) {
        this.service.deleteProducts(id, request, this.dataRequestScope.getAuthenticationPrincipal());
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    @PostMapping
    public ResponseEntity<SaveShoppingListRes> save(@RequestBody SaveShoppingListReq request) {
        return ResponseEntity.ok(this.service.save(request, this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UpdateShoppingListRes> update(@PathVariable Integer id,
                                                        @RequestBody UpdateShoppingListReq request) {
        return ResponseEntity.ok(this.service.update(id, request, this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        this.service.delete(id, this.dataRequestScope.getAuthenticationPrincipal());
        
        return ResponseEntity.noContent()
                             .build();
    }
    
}
