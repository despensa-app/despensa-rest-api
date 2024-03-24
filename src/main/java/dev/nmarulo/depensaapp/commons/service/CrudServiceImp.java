package dev.nmarulo.depensaapp.commons.service;

import dev.nmarulo.depensaapp.commons.classes.PagingAndSortingRes;
import dev.nmarulo.depensaapp.commons.exception.NotFoundException;
import lombok.Getter;
import org.springframework.core.ResolvableType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;

@Getter
public abstract class CrudServiceImp<I, O, E, ID> extends BasicServiceImp implements CrudService<I, O, ID> {
    
    protected abstract JpaRepository<E, ID> getRepository();
    
    @Override
    public PagingAndSortingRes<O> findAll() {
        Type responseType = new TypeToken<PagingAndSortingRes<O>>() {}.getType();
        Page<E> page = getRepository().findAll(getDataRequestScope().getPageable());
        
        return getModelMapper().map(page, responseType);
    }
    
    @Override
    public O findById(ID id) {
        E entity = getRepository().findById(id)
                                  .orElse(null);
        
        return getModelMapper().map(entity, getResponseClass());
    }
    
    @Override
    public O save(I request) {
        return saveOrUpdate(null, request);
    }
    
    @Override
    public O update(ID id, I request) {
        checkIsExistById(id);
        return saveOrUpdate(id, request);
    }
    
    @Override
    public void delete(ID id) {
        checkIsExistById(id);
        getRepository().deleteById(id);
    }
    
    private O saveOrUpdate(ID id, I request) {
        E entity = getModelMapper().map(request, getEntityClass());
        setFieldId(id, entity);
        E save = getRepository().save(entity);
        return getModelMapper().map(save, getResponseClass());
    }
    
    private void checkIsExistById(ID id) {
        if (!getRepository().existsById(id)) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
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
