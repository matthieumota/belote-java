package com.boxydev.belote.card;

import java.util.ArrayList;
import java.util.List;

public class CardPackage {
    private List<Card> cardPackage = new ArrayList<Card>();
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
        cardPackage.add(new Card(COEUR, AS));
        cardPackage.add(new Card(COEUR, ROI));
        cardPackage.add(new Card(COEUR, DAME));
        cardPackage.add(new Card(COEUR, VALET));
        cardPackage.add(new Card(COEUR, DIX));
        cardPackage.add(new Card(COEUR, NEUF));
        cardPackage.add(new Card(COEUR, HUIT));
        cardPackage.add(new Card(COEUR, SEPT));
        cardPackage.add(new Card(PIQUE, AS));
        cardPackage.add(new Card(PIQUE, ROI));
        cardPackage.add(new Card(PIQUE, DAME));
        cardPackage.add(new Card(PIQUE, VALET));
        cardPackage.add(new Card(PIQUE, DIX));
        cardPackage.add(new Card(PIQUE, NEUF));
        cardPackage.add(new Card(PIQUE, HUIT));
        cardPackage.add(new Card(PIQUE, SEPT));
        cardPackage.add(new Card(TREFLE, AS));
        cardPackage.add(new Card(TREFLE, ROI));
        cardPackage.add(new Card(TREFLE, DAME));
        cardPackage.add(new Card(TREFLE, VALET));
        cardPackage.add(new Card(TREFLE, DIX));
        cardPackage.add(new Card(TREFLE, NEUF));
        cardPackage.add(new Card(TREFLE, HUIT));
        cardPackage.add(new Card(TREFLE, SEPT));
        cardPackage.add(new Card(CARREAU, AS));
        cardPackage.add(new Card(CARREAU, ROI));
        cardPackage.add(new Card(CARREAU, DAME));
        cardPackage.add(new Card(CARREAU, VALET));
        cardPackage.add(new Card(CARREAU, DIX));
        cardPackage.add(new Card(CARREAU, NEUF));
        cardPackage.add(new Card(CARREAU, HUIT));
        cardPackage.add(new Card(CARREAU, SEPT));
    }

    public void mixing() {
        int number;
        for (int i = 32; i > 0; i--) {
            number = (int) (Math.random() * i);
            cards.add(cardPackage.get(number));
            cardPackage.remove(number);
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

    public List<Card> getCards() {
        return cards;
    }
}
