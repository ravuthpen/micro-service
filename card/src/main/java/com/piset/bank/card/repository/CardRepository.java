package com.piset.bank.card.repository;

import com.piset.bank.card.domain.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends MongoRepository<Card, Long> {
    List<Card> findByCustomerId(Long customerId);
}
