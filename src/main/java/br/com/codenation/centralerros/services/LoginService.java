package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.Log;
import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.LoginRepository;
import br.com.codenation.centralerros.service.interfaces.LoginServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoginService implements LoginServiceInterface {

    private LoginRepository loginRepository;

    public User login(UserDTO user) throws MessageException {
        if (loginRepository.findByCodeAndPassword(user.getCode(), user.getPassword()).isPresent()) {
            return loginRepository.findByCodeAndPassword(user.getCode(), user.getPassword()).orElse(null);
        }

        throw new MessageException("Usuário ou senha inválidos.");
    }

    public List<Log> findAllLogs(Long companyId) {
        return null;
    }

}
