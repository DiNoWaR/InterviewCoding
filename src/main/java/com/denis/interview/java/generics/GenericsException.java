package com.denis.interview.java.generics;

/**
 * This is tricky one from Deutsche bank.
 * We got ClassCastException here in main method.
 * Because of erasing generics to Object in runtime,
 * we'll never catch it in foo()
 */
public class GenericsException {

    public static <T> T foo() {
        try {
            return (T) new Integer(42);
        } catch (ClassCastException e) {
            return (T) "Deutsche Bank";
        }
    }

    public static void main(String[] args) {
        System.out.println(GenericsException.<String>foo());
    }

}
