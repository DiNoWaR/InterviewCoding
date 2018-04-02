package com.denis.interview.patterns.behavioral.visitor.concretevisitor;


import com.denis.interview.patterns.behavioral.visitor.concretevisitable.Bar;
import com.denis.interview.patterns.behavioral.visitor.concretevisitable.Baz;
import com.denis.interview.patterns.behavioral.visitor.concretevisitable.Foo;
import com.denis.interview.patterns.behavioral.visitor.interfaces.Visitor;

public class DownVisitor implements Visitor {

    public void visit(Foo foo) {
        System.out.println("do Down on " + foo.getFoo());
    }

    public void visit(Bar bar) {
        System.out.println("do Down on " + bar.getBar());
    }

    public void visit(Baz baz) {
        System.out.println("do Down on " + baz.getBaz());
    }
}
