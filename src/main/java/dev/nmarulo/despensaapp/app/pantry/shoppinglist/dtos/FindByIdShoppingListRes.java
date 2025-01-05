package dev.nmarulo.despensaapp.app.pantry.shoppinglist.dtos;

import dev.nmarulo.despensaapp.app.pantry.shoppinglist.enums.SelectedProducts;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FindByIdShoppingListRes {
    
    private Long id;
    
    private String name;
    
    private Integer totalProducts;
    
    private BigDecimal totalPrice;
    
    private Integer totalUnitsPerProducts;
    
    private Integer totalSelectedProducts;
    
    private BigDecimal totalPriceSelectedProducts;
    
    private FindByIdProductListRes productList;
    
    private List<SelectOption<SelectedProducts, String>> selectProductOption;
    
}
