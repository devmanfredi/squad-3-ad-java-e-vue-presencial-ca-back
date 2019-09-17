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
}
