package dev.nmarulo.depensaapp.app.products.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductAdminRes {
    
    private Long id;
    
    private String name;
    
    private BigDecimal price;
    
    private String imgUrl;
    
    private BigDecimal calories;
    
    private String description;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
}
