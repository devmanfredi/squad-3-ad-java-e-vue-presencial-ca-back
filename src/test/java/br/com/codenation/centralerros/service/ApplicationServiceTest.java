package br.com.codenation.centralerros.service;

import br.com.codenation.centralerros.entity.Application;
import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.ApplicationRepository;
import br.com.codenation.centralerros.services.ApplicationService;
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
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @MockBean
    private ApplicationRepository applicationRepository;

    @Test
    public void deveSalvarUmaApplication() throws MessageException {
        Application app = buildApplication(null);
        Mockito.when(applicationRepository.save(app)).thenReturn(buildApplication(10L));
        Application result = applicationService.save(app);
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarApplicationPeloId() {
        Application app = buildApplication(null);
        Mockito.when(applicationRepository.findById(app.getId())).thenReturn(Optional.of(buildApplication(10L)));
        Application result = applicationService.findById(app.getId()).orElse(null);
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarUmaLista() throws MessageException {
        List<Application> applications = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            applications.add(buildApplication(null));
        }
        Mockito.when(applicationRepository.findAll()).thenReturn(applications);
        List<Application> result = applicationService.findAll();
        Assert.assertThat(result, Matchers.equalTo(applications));
    }

    private Application buildApplication(Long id) {
        return Application.builder()
                .id(id)
                .appName("Amazon Cloud")
                .company(Company.builder().id(1L).build())
                .user(null)
                .log(null)
                .build();
    }


}
