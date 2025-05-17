package dev.nmarulo.despensa_app.commons.annotation;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Basado en {@link org.springdoc.core.converters.models.PageableAsQueryParam}
 * <p>
 * Es importante recordar usar la anotación {@code @Parameter(hidden = true)} en el parámetro Pageable del método
 * para evitar la documentación duplicada de los parámetros de paginación.
 */
@Parameter(in = ParameterIn.QUERY, name = "page", schema = @Schema(type = "integer", minimum = "0", defaultValue = "0"))
@Parameter(in = ParameterIn.QUERY,
           name = "size",
           description = "Page size",
           schema = @Schema(type = "integer", minimum = "1", defaultValue = "10"))
@Parameter(in = ParameterIn.QUERY,
           name = "sort",
           description = "Sorting criteria in the format: property,(asc|desc).",
           array = @ArraySchema(schema = @Schema(type = "string", defaultValue = "id,asc")))
@Target({
    ElementType.METHOD,
    ElementType.ANNOTATION_TYPE
})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface PageableParameters {}
