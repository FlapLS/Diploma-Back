package ru.authservice.application.auth.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    void deleteByToken(String token);

    Optional<Token> getByToken(String token);

    Optional<Token> getByCustomer(Customer customer);

    boolean existsByToken(String token);
}
