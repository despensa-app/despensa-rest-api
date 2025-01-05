package dev.nmarulo.despensa_app.app.pantry.products;

import dev.nmarulo.despensa_app.app.pantry.products.dtos.ProductAdminReq;
import dev.nmarulo.despensa_app.app.pantry.products.dtos.ProductAdminRes;
import dev.nmarulo.despensa_app.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class ProductAdminService extends CrudServiceImp<ProductAdminReq, ProductAdminRes, Product, Long> {
    
    private final ProductRepository repository;
    
}
