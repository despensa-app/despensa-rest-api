package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.shoppinglist.classes.ShoppingListReq;
import dev.nmarulo.depensaapp.app.shoppinglist.classes.ShoppingListRes;
import dev.nmarulo.depensaapp.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class ShoppingListService extends CrudServiceImp<ShoppingListReq, ShoppingListRes, ShoppingList, Integer> {
    
    private final ShoppingListRepository repository;
    
}
