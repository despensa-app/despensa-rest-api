package dev.nmarulo.depensaapp.app.products.classes;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ProductRes {
    
    private Integer id;
    
    private String name;
    
    private BigDecimal price;
    
    private String imgUrl;
    
    private BigDecimal calories;
    
    private String description;
    
    private Timestamp createdAt;
    
    private Timestamp updatedAt;
    
}
