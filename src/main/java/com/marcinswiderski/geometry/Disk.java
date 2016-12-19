package com.marcinswiderski.geometry;

public class Disk implements Figure {
    private Double radius;

    Disk(String radius) {
        this.radius = Double.valueOf(radius);
    }

    @Override
    public String getFigureDescription() {
        return "disk of radius " + radius;
    }

    @Override
    public Double getArea() {
        return radius * radius * Math.PI;
    }

    static String getAreaArgumentsDescription() {
        return "radius";
    }
}
