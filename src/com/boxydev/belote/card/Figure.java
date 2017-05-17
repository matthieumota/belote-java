package com.boxydev.belote.card;

public class Figure {
    private String name;
    private int point;
    private int pointTrump;
    private int value;
    private int valueTrump;

    Figure(String name, int point, int pointTrump, int value, int valueTrump) {
        this.name = name;
        this.point = point;
        this.pointTrump = pointTrump;
        this.value = value;
        this.valueTrump = valueTrump;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPointTrump() {
        return pointTrump;
    }

    public void setPointTrump(int pointTrump) {
        this.pointTrump = pointTrump;
    }
}
