package dev.nmarulo.despensa_app.commons.service;

import dev.nmarulo.despensa_app.commons.component.DataRequestScope;
import dev.nmarulo.despensa_app.commons.component.LocalMessage;
import dev.nmarulo.despensa_app.commons.gson.GsonUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class BasicServiceImp {
    
    @Autowired
    private GsonUtil gsonUtil;
    
    @Autowired
    private DataRequestScope dataRequestScope;
    
    @Autowired
    private LocalMessage localMessage;
    
}
