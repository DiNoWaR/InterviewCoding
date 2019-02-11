package com.denis.interview.patterns.behavioral.memento;


public class Memento {

    private final Coordinates coordinates;

    public Memento(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

}
