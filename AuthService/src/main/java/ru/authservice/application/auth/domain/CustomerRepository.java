package ru.authservice.application.auth.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByLogin(String login);

    Optional<Customer> getCustomerByLogin(String login);
}
