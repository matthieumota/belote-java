package com.boxydev.belote;

import com.boxydev.belote.card.Card;

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

    public boolean firstRound(int indexPlayer, Card displayCard) {
        int response = 1;
        int points = 0;

        switch (indexPlayer) {
            case 0 :
                response = JOptionPane.showConfirmDialog(null, "Vous prenez ?", "Choix atout - Premier tour", JOptionPane.YES_NO_OPTION);
            break;
            default :
                for (int i = 0; i < 5; i++) {
                    String trump = displayCard.getColor().getName();
                    if (trump == cards.get(i).getColor().getName()) {
                        points += cards.get(i).getFigure().getPointTrump();
                    } else {
                        points += cards.get(i).getFigure().getPoint();
                    }
                }
                if (points > 400) {
                    response = 0;
                }
            break;
        }

        if (response == 0) {
            return true;
        }

        return false;
    }

    public Integer secondRound(int indexPlayer, Card displayCard) {
        int response = 4;

        switch (indexPlayer) {
            case 0 :
                String[] trumps = {"Coeur", "Pique", "Trefle", "Carreau", "2"};
                response = JOptionPane.showOptionDialog(null, "Que prenez-vous ?", "Choix atout - Second tour", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, trumps, "1");
            break;
        }



        return response;
    }
}
