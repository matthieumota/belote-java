package com.boxydev.belote.card;

import javax.swing.*;
import java.awt.*;

public class Card {
    private int color;
    private int value;

    public Card(int color, int value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return this.getRealColor(color);
    }

    private String getRealColor(int color) {
        switch (color) {
            case 0: return "Coeur";
            case 1: return "Pique";
            case 2: return "Trefle";
            case 3: return "Carreau";
            default: return "";
        }
    }

    public String getValue() {
        return this.getRealValue(value);
    }

    private String getRealValue(int value) {
        switch (value) {
            case 0: return "As";
            case 1: return "Roi";
            case 2: return "Dame";
            case 3: return "Valet";
            case 4: return "Dix";
            case 5: return "Neuf";
            case 6: return "Huit";
            case 7: return "Sept";
            default: return "";
        }
    }

    public String getCard() {
        return getValue()+" de "+getColor();
    }

    public Image getCardImage() {
        ImageIcon image = new ImageIcon("src/com/boxydev/belote/images/"+getValue()+getColor()+".png");
        return image.getImage();
    }
}
