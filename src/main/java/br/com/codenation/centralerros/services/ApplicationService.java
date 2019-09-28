package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.Application;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.ApplicationRepository;
import br.com.codenation.centralerros.service.interfaces.ApplicationServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationService implements ApplicationServiceInterface {

    private ApplicationRepository applicationRepository;

    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public Optional<Application> findById(Long appId) {
        return applicationRepository.findById(appId);
    }

    public List<Application> findAll() throws MessageException {
        if (applicationRepository.findAll().isEmpty()) {
            throw new MessageException("Nenhuma Aplicação encontrada!");
        }
        return applicationRepository.findAll();
    }

    public void delete(Long appId) throws MessageException {
        if (applicationRepository.findById(appId).isPresent()) {
            applicationRepository.deleteById(appId);
        }
        throw new MessageException("Aplicação não encontrada!");
    }

    public List<Application> findAllApplicationsLogin(Long companyId, Long userId) {
        return applicationRepository.findApplicationsByCompanyIdAndUserId(companyId, userId);
    }


}
