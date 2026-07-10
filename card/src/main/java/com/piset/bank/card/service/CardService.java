package com.piset.bank.card.service;

import com.piset.bank.card.domain.Card;

import java.util.List;

public interface CardService {

    Card save(Card card);
    List<Card> findAll();
    List<Card> getByCustomerId(Long customerId);
}
