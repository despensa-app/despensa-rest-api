package dev.nmarulo.despensaapp.app.pantry.products;

import dev.nmarulo.despensaapp.app.pantry.products.dtos.ProductAdminReq;
import dev.nmarulo.despensaapp.app.pantry.products.dtos.ProductAdminRes;
import dev.nmarulo.despensaapp.commons.controller.CrudController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/products")
@RequiredArgsConstructor
@Getter
@Tag(name = "Product Admin", description = "Endpoints for managing products")
public class ProductAdminController extends CrudController<ProductAdminReq, ProductAdminRes, Long> {
    
    private final ProductAdminService service;
    
}
