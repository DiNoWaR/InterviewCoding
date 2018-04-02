package com.denis.interview.patterns.behavioral.memento.caretaker;


import com.denis.interview.patterns.behavioral.memento.Memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private List<Memento> mementos = new ArrayList<>();


    public void addToMementos(Memento memento) {
        mementos.add(memento);
    }

    public List<Memento> getMementos() {
        return mementos;
    }
}
