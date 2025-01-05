package dev.nmarulo.despensaapp.app.pantry.products;

import dev.nmarulo.despensaapp.app.pantry.products.dtos.FindAllProductRes;
import dev.nmarulo.despensaapp.app.pantry.products.dtos.FindAllShoppingListProductRes;
import dev.nmarulo.despensaapp.app.pantry.products.dtos.SaveShoppingListProductReq;
import dev.nmarulo.despensaapp.app.pantry.products.dtos.SaveShoppingListProductRes;
import dev.nmarulo.despensaapp.app.productshoppinglist.ProductHasShoppingList;
import dev.nmarulo.despensaapp.app.productshoppinglist.ProductHasShoppingListPK;
import dev.nmarulo.despensaapp.app.productshoppinglist.ProductHasShoppingListRepository;
import dev.nmarulo.despensaapp.app.shoppinglist.ShoppingListRepository;
import dev.nmarulo.despensaapp.app.unitytypes.UnitTypeRepository;
import dev.nmarulo.despensaapp.app.users.User;
import dev.nmarulo.despensaapp.commons.exception.BadRequestException;
import dev.nmarulo.despensaapp.commons.exception.NotFoundException;
import dev.nmarulo.despensaapp.commons.service.BasicServiceImp;
import dev.nmarulo.despensaapp.commons.util.BigDecimalUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class ProductService extends BasicServiceImp {
    
    private final ProductRepository productRepository;
    
    private final ShoppingListRepository shoppingListRepository;
    
    private final UnitTypeRepository unitTypeRepository;
    
    private final ProductHasShoppingListRepository productHasShoppingListRepository;
    
    public FindAllShoppingListProductRes findAllProductsByShoppingListId(Integer shoppingListId,
                                                                         boolean isExclude,
                                                                         Pageable pageable,
                                                                         User user) {
        Page<Product> pageFindAll;
        
        if (isExclude) {
            //Obtener todos los productos que no estén en la lista de compra actual.
            pageFindAll = this.productRepository.findAllByIdNotInShoppingListIdAndUser(shoppingListId, user, pageable);
        } else {
            pageFindAll = this.productRepository.findAllByIdInShoppingListIdAndUser(shoppingListId, user, pageable);
        }
        
        return ProductMapper.toFindAllShoppingListProductRes(pageFindAll);
    }
    
    public SaveShoppingListProductRes saveProductInShoppingList(SaveShoppingListProductReq request, User user) {
        var productOptional = this.productRepository.findById(request.getProductId());
        var shoppingListOptional = this.shoppingListRepository.findByIdAndUser(request.getShoppingListId(), user);
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
        
        return ProductMapper.toSaveShoppingListProductRes(productOptional.get(),
                                                          shoppingList,
                                                          unityTipeOptional.get(),
                                                          productHasShoppingListSave);
    }
    
    public FindAllProductRes findAll(final Pageable pageable) {
        var pageFindAll = this.productRepository.findAll(pageable);
        
        return ProductMapper.toFindAllProductRes(pageFindAll);
    }
    
    private ProductHasShoppingList getEntity(SaveShoppingListProductReq request, Product product) {
        var productHasShoppingListPK = new ProductHasShoppingListPK();
        var productHasShoppingList = new ProductHasShoppingList();
        
        productHasShoppingListPK.setProductId(request.getProductId());
        productHasShoppingListPK.setShoppingListId(request.getShoppingListId());
        productHasShoppingListPK.setUnitTypeId(request.getUnitTypeId());
        
        throwIsExisteProductInShoppingList(productHasShoppingListPK);
        
        var totalPrice = BigDecimalUtil.multiply(product.getPrice(), request.getUnitsPerProduct());
        var totalCalories = BigDecimalUtil.multiply(product.getCalories(), request.getUnitsPerProduct());
        
        productHasShoppingList.setProductHasShoppingListPK(productHasShoppingListPK);
        productHasShoppingList.setUnitsPerProduct(request.getUnitsPerProduct());
        productHasShoppingList.setTotalCalories(totalCalories);
        productHasShoppingList.setTotalPrice(totalPrice);
        productHasShoppingList.setSelected(false);
        
        return productHasShoppingList;
    }
    
    private void throwIsExisteProductInShoppingList(ProductHasShoppingListPK productHasShoppingListPK) {
        boolean isExistsProductShoppingList = this.productHasShoppingListRepository.existsById(productHasShoppingListPK);
        
        if (isExistsProductShoppingList) {
            throw new BadRequestException(getLocalMessage().getMessage("error.record-already-exist"));
        }
    }
    
}
