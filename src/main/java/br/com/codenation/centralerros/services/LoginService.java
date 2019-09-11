package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends AbstractService<UserRepository, User, Long> {

    @Autowired
    public LoginService(UserRepository repository) {
        super(repository);
    }

    public User login(Long id) throws MessageException {

        if (repository.findById(id).isPresent()) {
            return repository.findById(id).orElse(null);
        }

        throw new MessageException("Usuário não encontrado.");
    }
}
