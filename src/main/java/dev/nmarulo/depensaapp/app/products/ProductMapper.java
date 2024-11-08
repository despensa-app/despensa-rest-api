package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.products.dtos.FindAllProductRes;
import dev.nmarulo.depensaapp.app.products.dtos.FindAllShoppingListProductRes;
import dev.nmarulo.depensaapp.app.products.dtos.SaveShoppingListProductRes;
import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingList;
import dev.nmarulo.depensaapp.app.shoppinglist.ShoppingList;
import dev.nmarulo.depensaapp.app.unitytypes.UnitType;

public final class ProductMapper {
    
    private ProductMapper() {
    }
    
    public static FindAllShoppingListProductRes.Product toFindAllShoppingListProductResProduct(final Product product) {
        final var response = new FindAllShoppingListProductRes.Product();
        
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setImgUrl(product.getImgUrl());
        
        return response;
    }
    
    public static SaveShoppingListProductRes toSaveShoppingListProductRes(final Product product,
                                                                          final ShoppingList shoppingList,
                                                                          final UnitType unitType,
                                                                          final ProductHasShoppingList productHasShoppingListSave) {
        final var response = new SaveShoppingListProductRes();
        final var shoppingListRes = new SaveShoppingListProductRes.ShoppingList(shoppingList.getId(),
                                                                                shoppingList.getName());
        final var unitTypeRes = new SaveShoppingListProductRes.UnitType(unitType.getId(), unitType.getName());
        final var productRes = new SaveShoppingListProductRes.Product(product.getId(),
                                                                      product.getName(),
                                                                      product.getPrice());
        
        response.setShoppingList(shoppingListRes);
        response.setProduct(productRes);
        response.setUnitType(unitTypeRes);
        response.setTotalPrice(productHasShoppingListSave.getTotalPrice());
        response.setUnitsPerProduct(productHasShoppingListSave.getUnitsPerProduct());
        
        return response;
    }
    
    public static FindAllProductRes.Product toFindAllProductResProduct(final Product product) {
        final var response = new FindAllProductRes.Product();
        
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setImgUrl(product.getImgUrl());
        response.setCalories(product.getCalories());
        response.setDescription(product.getDescription());
        
        return response;
    }
    
}
