package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.products.dtos.ProductAdminReq;
import dev.nmarulo.depensaapp.app.products.dtos.ProductAdminRes;
import dev.nmarulo.depensaapp.commons.controller.CrudController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/products")
@RequiredArgsConstructor
@Getter
public class ProductAdminController extends CrudController<ProductAdminReq, ProductAdminRes, Integer> {
    
    private final ProductAdminService service;
    
}
