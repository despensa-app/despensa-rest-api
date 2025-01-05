package dev.nmarulo.despensaapp.app.pantry.shopping_list;

import dev.nmarulo.despensaapp.app.pantry.shopping_list.dtos.ShoppingListAdminReq;
import dev.nmarulo.despensaapp.app.pantry.shopping_list.dtos.ShoppingListAdminRes;
import dev.nmarulo.despensaapp.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class ShoppingListAdminService extends CrudServiceImp<ShoppingListAdminReq, ShoppingListAdminRes, ShoppingList, Long> {
    
    private final ShoppingListRepository repository;
    
}
