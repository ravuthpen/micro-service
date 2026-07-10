package com.piset.bank.card.mapper;

import com.piset.bank.card.domain.Card;
import com.piset.bank.card.dto.CardDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CardMapper {
    Card toCard(CardDTO dto);
    CardDTO toCardDTO(Card card);
}
