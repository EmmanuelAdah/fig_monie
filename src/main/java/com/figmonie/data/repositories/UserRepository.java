package com.figmonie.data.repositories;

import com.figmonie.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    Optional<User> findByAccount_AccountNumber(String accountAccountNumber);
    boolean existsByEmail(String email);
}
