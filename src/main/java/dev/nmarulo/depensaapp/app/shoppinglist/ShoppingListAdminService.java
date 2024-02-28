package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.shoppinglist.classes.ShoppingListAdminReq;
import dev.nmarulo.depensaapp.app.shoppinglist.classes.ShoppingListAdminRes;
import dev.nmarulo.depensaapp.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class ShoppingListAdminService extends CrudServiceImp<ShoppingListAdminReq, ShoppingListAdminRes, ShoppingList, Integer> {
    
    private final ShoppingListRepository repository;
    
}
