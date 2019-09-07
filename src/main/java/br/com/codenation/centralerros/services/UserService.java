package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.Users;
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

    public Users save (Users user){
        return userRepository.save(user);
    }

    public List<Users> findAll(){
        return userRepository.findAll();
    }

    public Optional<Users> findById(Long userId){
        return userRepository.findById(userId);
    }



}
