package com.boxydev.belote.gui;

import com.boxydev.belote.Player;
import com.boxydev.belote.card.Card;
import com.boxydev.belote.card.CardPackage;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Board extends JPanel {
    private ImageIcon background = new ImageIcon("src/com/boxydev/belote/images/playmat.jpg");
    public CardPackage cards;
    public List<Player> players;

    public Board addPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public Board addCards(CardPackage cards) {
        this.cards = cards;
        return this;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int width = getWidth();
        int height = getHeight();

        graphics.drawImage(background.getImage(), 0, 0, null);

        // Joueur
        graphics.setColor(Color.YELLOW);
        graphics.drawRect((width - 200) / 2, height - 202, 200, 200);

        int index = 0;
        for (Card card : players.get(0).getCards()) {
            System.out.println(card.getCard());
            graphics.drawImage(card.getCardImage(), index, 0, 80, 100, null);
            index += 40;
        }

        // Bot 1
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, (height - 200) / 2, 200, 200);

        index = 0;
        for (Card card : players.get(1).getCards()) {
            System.out.println(card.getCard());
            graphics.drawImage(card.getCardImage(), index, 110, 80, 100, null);
            index += 40;
        }

        // Bot 2
        graphics.setColor(Color.RED);
        graphics.drawRect((width - 200) / 2, 0, 200, 200);

        index = 0;
        for (Card card : players.get(2).getCards()) {
            System.out.println(card.getCard());
            graphics.drawImage(card.getCardImage(), index, 220, 80, 100, null);
            index += 40;
        }

        // Bot 3
        graphics.setColor(Color.PINK);
        graphics.drawRect(width - 202, (height - 200) / 2, 200, 200);

        index = 0;
        for (Card card : players.get(3).getCards()) {
            System.out.println(card.getCard());
            graphics.drawImage(card.getCardImage(), index, 330, 80, 100, null);
            index += 40;
        }

    }
}
