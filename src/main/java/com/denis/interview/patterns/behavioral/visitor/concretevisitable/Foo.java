package com.denis.interview.patterns.behavioral.visitor.concretevisitable;


import com.denis.interview.patterns.behavioral.visitor.interfaces.Visitable;
import com.denis.interview.patterns.behavioral.visitor.interfaces.Visitor;

public class Foo implements Visitable {

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getFoo() {
        return "FOO";
    }
}