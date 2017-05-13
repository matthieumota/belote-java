package com.boxydev.belote.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardPackage {
    private List<Card> cards = new ArrayList<>();
    private int cardNumber = 32;

    public CardPackage() {
        generateCardPackage(cardNumber);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void generateCardPackage(int card_number) {
        // c t p c
        // a r d v 10 9 8 7 6 5 4 3 2
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < card_number / 4; j++) {
                Card card = new Card(i, j);
                cards.add(card);
            }
        }
    }

    public void mixing() {
        Collections.shuffle(cards);
    }
}
