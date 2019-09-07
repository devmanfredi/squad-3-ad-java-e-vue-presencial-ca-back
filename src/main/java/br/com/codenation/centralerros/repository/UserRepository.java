package br.com.codenation.centralerros.repository;

import br.com.codenation.centralerros.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findById(Long userId);

    Optional<Users> findByCode(String userCode);
}

