package dev.nmarulo.despensa_app.app.pantry.shopping_list.services;

import dev.nmarulo.despensa_app.app.pantry.product_shopping_list.ProductHasShoppingList;
import dev.nmarulo.despensa_app.app.pantry.product_shopping_list.ProductHasShoppingListRepository;
import dev.nmarulo.despensa_app.app.pantry.products.ProductRepository;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.ShoppingList;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.ShoppingListMapper;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.ShoppingListRepository;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos.UpdateShoppingListReq;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos.UpdateShoppingListRes;
import dev.nmarulo.despensa_app.app.users.User;
import dev.nmarulo.despensa_app.commons.exception.BadRequestException;
import dev.nmarulo.despensa_app.commons.exception.NotFoundException;
import dev.nmarulo.despensa_app.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
public class UpdateShoppingListService extends BasicServiceImp {
    
    private final ShoppingListRepository shoppingListRepository;
    
    private final ProductHasShoppingListRepository productHasShoppingListRepository;
    
    private final ProductRepository productRepository;
    
    public UpdateShoppingListRes update(Long id, UpdateShoppingListReq request, User user) {
        final var shoppingList = getShoppingList(id, user);
        
        updateProducts(shoppingList, request.getProducts(), user);
        
        shoppingList.setName(request.getName());
        
        var update = this.shoppingListRepository.save(shoppingList);
        
        return ShoppingListMapper.toUpdateShoppingListRes(update);
    }
    
    private void updateProducts(final ShoppingList shoppingList,
                                List<UpdateShoppingListReq.ProductShoppingList> productsReq,
                                User user) {
        final var productsReqOptional = Optional.ofNullable(productsReq);
        
        if (productsReqOptional.isEmpty()) {
            return;
        }
        
        final var list = ShoppingListMapper.toProductHasShoppingListPK(productsReq, shoppingList.getId());
        final var result = this.productHasShoppingListRepository.findAllByShoppingList_UserAndProductHasShoppingListPKIn(
            user,
            list);
        
        checkResultAndThrowException(result, productsReq);
        
        result.forEach(value -> {
            var productDTO = value.getProduct();
            
            productsReq.stream()
                       .filter(productReq -> productReq.getProductId()
                                                       .equals(productDTO.getId()))
                       .findFirst()
                       .ifPresent(productReq -> value.setSelected(productReq.isSelected()));
            
            this.productHasShoppingListRepository.save(value);
        });
    }
    
    private ShoppingList getShoppingList(final Long id, final User user) {
        final var shoppingListOptional = this.shoppingListRepository.findByIdAndUser(id, user);
        
        if (shoppingListOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        return shoppingListOptional.get();
    }
    
    private void checkResultAndThrowException(final List<ProductHasShoppingList> result,
                                              final List<UpdateShoppingListReq.ProductShoppingList> productsReq) {
        if (result.size() == productsReq.size()) {
            return;
        }
        
        if (productsReq.size() > 1) {
            throw new BadRequestException(getLocalMessage().getMessage("error.some-products-not-exist"));
        }
        
        final var first = productsReq.getFirst();
        final var productOptional = this.productRepository.findById(first.getProductId());
        
        if (productOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        final var product = productOptional.get();
        
        throw new BadRequestException(getLocalMessage().getMessage("error.product-not-updated", product.getName()));
    }
    
}
