package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractService<CompanyRepository, Company, Long> {

    @Autowired
    public CompanyService(CompanyRepository repository) {
        super(repository);
    }

    public Company save(Company company) throws MessageException {
        if (repository.findById(company.getId()).isPresent()){
            throw new MessageException("Companhia já cadastrada.");
        }
        return repository.save(company);
    }
}
