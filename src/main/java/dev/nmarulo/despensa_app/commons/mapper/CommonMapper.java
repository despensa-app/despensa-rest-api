package dev.nmarulo.despensa_app.commons.mapper;

import dev.nmarulo.despensa_app.commons.dtos.PagingAndSortingRes;
import org.springframework.data.domain.Page;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class CommonMapper {
    
    protected static <E, R extends PagingAndSortingRes<O>, O> R pageTo(final Page<E> page,
                                                                       final Supplier<R> supplier,
                                                                       final Function<E, O> function) {
        final var response = supplier.get();
        final var content = page.stream()
                                .map(function)
                                .toList();
        
        response.setContent(content);
        response.setCurrentPage(page.getNumber());
        response.setPageSize(page.getNumberOfElements());
        response.setTotalPages(page.getTotalPages());
        response.setTotal(page.getTotalElements());
        
        return response;
    }
    
}
