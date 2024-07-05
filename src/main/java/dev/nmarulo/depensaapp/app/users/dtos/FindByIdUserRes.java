package dev.nmarulo.depensaapp.app.users.dtos;

import lombok.Data;

@Data
public class FindByIdUserRes {
    
    private Integer id;
    
    private String username;
    
    private String email;
    
}
