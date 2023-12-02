package dev.nmarulo.depensaapp.commons.service;

import dev.nmarulo.depensaapp.commons.classes.PagingAndSortingRes;
import dev.nmarulo.depensaapp.commons.component.DataRequestScope;
import dev.nmarulo.depensaapp.commons.component.LocalMessage;
import dev.nmarulo.depensaapp.commons.exception.NotFoundException;
import dev.nmarulo.depensaapp.commons.gson.GsonUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;

@Getter
public abstract class CrudServiceImp<I, O, E, ID> implements CrudService<I, O, ID> {
    
    @Autowired
    private GsonUtil gsonUtil;
    
    @Autowired
    private DataRequestScope dataRequestScope;
    
    @Autowired
    private LocalMessage localMessage;
    
    protected abstract JpaRepository<E, ID> getRepository();
    
    @Override
    public PagingAndSortingRes<O> findAll() {
        Page<E> page = getRepository().findAll(this.dataRequestScope.getPageable());
        
        return pageToResponse(page, getResponseClass());
    }
    
    @Override
    public O findById(ID id) {
        E entity = getRepository().findById(id)
                                  .orElse(null);
        
        return this.gsonUtil.convertTo(entity, getResponseClass());
    }
    
    @Override
    public O save(I request) {
        E entity = this.gsonUtil.convertTo(request, getEntityClass());
        
        setFieldId(null, entity);
        
        E save = getRepository().save(entity);
        
        return this.gsonUtil.convertTo(save, getResponseClass());
    }
    
    @Override
    public O update(ID id, I request) {
        checkIsExistById(id);
        E entity = this.gsonUtil.convertTo(request, getEntityClass());
        
        setFieldId(id, entity);
        
        E save = getRepository().save(entity);
        
        return this.gsonUtil.convertTo(save, getResponseClass());
    }
    
    @Override
    public void delete(ID id) {
        checkIsExistById(id);
        getRepository().deleteById(id);
    }
    
    protected <RE, EN> PagingAndSortingRes<RE> pageToResponse(Page<EN> page, Class<RE> classRE) {
        PagingAndSortingRes<RE> response = new PagingAndSortingRes<>();
        List<RE> content = this.gsonUtil.convertTo(page.getContent(), classRE);
        
        response.setContent(content);
        response.setCurrentPage(page.getNumber());
        response.setPageSize(page.getNumberOfElements());
        response.setTotalPages(page.getTotalPages());
        response.setTotal(page.getTotalElements());
        
        return response;
    }
    
    private void checkIsExistById(ID id) {
        if (!getRepository().existsById(id)) {
            throw new NotFoundException(this.localMessage.getMessage("error.record-not-exist"));
        }
    }
    
    private void setFieldId(ID id, E entity) {
        Field field = ReflectionUtils.findField(entity.getClass(), "id");
        
        if (field != null) {
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, entity, id);
        }
    }
    
    @SuppressWarnings("unchecked")
    public Class<E> getEntityClass() {
        return (Class<E>) ResolvableType.forClass(this.getClass())
                                        .getSuperType()
                                        .resolveGeneric(2);
    }
    
    @SuppressWarnings("unchecked")
    protected Class<O> getResponseClass() {
        return (Class<O>) ResolvableType.forClass(this.getClass())
                                        .getSuperType()
                                        .resolveGeneric(1);
    }
    
}
