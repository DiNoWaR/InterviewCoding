package com.denis.interview.java.staticnonstatic;

public class A {

    static {
        System.out.println("Static A");
    }

    public A() {
        System.out.println("Costructor A");
    }

    {
        System.out.println("Non Static A");
    }

}
