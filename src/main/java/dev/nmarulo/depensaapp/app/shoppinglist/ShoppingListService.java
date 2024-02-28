package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingList;
import dev.nmarulo.depensaapp.app.shoppinglist.classes.IndexByIdShoppingListRes;
import dev.nmarulo.depensaapp.app.shoppinglist.classes.IndexShoppingListRes;
import dev.nmarulo.depensaapp.commons.exception.NotFoundException;
import dev.nmarulo.depensaapp.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class ShoppingListService extends BasicServiceImp {
    
    private final ShoppingListRepository repository;
    
    public IndexShoppingListRes index() {
        var response = new IndexShoppingListRes();
        var pageFindAll = this.repository.findAll(getDataRequestScope().getPageable());
        
        var shoppingList = pageFindAll.stream()
                                      .map(this::mapperTo)
                                      .toList();
        
        response.setContent(shoppingList);
        response.setCurrentPage(pageFindAll.getNumber());
        response.setPageSize(pageFindAll.getNumberOfElements());
        response.setTotalPages(pageFindAll.getTotalPages());
        response.setTotal(pageFindAll.getTotalElements());
        
        return response;
    }
    
    public IndexByIdShoppingListRes indexById(Integer id) {
        var findById = this.repository.findById(id);
        
        if (findById.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        var response = new IndexByIdShoppingListRes();
        var shoppingList = findById.get();
        var productsRes = shoppingList.getProductHasShoppingList()
                                      .stream()
                                      .map(this::mapperTo)
                                      .toList();
        
        response.setId(shoppingList.getId());
        response.setName(shoppingList.getName());
        response.setItems(productsRes);
        
        return response;
    }
    
    private IndexByIdShoppingListRes.Item mapperTo(ProductHasShoppingList productHasShoppingList) {
        var response = new IndexByIdShoppingListRes.Item();
        var productRes = new IndexByIdShoppingListRes.Item.Product();
        var unitTypeRes = new IndexByIdShoppingListRes.Item.UnitType();
        var product = productHasShoppingList.getProduct();
        var unitType = productHasShoppingList.getUnitType();
        
        productRes.setId(product.getId());
        productRes.setName(product.getName());
        productRes.setPrice(product.getPrice());
        unitTypeRes.setId(unitType.getId());
        unitTypeRes.setName(unitType.getName());
        
        response.setProduct(productRes);
        response.setUnitType(unitTypeRes);
        response.setTotalPrice(productHasShoppingList.getTotalPrice());
        response.setUnitsPerProduct(productHasShoppingList.getUnitsPerProduct());
        response.setSelected(productHasShoppingList.isSelected());
        
        return response;
    }
    
    private IndexShoppingListRes.ShoppingList mapperTo(ShoppingList entity) {
        var response = new IndexShoppingListRes.ShoppingList();
        
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setTotalProducts(entity.getTotalProducts());
        response.setCreatedAt(entity.getCreatedAt());
        
        return response;
    }
    
}
