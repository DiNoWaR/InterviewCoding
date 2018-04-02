package com.denis.interview.patterns.behavioral.visitor.concretevisitable;


import com.denis.interview.patterns.behavioral.visitor.interfaces.Visitable;
import com.denis.interview.patterns.behavioral.visitor.interfaces.Visitor;

public class Bar implements Visitable {

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getBar() {
        return "BAR";
    }
}
