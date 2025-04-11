package dev.nmarulo.despensa_app.app.pantry.shopping_list.services;

import dev.nmarulo.despensa_app.app.pantry.product_shopping_list.ProductHasShoppingListRepository;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.ShoppingList;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.ShoppingListMapper;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.ShoppingListRepository;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos.UpdateShoppingListReq;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos.UpdateShoppingListRes;
import dev.nmarulo.despensa_app.app.users.User;
import dev.nmarulo.despensa_app.commons.exception.NotFoundException;
import dev.nmarulo.despensa_app.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class UpdateShoppingListService extends BasicServiceImp {
    
    private final ShoppingListRepository shoppingListRepository;
    
    private final ProductHasShoppingListRepository productHasShoppingListRepository;
    
    public UpdateShoppingListRes update(Long id, UpdateShoppingListReq request, User user) {
        final var shoppingList = getShoppingList(id, user);
        
        updateProducts(id, request.getProducts(), user);
        
        shoppingList.setName(request.getName());
        
        var update = this.shoppingListRepository.save(shoppingList);
        
        return ShoppingListMapper.toUpdateShoppingListRes(update);
    }
    
    private void updateProducts(Long shoppingListId,
                                List<UpdateShoppingListReq.ProductShoppingList> productsReq,
                                User user) {
        if (productsReq == null || productsReq.isEmpty()) {
            return;
        }
        
        var productsId = productsReq.stream()
                                    .map(UpdateShoppingListReq.ProductShoppingList::getProductId)
                                    .toList();
        var unitTypesId = productsReq.stream()
                                     .map(UpdateShoppingListReq.ProductShoppingList::getUnitTypeId)
                                     .toList();
        var result = this.productHasShoppingListRepository.findAllByShoppingList_IdAndShoppingList_UserAndProduct_IdInAndUnitType_IdIn(
            shoppingListId,
            user,
            productsId,
            unitTypesId);
        
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
    
}
