package com.boxydev.belote.gui;

import com.boxydev.belote.Player;
import com.boxydev.belote.card.Card;
import com.boxydev.belote.card.CardPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Board extends JPanel implements ActionListener {
    private ImageIcon background = new ImageIcon("src/com/boxydev/belote/images/playmat.jpg");
    private static final Integer CARD_WIDTH = 160;
    private static final Integer CARD_HEIGHT = 200;
    private static final Integer CARD_SPACE = CARD_WIDTH / 2;
    private static final Integer CARD_SPACE_BOT = CARD_SPACE / 2;
    public List<Player> players;
    public Card cardPlaying = null;
    private Card displayCard = null;
    public Integer numberCardPlayer = 0;

    public Board() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX() - (getWidth() - CARD_SPACE * (numberCardPlayer + 1)) / 2;
                int y = e.getY() - (getHeight() - (CARD_HEIGHT + 20));
                if (x >= 0 && x <= (CARD_SPACE * (numberCardPlayer + 1)) && y >= 0 && y <= CARD_HEIGHT) {
                    int cardNumber = (numberCardPlayer == x / CARD_SPACE) ? numberCardPlayer - 1 : x / CARD_SPACE;
                    cardPlaying = players.get(0).getCards().get(cardNumber);
                    players.get(0).getCards().remove(cardNumber);
                    numberCardPlayer = players.get(0).getCards().size();
                    repaint();
                }
            }
        });
    }

    public void addPlayers(List<Player> players) {
        this.players = players;
        numberCardPlayer = players.get(0).getCards().size();
        repaint();
    }

    public void displayCard(Card card) {
        displayCard = card;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // Draw playmat
        graphics.drawImage(background.getImage(), 0, 0, null);

        // Draw displayCard during distribution
        if (displayCard != null) {
            graphics.drawImage(displayCard.getCardImage(), getWidth() / 2 - CARD_WIDTH / 2, getHeight() / 2 - CARD_HEIGHT / 2, CARD_WIDTH, CARD_HEIGHT, null);
        }

        if (players != null) {
            // Player game
            int posx = (getWidth() - CARD_SPACE * (numberCardPlayer + 1)) / 2;
            int posy = getHeight() - (CARD_HEIGHT + 20);
            for (Card card : players.get(0).getCards()) {
                graphics.drawImage(card.getCardImage(), posx, posy, CARD_WIDTH, CARD_HEIGHT, null);
                posx += CARD_SPACE;
            }

            // Bot 1 game
            posx = 0;
            posy = getHeight() / 2 - CARD_HEIGHT / 2;
            for (Card card : players.get(1).getCards()) {
                graphics.drawImage(card.getCardImage(), posx, posy, CARD_WIDTH, CARD_HEIGHT, null);
                posx += CARD_SPACE_BOT;
            }

            // Bot 2 game
            int numberCardBot = players.get(2).getCards().size();
            posx = (getWidth() - CARD_SPACE_BOT * (numberCardBot + 4 - 1)) / 2;
            posy = 20;
            for (Card card : players.get(2).getCards()) {
                graphics.drawImage(card.getCardImage(), posx, posy, CARD_WIDTH, CARD_WIDTH, null);
                posx += CARD_SPACE_BOT;
            }

            // Bot 3 game
            numberCardBot = players.get(3).getCards().size();
            posx = getWidth() - CARD_SPACE_BOT * (numberCardBot + 4 - 1);
            posy = getHeight() / 2 - CARD_HEIGHT / 2;
            for (Card card : players.get(3).getCards()) {
                graphics.drawImage(card.getCardImage(), posx, posy, CARD_WIDTH, CARD_HEIGHT, null);
                posx += CARD_SPACE_BOT;
            }
        }

    }

    public Card getCardPlaying() {
        return cardPlaying;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
