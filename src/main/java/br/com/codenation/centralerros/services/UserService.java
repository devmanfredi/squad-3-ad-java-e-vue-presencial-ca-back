package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.mapper.UserMapper;
import br.com.codenation.centralerros.repository.UserRepository;
import br.com.codenation.centralerros.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserMapper userMapper;

    @Override
    public User findUserByCode(String userCode) {
        return userRepository.findByCode(userCode).orElse(null);
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public UserDTO save(UserDTO user) throws MessageException {
        if (userRepository.findByCode(user.getCode()).isPresent()) {
            throw new MessageException("Código de Usuário já utilizado!");
        }
        if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            throw new MessageException("Campos incompletos!");
        }

        return userMapper.toDto(userRepository.saveAndFlush(userMapper.map(user)));
    }

    public void delete(Long userId) throws MessageException {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
        }
        throw new MessageException("Usuário não encontrado!");
    }

    public List<User> findAll() {
        if (userRepository.findAll().isEmpty()) {
            return Collections.emptyList();
        }
        return userRepository.findAll();
    }

    public String validateCode(String userCodeDTO) {
        User userValidate = userRepository.findByCode(userCodeDTO).orElse(null);
        if (userValidate != null) {
            return "Código já existente!";
        }
        return "Code apto para cadastro!";
    }

    public User saveConfig(User user) {//temporário
        return userRepository.save(user);
    }
}
