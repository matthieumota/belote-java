package com.boxydev.belote.card;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Card {
    private Color color;
    private Figure figure;

    public Card(Color color, Figure figure) {
        this.color = color;
        this.figure = figure;
    }

    public Color getColor() {
        return color;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getCard() {
        return figure.getName()+" de "+color.getName();
    }

    public Image getCardImage() {
        ImageIcon image = new ImageIcon("src/com/boxydev/belote/images/"+figure.getName()+color.getName()+".png");
        return image.getImage();
    }
}
