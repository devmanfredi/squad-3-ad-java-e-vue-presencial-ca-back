package br.com.codenation.centralerros.repository;

import br.com.codenation.centralerros.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findApplicationsByCompanyIdAndUserId(Long companyId, Long userId);

}
