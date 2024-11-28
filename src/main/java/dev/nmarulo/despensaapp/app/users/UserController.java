package dev.nmarulo.despensaapp.app.users;

import dev.nmarulo.despensaapp.app.users.dtos.FindByIdUserRes;
import dev.nmarulo.despensaapp.commons.component.DataRequestScope;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "Endpoints for managing users")
public class UserController {
    
    private final UserService userService;
    
    private final DataRequestScope dataRequestScope;
    
    @GetMapping("/{id}")
    public ResponseEntity<FindByIdUserRes> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.findById(id, this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
}
