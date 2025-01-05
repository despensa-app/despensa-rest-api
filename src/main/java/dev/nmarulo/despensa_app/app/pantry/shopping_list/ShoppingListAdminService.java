package dev.nmarulo.despensa_app.app.pantry.shopping_list;

import dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos.ShoppingListAdminReq;
import dev.nmarulo.despensa_app.app.pantry.shopping_list.dtos.ShoppingListAdminRes;
import dev.nmarulo.despensa_app.commons.service.CrudServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class ShoppingListAdminService extends CrudServiceImp<ShoppingListAdminReq, ShoppingListAdminRes, ShoppingList, Long> {
    
    private final ShoppingListRepository repository;
    
}
