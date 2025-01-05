package dev.nmarulo.despensa_app.app.pantry.shopping_list;

import dev.nmarulo.despensa_app.app.pantry.product_shopping_list.ProductHasShoppingList;
import dev.nmarulo.despensa_app.app.pantry.product_shopping_list.ProductHasShoppingListRepository;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos.*;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.enums.SelectedProducts;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.specifications.ProductHasShoppingListSpecs;
import dev.nmarulo.despensa_app.app.users.User;
import dev.nmarulo.despensa_app.app.users.UserRepository;
import dev.nmarulo.despensa_app.commons.exception.NotFoundException;
import dev.nmarulo.despensa_app.commons.service.BasicServiceImp;
import dev.nmarulo.despensa_app.commons.util.BigDecimalUtil;
import dev.nmarulo.despensa_app.commons.util.IntegerUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

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
    
    public FindByIdShoppingListRes findById(final Long id,
                                            final User user,
                                            final FindByIdProductListReq request,
                                            final Pageable pageable) {
        final var shoppingList = getShoppingList(id, user);
        final var productListPage = findAllProductList(shoppingList, user, request, pageable);
        final var response = ShoppingListMapper.toFindByIdShoppingListRes(shoppingList);
        final var totalUnitsPerProducts = IntegerUtil.newAtomicReference(response.getTotalUnitsPerProducts());
        final var totalSelectedProducts = IntegerUtil.newAtomicReference(response.getTotalSelectedProducts());
        final var totalPriceSelectedProducts = BigDecimalUtil.newAtomicReference(response.getTotalPriceSelectedProducts());
        final var selectProductOption = getSelectOptionList(request);
        
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
        response.setProductList(productListPage);
        response.setSelectProductOption(selectProductOption);
        
        return response;
    }
    
    public FindByIdProductShoppingListRest findByIdProduct(Long id, Long productId, User user) {
        final var productShoppingListOptional = this.productHasShoppingListRepository.findByShoppingList_IdAndShoppingList_UserAndProduct_Id(
            id,
            user,
            productId);
        
        if (productShoppingListOptional.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        return ShoppingListMapper.toFindByIdProductShoppingListRest(productShoppingListOptional.get());
    }
    
    public void deleteProducts(Long id, DeleteProductsShoppingListReq request, User user) {
        final var shoppingList = getShoppingList(id, user);
        final var productsShoppingList = this.productHasShoppingListRepository.findAllByShoppingList_IdAndShoppingList_UserAndProduct_IdIn(
            id,
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
        final var shoppingList = getShoppingList(id, user);
        
        updateProducts(id, request.getProducts(), user);
        
        shoppingList.setName(request.getName());
        
        var update = this.shoppingListRepository.save(shoppingList);
        
        return ShoppingListMapper.toUpdateShoppingListRes(update);
    }
    
    public void delete(Long id, User user) {
        final var shoppingList = getShoppingList(id, user);
        
        this.productHasShoppingListRepository.deleteAll(shoppingList.getProductHasShoppingList());
        this.shoppingListRepository.delete(shoppingList);
    }
    
    public FindByIdProductListRes findByIdProductList(final Long id,
                                                      final User user,
                                                      final FindByIdProductListReq request,
                                                      final Pageable pageable) {
        final var shoppingList = getShoppingList(id, user);
        
        return findAllProductList(shoppingList, user, request, pageable);
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
    
    private List<SelectOption<SelectedProducts, String>> getSelectOptionList(FindByIdProductListReq request) {
        final var selected = request.getSelected() == null ? SelectedProducts.NO : request.getSelected();
        
        return List.of(new SelectOption<>(SelectedProducts.NO, "Pendientes", SelectedProducts.NO == selected),
                       new SelectOption<>(SelectedProducts.YES, "Finalizados", SelectedProducts.YES == selected),
                       new SelectOption<>(SelectedProducts.ALL, "Todos", SelectedProducts.ALL == selected));
    }
    
    @Transactional
    public void productsSelected(Long id, ProductsSelectedReq request, User user) {
        if (request.getAction() == null) {
            return;
        }
        
        if (!this.shoppingListRepository.existsByIdAndUser(id, user)) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        final var select = ProductsSelectedReq.ActionType.SELECT == request.getAction();
        
        this.productHasShoppingListRepository.updateSelectedByShoppingList_IdShoppingList_User(select, id, user);
    }
    
}
