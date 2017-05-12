package com.boxydev;

import com.boxydev.card.CardPackage;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int position;

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
        System.out.print(this.getPosition());
        List<Player> targets = new ArrayList<>();
        switch (this.getPosition()) {
            case 0:
                targets.add(players.get(1));
                targets.add(players.get(2));
                targets.add(players.get(3));
            break;
            case 1:
                targets.add(players.get(0));
                targets.add(players.get(2));
                targets.add(players.get(3));
            break;
            case 2:
                targets.add(players.get(0));
                targets.add(players.get(1));
                targets.add(players.get(3));
            break;
            case 3:
                targets.add(players.get(0));
                targets.add(players.get(1));
                targets.add(players.get(2));
            break;
        }
        System.out.println(targets);
    }
}
