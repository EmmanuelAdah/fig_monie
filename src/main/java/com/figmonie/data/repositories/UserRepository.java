package com.figmonie.data.repositories;

import com.figmonie.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    Optional<User> findByAccount_AccountNumber(String accountAccountNumber);
    boolean existsByEmail(String email);
}
