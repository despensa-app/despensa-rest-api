package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.shoppinglist.dtos.ShoppingListAdminReq;
import dev.nmarulo.depensaapp.app.shoppinglist.dtos.ShoppingListAdminRes;
import dev.nmarulo.depensaapp.commons.controller.CrudController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/shopping-lists")
@RequiredArgsConstructor
@Getter
public class ShoppingListAdminController extends CrudController<ShoppingListAdminReq, ShoppingListAdminRes, Integer> {
    
    private final ShoppingListAdminService service;
    
}
