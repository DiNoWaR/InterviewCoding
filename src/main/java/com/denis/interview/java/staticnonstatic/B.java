package com.denis.interview.java.staticnonstatic;

public class B extends A {

    static {
        System.out.println("Static B");
    }

    public B() {
        System.out.println("Costructor B");
    }

    {
        System.out.println("Non Static B");
    }

}
