package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.products.classes.IndexProductRes;
import dev.nmarulo.depensaapp.app.products.classes.ProductReq;
import dev.nmarulo.depensaapp.app.products.classes.ProductRes;
import dev.nmarulo.depensaapp.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class ProductService extends CrudServiceImp<ProductReq, ProductRes, Product, Integer> {
    
    private final ProductRepository repository;
    
    public IndexProductRes index(Integer excludeShoppingListId) {
        var response = new IndexProductRes();
        //Obtener todos los productos que no estén en la lista de compra actual.
        var pageFindAll = this.repository.findAllByIdNotInShoppingList(excludeShoppingListId, getDataRequestScope().getPageable());
        
        var products = pageFindAll.stream()
                                  .map(this::mapperTo)
                                  .toList();
        
        response.setContent(products);
        response.setCurrentPage(pageFindAll.getNumber());
        response.setPageSize(pageFindAll.getNumberOfElements());
        response.setTotalPages(pageFindAll.getTotalPages());
        response.setTotal(pageFindAll.getTotalElements());
        
        return response;
    }
    
    private IndexProductRes.Product mapperTo(Product product) {
        var response = new IndexProductRes.Product();
        
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        
        return response;
    }
    
}
