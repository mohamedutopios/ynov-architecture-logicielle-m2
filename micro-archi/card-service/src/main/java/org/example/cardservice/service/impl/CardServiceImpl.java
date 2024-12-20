package org.example.cardservice.service.impl;

import org.example.cardservice.entity.Card;
import org.example.cardservice.kafka.CardKafkaConsumer;
import org.example.cardservice.repository.CardRepository;
import org.example.cardservice.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.cardservice.rest.AccountServiceClient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private static final Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AccountServiceClient accountServiceClient;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
    }

    public List<Card> getCardsByAccountId(Long accountId) {
        return cardRepository.findByAccountId(accountId);
    }

    public Card saveCard(Card card) {
        if (accountServiceClient.accountExists(card.getAccountId())) {
            return cardRepository.save(card);
        } else {
            throw new IllegalArgumentException("Account does not exist");
        }
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCardByAccountId(Long id) {
        logger.info("Deleting card in service impl : " + id);
        cardRepository.deleteCardByAccountId(id);
    }
}
