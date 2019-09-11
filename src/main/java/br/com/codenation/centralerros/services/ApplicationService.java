package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.Application;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService extends AbstractService<ApplicationRepository, Application, Long>{

    @Autowired
    public ApplicationService(ApplicationRepository repository) {
        super(repository);
    }

    public Application save (Application application) throws MessageException {
        if(repository.findById(application.getId()).isPresent()){
            throw new MessageException("Aplicação já cadastrada.");
        }
        return repository.save(application);
    }
}
