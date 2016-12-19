package com.marcinswiderski.geometry;

public class Square implements Figure {

    private Double side;

    Square(String side) {
        this.side = Double.valueOf(side);
    }

    @Override
    public String getFigureDescription() {
        return "square of side " + side;
    }

    @Override
    public Double getArea() {
        return side * side;
    }

    static String getAreaArgumentsDescription() {
        return "side";
    }
}
