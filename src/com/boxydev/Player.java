package com.boxydev;

import com.boxydev.card.Card;
import com.boxydev.card.CardPackage;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int position;
    private List<Card> cards = new ArrayList<>();

    public Player(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public Player() {
        this("", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void distribute(CardPackage cards, List<Player> players) {
        List<Player> targets = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (i != this.getPosition()) {
                targets.add(players.get(i));
            }
        }
        for (Player target : targets) {
            System.out.println(target.getName());
            for (int i = 0; i < 8; i++) {
                target.cards.add(cards.getCards().get(i));
                cards.getCards().remove(i);
            }
        }
        System.out.println(this.getName());
        for (int i = 7; i >= 0; i--) {
            this.cards.add(cards.getCards().get(i));
            cards.getCards().remove(i);
        }
        for(Card card : cards.getCards()) {
            System.out.println(card.getCard());
        }
        for(Player player : targets) {
            System.out.println("Main de " + player.getName());
            for(Card card : player.cards) {
                System.out.println(card.getCard());
            }
        }
    }
}
