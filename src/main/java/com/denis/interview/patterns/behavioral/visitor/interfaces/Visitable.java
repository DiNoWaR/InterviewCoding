package com.denis.interview.patterns.behavioral.visitor.interfaces;


public interface Visitable {

    void accept(Visitor v);
}
