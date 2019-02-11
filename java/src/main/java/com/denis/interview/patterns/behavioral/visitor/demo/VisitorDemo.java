package com.denis.interview.patterns.behavioral.visitor.demo;


import com.denis.interview.patterns.behavioral.visitor.concretevisitable.Bar;
import com.denis.interview.patterns.behavioral.visitor.concretevisitable.Baz;
import com.denis.interview.patterns.behavioral.visitor.concretevisitable.Foo;
import com.denis.interview.patterns.behavioral.visitor.concretevisitor.DownVisitor;
import com.denis.interview.patterns.behavioral.visitor.concretevisitor.UpVisitor;
import com.denis.interview.patterns.behavioral.visitor.interfaces.Visitable;
import com.denis.interview.patterns.behavioral.visitor.interfaces.Visitor;

public class VisitorDemo {

    private static void iterateThroughArrayOfElements(Visitable[] array, Visitor visitor) {
        for (Visitable visitable : array) {
            visitable.accept(visitor);
        }
    }

    public static void main(String[] args) {

        Visitable[] list = {new Foo(), new Bar(), new Baz()};

        UpVisitor up = new UpVisitor();
        DownVisitor down = new DownVisitor();

        iterateThroughArrayOfElements(list, up);
        iterateThroughArrayOfElements(list, down);
    }
}
