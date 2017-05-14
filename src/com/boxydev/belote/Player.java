package com.boxydev.belote;

import com.boxydev.belote.card.Card;
import com.boxydev.belote.card.CardPackage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    protected String name;
    protected int position;
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

    public void askName() {
        while (name == null || name.isEmpty()) {
            name = JOptionPane.showInputDialog("Quel est ton nom ?");
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void distribute(CardPackage cards, List<Player> players) {
        List<Player> targets = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (i != this.getPosition()) {
                targets.add(players.get(i));
            }
        }
        for (Player target : targets) {
            for (int i = 0; i < 8; i++) {
                target.cards.add(cards.getCards().get(i));
                cards.getCards().remove(i);
            }
        }
        for (int i = 7; i >= 0; i--) {
            this.cards.add(cards.getCards().get(i));
            cards.getCards().remove(i);
        }
    }
}
