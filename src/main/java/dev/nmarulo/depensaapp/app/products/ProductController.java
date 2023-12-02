package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.products.classes.ProductReq;
import dev.nmarulo.depensaapp.app.products.classes.ProductRes;
import dev.nmarulo.depensaapp.commons.controller.CrudController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Getter
public class ProductController extends CrudController<ProductReq, ProductRes, Integer> {
    
    private final ProductService service;
    
}
