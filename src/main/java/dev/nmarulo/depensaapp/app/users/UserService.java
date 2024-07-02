package dev.nmarulo.depensaapp.app.users;

import dev.nmarulo.depensaapp.app.users.classes.FindByIdUserRes;
import dev.nmarulo.depensaapp.commons.exception.NotFoundException;
import dev.nmarulo.depensaapp.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class UserService extends BasicServiceImp {
    
    private final UserRepository userRepository;
    
    public FindByIdUserRes findById(Integer id) {
        var findById = this.userRepository.findById(id);
        
        if (findById.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        var response = new FindByIdUserRes();
        var user = findById.get();
        
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        
        return response;
    }
    
}
