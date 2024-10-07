package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.products.dtos.ProductAdminReq;
import dev.nmarulo.depensaapp.app.products.dtos.ProductAdminRes;
import dev.nmarulo.depensaapp.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class ProductAdminService extends CrudServiceImp<ProductAdminReq, ProductAdminRes, Product, Long> {
    
    private final ProductRepository repository;
    
}
