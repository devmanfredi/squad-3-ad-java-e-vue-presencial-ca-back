package br.com.codenation.centralerros.repository;

import br.com.codenation.centralerros.entity.LevelLog;
import br.com.codenation.centralerros.entity.Log;
import br.com.codenation.centralerros.entity.ServerOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    List<Log> findAllByServerOriginAndToFileFalse(ServerOrigin origin);

    List<Log> findByServerOriginAndToFileFalse(ServerOrigin origin);

    List<Log> findByLevelLogAndToFileFalse(LevelLog level);

    List<Log> findAllByToFileFalseOrderByLevelLogDesc();

    List<Log> findAllByServerOriginAndToFileFalseOrderByLevelLogDesc(ServerOrigin origin);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Log a SET a.toFile = true WHERE a.id =:id")
    void toFile(@Param("id") Long id);

    void deleteById(Long id);

    @Query(value = "select * from log as lo\n" +
            "join application as ap on ap.id = lo.application_id\n" +
            "join company as co on co.id = ap.company_id\n" +
            "join users as us on us.company_id = :companyId\n" +
            "where lo.user_id = :userId", nativeQuery = true)
    List<Log> findLogsByApplicationAndCompanyAndUser(@Param("companyId") Long companyId, @Param("userId") Long userId);
}
