package dev.nmarulo.despensaapp.commons.service;

import dev.nmarulo.despensaapp.commons.component.DataRequestScope;
import dev.nmarulo.despensaapp.commons.component.LocalMessage;
import dev.nmarulo.despensaapp.commons.gson.GsonUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class BasicServiceImp implements BasicService {
    
    @Autowired
    private GsonUtil gsonUtil;
    
    @Autowired
    private DataRequestScope dataRequestScope;
    
    @Autowired
    private LocalMessage localMessage;
    
}
