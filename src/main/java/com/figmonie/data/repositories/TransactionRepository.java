package com.figmonie.data.repositories;

import com.figmonie.data.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
