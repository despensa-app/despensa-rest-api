package dev.nmarulo.depensaapp.app.users.classes;

import lombok.Data;

@Data
public class FindByIdUserRes {
    
    private Integer id;
    
    private String username;
    
    private String email;
    
}
