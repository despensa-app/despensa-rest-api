package dev.nmarulo.despensa_app.commons.controller;

import dev.nmarulo.despensa_app.commons.annotation.PageableParameters;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface CrudApi<I, O, ID> {
    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PageableParameters()
    ResponseEntity<?> findAll(@Parameter(hidden = true) Pageable pageable);
    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
    })
    ResponseEntity<?> findById(@Parameter(required = true) ID id);
    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
    })
    ResponseEntity<?> save(I request, UriComponentsBuilder uriComponentsBuilder, HttpServletRequest httpServletRequest);
    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
    })
    ResponseEntity<?> update(@Parameter(required = true) ID id, I request);
    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204"),
    })
    ResponseEntity<?> delete(@Parameter(required = true) ID id);
    
}
