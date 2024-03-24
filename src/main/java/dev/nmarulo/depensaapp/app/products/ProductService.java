package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.products.classes.FindAllProductRes;
import dev.nmarulo.depensaapp.app.products.classes.FindAllShoppingListProductRes;
import dev.nmarulo.depensaapp.app.products.classes.SaveShoppingListProductReq;
import dev.nmarulo.depensaapp.app.products.classes.SaveShoppingListProductRes;
import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingList;
import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingListPK;
import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingListRepository;
import dev.nmarulo.depensaapp.app.shoppinglist.ShoppingList;
import dev.nmarulo.depensaapp.app.shoppinglist.ShoppingListRepository;
import dev.nmarulo.depensaapp.app.unitytypes.UnitType;
import dev.nmarulo.depensaapp.app.unitytypes.UnitTypeRepository;
import dev.nmarulo.depensaapp.commons.exception.BadRequestException;
import dev.nmarulo.depensaapp.commons.exception.NotFoundException;
import dev.nmarulo.depensaapp.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Getter
public class ProductService extends BasicServiceImp {
    
    private final ProductRepository repository;
    
    private final ShoppingListRepository shoppingListRepository;
    
    private final UnitTypeRepository unitTypeRepository;
    
    private final ProductHasShoppingListRepository productHasShoppingListRepository;
    
    public FindAllShoppingListProductRes findAllShoppingList(Integer excludeShoppingListId) {
        var response = new FindAllShoppingListProductRes();
        //Obtener todos los productos que no estén en la lista de compra actual.
        var pageFindAll = this.repository.findAllByIdNotInShoppingList(excludeShoppingListId, getDataRequestScope().getPageable());
        
        getModelMapper().map(pageFindAll, response);
        
        return response;
    }
    
    public FindAllProductRes findAll() {
        var response = new FindAllProductRes();
        //Obtener todos los productos que no estén en la lista de compra actual.
        var pageFindAll = this.repository.findAll(getDataRequestScope().getPageable());
        
        getModelMapper().map(pageFindAll, response);
        
        return response;
    }
    
    public SaveShoppingListProductRes saveShoppingList(SaveShoppingListProductReq request) {
        var productOptional = this.repository.findById(request.getProductId());
        var shoppingListOptional = this.shoppingListRepository.findById(request.getShoppingListId());
        var unityTipeOptional = this.unitTypeRepository.findById(request.getUnitTypeId());
        var isEmptyShoppingList = shoppingListOptional.isEmpty();
        var isEmptyProduct = productOptional.isEmpty();
        var isEmptyUnitType = unityTipeOptional.isEmpty();
        
        if (isEmptyProduct || isEmptyShoppingList || isEmptyUnitType) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        var productHasShoppingList = getEntity(request, productOptional.get());
        var shoppingList = shoppingListOptional.get();
        
        var totalProducts = shoppingList.getTotalProducts() + 1;
        var totalPrice = shoppingList.getTotalPrice()
                                     .add(productHasShoppingList.getTotalPrice());
        
        shoppingList.setTotalProducts(totalProducts);
        shoppingList.setTotalPrice(totalPrice);
        
        //TODO: Como el "save" no me retorna las FK estoy consultando previamente cada uno de los campos.
        var productHasShoppingListSave = this.productHasShoppingListRepository.save(productHasShoppingList);
        
        return mapperTo(productOptional.get(), shoppingList, unityTipeOptional.get(), productHasShoppingListSave);
    }
    
    private SaveShoppingListProductRes mapperTo(Product product, ShoppingList shoppingList, UnitType unitType, ProductHasShoppingList productHasShoppingListSave) {
        var response = new SaveShoppingListProductRes();
        
        var shoppingListRes = getModelMapper().map(shoppingList, SaveShoppingListProductRes.ShoppingList.class);
        var unitTypeRes = getModelMapper().map(unitType, SaveShoppingListProductRes.UnitType.class);
        var productRes = getModelMapper().map(product, SaveShoppingListProductRes.Product.class);
        
        getModelMapper().map(shoppingList, response);
        getModelMapper().map(unitType, response);
        getModelMapper().map(product, response);
        getModelMapper().map(productHasShoppingListSave, response);
        
        return response;
    }
    
    private ProductHasShoppingList getEntity(SaveShoppingListProductReq request, Product product) {
        var productHasShoppingListPK = new ProductHasShoppingListPK();
        var productHasShoppingList = new ProductHasShoppingList();
        
        productHasShoppingListPK.setProductId(request.getProductId());
        productHasShoppingListPK.setShoppingListId(request.getShoppingListId());
        productHasShoppingListPK.setUnitTypeId(request.getUnitTypeId());
        
        throwIsExisteProductInShoppingList(productHasShoppingListPK);
        
        var totalPrice = multiply(product.getPrice(), request.getUnitsPerProduct());
        var totalCalories = multiply(product.getCalories(), request.getUnitsPerProduct());
        
        productHasShoppingList.setProductHasShoppingListPK(productHasShoppingListPK);
        productHasShoppingList.setUnitsPerProduct(request.getUnitsPerProduct());
        productHasShoppingList.setTotalCalories(totalCalories);
        productHasShoppingList.setTotalPrice(totalPrice);
        productHasShoppingList.setSelected(false);
        
        return productHasShoppingList;
    }
    
    private BigDecimal multiply(BigDecimal valueBigDecimal, Integer valueInteger) {
        return valueBigDecimal.multiply(new BigDecimal(valueInteger));
    }
    
    private void throwIsExisteProductInShoppingList(ProductHasShoppingListPK productHasShoppingListPK) {
        boolean isExistsProductShoppingList = this.productHasShoppingListRepository.existsById(productHasShoppingListPK);
        
        if (isExistsProductShoppingList) {
            throw new BadRequestException(getLocalMessage().getMessage("error.record-already-exist"));
        }
    }
    
}
