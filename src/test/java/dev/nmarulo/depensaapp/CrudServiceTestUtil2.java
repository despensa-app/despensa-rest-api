package dev.nmarulo.depensaapp;

import lombok.Getter;
import lombok.Value;

import java.util.List;

@Getter
public abstract class CrudServiceTestUtil2<E, R, T, ID> {
    
    private E request;
    
    private R response;
    
    private T entity;
    
    private T entitySaveResult;
    
    private ID id;
    
    private final List<R> responseList;
    
    private final List<T> entityList;
    
    public CrudServiceTestUtil2() {
        setInit();
        this.responseList = List.of(this.response);
        this.entityList = List.of(this.entity);
    }
    
    public abstract Init<E, R, T, ID> init();
    
    private void setInit() {
        Init<E, R, T, ID> init = init();
        
        this.request = init.getRequest();
        this.response = init.getResponse();
        this.entity = init.getEntity();
        this.entitySaveResult = init.getEntitySaveResult();
        this.id = init.getId();
    }
    
    @Value(staticConstructor = "of")
    public static class Init<E, R, T, ID> {
        
        E request;
        
        R response;
        
        T entity;
        
        T entitySaveResult;
        
        ID id;
        
    }
    
}
