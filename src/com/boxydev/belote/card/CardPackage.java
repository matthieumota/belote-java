package com.boxydev.belote.card;

import com.boxydev.belote.Player;

import java.util.ArrayList;
import java.util.List;

public class CardPackage {
    private List<Card> newCards = new ArrayList<Card>();
    private List<Card> cards = new ArrayList<Card>(32);
    private static final Color COEUR = new Color("Coeur");
    private static final Color PIQUE = new Color("Pique");
    private static final Color TREFLE = new Color("Trefle");
    private static final Color CARREAU = new Color("Carreau");
    private static final Figure AS = new Figure("As", 11, 11, 8, 14);
    private static final Figure ROI = new Figure("Roi", 4, 4, 6, 12);
    private static final Figure DAME = new Figure("Dame", 3, 3, 5, 11);
    private static final Figure VALET = new Figure("Valet", 2, 20, 4, 16);
    private static final Figure DIX = new Figure("Dix", 10, 10, 7, 13);
    private static final Figure NEUF = new Figure("Neuf", 0, 14, 3, 15);
    private static final Figure HUIT = new Figure("Huit", 0, 0, 2, 10);
    private static final Figure SEPT = new Figure("Sept", 0, 0, 1, 9);

    public CardPackage() {
        newCards.add(new Card(COEUR, AS));
        newCards.add(new Card(COEUR, ROI));
        newCards.add(new Card(COEUR, DAME));
        newCards.add(new Card(COEUR, VALET));
        newCards.add(new Card(COEUR, DIX));
        newCards.add(new Card(COEUR, NEUF));
        newCards.add(new Card(COEUR, HUIT));
        newCards.add(new Card(COEUR, SEPT));
        newCards.add(new Card(PIQUE, AS));
        newCards.add(new Card(PIQUE, ROI));
        newCards.add(new Card(PIQUE, DAME));
        newCards.add(new Card(PIQUE, VALET));
        newCards.add(new Card(PIQUE, DIX));
        newCards.add(new Card(PIQUE, NEUF));
        newCards.add(new Card(PIQUE, HUIT));
        newCards.add(new Card(PIQUE, SEPT));
        newCards.add(new Card(TREFLE, AS));
        newCards.add(new Card(TREFLE, ROI));
        newCards.add(new Card(TREFLE, DAME));
        newCards.add(new Card(TREFLE, VALET));
        newCards.add(new Card(TREFLE, DIX));
        newCards.add(new Card(TREFLE, NEUF));
        newCards.add(new Card(TREFLE, HUIT));
        newCards.add(new Card(TREFLE, SEPT));
        newCards.add(new Card(CARREAU, AS));
        newCards.add(new Card(CARREAU, ROI));
        newCards.add(new Card(CARREAU, DAME));
        newCards.add(new Card(CARREAU, VALET));
        newCards.add(new Card(CARREAU, DIX));
        newCards.add(new Card(CARREAU, NEUF));
        newCards.add(new Card(CARREAU, HUIT));
        newCards.add(new Card(CARREAU, SEPT));
    }

    public void mixing() {
        int number;
        for (int i = 32; i > 0; i--) {
            number = (int) (Math.random() * i);
            cards.add(newCards.get(number));
            newCards.remove(number);
        }
    }

    public void cut() {
        int random = (int) (Math.random() * 31);
        cards.addAll(cards.subList(random, 32));
        cards.addAll(cards.subList(0, random));
        for (int i = 0; i < 31; i++) {
            cards.remove(0);
        }
    }

    public void distribute(Player player, int cardsNumber) {
        for (int i = 0; i < cardsNumber; i++) {
            player.getCards().add(cards.get(0));
            cards.remove(0);
        }
    }

    public Card display() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public List<Card> getCards() {
        return cards;
    }
}
