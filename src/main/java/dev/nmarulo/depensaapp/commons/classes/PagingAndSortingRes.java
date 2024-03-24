package dev.nmarulo.depensaapp.commons.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PagingAndSortingRes<R> extends ContentRes<R> {
    
    @JsonProperty("currentPage")
    private int number;
    
    @JsonProperty("pageSize")
    private int numberOfElements;
    
    @JsonProperty("totalPages")
    private int totalPages;
    
    @JsonProperty("total")
    private long totalElements;
    
}
