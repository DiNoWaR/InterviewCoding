package com.denis.interview.patterns.behavioral.memento.originator;


import com.denis.interview.patterns.behavioral.memento.Coordinates;
import com.denis.interview.patterns.behavioral.memento.Memento;

public class Originator {

    private Coordinates coordinates;

    public Memento saveCoordinatesToMemo() {
        return new Memento(coordinates);
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
