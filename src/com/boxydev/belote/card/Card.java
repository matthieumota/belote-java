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

    public String getColor() {
        return color.getName();
    }

    public String getFigure() {
        return figure.getName();
    }

    public String getCard() {
        return getFigure()+" de "+getColor();
    }

    public Image getCardImage() {
        ImageIcon image = new ImageIcon("src/com/boxydev/belote/images/"+getFigure()+getColor()+".png");
        return image.getImage();
    }
}
