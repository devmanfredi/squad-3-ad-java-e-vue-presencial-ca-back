package br.com.codenation.centralerros.services;

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

    public User login(String code, String password) throws MessageException {
        if (loginRepository.findByCodeAndPassword(code, password).isPresent()) {
            return loginRepository.findByCodeAndPassword(code, password).orElse(null);
        }

        throw new MessageException("Usuário ou senha inválidos.");
    }

    public List<Log> findAllLogs(Long companyId) {
        return null;
    }

}
