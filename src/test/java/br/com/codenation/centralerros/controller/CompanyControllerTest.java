package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.dto.entitty.CompanyDTO;
import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.CompanyRepository;
import br.com.codenation.centralerros.services.CompanyService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyControllerTest {

    @Autowired
    private CompanyController companyController;

    @MockBean
    private CompanyService companyService;

    @MockBean
    private CompanyRepository companyRepository;

    @Test
    public void deveSalvarUmaCompanhiaDto() throws MessageException {
        Company company = buildCompany(null);
        Mockito.when(companyController.save(company)).thenReturn(buildCompanyDTO(10L));
        CompanyDTO result = companyController.save(company);
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarCompanhiaPeloId() throws MessageException {
        CompanyDTO company = buildCompanyDTO(null);
        Mockito.when(companyController.findById(company.getId())).thenReturn(buildCompany(10L));
        Company result = companyController.findById(company.getId());
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarUmaListaDeCompanhias() throws MessageException {
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            companies.add(buildCompany(null));
        }
        Mockito.when(companyController.findAll()).thenReturn(companies);
        List<Company> result = companyController.findAll();
        Assert.assertThat(result, Matchers.equalTo(companies));
    }

    //@Test
    //public void deveDeletarCompanhiaPeloId(){
    //    Company company = buildCompany(null);
    //    Mockito.when(companyController.delete(1L)).thenReturn(company).the‌​nReturn(null);
    //}

    private CompanyDTO buildCompanyDTO(Long id) {
        return CompanyDTO.builder()
                .id(id)
                .code("contaAzul")
                .name("Conta Azul SA")
                .build();
    }

    private Company buildCompany(Long id) {
        return Company.builder()
                .id(id)
                .code("contaAzul")
                .name("Conta Azul SA")
                .application(null)
                .build();
    }

}
