package dev.nmarulo.depensaapp.app.shoppinglist.classes;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ShoppingListRes {
    
    private Integer id;
    
    private String name;
    
    private Integer totalProducts;
    
    private BigDecimal totalCalories;
    
    private BigDecimal totalPrice;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
}
