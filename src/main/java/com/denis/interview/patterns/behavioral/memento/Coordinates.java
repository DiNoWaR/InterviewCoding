package com.denis.interview.patterns.behavioral.memento;


public final class Coordinates {

    private final double X;
    private final double Y;
    private final double Z;

    public Coordinates(double x, double y, double z) {
        X = x;
        Y = y;
        Z = z;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "X=" + X +
                ", Y=" + Y +
                ", Z=" + Z +
                '}';
    }
}
