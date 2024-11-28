package dev.nmarulo.despensaapp.commons.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PagingAndSortingRes<R> extends ContentRes<R> {
    
    private int currentPage;
    
    private int pageSize;
    
    private int totalPages;
    
    private long total;
    
}
