package dev.nmarulo.depensaapp.app.shoppinglist.classes;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ShoppingListRes {
    
    private Integer id;
    
    private String name;
    
    private Integer totalProducts;
    
    private BigDecimal totalCalories;
    
    private BigDecimal totalPrice;
    
    private Timestamp createdAt;
    
    private Timestamp updatedAt;
    
}
