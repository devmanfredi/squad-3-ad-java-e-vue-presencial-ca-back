package br.com.codenation.centralerros.repository;

import br.com.codenation.centralerros.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCode(String userCode);
}

