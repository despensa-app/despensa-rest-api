package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingList;
import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingListRepository;
import dev.nmarulo.depensaapp.app.shoppinglist.dtos.*;
import dev.nmarulo.depensaapp.app.shoppinglist.dtos.FindByIdProductShoppingListRest.UnitTypeRes;
import dev.nmarulo.depensaapp.app.users.User;
import dev.nmarulo.depensaapp.app.users.UserRepository;
import dev.nmarulo.depensaapp.commons.exception.NotFoundException;
import dev.nmarulo.depensaapp.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        var response = new FindAllShoppingListRes();
        var pageFindAll = this.shoppingListRepository.findAllByUser(user, pageable);
        
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
    
    public FindByIdShoppingListRes findById(Integer id, User user) {
        var findById = this.shoppingListRepository.findByIdAndUser(id, user);
        
        if (findById.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        var response = new FindByIdShoppingListRes();
        var shoppingList = findById.get();
        var productsRes = shoppingList.getProductHasShoppingList()
                                      .stream()
                                      .map(this::mapperTo)
                                      .toList();
        
        response.setId(shoppingList.getId());
        response.setName(shoppingList.getName());
        response.setProducts(productsRes);
        response.setTotalProducts(shoppingList.getTotalProducts());
        response.setTotalPrice(shoppingList.getTotalPrice());
        
        return response;
    }
    
    public FindByIdProductShoppingListRest findByIdProduct(Integer id, Integer productId, User user) {
        Optional<ProductHasShoppingList> productShoppingListOptional = this.productHasShoppingListRepository.findByShoppingListIdAndUserAndProductId(
            id,
            user,
            productId);
        
        if (productShoppingListOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        return findByIdProductMapperTo(productShoppingListOptional.get());
    }
    
    public void deleteProducts(Integer id, DeleteProductsShoppingListReq request, User user) {
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
        shoppingList.setTotalCalories(new BigDecimal("0"));
        shoppingList.setTotalPrice(new BigDecimal("0"));
        shoppingList.setCreatedAt(LocalDateTime.now());
        shoppingList.setUpdatedAt(LocalDateTime.now());
        shoppingList.setUser(user);
        
        var save = this.shoppingListRepository.save(shoppingList);
        
        return new SaveShoppingListRes(save.getId(), save.getName());
    }
    
    public UpdateShoppingListRes update(Integer id, UpdateShoppingListReq request, User user) {
        var shoppingListOptional = this.shoppingListRepository.findByIdAndUser(id, user);
        
        if (shoppingListOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        updateProducts(id, request.getProducts(), user);
        
        var shoppingList = shoppingListOptional.get();
        
        shoppingList.setName(request.getName());
        shoppingList.setUpdatedAt(LocalDateTime.now());
        
        var update = this.shoppingListRepository.save(shoppingList);
        
        return new UpdateShoppingListRes(update.getId());
    }
    
    public void delete(Integer id, User user) {
        var shoppingListOptional = this.shoppingListRepository.findByIdAndUser(id, user);
        
        if (shoppingListOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        var shoppingList = shoppingListOptional.get();
        
        this.productHasShoppingListRepository.deleteAll(shoppingList.getProductHasShoppingList());
        this.shoppingListRepository.delete(shoppingList);
    }
    
    private void updateProducts(Integer shoppingListId,
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
    
    private FindByIdProductShoppingListRest findByIdProductMapperTo(ProductHasShoppingList productHasShoppingList) {
        var response = new FindByIdProductShoppingListRest();
        var product = productHasShoppingList.getProduct();
        var unitType = productHasShoppingList.getUnitType();
        var unitTypeRes = new UnitTypeRes(unitType.getId(), unitType.getName());
        
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setUnitsPerProduct(productHasShoppingList.getUnitsPerProduct());
        response.setTotalPrice(productHasShoppingList.getTotalPrice());
        response.setImgUrl(product.getImgUrl());
        response.setUnitType(unitTypeRes);
        
        return response;
    }
    
    private FindByIdShoppingListRes.ProductShoppingList mapperTo(ProductHasShoppingList productHasShoppingList) {
        var response = new FindByIdShoppingListRes.ProductShoppingList();
        var productRes = new FindByIdShoppingListRes.ProductShoppingList.Product();
        var unitTypeRes = new FindByIdShoppingListRes.ProductShoppingList.UnitType();
        var product = productHasShoppingList.getProduct();
        var unitType = productHasShoppingList.getUnitType();
        
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
    
    private FindAllShoppingListRes.ShoppingList mapperTo(ShoppingList entity) {
        var response = new FindAllShoppingListRes.ShoppingList();
        
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setTotalProducts(entity.getTotalProducts());
        response.setCreatedAt(entity.getCreatedAt());
        
        return response;
    }
    
}
