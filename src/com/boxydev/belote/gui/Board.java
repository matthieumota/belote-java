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
    public List<Player> players;
    public Card cardPlaying = null;
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

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int width = getWidth();
        int height = getHeight();

        graphics.drawImage(background.getImage(), 0, 0, null);

        if (players != null) {

            // Joueur
            graphics.setColor(Color.YELLOW);
            graphics.drawRect((width - 200) / 2, height - 202, 200, 200);

            int posx = (width - CARD_SPACE * (numberCardPlayer + 1)) / 2;
            int posy = height - (CARD_HEIGHT + 20);
            for (Card card : players.get(0).getCards()) {
                System.out.println(card.getCard());
                graphics.drawImage(card.getCardImage(), posx, posy, CARD_WIDTH, CARD_HEIGHT, null);
                posx += CARD_SPACE;
            }

            // Bot 1
            graphics.setColor(Color.BLUE);
            graphics.drawRect(0, (height - 200) / 2, 200, 200);

            int index = 0;
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

    public Card getCardPlaying() {
        return cardPlaying;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
