package com.denis.interview.patterns.behavioral.memento.demo;


import com.denis.interview.patterns.behavioral.memento.Coordinates;
import com.denis.interview.patterns.behavioral.memento.Memento;
import com.denis.interview.patterns.behavioral.memento.caretaker.CareTaker;
import com.denis.interview.patterns.behavioral.memento.originator.Originator;

public class MementoDemo {

    public static void main(String[] args) {

        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        Coordinates first = new Coordinates(1, 3, 4);
        Coordinates second = new Coordinates(3, 13, 6);
        Coordinates third = new Coordinates(5, 6, 9);
        Coordinates fourth = new Coordinates(10, 14, 418);

        originator.setCoordinates(first);
        careTaker.addToMementos(originator.saveCoordinatesToMemo());

        originator.setCoordinates(fourth);
        careTaker.addToMementos(originator.saveCoordinatesToMemo());

        for (Memento memento : careTaker.getMementos()) {
            System.out.println(memento.getCoordinates().toString());
        }

    }

}
