package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingList;
import dev.nmarulo.depensaapp.app.shoppinglist.dtos.*;
import dev.nmarulo.depensaapp.commons.mapper.CommonMapper;
import org.springframework.data.domain.Page;

public final class ShoppingListMapper extends CommonMapper {
    
    private ShoppingListMapper() {
    }
    
    public static FindByIdShoppingListRes.ProductShoppingList toFindByIdShoppingListResProductShoppingList(final ProductHasShoppingList productHasShoppingList) {
        final var response = new FindByIdShoppingListRes.ProductShoppingList();
        final var productRes = new FindByIdShoppingListRes.ProductShoppingList.Product();
        final var unitTypeRes = new FindByIdShoppingListRes.ProductShoppingList.UnitType();
        final var product = productHasShoppingList.getProduct();
        final var unitType = productHasShoppingList.getUnitType();
        
        productRes.setId(product.getId());
        productRes.setName(product.getName());
        productRes.setPrice(product.getPrice());
        productRes.setImgUrl(product.getImgUrl());
        unitTypeRes.setId(unitType.getId());
        unitTypeRes.setName(unitType.getName());
        
        response.setProduct(productRes);
        response.setUnitType(unitTypeRes);
        response.setTotalPrice(productHasShoppingList.getTotalPrice());
        response.setUnitsPerProduct(productHasShoppingList.getUnitsPerProduct());
        response.setSelected(productHasShoppingList.isSelected());
        
        return response;
    }
    
    public static FindAllShoppingListRes.ShoppingList toFindAllShoppingListResShoppingList(final ShoppingList entity) {
        var response = new FindAllShoppingListRes.ShoppingList();
        
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setTotalProducts(entity.getTotalProducts());
        response.setCreatedAt(entity.getCreatedAt());
        
        return response;
    }
    
    public static FindByIdProductShoppingListRest toFindByIdProductShoppingListRest(final ProductHasShoppingList productHasShoppingList) {
        final var response = new FindByIdProductShoppingListRest();
        final var product = productHasShoppingList.getProduct();
        final var unitType = productHasShoppingList.getUnitType();
        final var unitTypeRes = new FindByIdProductShoppingListRest.UnitTypeRes(unitType.getId(), unitType.getName());
        
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setUnitsPerProduct(productHasShoppingList.getUnitsPerProduct());
        response.setTotalPrice(productHasShoppingList.getTotalPrice());
        response.setImgUrl(product.getImgUrl());
        response.setUnitType(unitTypeRes);
        
        return response;
    }
    
    public static SaveShoppingListRes toSaveShoppingListRes(final ShoppingList save) {
        return new SaveShoppingListRes(save.getId(), save.getName());
    }
    
    public static UpdateShoppingListRes toUpdateShoppingListRes(final ShoppingList update) {
        return new UpdateShoppingListRes(update.getId());
    }
    
}
