package dev.nmarulo.despensaapp.app.pantry.shopping_list;

import dev.nmarulo.despensaapp.app.pantry.shopping_list.dtos.ShoppingListAdminReq;
import dev.nmarulo.despensaapp.app.pantry.shopping_list.dtos.ShoppingListAdminRes;
import dev.nmarulo.despensaapp.commons.controller.CrudController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/shopping-lists")
@RequiredArgsConstructor
@Getter
@Tag(name = "Shopping List Admin", description = "Endpoints for managing shopping lists")
public class ShoppingListAdminController extends CrudController<ShoppingListAdminReq, ShoppingListAdminRes, Long> {
    
    private final ShoppingListAdminService service;
    
}
