package dev.nmarulo.depensaapp.app.users;

import dev.nmarulo.depensaapp.app.users.classes.FindByIdUserRes;
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
    
    @GetMapping("/{id}")
    public ResponseEntity<FindByIdUserRes> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.findById(id));
    }
    
}
