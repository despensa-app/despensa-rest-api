package dev.nmarulo.depensaapp.app.shoppinglist.dtos;

import lombok.Data;

import java.math.BigDecimal;

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
    
}
