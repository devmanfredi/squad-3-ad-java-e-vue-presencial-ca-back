package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.repository.UserRepository;
import br.com.codenation.centralerros.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends AbstractService<UserRepository,User,Long> {

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }

    public User findUserByCode(String userCode){
        return this.repository.findByCode(userCode).orElse(null);
    }

    public Optional<User> findById(Long userId){
        return this.repository.findById(userId);
    }

    public Boolean verifyId(Long id){
        return this.repository.existsById(id);
    }

}
