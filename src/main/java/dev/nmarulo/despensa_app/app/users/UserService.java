package dev.nmarulo.despensa_app.app.users;

import dev.nmarulo.despensa_app.app.users.dtos.FindByIdUserRes;
import dev.nmarulo.despensa_app.commons.exception.NotFoundException;
import dev.nmarulo.despensa_app.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Getter
public class UserService extends BasicServiceImp {
    
    private final UserRepository userRepository;
    
    @Transactional(readOnly = true)
    public FindByIdUserRes findById(Long id, User userToken) {
        var userId = id;
        
        if (!Objects.equals(userToken.getId(), id)) {
            userId = userToken.getId();
        }
        
        var findById = this.userRepository.findById(userId);
        
        if (findById.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        return UserMapper.toFindByIdUserRes(findById.get());
    }
    
}
