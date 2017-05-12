package com.boxydev.card;

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
            case 4: return "10";
            case 5: return "9";
            case 6: return "8";
            case 7: return "7";
            default: return "";
        }
    }

    public String getCard() {
        return "C'est "+getValue()+" de "+getColor();
    }
}
