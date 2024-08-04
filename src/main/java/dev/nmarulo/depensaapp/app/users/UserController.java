package dev.nmarulo.depensaapp.app.users;

import dev.nmarulo.depensaapp.app.users.dtos.FindByIdUserRes;
import dev.nmarulo.depensaapp.commons.component.DataRequestScope;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Getter
public class UserController {
    
    private final UserService service;
    
    private final DataRequestScope dataRequestScope;
    
    @GetMapping("/{id}")
    public ResponseEntity<FindByIdUserRes> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.findById(id, this.dataRequestScope.getAuthenticationPrincipal()));
    }
    
}
