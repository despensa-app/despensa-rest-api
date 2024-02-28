package dev.nmarulo.depensaapp.commons.service;

import dev.nmarulo.depensaapp.commons.classes.PagingAndSortingRes;

public interface CrudService<I, O, ID> extends BasicService {
    
    PagingAndSortingRes<O> findAll();
    
    O findById(ID id);
    
    O save(I request);
    
    O update(ID id, I request);
    
    void delete(ID id);
    
}
