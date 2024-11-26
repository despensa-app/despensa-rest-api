package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingList;
import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingListRepository;
import dev.nmarulo.depensaapp.app.shoppinglist.dtos.*;
import dev.nmarulo.depensaapp.app.shoppinglist.specifications.ProductHasShoppingListSpecs;
import dev.nmarulo.depensaapp.app.users.User;
import dev.nmarulo.depensaapp.app.users.UserRepository;
import dev.nmarulo.depensaapp.commons.exception.NotFoundException;
import dev.nmarulo.depensaapp.commons.service.BasicServiceImp;
import dev.nmarulo.depensaapp.commons.util.BigDecimalUtil;
import dev.nmarulo.depensaapp.commons.util.IntegerUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
public class ShoppingListService extends BasicServiceImp {
    
    private final ShoppingListRepository shoppingListRepository;
    
    private final ProductHasShoppingListRepository productHasShoppingListRepository;
    
    private final UserRepository userRepository;
    
    public FindAllShoppingListRes findAll(final Pageable pageable, User user) {
        var pageFindAll = this.shoppingListRepository.findAllByUser(user, pageable);
        
        return ShoppingListMapper.toFindAllShoppingListRes(pageFindAll);
    }
    
    public FindByIdShoppingListRes findById(Long id, User user) {
        var findById = this.shoppingListRepository.findByIdAndUser(id, user);
        
        if (findById.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        final var shoppingList = findById.get();
        final var response = ShoppingListMapper.toFindByIdShoppingListRes(shoppingList);
        final var totalUnitsPerProducts = IntegerUtil.newAtomicReference(response.getTotalUnitsPerProducts());
        final var totalSelectedProducts = IntegerUtil.newAtomicReference(response.getTotalSelectedProducts());
        final var totalPriceSelectedProducts = BigDecimalUtil.newAtomicReference(response.getTotalPriceSelectedProducts());
        
        shoppingList.getProductHasShoppingList()
                    .forEach(value -> {
                        if (value.isSelected()) {
                            totalSelectedProducts.accumulateAndGet(1, Integer::sum);
                            totalPriceSelectedProducts.accumulateAndGet(value.getTotalPrice(), BigDecimal::add);
                        }
                        
                        totalUnitsPerProducts.accumulateAndGet(value.getUnitsPerProduct(), Integer::sum);
                    });
        
        response.setTotalUnitsPerProducts(totalUnitsPerProducts.get());
        response.setTotalSelectedProducts(totalSelectedProducts.get());
        response.setTotalPriceSelectedProducts(totalPriceSelectedProducts.get());
        
        return response;
    }
    
    public FindByIdProductShoppingListRest findByIdProduct(Integer id, Long productId, User user) {
        Optional<ProductHasShoppingList> productShoppingListOptional = this.productHasShoppingListRepository.findByShoppingListIdAndUserAndProductId(
            id,
            user,
            productId);
        
        if (productShoppingListOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        return ShoppingListMapper.toFindByIdProductShoppingListRest(productShoppingListOptional.get());
    }
    
    public void deleteProducts(Long id, DeleteProductsShoppingListReq request, User user) {
        var shoppingListOptional = this.shoppingListRepository.findByIdAndUser(id, user);
        
        if (shoppingListOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        var shoppingList = shoppingListOptional.get();
        
        var productsShoppingList = this.productHasShoppingListRepository.findAllByShoppingListIdAndUserAndProductIdIn(id,
                                                                                                                      user,
                                                                                                                      request.getProductsId());
        
        var totalProducts = shoppingList.getTotalProducts() - productsShoppingList.size();
        var reduce = productsShoppingList.stream()
                                         .map(ProductHasShoppingList::getTotalPrice)
                                         .reduce(BigDecimal.ZERO, BigDecimal::add);
        var totalPrice = shoppingList.getTotalPrice()
                                     .subtract(reduce);
        
        shoppingList.setTotalProducts(totalProducts);
        shoppingList.setTotalPrice(totalPrice);
        
        this.productHasShoppingListRepository.deleteAll(productsShoppingList);
    }
    
    public SaveShoppingListRes save(SaveShoppingListReq request, User user) {
        var shoppingList = new ShoppingList();
        
        shoppingList.setName(StringUtils.defaultIfBlank(request.getName(), "Sin título"));
        shoppingList.setTotalProducts(0);
        shoppingList.setTotalCalories(BigDecimal.ZERO);
        shoppingList.setTotalPrice(BigDecimal.ZERO);
        shoppingList.setUser(user);
        
        var save = this.shoppingListRepository.save(shoppingList);
        
        return ShoppingListMapper.toSaveShoppingListRes(save);
    }
    
    public UpdateShoppingListRes update(Long id, UpdateShoppingListReq request, User user) {
        var shoppingListOptional = this.shoppingListRepository.findByIdAndUser(id, user);
        
        if (shoppingListOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        updateProducts(id, request.getProducts(), user);
        
        var shoppingList = shoppingListOptional.get();
        
        shoppingList.setName(request.getName());
        
        var update = this.shoppingListRepository.save(shoppingList);
        
        return ShoppingListMapper.toUpdateShoppingListRes(update);
    }
    
    public void delete(Long id, User user) {
        var shoppingListOptional = this.shoppingListRepository.findByIdAndUser(id, user);
        
        if (shoppingListOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        var shoppingList = shoppingListOptional.get();
        
        this.productHasShoppingListRepository.deleteAll(shoppingList.getProductHasShoppingList());
        this.shoppingListRepository.delete(shoppingList);
    }
    
    public FindByIdProductListRes findByIdProductList(final Long id,
                                                      final User user,
                                                      final FindByIdProductListReq request,
                                                      final Pageable pageable) {
        var shoppingListOptional = this.shoppingListRepository.findByIdAndUser(id, user);
        
        if (shoppingListOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        return findAllProductList(shoppingListOptional.get(), user, request, pageable);
    }
    
    private FindByIdProductListRes findAllProductList(final ShoppingList shoppingList,
                                                      final User user,
                                                      final FindByIdProductListReq request,
                                                      final Pageable pageable) {
        final var specification = ProductHasShoppingListSpecs.findAll(request, user, shoppingList);
        final var productListPage = this.productHasShoppingListRepository.findAll(specification, pageable);
        
        return ShoppingListMapper.toFindByIdProductListRes(productListPage);
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
        var result = this.productHasShoppingListRepository.findAllByShoppingListIdAndUserAndProductIdInAndUnitTypeIdIn(
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
    
}
