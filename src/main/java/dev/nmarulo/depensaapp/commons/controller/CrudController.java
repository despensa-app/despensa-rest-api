package dev.nmarulo.depensaapp.commons.controller;

import dev.nmarulo.depensaapp.commons.component.LocalMessage;
import dev.nmarulo.depensaapp.commons.exception.InternalServerErrorException;
import dev.nmarulo.depensaapp.commons.service.CrudService;
import dev.nmarulo.depensaapp.configuration.AppProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Field;
import java.net.URI;

@Getter(value = AccessLevel.PROTECTED)
public abstract class CrudController<I, O, ID> {
    
    @Autowired
    private AppProperties appProperties;
    
    @Autowired
    private LocalMessage localMessage;
    
    public abstract CrudService<I, O, ID> getService();
    
    @GetMapping
    public ResponseEntity<?> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(getService().findAll(pageable));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable ID id) {
        O byId = getService().findById(id);
        
        if (byId == null) {
            return ResponseEntity.notFound()
                                 .build();
        }
        
        return ResponseEntity.ok(byId);
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody I request,
                                  UriComponentsBuilder uriComponentsBuilder,
                                  HttpServletRequest httpServletRequest) {
        O save = getService().save(request);
        Object valueId = getValueId(save);
        URI uri = uriComponentsBuilder.path(httpServletRequest.getServletPath())
                                      .pathSegment("{id}")
                                      .buildAndExpand(valueId)
                                      .toUri();
        
        return ResponseEntity.created(uri)
                             .body(save);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody I request) {
        return ResponseEntity.ok(getService().update(id, request));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ID id) {
        getService().delete(id);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    private Object getValueId(O response) {
        Field field = ReflectionUtils.findField(response.getClass(), "id");
        Object fieldId;
        
        if (field == null) {
            throw new InternalServerErrorException(this.localMessage.getMessage("error.class-does-not-have-property",
                                                                                "ID"));
        }
        
        try {
            ReflectionUtils.makeAccessible(field);
            fieldId = ReflectionUtils.getField(field, response);
        } catch (Exception ex) {
            throw new InternalServerErrorException(this.localMessage.getMessage("error.obtaining-value-property",
                                                                                "ID"));
        }
        
        return fieldId;
    }
    
}
