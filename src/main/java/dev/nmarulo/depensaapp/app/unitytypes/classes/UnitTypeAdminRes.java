package dev.nmarulo.depensaapp.app.unitytypes.classes;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UnitTypeAdminRes {
    
    private Integer id;
    
    private String name;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
}
