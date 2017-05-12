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
        System.out.println(this.getName());
        List<Player> targets = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (i != this.getPosition()) {
                targets.add(players.get(i));
            }
        }
        for (Player target : targets) {
            System.out.println(target.getName());
        }
    }
}
