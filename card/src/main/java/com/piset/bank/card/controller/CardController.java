package com.piset.bank.card.controller;


import com.piset.bank.card.domain.Card;
import com.piset.bank.card.dto.CardDTO;
import com.piset.bank.card.mapper.CardMapper;
import com.piset.bank.card.service.CardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/cards")
@AllArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    @PostMapping
    public ResponseEntity<?> createCard(@RequestBody CardDTO dto){

        Card card = cardMapper.toCard(dto);
        card = cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(card);
    }

    @GetMapping
    public ResponseEntity<?> findCard(){
        List<Card> cards = cardService.findAll();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("{customerId}")
    public ResponseEntity<List<Card>> getByCustomerId(
            @RequestHeader("pisethbank-correlation-id") String correlationId,
            @PathVariable Long customerId){

        //log.debug("Correlation id found: {}", correlationId);
        log.debug("fetch card detail method start");
        List<Card> cards = cardService.getByCustomerId(customerId);
        log.debug("fetch card detail method end");

        return ResponseEntity.ok(cards);
    }
}
