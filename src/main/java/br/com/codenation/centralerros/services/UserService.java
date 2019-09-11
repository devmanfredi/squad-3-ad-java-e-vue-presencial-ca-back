package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.repository.UserRepository;
import br.com.codenation.centralerros.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUserByCode(String userCode){
        return userRepository.findByCode(userCode).orElse(null);
    }


    public Optional<User> findById(Long userId){
        return userRepository.findById(userId);
    }



}
