package dev.nmarulo.depensaapp.commons.service;

import dev.nmarulo.depensaapp.commons.component.DataRequestScope;
import dev.nmarulo.depensaapp.commons.component.LocalMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

@Getter
public abstract class BasicServiceImp implements BasicService {
    
    private final ModelMapper modelMapper = new ModelMapper();
    
    @Autowired
    private DataRequestScope dataRequestScope;
    
    @Autowired
    private LocalMessage localMessage;
    
}
