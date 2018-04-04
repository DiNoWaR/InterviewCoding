package com.denis.interview.patterns.behavioral.memento.demo;


import com.denis.interview.patterns.behavioral.memento.Coordinates;
import com.denis.interview.patterns.behavioral.memento.Memento;
import com.denis.interview.patterns.behavioral.memento.caretaker.CareTaker;
import com.denis.interview.patterns.behavioral.memento.originator.Originator;

public class MementoDemo {

    public static void main(String[] args) {

        var originator = new Originator();
        var careTaker = new CareTaker();

        var first = new Coordinates(1, 3, 4);
        var second = new Coordinates(3, 13, 6);
        var var = new Coordinates(5, 6, 9);
        var fourth = new Coordinates(10, 14, 418);

        originator.setCoordinates(first);
        careTaker.addToMementos(originator.saveCoordinatesToMemo());

        originator.setCoordinates(fourth);
        careTaker.addToMementos(originator.saveCoordinatesToMemo());

        for (var memento : careTaker.getMementos()) {
            System.out.println(memento.getCoordinates().toString());
        }

    }

}
