package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.shoppinglist.dtos.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-lists")
@RequiredArgsConstructor
@Getter
public class ShoppingListController {
    
    private final ShoppingListService service;
    
    @GetMapping
    public ResponseEntity<FindAllShoppingListRes> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.service.findAll(pageable));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FindByIdShoppingListRes> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.findById(id));
    }
    
    @GetMapping("/{id}/products/{productId}")
    public ResponseEntity<FindByIdProductShoppingListRest> findByIdProduct(@PathVariable Integer id,
                                                                           @PathVariable Integer productId) {
        return ResponseEntity.ok(this.service.findByIdProduct(id, productId));
    }
    
    @DeleteMapping("/{id}/products")
    public ResponseEntity<?> deleteProducts(@PathVariable Integer id,
                                            @RequestBody DeleteProductsShoppingListReq request) {
        this.service.deleteProducts(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    @PostMapping
    public ResponseEntity<SaveShoppingListRes> save(@RequestBody SaveShoppingListReq request) {
        //anonymousUser
        final var principal = SecurityContextHolder.getContext()
                                                   .getAuthentication()
                                                   .getPrincipal();
        String username;
        
        if (principal instanceof Jwt jwt) {
            username = jwt.getSubject();
        } else {
            username = String.valueOf(principal);
        }
        
        return ResponseEntity.ok(this.service.save(request, username));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UpdateShoppingListRes> update(@PathVariable Integer id,
                                                        @RequestBody UpdateShoppingListReq request) {
        return ResponseEntity.ok(this.service.update(id, request));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        this.service.delete(id);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
}
