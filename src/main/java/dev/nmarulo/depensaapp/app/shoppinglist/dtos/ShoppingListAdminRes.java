package dev.nmarulo.depensaapp.app.shoppinglist.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ShoppingListAdminRes {
    
    private Integer id;
    
    private String name;
    
    private Integer totalProducts;
    
    private BigDecimal totalCalories;
    
    private BigDecimal totalPrice;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
}
