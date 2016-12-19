package com.marcinswiderski.geometry;

public class Rectangle implements Figure {
    private Double shorterSide;
    private Double longerSide;

    Rectangle(String sideA, String sideB) {
        if (Double.valueOf(sideA).compareTo(Double.valueOf(sideB)) > 0) {
            longerSide = Double.valueOf(sideA);
            shorterSide = Double.valueOf(sideB);
        } else {
            longerSide = Double.valueOf(sideB);
            shorterSide = Double.valueOf(sideA);
        }
    }

    @Override
    public String getFigureDescription() {
        return "rectangle of sides " + shorterSide + " and " + longerSide;
    }

    @Override
    public Double getArea() {
        return longerSide * shorterSide;
    }

    static String getAreaArgumentsDescription() {
        return "side side";
    }
}
