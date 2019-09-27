package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.dto.entitty.CompanyDTO;
import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.mapper.CompanyMapper;
import br.com.codenation.centralerros.repository.CompanyRepository;
import br.com.codenation.centralerros.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements CompanyServiceInterface {

    @Autowired
    private CompanyRepository companyRepository;

    private CompanyMapper companyMapper;


    public CompanyDTO save(CompanyDTO company) throws MessageException {
        if (companyRepository.findById(company.getId()).isPresent()) {
            throw new MessageException("Companhia já cadastrada.");
        }
        return companyMapper.toDto(companyRepository.saveAndFlush(companyMapper.map(company)));
    }

    public Company finById(Long companyId) throws MessageException {
        if (companyRepository.findById(companyId).isPresent()) {
            return companyRepository.findById(companyId).orElse(null);
        }
        throw new MessageException("Companhia não encontrada!");
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public void delete(Long companyId) {
        companyRepository.deleteById(companyId);
    }

}
