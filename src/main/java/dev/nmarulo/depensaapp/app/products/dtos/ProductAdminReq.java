package dev.nmarulo.depensaapp.app.products.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductAdminReq {
    
    private String name;
    
    private BigDecimal price;
    
    private String imgUrl;
    
    private BigDecimal calories;
    
    private String description;
    
}
