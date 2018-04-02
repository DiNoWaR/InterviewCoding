package com.denis.interview.patterns.behavioral.visitor.interfaces;


import com.denis.interview.patterns.behavioral.visitor.concretevisitable.Bar;
import com.denis.interview.patterns.behavioral.visitor.concretevisitable.Baz;
import com.denis.interview.patterns.behavioral.visitor.concretevisitable.Foo;

public interface Visitor {

    void visit(Foo foo);

    void visit(Bar bar);

    void visit(Baz baz);
}
