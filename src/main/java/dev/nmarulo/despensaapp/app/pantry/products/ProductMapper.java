package dev.nmarulo.despensaapp.app.pantry.products;

import dev.nmarulo.despensaapp.app.pantry.product_shopping_list.ProductHasShoppingList;
import dev.nmarulo.despensaapp.app.pantry.products.dtos.FindAllProductRes;
import dev.nmarulo.despensaapp.app.pantry.products.dtos.FindAllShoppingListProductRes;
import dev.nmarulo.despensaapp.app.pantry.products.dtos.SaveShoppingListProductRes;
import dev.nmarulo.despensaapp.app.pantry.shopping_list.ShoppingList;
import dev.nmarulo.despensaapp.app.pantry.unity_types.UnitType;
import dev.nmarulo.despensaapp.commons.mapper.CommonMapper;
import org.springframework.data.domain.Page;

public final class ProductMapper extends CommonMapper {
    
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
    
    public static FindAllShoppingListProductRes toFindAllShoppingListProductRes(final Page<Product> page) {
        return pageTo(page, FindAllShoppingListProductRes::new, ProductMapper::toFindAllShoppingListProductResProduct);
    }
    
    public static FindAllProductRes toFindAllProductRes(final Page<Product> page) {
        return pageTo(page, FindAllProductRes::new, ProductMapper::toFindAllProductResProduct);
    }
    
}
