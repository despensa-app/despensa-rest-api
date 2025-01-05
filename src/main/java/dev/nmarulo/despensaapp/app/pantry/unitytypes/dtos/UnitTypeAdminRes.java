package dev.nmarulo.despensaapp.app.pantry.unitytypes.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UnitTypeAdminRes {
    
    private Integer id;
    
    private String name;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
}
