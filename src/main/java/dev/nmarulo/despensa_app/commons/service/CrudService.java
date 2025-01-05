package dev.nmarulo.despensa_app.commons.service;

import dev.nmarulo.despensa_app.commons.dtos.PagingAndSortingRes;
import org.springframework.data.domain.Pageable;

public interface CrudService<I, O, ID> {
    
    PagingAndSortingRes<O> findAll(final Pageable pageable);
    
    O findById(ID id);
    
    O save(I request);
    
    O update(ID id, I request);
    
    void delete(ID id);
    
}
