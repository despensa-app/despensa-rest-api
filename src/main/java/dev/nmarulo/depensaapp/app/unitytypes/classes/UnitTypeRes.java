package dev.nmarulo.depensaapp.app.unitytypes.classes;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UnitTypeRes {
    
    private Integer id;
    
    private String name;
    
    private Timestamp createdAt;
    
    private Timestamp updatedAt;
    
}
