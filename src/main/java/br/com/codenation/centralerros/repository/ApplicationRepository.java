package br.com.codenation.centralerros.repository;

import br.com.codenation.centralerros.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    //@Query(" select ap from Applications ap " +
    //        " join ap.id.company co " +
    //        " join co.users us " +
    //        " where us.id = :userId and co.id = :companyId ")
    //List<Application> findApplicationsByCompanyIdAndUserId(@Param("companyId") Long companyId, @Param("userId") Long userId);
    List<Application> findApplicationsByCompanyIdAndUserId(Long companyId, Long userId);
}
