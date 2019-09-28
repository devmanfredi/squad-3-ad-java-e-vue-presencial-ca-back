package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.dto.entitty.CompanyDTO;
import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @PostMapping
    public CompanyDTO save(@RequestBody Company company) throws MessageException {
        return companyService.save(company);
    }

    @GetMapping("/{companyId}")
    public Company findById(@PathVariable Long companyId) throws MessageException {
        return companyService.finById(companyId);
    }

    @GetMapping
    public List<Company> findAll(){
        if (companyService.findAll().isEmpty()) {
            return Collections.emptyList();
        }
        return companyService.findAll();
    }

    @PutMapping
    public Company edit (Company company){
        return null;
    }

    @DeleteMapping
    public void delete(Long companyId){
        companyService.delete(companyId);
    }
}
