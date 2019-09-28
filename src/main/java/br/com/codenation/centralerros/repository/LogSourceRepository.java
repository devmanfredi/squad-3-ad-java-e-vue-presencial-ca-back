package br.com.codenation.centralerros.repository;

import br.com.codenation.centralerros.entity.LogSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogSourceRepository extends JpaRepository<LogSource, Long> {
}
