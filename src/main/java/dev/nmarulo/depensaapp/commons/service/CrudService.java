package dev.nmarulo.depensaapp.commons.service;

import dev.nmarulo.depensaapp.commons.dtos.PagingAndSortingRes;
import org.springframework.data.domain.Pageable;

public interface CrudService<I, O, ID> extends BasicService {
    
    PagingAndSortingRes<O> findAll(final Pageable pageable);
    
    O findById(ID id);
    
    O save(I request);
    
    O update(ID id, I request);
    
    void delete(ID id);
    
}
