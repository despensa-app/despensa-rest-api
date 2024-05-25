package dev.nmarulo.depensaapp.commons.handler;

import dev.nmarulo.depensaapp.commons.component.DataRequestScope;
import dev.nmarulo.depensaapp.configuration.AppProperties;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class PagingAndSortingRequestInterceptor implements HandlerInterceptor {
    
    private static final String SORT_ORDER_REGEX = "(([a-zA-Z0-9_]+)(,asc|,desc)?:?,?)+";
    
    private static final String DEFAULT_SORT_ORDER = "id,desc";
    
    private final DataRequestScope dataRequestScope;
    
    private final AppProperties appProperties;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var pageStr = request.getParameter("page");
        var sizeStr = request.getParameter("size");
        var sortStr = request.getParameter("sort");
        var pageNumber = 0;
        var pageSize = 0;
        
        if (HttpMethod.GET.matches(request.getMethod())) {
            if (StringUtils.isNumeric(pageStr)) {
                pageNumber = Math.max(Integer.parseInt(pageStr), 0);
            }
            
            if (StringUtils.isNumeric(sizeStr)) {
                pageSize = Integer.parseInt(sizeStr);
                pageSize = pageSize <= 0 ? this.appProperties.getPageableSize() : pageSize;
            } else {
                pageSize = this.appProperties.getPageableSize();
            }
            
            List<Sort.Order> sortList = getOrders(StringUtils.defaultIfBlank(sortStr, DEFAULT_SORT_ORDER));
            
            this.dataRequestScope.setPageable(PageRequest.of(pageNumber, pageSize, Sort.by(sortList)));
        }
        
        return true;
    }
    
    private List<Sort.Order> getOrders(String sortStr) {
        /*
         * k1ey_name,desc:name_user,asc
         * key_name2
         * ke2y_3name,asc
         * k3ey_name,desc:name_user,asc:key_3name,desc
         */
        if (StringUtils.isBlank(sortStr) || !RegExUtils.dotAllMatcher(SORT_ORDER_REGEX, sortStr)
                                                       .matches()) {
            return Collections.emptyList();
        }
        
        return Arrays.stream(StringUtils.split(sortStr, ":"))
                     .map(value -> StringUtils.split(value, ","))
                     .map(value -> {
                         var direction = ArrayUtils.get(value, 1, "");
                         
                         return new Sort.Order(getDirection(direction), value[0]);
                     })
                     .toList();
    }
    
    private static Sort.Direction getDirection(String value) {
        if (StringUtils.isBlank(value)) {
            return Sort.Direction.ASC;
        }
        
        try {
            return Sort.Direction.fromString(value);
        } catch (IllegalArgumentException e) {
            return Sort.Direction.ASC;
        }
    }
    
}
